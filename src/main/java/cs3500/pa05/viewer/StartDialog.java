package cs3500.pa05.viewer;

import java.io.File;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
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
    buildUI();
    this.setResultConverter();
  }

  /**
   * builds the UI for the StartDialog
   */
  private void buildUI() {
    Pane pane = new Pane();
    pane.setPrefSize(1280, 720);
    VBox vBox = new VBox();
    Button newBtn = new Button("New Journal");
    newBtn.setOnAction(e -> {
      this.close();
    });
    Button openBtn = new Button("Open Journal");
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
    vBox.getChildren().addAll(newBtn, openBtn);
    pane.getChildren().add(vBox);
    getDialogPane().setContent(pane);
    getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
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
