package cs3500.pa05.viewer;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Events;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class DayView extends VBox {
  public DayView(Day day, Week week, Controller controller) {
    MaxView maxEventsView = new MaxView("Events: ", day.getEvents().size(),
        week.getMaxEventsStrProp());
    abstractDayView(day, week, controller, maxEventsView);
    MaxView maxTasksView = new MaxView("Tasks: ", day.getTasks().size(),
        week.getMaxTasksStrProp());
    VBox taskContainer = new VBox();
    for (Task t : day.getTasks()) {
      taskContainer.getChildren().add(new TaskView(t, week.getTaskQueue(),
          controller, day, maxTasksView));
    }
    this.getChildren().addAll(taskContainer,
        new ButtonView(day, week, controller), maxEventsView, maxTasksView);
  }

  public DayView(Day day, String query, Week week, Controller controller) {
    MaxView maxEventsView = new MaxView("Events: ", day.getEvents().size(),
        week.getMaxEventsStrProp());
    abstractDayView(day, week, controller, maxEventsView);
    MaxView maxTasksView = new MaxView("Tasks: ", day.getTasks().size(),
        week.getMaxTasksStrProp());
    VBox taskContainer = new VBox();
    for (Task t : day.getTasks()) {
      if (t.getDescription().toLowerCase().contains(query) || t.getName().toLowerCase().contains(query)
          || t.day.toString().toLowerCase().contains(query)) {
        taskContainer.getChildren().add(new TaskView(t, week.getTaskQueue(),
            controller, day, maxTasksView));
      }
    }
    this.getChildren().addAll(taskContainer,
        new ButtonView(day, week, controller), maxEventsView, maxTasksView);
  }

  private void abstractDayView(Day day, Week week, Controller controller, MaxView maxEventsView) {
    this.setPadding(new Insets(10));
    this.setAlignment(Pos.TOP_CENTER);
    Label dayOfTheWeek = new Label(day.getDay());
    dayOfTheWeek.setPadding(new Insets(10));
    this.getChildren().add(dayOfTheWeek);
    VBox eventContainer = new VBox();
    for (Events e : day.getEvents()) {
      eventContainer.getChildren().add(new EventView(e, day, maxEventsView, controller));
    }
    this.getChildren().add(eventContainer);
  }
}
