package cs3500.pa05.viewer;

import cs3500.pa05.model.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class EventView extends VBox {
  public EventView(Event event) {
    this.setAlignment(Pos.TOP_LEFT);
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
