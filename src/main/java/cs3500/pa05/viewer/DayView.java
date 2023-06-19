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
  public DayView(Day day, List<Task> taskQueue, VBox taskQueueBox, int maxEvents, int maxTasks) {
    this.setPadding(new Insets(10));
    this.setAlignment(Pos.TOP_CENTER);
    Label dayOfTheWeek = new Label(day.getDay());
    dayOfTheWeek.setPadding(new Insets(10));
    this.getChildren().add(dayOfTheWeek);
    MaxView maxEventsView = new MaxView("Events: ", day.getEvents().size(), maxEvents);
    MaxView maxTasksView = new MaxView("Tasks: ", day.getTasks().size(), maxTasks);
    for (Events e : day.getEvents()) {
      this.getChildren().add(new EventView(e, day, maxEventsView));
    }
    for (Task t : day.getTasks()) {
      this.getChildren().add(new TaskView(t, day, taskQueue, taskQueueBox, maxTasksView));
    }
    this.getChildren().addAll(new ButtonView(), maxEventsView, maxTasksView);
  }

  public DayView(Day day, List<Task> taskQueue, VBox taskQueueBox, String query,
                 int maxEvents, int maxTasks) {
    this.setPadding(new Insets(10));
    this.setAlignment(Pos.TOP_CENTER);
    Label dayOfTheWeek = new Label(day.getDay());
    dayOfTheWeek.setPadding(new Insets(10));
    this.getChildren().add(dayOfTheWeek);
    MaxView maxEventsView = new MaxView("Events: ", day.getEvents().size(), maxEvents);
    MaxView maxTasksView = new MaxView("Tasks: ", day.getTasks().size(), maxTasks);
    for (Events e : day.getEvents()) {
      this.getChildren().add(new EventView(e, day, maxEventsView));
    }
    for (Task t : day.getTasks()) {
      if (t.getDescription().toLowerCase().contains(query) || t.getName().toLowerCase().contains(query)
          || t.day.toString().toLowerCase().contains(query)) {
        this.getChildren().add(new TaskView(t, day, taskQueue, taskQueueBox, maxTasksView));
      }
    }
    this.getChildren().addAll(new ButtonView(), maxEventsView, maxTasksView);
  }
}
