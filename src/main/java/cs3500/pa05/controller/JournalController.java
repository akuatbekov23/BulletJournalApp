package cs3500.pa05.controller;

import cs3500.pa05.controller.reader.BujoReader;
import cs3500.pa05.controller.writer.BujoWriter;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Theme;
import cs3500.pa05.model.Week;
import cs3500.pa05.viewer.DayView;
import cs3500.pa05.viewer.StartDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

// Deployable Application - Done
// Visual Flourish - Not Started
// Splash Screen - In Progress
// Privacy Lock - Not Started
// Weekly Starters - Not Started
// Tested GUI - Not Started

/**
 * Represents a controller for the journal.
 */
public class JournalController implements Controller {
  private boolean init = true;
  private Week week;
  @FXML
  private Label weeklyOverview;
  @FXML
  private Scene weekScene;
  @FXML
  private TextField searchBar;
  @FXML
  private Label clear;
  @FXML
  private TextField weekTitle;
  @FXML
  private ListView<Task> taskQueue;
  @FXML
  private GridPane weekGrid;
  @FXML
  private AnchorPane weekPane1;
  @FXML
  private HBox titleHBox;
  @FXML
  private TextArea noteTextArea;
  @FXML
  private ImageView notesImage1;
  @FXML
  private ImageView notesImage2;
  @FXML
  private ImageView topLeftImage;
  @FXML
  private ImageView bottomRightImage;
  @FXML
  private TextField setMaxEvents;
  @FXML
  private TextField setMaxTasks;

  /**
   * Constructs a new JournalController.
   *
   * @param week the week to use
   */
  public JournalController(Week week) {
    this.week = week;
  }

  @FXML
  private void handleSave(Event event) {
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter bujoFilter =
        new FileChooser.ExtensionFilter("Bujo Files", "*.bujo");
    fileChooser.getExtensionFilters().add(bujoFilter);
    File file = fileChooser.showSaveDialog(weekScene.getWindow());
    if (file != null) {
      new BujoWriter().write(file, JsonConverter.convertWeekToJson(week));
    }
  }

  @FXML
  private void handleOpen(Event event) {
    FileChooser fileChooser = new FileChooser();
    FileChooser.ExtensionFilter bujoFilter =
        new FileChooser.ExtensionFilter("Bujo Files", "*.bujo");
    fileChooser.getExtensionFilters().add(bujoFilter);
    File file = fileChooser.showOpenDialog(weekScene.getWindow());
    if (file != null) {
      load(file);
      initialize();
    }
  }

  private void load(File file) {
    week.update(JsonConverter.convertJsonToWeek(new BujoReader().read(file)));
  }

  // Let user change the week name
  @FXML
  private void handleWeekTitle(Event event) {
    week.setTitle(weekTitle.getText());
    event.consume();
  }

  @FXML
  private void handleQuotesNotes(Event event) {
    week.updateNotes(noteTextArea.getText());
    event.consume();
  }

  @FXML
  private void handleSearch(Event event) {
    String query = searchBar.getText();
    if (!query.equals("")) {
      clear.setVisible(true);

      weekGrid.getChildren().clear();
      // Week View
      for (int i = 0; i < 7; i++) {
        ScrollPane sp =
            new ScrollPane(new DayView(week.getDay(i), query.toLowerCase(), week, this));
        sp.setStyle("-fx-focus-color: transparent; -fx-background-color: transparent;");
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        weekGrid.add(sp, i, 0);
      }
    } else {
      clear.setVisible(false);
      weekGrid.getChildren().clear();
      updateWeekView();
    }
    traverseSceneGraph(weekScene.getRoot(), week.getTheme());
  }

  @FXML
  private void handleClear(Event event) {
    searchBar.setText("");
    clear.setVisible(false);
    weekGrid.getChildren().clear();
    updateWeekView();
    traverseSceneGraph(weekScene.getRoot(), week.getTheme());
  }

  @FXML
  private void handleMaxEvents(Event event) {
    int result = 0;
    try {
      result = Integer.parseInt(setMaxEvents.getText());
    } catch (NumberFormatException e) {
      result = 0;
    }
    week.setMaxEvents(result);
  }

  @FXML
  private void handleMaxTasks(Event event) {
    int result = 0;
    try {
      result = Integer.parseInt(setMaxTasks.getText());
    } catch (NumberFormatException e) {
      result = 0;
    }
    week.setMaxTasks(result);
  }

  @Override
  /**
   * Initializes the GUI.
   */
  public void initialize() {
    if (init) {
      init = false;
      triggerStartDialog();
    }
    // set weekly overview
    weeklyOverview.textProperty().bind(week.getWeeklyOverview());
    // Set week name
    weekTitle.setText(week.getTitle());
    // Set Quotes & Notes
    noteTextArea.setText(week.getNotes());
    // Bind Task Queue
    taskQueue.setItems(week.getTaskQueue());
    // Set Commitment Warnings
    setMaxEvents.setText(String.valueOf(week.getMaxEvents()));
    setMaxTasks.setText(String.valueOf(week.getMaxTasks()));
    // Update WeekView (Each day
    updateWeekView();
    setupThemeButton();
    setTheme(week.getCurrentTheme());
  }

