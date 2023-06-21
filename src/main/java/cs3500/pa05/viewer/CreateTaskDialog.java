package cs3500.pa05.viewer;

import cs3500.pa05.model.DayEnum;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Week;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class CreateTaskDialog extends Dialog {
  private DayEnum dayEnum;
  private TextField title;
  private TextField description;

  public CreateTaskDialog(DayEnum dayEnum) {
    super();
    this.setTitle("Create a New Task");
    this.dayEnum = dayEnum;
    buildUI();
    setResultConverter();
  }

  private void buildUI() {
    Pane pane = buildDialog();
    getDialogPane().setContent(pane);

    getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.CANCEL);

    Button button = (Button) getDialogPane().lookupButton(ButtonType.FINISH);
    button.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        if (validate()) {
          event.consume();
        }
      }

      private boolean validate() {
        return (title.getText().isEmpty());
      }
    });

  }

  private Pane buildDialog() {
    VBox content = new VBox(10);

    Label titleLabel = new Label("Title: ");
    Label descriptionLabel = new Label("Desc: ");

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(5);
    grid.add(titleLabel, 0, 0);
    grid.add(descriptionLabel, 0, 1);

    title = new TextField();
    description = new TextField();

    grid.add(title, 1, 0);
    GridPane.setHgrow(this.title, Priority.ALWAYS);
    grid.add(description, 1, 1);
    GridPane.setHgrow(this.description, Priority.ALWAYS);

    content.getChildren().add(grid);

    return content;
  }

  public void setResultConverter() {
    Callback<ButtonType, Task> taskResult = new Callback<ButtonType, Task>() {
      @Override
      public Task call(ButtonType param) {
        if (param == ButtonType.FINISH) {
          return new Task(title.getText(), description.getText(), dayEnum, false);
        } else {
          return null;
        }
      }
    };
    setResultConverter(taskResult);
  }
}
