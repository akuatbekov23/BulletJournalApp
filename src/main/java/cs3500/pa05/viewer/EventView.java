package cs3500.pa05.viewer;

import cs3500.pa05.controller.EventDeleteHandler;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Events;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class EventView extends BlockView {
  public EventView(Events events, Day day) {
    super();
    Label eventLabel = new Label("Event");
    Label name = new Label(events.getName());
    Label startTime = new Label("Start time: " + events.getStartTime());
    Label duration = new Label("Duration: " + events.getDuration());
    this.getChildren().addAll(eventLabel, name, startTime, duration);
    if (!events.getDescription().equals("")) {
      Label description = new Label(events.getDescription());
      this.getChildren().add(description);
    }
    Button delete = new Button("Delete");
    delete.setOnAction(new EventDeleteHandler(events, day, this));
    this.getChildren().add(delete);
  }
}
