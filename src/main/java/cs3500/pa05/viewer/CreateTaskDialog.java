package cs3500.pa05.viewer;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CreateTaskDialog extends Dialog {

  private TextField title;
  private TextField description;

  public CreateTaskDialog() {
    super();
    this.setTitle("Create a New Task");

    buildUI();
  }

  private void buildUI() {
    Pane pane = buildDialog();
    getDialogPane().setContent(pane);

    getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.CANCEL);
  }

  private Pane buildDialog() {
    VBox content = new VBox(10);

    Label titleLabel = new Label("Title: ");
    Label descriptionLabel = new Label("Desc: ");
    Label startLabel = new Label("Start Time: ");
    Label durationLabel = new Label("Duration: ");

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(5);
    grid.add(titleLabel, 0, 0);
    grid.add(descriptionLabel, 0, 1);
    grid.add(startLabel, 0, 2);
    grid.add(durationLabel, 0, 3);

    title = new TextField();
    description = new TextField();

    grid.add(title, 1, 0);
    GridPane.setHgrow(this.title, Priority.ALWAYS);
    grid.add(description, 1, 1);
    GridPane.setHgrow(this.description, Priority.ALWAYS);

    content.getChildren().add(grid);

    return content;
  }
}
