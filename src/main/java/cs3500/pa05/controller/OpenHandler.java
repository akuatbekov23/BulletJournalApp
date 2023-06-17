package cs3500.pa05.controller;

import cs3500.pa05.controller.reader.BujoReader;
import cs3500.pa05.controller.reader.Reader;
import java.io.File;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.event.Event;
import javafx.event.EventHandler;

public class OpenHandler implements EventHandler {
  /**
   * Invoked when a specific event of the type for which this handler is
   * registered happens.
   *
   * @param event the event which occurred
   */
  @Override
  public void handle(Event event) {
    Reader reader = new BujoReader();
    FileChooser fileChooser = new FileChooser();
//    File selectedFile = fileChooser.showSaveDialog(primaryStage);
//    if (selectedFile != null) {
//      try (BufferedReader br = Files.newBufferedReader(selectedFile.toPath(), StandardCharsets.UTF_8)) {
//        br.write("Hello World!\n");
//      }
//    }
  }
}
