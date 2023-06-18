package cs3500.pa05.controller;

import cs3500.pa05.model.Theme;
import cs3500.pa05.model.Week;
import cs3500.pa05.viewer.DayView;
import cs3500.pa05.viewer.TaskQueueView;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Represents a controller for the journal.
 */
public class JournalController implements Controller {
  private Week week;

  @FXML
  private Scene weekScene;
  @FXML
  private VBox taskQueue;
  @FXML
  private GridPane weekGrid;
  @FXML
  private AnchorPane weekPane1;
  @FXML
  private AnchorPane weekPane2;
  @FXML
  private AnchorPane weekPane3;
  @FXML
  private SplitPane weekSplitPane;
  @FXML
  private VBox weekVBox1;
  @FXML
  private VBox weekVBox2;
  @FXML
  private VBox weekVBox3;
  @FXML
  private ScrollPane weekScrollPane;
  @FXML
  private HBox titleHBox;
  @FXML
  private Button themeButton1;
  @FXML
  private Button themeButton2;
  @FXML
  private Button themeButton3;


  /**
   * Constructs a new JournalController.
   *
   * @param week the week to use
   */
  public JournalController(Week week) {
    this.week = week;
  }

  @Override
  public void run() {
    initialize();
  }

  private void initialize() {
    // Week View
    for (int i = 0; i < 7; i++) {
      weekGrid.add(new DayView(week.getDay(i)), i, 0);
    }

    // Task Queue
    for (int i = 0; i < week.getTaskQueue().size(); i++) {
      taskQueue.getChildren().add(new TaskQueueView(week.getTaskQueue().get(i)));
    }

    // Create the theme buttons
    Button themeButton1 = new Button("Theme 1");
    Button themeButton2 = new Button("Theme 2");
    Button themeButton3 = new Button("Theme 3");

    themeButton1.setStyle("-fx-background-color: #ffffff;");
    themeButton2.setStyle("-fx-background-color: #000000;");
    themeButton3.setStyle("-fx-background-color: #00ffff;");

    HBox themeButtonsContainer = new HBox(themeButton1, themeButton2, themeButton3);
    themeButtonsContainer.setAlignment(Pos.CENTER_LEFT);
    themeButtonsContainer.setSpacing(10);
    themeButtonsContainer.setPadding(new Insets(0, 40, 0, 0));

    titleHBox.getChildren().add(themeButtonsContainer);

    themeButton1.setOnAction(event -> setTheme(Theme.THEME_1));
    themeButton2.setOnAction(event -> setTheme(Theme.THEME_2));
    themeButton3.setOnAction(event -> setTheme(Theme.THEME_3));

    Label weekTitle = new Label(week.getTitle());
    titleHBox.getChildren().add(weekTitle);

  }

  /**
   * Changes the theme of the journal.
   *
   * @param theme the theme to set to
   */
  private void setTheme(Theme theme) {
    weekPane1.setBackground(new Background
        (new BackgroundFill(theme.getBackgroundColor(), null, null)));
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
        label.setFont(javafx.scene.text.Font.font(theme.fontFamily));
        label.setTextFill(theme.fontColor);
      } else if (node instanceof Parent) {
        traverseSceneGraph((Parent) node, theme);
      }
    }
  }
}
