package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Events;
import cs3500.pa05.viewer.MaxView;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class EventDeleteHandler implements EventHandler {
  private Events events;
  private Day day;
  private Parent parent;
  private MaxView maxView;

  public EventDeleteHandler(Events events, Day day, Parent parent, MaxView maxView) {
    this.events = events;
    this.day = day;
    this.parent = parent;
    this.maxView = maxView;
  }

  /**
   * Invoked when a specific event of the type for which this handler is
   * registered happens.
   *
   * @param event the event which occurred
   */
  @Override
  public void handle(Event event) {
    day.removeIfFound(events);
    ((VBox) this.parent.getParent()).getChildren().remove(this.parent);
    maxView.subtract();
  }
}
