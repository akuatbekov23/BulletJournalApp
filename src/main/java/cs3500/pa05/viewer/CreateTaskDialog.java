package cs3500.pa05.viewer;

import cs3500.pa05.model.DayEnum;
import cs3500.pa05.model.Task;
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

public class CreateTaskDialog extends Dialog {

  private final Task task;
  private TextField title;
  private TextField description;

  private TextField day;
  public CreateTaskDialog(Task task) {
    super();
    this.task = task;
    this.setTitle("Create a New Task");

    buildUI();
    setTask();
  }

  private void buildUI() {
    Pane pane = buildDialog();
    getDialogPane().setContent(pane);

    getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.CANCEL);

    Button button = (Button) getDialogPane().lookupButton(ButtonType.FINISH);
    button.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        if (!validate()) {
          event.consume();
        }
      }

      private boolean validate() {
        return (title.getText().isEmpty() || day.getText().isEmpty());
      }
    });

  }

  private Pane buildDialog() {
    VBox content = new VBox(10);

    Label titleLabel = new Label("Title: ");
    Label descriptionLabel = new Label("Desc: ");
    Label dayLabel = new Label("Day: ");

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(5);
    grid.add(titleLabel, 0, 0);
    grid.add(descriptionLabel, 0, 1);
    grid.add(dayLabel, 0, 2);

    title = new TextField();
    description = new TextField();
    day = new TextField();

    grid.add(title, 1, 0);
    GridPane.setHgrow(this.title, Priority.ALWAYS);
    grid.add(description, 1, 1);
    GridPane.setHgrow(this.description, Priority.ALWAYS);
    grid.add(day, 1, 2);
    GridPane.setHgrow(this.day, Priority.ALWAYS);

    content.getChildren().add(grid);

    return content;
  }

  private void setTask() {
    task.name = title.getText();
    task.description = description.getText();
    String dayString = day.getText();
    if (dayString.equals("Monday")) {
      task.day = DayEnum.MONDAY;
    } else if (dayString.equals("Tuesday")) {
      task.day = DayEnum.TUESDAY;
    } else if (dayString.equals("Wednesday")) {
      task.day = DayEnum.WEDNESDAY;
    } else if (dayString.equals("Thursday")) {
      task.day = DayEnum.THURSDAY;
    } else if (dayString.equals("Friday")) {
      task.day = DayEnum.FRIDAY;
    } else if (dayString.equals("Saturday")) {
      task.day = DayEnum.SATURDAY;
    } else if (dayString.equals("Sunday")) {
      task.day = DayEnum.SUNDAY;
    }
  }
}
