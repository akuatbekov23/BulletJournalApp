package cs3500.pa05.viewer;

import cs3500.pa05.model.Events;
import javafx.scene.control.Label;

public class EventView extends BlockView {
  public EventView(Events events) {
    super();
    Label eventLabel = new Label("Events");
    Label name = new Label(events.getName());
    Label startTime = new Label("Start time: " + events.getStartTime());
    Label duration = new Label("Duration: " + events.getDuration());
    this.getChildren().addAll(eventLabel, name, startTime, duration);
    if (!events.getDescription().equals("")) {
      Label description = new Label(events.getDescription());
      this.getChildren().add(description);
    }
  }
}
