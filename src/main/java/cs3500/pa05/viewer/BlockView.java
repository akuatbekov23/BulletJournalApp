package cs3500.pa05.viewer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public abstract class BlockView extends VBox {
  public BlockView() {
    this.setMinHeight(110);
    this.setMinWidth(110);
    this.setBackground(Background.fill(new Color(0.5,0.5,0.5,1)));
    VBox.setMargin(this, new Insets(0, 0, 10, 0));
    this.setAlignment(Pos.TOP_LEFT);
    this.setPadding(new Insets(5));
  }
}