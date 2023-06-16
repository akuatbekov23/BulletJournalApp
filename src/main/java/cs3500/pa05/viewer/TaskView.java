package cs3500.pa05.viewer;

import cs3500.pa05.model.Event;
import cs3500.pa05.model.Task;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TaskView extends VBox {
  public TaskView(Task task) {
    this.setAlignment(Pos.TOP_LEFT);
    Label taskLabel = new Label("Task");
    Label name = new Label(task.getName());
    Label complete = new Label("Completed: " + task.getComplete());
    this.getChildren().addAll(taskLabel, name, complete);
    if (!task.getDescription().equals("")) {
      Label description = new Label(task.getDescription());
      this.getChildren().add(description);
    }
  }
}
