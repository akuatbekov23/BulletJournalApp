package cs3500.pa05.viewer;

import cs3500.pa05.controller.CreateEventHandler;
import cs3500.pa05.controller.CreateTaskHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ChooseNewDialog extends Dialog {

  public ChooseNewDialog() {
    super();
    this.setTitle("Choose Which One To Create");

    buildPrompt();
  }

  private void buildPrompt() {
    Pane pane = buildDialog();
    getDialogPane().setContent(pane);

    getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
  }

  private Pane buildDialog() {
    VBox content = new VBox(10);

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(5);
    Button newEvent = new Button("New Event");
    Button newTask = new Button("New Task");
    grid.add(newEvent, 1, 0);
    grid.add(newTask, 1, 1);
    newEvent.setOnAction(new CreateEventHandler());
    newTask.setOnAction(new CreateTaskHandler());

    content.getChildren().add(grid);

    return content;

  }


}

