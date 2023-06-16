package cs3500.pa05.viewer;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ButtonView extends VBox {

  public ButtonView() {
    this.setAlignment(Pos.TOP_CENTER);

    HBox addEventContainer = new HBox();
    addEventContainer.setAlignment(Pos.TOP_CENTER);
    addEventContainer.setMinWidth(80); // looks ugly cause it's going by comp_size calcualtion
    addEventContainer.setMinHeight(80);

    Button addEvent = new Button("+");
    addEvent.setAlignment(Pos.CENTER);
    addEvent.setMaxHeight(Double.MAX_VALUE);
    addEvent.setMaxWidth(Double.MAX_VALUE);

    addEventContainer.getChildren().add(addEvent);
    HBox.setHgrow(addEvent, Priority.ALWAYS);
    this.getChildren().add(addEventContainer);
    // functionality goes here: addEvent.setOnAction(value);


  }
}
