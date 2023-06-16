package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.viewer.DayView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class JournalController implements Controller {
  private Week week;
  @FXML
  private Label weekTitle;
  @FXML
  private GridPane weekGrid;

  public JournalController(Week week) {
    this.week = week;
  }

  @Override
  public void run() {
    initialize();
  }

  private void initialize() {
    weekTitle.setText(week.getTitle());

    for (int i = 0; i < 7; i++) {
      weekGrid.add(new DayView(week.getDay(i)), i, 0);
    }
  }
}
