package cs3500.pa05.viewer;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.TaskDeleteHandler;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.Task;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class TaskView extends BlockView {
  public TaskView(Task task, ObservableList<Task> taskQueue, Controller controller,
                  Day day, MaxView maxView) {
    super();
    Label taskLabel = new Label("Task");
    Label name = new Label(task.getName());
    CheckBox complete = new CheckBox();
    complete.setSelected(task.getComplete());
    complete.setOnAction(e -> {
      task.changeComplete();
      List<Task> temp = new ArrayList<>();
      for (Task t : taskQueue) {
        temp.add(t);
        taskQueue.remove(t);
      }
      taskQueue.addAll(temp);
      controller.initialize();
    });
    this.getChildren().addAll(taskLabel, name, complete);
    if (!task.getDescription().equals("")) {
      Label description = new Label(task.getDescription());
      this.getChildren().add(description);
    }
    Button delete = new Button("Delete");
    delete.setOnAction(e -> {
      new TaskDeleteHandler(task, taskQueue, day, this, maxView).handle(e);
      controller.initialize();
    });
    this.getChildren().add(delete);
  }
}
