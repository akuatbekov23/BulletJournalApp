package cs3500.pa05.viewer;

import cs3500.pa05.controller.Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class IntroView implements Viewer {
  FXMLLoader loader;

  public IntroView() {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("intro.fxml"));
  }

  @Override
  public Scene load() throws IllegalStateException {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
