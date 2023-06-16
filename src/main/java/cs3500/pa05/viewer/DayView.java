package cs3500.pa05.viewer;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DayView extends VBox {
  public DayView(Day day) {
    this.setAlignment(Pos.TOP_CENTER);
    Label dayOfTheWeek = new Label(day.getDay());
    this.getChildren().add(dayOfTheWeek);
    for (Event e : day.getEvents()) {
      this.getChildren().add(new EventView(e));
    }
    for (Task t : day.getTasks()) {
      this.getChildren().add(new TaskView(t));
    }
  }
}