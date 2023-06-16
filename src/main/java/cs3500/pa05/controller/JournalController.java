package cs3500.pa05.controller;

import cs3500.pa05.model.Theme;
import cs3500.pa05.model.Week;
import cs3500.pa05.viewer.DayView;
import cs3500.pa05.viewer.EventView;
import javafx.fxml.FXML;
import javafx.scene.Scene;
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
  private HBox weekHBox1;

  public JournalController(Week week) {
    this.week = week;
  }

  @Override
  public void run() {
    initialize();
  }

  private void initialize() {
    Theme theme = week.getTheme();
    weekGrid.setBackground(Background.fill(theme.getBackgroundColor()));
    weekPane1.setBackground(Background.fill(theme.getBackgroundColor()));
    weekPane2.setBackground(Background.fill(theme.getBackgroundColor()));
    weekPane3.setBackground(Background.fill(theme.getBackgroundColor()));
    weekSplitPane.setBackground(Background.fill(theme.getBackgroundColor()));
    weekVBox1.setBackground(Background.fill(theme.getBackgroundColor()));
    weekVBox2.setBackground(Background.fill(theme.getBackgroundColor()));
    weekVBox3.setBackground(Background.fill(theme.getBackgroundColor()));
    weekScrollPane.setBackground(Background.fill(theme.getBackgroundColor()));
    weekHBox1.setBackground(Background.fill(theme.getBackgroundColor()));
    weekTitle.setText(week.getTitle());

    for (int i = 0; i < 7; i++) {
      weekGrid.add(new DayView(week.getDay(i)), i, 0);
    }
  }
}
