package cs3500.pa05.viewer;

import cs3500.pa05.model.Event;
import javafx.scene.control.Label;

public class EventView extends BlockView {
  public EventView(Event event) {
    super();
    Label eventLabel = new Label("Event");
    Label name = new Label(event.getName());
    Label startTime = new Label("Start time: " + event.getStartTime());
    Label duration = new Label("Duration: " + event.getDuration());
    this.getChildren().addAll(eventLabel, name, startTime, duration);
    if (!event.getDescription().equals("")) {
      Label description = new Label(event.getDescription());
      this.getChildren().add(description);
    }
  }
}
