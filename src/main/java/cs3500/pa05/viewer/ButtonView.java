package cs3500.pa05.viewer;

import cs3500.pa05.controller.CreateEventHandler;
import cs3500.pa05.model.Activity;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class ButtonView extends BlockView {

  public ButtonView() {
    super();
    HBox addEventContainer = new HBox();
    addEventContainer.setAlignment(Pos.TOP_CENTER);
    addEventContainer.setMinWidth(110);
    addEventContainer.setMinHeight(110);

    ComboBox<Activity> comboBox = new ComboBox<>();
    comboBox.getItems().add(Activity.EVENT);
    comboBox.getItems().add(Activity.TASK);
    comboBox.setOnAction(new CreateEventHandler());

    Button addEvent = new Button("+", comboBox);
    addEvent.setAlignment(Pos.CENTER);
    addEvent.setMaxHeight(Double.MAX_VALUE);
    addEvent.setMaxWidth(Double.MAX_VALUE);

    addEventContainer.getChildren().add(addEvent);
    HBox.setHgrow(addEvent, Priority.ALWAYS);
    this.getChildren().add(addEventContainer);
  }
}
