package cs3500.pa05.viewer;

import cs3500.pa05.controller.TaskDeleteHandler;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Task;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TaskView extends BlockView {
  public TaskView(Task task, Day day, List<Task> taskQueue, VBox taskQueueBox) {
    super();
    Label taskLabel = new Label("Task");
    Label name = new Label(task.getName());
    Label complete = new Label("Completed: " + task.getComplete());
    this.getChildren().addAll(taskLabel, name, complete);
    if (!task.getDescription().equals("")) {
      Label description = new Label(task.getDescription());
      this.getChildren().add(description);
    }
    Button delete = new Button("Delete");
    delete.setOnAction(new TaskDeleteHandler(task, day, this, taskQueue, taskQueueBox));
    this.getChildren().add(delete);
  }
}
