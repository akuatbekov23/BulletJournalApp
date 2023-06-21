package cs3500.pa05.controller;

import cs3500.pa05.controller.reader.BujoReader;
import cs3500.pa05.controller.writer.BujoWriter;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Theme;
import cs3500.pa05.model.Week;
import cs3500.pa05.viewer.DayView;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

// Week View - Done
// Event and Task Creation - In Progress
// Persistence - In Progress (Option to choose what file to open and save, When your program first opens, have the user choose a .bujo file to open and display the contents as you would display a week)
// Commitment Warnings - In Progress (Let user setting/updating the max events and tasks)

// Task Queue - Done
// Themes - Done

// Quotes & Notes - Done
// Weekly Overview - In Progress
// Takesie-backies - Done

// Task Search - Done
// Custom Themes - In Progress

// Deployable Application - Not Started
// Visual Flourish - Not Started
// Splash Screen - In Progress
// Privacy Lock - Not Started
// Weekly Starters - Not Started
// Tested GUI - Not Started

/**
 * Represents a controller for the journal.
 */
public class JournalController implements Controller {
  private Week week;
  @FXML
  private Scene weekScene;
  @FXML
  private TextField searchBar;
  @FXML
  private Label clear;
  @FXML
  private TextArea weekTitle;
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

  /**
   * Constructs a new JournalController.
   *
   * @param week the week to use
   */
  public JournalController(Week week) {
    this.week = week;
  }

  // Let user name the week
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
        weekGrid.add(new DayView(week.getDay(i), week.getTaskQueue(),
            query.toLowerCase(), week.getMaxEvents(), week.getMaxTasks()), i, 0);
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

  @Override
  /**
   * Initializes the GUI.
   */
  public void initialize() {
    // Set week name
    weekTitle.setText(week.getTitle());

    // Set Quotes & Notes
    noteTextArea.setText(week.getNotes());

    // Bind Task Queue
    taskQueue.setItems(week.getTaskQueue());

    // reset
    titleHBox.getChildren().clear();

    updateWeekView();
//
//    // Create the theme buttons
//    for (int i = 0; i < week.getThemes().size(); i++) {
//      Theme theme = week.getThemes().get(i);
//      Button themeButton = new Button("Theme: " + i);
//      themeButton.setStyle("-fx-background-color: " + toHexString(theme.getBackgroundColor()));
//      titleHBox.getChildren().add(themeButton);
//      int finalI = i;
//      themeButton.setOnAction(e -> setTheme(finalI));
//    }
//

    // Create the theme menu button
    MenuButton themeMenuButton = new MenuButton("Themes");
    List<MenuItem> menuItems = createThemeMenuItems();
    themeMenuButton.getItems().addAll(menuItems);

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

    Button saveBtn = new Button("Save");
    Button loadBtn = new Button("Load");
    saveBtn.setOnAction(e -> new BujoWriter().write(JsonConverter.convertWeekToJson(week)));
    loadBtn.setOnAction(e -> load());

    titleHBox.getChildren().addAll(themeMenuButton, customThemeButton, saveBtn, loadBtn);

    setTheme(week.getCurrentTheme());
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
      weekGrid.add(new DayView(week.getDay(i), week), i, 0);
    }
  }


  private void load() {
    week.update(JsonConverter.convertJsonToWeek(new BujoReader().read()));
    initialize();
  }

  private void setTheme(int newTheme) {
    week.updateTheme(newTheme);
    Theme theme = week.getTheme();
    weekPane1.setBackground(Background.fill(theme.getBackgroundColor()));
    noteTextArea.setStyle("-fx-text-fill: " + toHexString(theme.getFontColor()));
    noteTextArea.setFont(javafx.scene.text.Font.font(theme.getFontFamily()));
    traverseSceneGraph(weekScene.getRoot(), theme);
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
      } else if (node instanceof Parent) {
        traverseSceneGraph((Parent) node, theme);
      }
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
