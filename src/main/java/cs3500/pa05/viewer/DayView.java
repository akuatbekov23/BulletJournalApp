package cs3500.pa05.viewer;

import cs3500.pa05.model.Day;
import cs3500.pa05.model.Events;
import cs3500.pa05.model.Task;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DayView extends VBox {
  public DayView(Day day, List<Task> taskQueue, VBox taskQueueBox) {
    this.setPadding(new Insets(10));
    this.setAlignment(Pos.TOP_CENTER);
    Label dayOfTheWeek = new Label(day.getDay());
    dayOfTheWeek.setPadding(new Insets(10));
    this.getChildren().add(dayOfTheWeek);
    for (Events e : day.getEvents()) {
      this.getChildren().add(new EventView(e, day));
    }
    for (Task t : day.getTasks()) {
      this.getChildren().add(new TaskView(t, day, taskQueue, taskQueueBox));
    }
    this.getChildren().add(new ButtonView());

  }
}
