package cs3500.pa05.viewer;

import cs3500.pa05.controller.ChooseNewHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import cs3500.pa05.model.Day;

public class ButtonView extends BlockView {
  public ButtonView(Day day) {
    super();
    HBox addEventContainer = new HBox();
    addEventContainer.setAlignment(Pos.TOP_CENTER);
    addEventContainer.setMinWidth(110);
    addEventContainer.setMinHeight(110);

    Button addEvent = new Button("+");
    addEvent.setAlignment(Pos.CENTER);
    addEvent.setMaxHeight(Double.MAX_VALUE);
    addEvent.setMaxWidth(Double.MAX_VALUE);
    addEvent.setOnAction(new ChooseNewHandler(day));

    addEventContainer.getChildren().add(addEvent);
    HBox.setHgrow(addEvent, Priority.ALWAYS);
    this.getChildren().add(addEventContainer);
  }
}
