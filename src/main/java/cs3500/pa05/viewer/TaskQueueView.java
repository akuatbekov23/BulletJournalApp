package cs3500.pa05.viewer;

import cs3500.pa05.model.Task;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TaskQueueView extends VBox {
  public TaskQueueView(Task task) {
    this.setPadding(new Insets(10));
    Label name = new Label(task.getName());
    name.setStyle("-fx-text-fill: black;");
    Label complete = new Label("Completed: " + task.getComplete());
    complete.setStyle("-fx-text-fill: black;");
    this.getChildren().addAll(name, complete);
  }
}
