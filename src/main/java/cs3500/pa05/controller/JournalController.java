package cs3500.pa05.controller;

import cs3500.pa05.controller.reader.BujoReader;
import cs3500.pa05.controller.writer.BujoWriter;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Theme;
import cs3500.pa05.model.Week;
import cs3500.pa05.viewer.DayView;
import java.util.ArrayList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
  private Label weeklyOverview;
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

    // set weekly overview
    weeklyOverview.textProperty().bind(week.getWeeklyOverview());

    // Set week name
    weekTitle.setText(week.getTitle());

    // Set Quotes & Notes
    noteTextArea.setText(week.getNotes());

    // Bind Task Queue
    taskQueue.setItems(week.getTaskQueue());

    // reset
    titleHBox.getChildren().clear();

    updateWeekView();

    // Create the theme buttons
    for (int i = 0; i < week.getThemes().size(); i++) {
      Theme theme = week.getThemes().get(i);
      Button themeButton = new Button("Theme: " + i);
      themeButton.setStyle("-fx-background-color: " + toHexString(theme.getBackgroundColor()));
      titleHBox.getChildren().add(themeButton);
      int finalI = i;
      themeButton.setOnAction(e -> setTheme(finalI));
    }

    Button customThemeButton = new Button("Custom");
    customThemeButton.setStyle("-fx-background-color: #2f2fff;");
    customThemeButton.setOnAction(new CustomThemeHandler(new ArrayList<>()));

    Button saveBtn = new Button("Save");
    Button loadBtn = new Button("Load");
    saveBtn.setOnAction(e -> new BujoWriter().write(JsonConverter.convertWeekToJson(week)));
    loadBtn.setOnAction(e -> load());

    titleHBox.getChildren().addAll(customThemeButton, saveBtn, loadBtn);

    setTheme(week.getCurrentTheme());
  }

  private void updateWeekView() {
    weekGrid.getChildren().clear();
    for (int i = 0; i < 7; i++) {
      weekGrid.add(new DayView(week.getDay(i), week), i, 0);
    }
  }

  /**
   * handler for the custom theme button. Opens a new window to customize the theme.
   * The user can select a color for the background and the font. Can select the font family
   * and can add images to the background. Basically the user creates a new theme.
   */
  private void customizeTheme() {
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
    notesImage1.setImage(theme.getImages().get(1));
    notesImage2.setImage(theme.getImages().get(1));
    topLeftImage.setImage(theme.getImages().get(2));
    bottomRightImage.setImage(theme.getImages().get(0));
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
      } else if (node instanceof Parent) {
        traverseSceneGraph((Parent) node, theme);
      }
    }
  }

  private static String toHexString(Color color) {
    int r = ((int) Math.round(color.getRed()     * 255)) << 24;
    int g = ((int) Math.round(color.getGreen()   * 255)) << 16;
    int b = ((int) Math.round(color.getBlue()    * 255)) << 8;
    int a = ((int) Math.round(color.getOpacity() * 255));
    return String.format("#%08X", (r + g + b + a));
  }
}
