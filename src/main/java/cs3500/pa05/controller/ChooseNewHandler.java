package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Events;
import cs3500.pa05.model.Week;
import cs3500.pa05.viewer.ChooseNewDialog;
import cs3500.pa05.viewer.MaxView;
import java.time.LocalTime;
import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.VBox;

public class ChooseNewHandler implements EventHandler {
  Day day;
  Week week;
  Controller controller;

  public ChooseNewHandler(Day day, Week week, Controller controller) {
    this.day = day;
    this.week = week;
    this.controller = controller;
  }

  @Override
  public void handle(Event event) {
    Dialog popup = new ChooseNewDialog(day, week, controller);
    popup.show();
  }
}