  private void setupThemeButton() { // reset
    titleHBox.getChildren().clear();
    // Create the theme menu button
    MenuButton themeMenuButton = new MenuButton("Themes");
    List<MenuItem> menuItems = createThemeMenuItems();
    themeMenuButton.getItems().addAll(menuItems);
    // Custom Theme Button
    Button customThemeButton = new Button("Custom");
    customThemeButton.setStyle("-fx-background-color: #2f2fff;");
    customThemeButton.setOnAction(e -> {
      CustomThemeHandler handler = new CustomThemeHandler(week.getThemes());
      handler.handle(e);
      MenuItem item = createCustomThemeMenuItems();
      themeMenuButton.getItems().addAll(item);
      setTheme(week.getThemes().size() - 1);
    });
    for (MenuItem menuItem : themeMenuButton.getItems()) {
      menuItem.setOnAction(e -> {
        String selectedTheme = menuItem.getText();
        if (selectedTheme.equals("Custom")) {
          setTheme(week.getThemes().size() - 1);
        } else {
          int themeIndex = Integer.parseInt(selectedTheme.substring(
              selectedTheme.lastIndexOf(" ") + 1));
          setTheme(themeIndex);
        }
      });
    }
    titleHBox.getChildren().addAll(themeMenuButton, customThemeButton);
  }

  private void triggerStartDialog() {
    Dialog popup = new StartDialog(weekScene);
    Optional<File> result = popup.showAndWait();

    if (result.isPresent()) {
      result.ifPresent(this::load);
    } else {
      initialize();
    }
  }

  private List<MenuItem> createThemeMenuItems() {
    List<MenuItem> menuItems = new ArrayList<>();
    for (int i = 0; i < week.getThemes().size(); i++) {
      menuItems.add(new MenuItem("Theme " + i));
    }

    // menuItems.add(createCustomThemeMenuItems());
    return menuItems;
  }

  private MenuItem createCustomThemeMenuItems() {
    // Add Custom option
    int customThemeNumber = week.getThemes().size() - 1;
    MenuItem customMenuItem = new MenuItem("Custom Theme " + customThemeNumber);

    customMenuItem.setOnAction(e -> {
      setTheme(customThemeNumber);
    });

    return customMenuItem;

  }


  private void updateWeekView() {
    weekGrid.getChildren().clear();
    for (int i = 0; i < 7; i++) {
      ScrollPane sp = new ScrollPane(new DayView(week.getDay(i), week, this));
      sp.setStyle("-fx-focus-color: transparent; -fx-background-color: transparent;");
      sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
      sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
      weekGrid.add(sp, i, 0);
    }
  }

  private void setTheme(int newTheme) {
    week.updateTheme(newTheme);
    Theme theme = week.getTheme();
    weekPane1.setBackground(Background.fill(theme.getBackgroundColor()));
    noteTextArea.setStyle("-fx-text-fill: " + toHexString(theme.getFontColor()));
    noteTextArea.setFont(javafx.scene.text.Font.font(theme.getFontFamily()));
    if (theme.getImages().size() < 1) {
      // set the images to empty
      notesImage1.setImage(null);
      notesImage2.setImage(null);
      topLeftImage.setImage(null);
      bottomRightImage.setImage(null);
    } else if (theme.getImages().size() < 2) {
      notesImage1.setImage(null);
      notesImage2.setImage(null);
      topLeftImage.setImage(null);
      bottomRightImage.setImage(theme.getImages().get(0));
    } else if (theme.getImages().size() < 3) {
      notesImage1.setImage(theme.getImages().get(1));
      notesImage2.setImage(theme.getImages().get(1));
      topLeftImage.setImage(null);
      bottomRightImage.setImage(theme.getImages().get(0));
    } else {
      notesImage1.setImage(theme.getImages().get(1));
      notesImage2.setImage(theme.getImages().get(1));
      topLeftImage.setImage(theme.getImages().get(2));
      bottomRightImage.setImage(theme.getImages().get(0));
    }
    traverseSceneGraph(weekScene.getRoot(), theme);
  }

  /**
   * Traverses the scene graph and sets the font family and font color of all labels.
   *
   * @param parent the parent node
   * @param theme  the theme to set to
   */
  private void traverseSceneGraph(Parent parent, Theme theme) {
    for (javafx.scene.Node node : parent.getChildrenUnmodifiable()) {
      if (node instanceof Label label) {
        label.setFont(javafx.scene.text.Font.font(theme.getFontFamily()));
        label.setStyle("-fx-text-fill: " + toHexString(theme.getFontColor()));
      }
      if (node instanceof TextField textField) {
        textField.setFont(javafx.scene.text.Font.font(theme.getFontFamily()));
        textField.setStyle("-fx-background-color: transparent; -fx-text-fill: " +
            toHexString(theme.getFontColor()));
      } else if (node instanceof ScrollPane) {
        traverseSceneGraph((ScrollPane) node, theme);
      } else if (node instanceof Parent) {
        traverseSceneGraph((Parent) node, theme);
      }
    }
  }

  private void traverseSceneGraph(ScrollPane parent, Theme theme) {
    Node node = parent.getContent();
    if (node instanceof Label label) {
      label.setFont(javafx.scene.text.Font.font(theme.getFontFamily()));
      label.setStyle("-fx-text-fill: " + toHexString(theme.getFontColor()));
    }
    if (node instanceof TextField textField) {
      textField.setFont(javafx.scene.text.Font.font(theme.getFontFamily()));
      textField.setStyle("-fx-background-color: transparent; -fx-text-fill: " +
          toHexString(theme.getFontColor()));
    } else if (node instanceof ScrollPane) {
      traverseSceneGraph((ScrollPane) node, theme);
    } else if (node instanceof Parent) {
      traverseSceneGraph((Parent) node, theme);
    }
  }

  private static String toHexString(Color color) {
    int r = ((int) Math.round(color.getRed() * 255)) << 24;
    int g = ((int) Math.round(color.getGreen() * 255)) << 16;
    int b = ((int) Math.round(color.getBlue() * 255)) << 8;
    int a = ((int) Math.round(color.getOpacity() * 255));
    return String.format("#%08X", (r + g + b + a));
  }
}
