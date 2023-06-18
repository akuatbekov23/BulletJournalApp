package cs3500.pa05.controller;

import cs3500.pa05.model.Theme;
import cs3500.pa05.model.Week;
import cs3500.pa05.viewer.DayView;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class JournalController implements Controller {
  private Week week;
  @FXML
  private Label weekTitle;
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


  public JournalController(Week week) {
    this.week = week;
  }

  @Override
  public void run() {
    initialize();
  }


  private void initialize() {
    for (int i = 0; i < 7; i++) {
      weekGrid.add(new DayView(week.getDay(i)), i, 0);
    }

    // Create the theme buttons
    Button themeButton1 = new Button("Theme 1");
    Button themeButton2 = new Button("Theme 2");
    Button themeButton3 = new Button("Theme 3");

    themeButton1.setStyle("-fx-background-color: #000000;"); // Set the background color to black

    themeButton1.setStyle("-fx-background-color: #ff0000;"); // Set the background color to black

    themeButton1.setStyle("-fx-background-color: #0000ff;"); // Set the background color to black


    // Create an HBox to contain the theme buttons
    HBox themeButtonsContainer = new HBox(themeButton1, themeButton2, themeButton3);
    //
    //themeButtonsContainer.setSpacing(10);
    //themeButtonsContainer.setPadding(new Insets(10));
    titleHBox.getChildren().add(themeButtonsContainer);


    // Set event handlers for the theme buttons
    themeButton1.setOnAction(event -> changeTheme(Theme.THEME_1));
    themeButton2.setOnAction(event -> changeTheme(Theme.THEME_2));
    themeButton3.setOnAction(event -> changeTheme(Theme.THEME_3));
    themeButtonsContainer.setAlignment(Pos.TOP_LEFT);


  }

  private void changeTheme(Theme theme) {
    // Change the theme of the scene
    Scene scene = weekGrid.getScene();
    scene.getStylesheets().clear();


    // Update the background of the anchor panes
    weekPane1.setBackground(new Background
        (new BackgroundFill(theme.getBackgroundColor(), null, null)));
    
  }


}
