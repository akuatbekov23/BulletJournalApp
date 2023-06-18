package cs3500.pa05.viewer;

import cs3500.pa05.model.Theme;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ThemeView extends BlockView{
  public ThemeView() {
    super();

    // Create the theme buttons
    Button themeButton1 = new Button("Theme 1");
    Button themeButton2 = new Button("Theme 2");
    Button themeButton3 = new Button("Theme 3");

    themeButton1.setStyle("-fx-background-color: #000000;"); // Set the background color to black

    themeButton1.setStyle("-fx-background-color: #ff0000;"); // Set the background color to black

    themeButton1.setStyle("-fx-background-color: #0000ff;"); // Set the background color to black


    // Create an HBox to contain the theme buttons
    HBox themeButtonsContainer = new HBox(themeButton1, themeButton2, themeButton3);
    themeButtonsContainer.setAlignment(Pos.TOP_LEFT);
    themeButtonsContainer.setSpacing(10);
    themeButtonsContainer.setPadding(new Insets(10));


  }
}
