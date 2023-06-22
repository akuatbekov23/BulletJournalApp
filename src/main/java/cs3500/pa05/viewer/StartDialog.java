package cs3500.pa05.viewer;

import java.io.File;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.util.Callback;

/**
 * a StartDialog
 */
public class StartDialog extends Dialog {
  private Scene scene;

  /**
   * constructs a StartDialog
   *
   * @param scene the scene to construct it on
   */
  public StartDialog(Scene scene) {
    super();
    this.scene = scene;
    this.setTitle("Journal Setup");
    buildUi();
    this.setResultConverter();
  }

  /**
   * builds the UI for the StartDialog
   */
  private void buildUi() {
    Pane pane = new Pane();
    pane.setPrefSize(500, 200);
    VBox vertBox = new VBox(20);
    vertBox.setAlignment(Pos.CENTER);
    vertBox.setPrefSize(500, 200);
    String style = "-fx-border-radius: 50px; -fx-border-color: black;"
        + "-fx-background-radius: 50px; "
        + "-fx-background-color: transparent; "
        + "-fx-pref-height: 40; -fx-pref-width: 100;";
    Button newBtn = new Button("New Journal");
    newBtn.setStyle(style);
    Button openBtn = new Button("Open Journal");
    openBtn.setStyle(style);
    newBtn.setOnAction(e -> {
      this.close();
    });
    openBtn.setOnAction(e -> {
      FileChooser fileChooser = new FileChooser();
      FileChooser.ExtensionFilter bujoFilter =
          new FileChooser.ExtensionFilter("Bujo Files", "*.bujo");
      fileChooser.getExtensionFilters().add(bujoFilter);
      File file = fileChooser.showOpenDialog(scene.getWindow());
      if (file != null) {
        this.setResult(file);
      }
    });
    vertBox.getChildren().addAll(newBtn, openBtn);
    pane.getChildren().add(vertBox);
    getDialogPane().setContent(pane);
    getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
    Button closeButton = (Button) getDialogPane().lookupButton(ButtonType.CANCEL);
    closeButton.setVisible(false);
    getDialogPane().setStyle("-fx-background-color: #FFE2E4");
  }

  /**
   * sets the result converter to the resulting file
   */
  public void setResultConverter() {
    Callback<ButtonType, File> fileResult = new Callback<ButtonType, File>() {
      @Override
      public File call(ButtonType param) {
        return null;
      }
    };
    setResultConverter(fileResult);
  }
}
