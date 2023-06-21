package cs3500.pa05.controller;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayEnum;
import cs3500.pa05.model.Events;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import cs3500.pa05.viewer.CreateEventDialog;
import cs3500.pa05.viewer.EventView;
import cs3500.pa05.viewer.MaxView;
import cs3500.pa05.viewer.TaskView;
import java.util.List;
import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;
import javafx.scene.layout.VBox;

/**
 * the event handler
 */
public class CreateEventHandler implements EventHandler {
  List<Events> events;
  Day day;
  Week week;
  Dialog dialog;
  Controller controller;

  public CreateEventHandler(List<Events> events, Week week, Day day,
                            Controller controller, Dialog dialog) {
    this.events = events;
    this.week = week;
    this.day = day;
    this.dialog = dialog;
    this.controller = controller;
  }

  @Override
  public void handle(Event event) {

    Dialog popup = new CreateEventDialog(DayEnum.valueOf(day.getDay()));
    Optional<Events> result = popup.showAndWait();

    result.ifPresent((Events e) -> {
      events.add(e);
      controller.initialize();
      dialog.close();
    });
  }
}
