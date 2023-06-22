package cs3500.pa05.viewer;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * the IntroView
 */
public class IntroView implements Viewer {
  FXMLLoader loader;

  /**
   * constructs an IntroView
   */
  public IntroView() {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("intro.fxml"));
  }

  /**
   * loads the fxml file
   *
   * @return a Scene of the intro view
   * @throws IllegalStateException if the FXML file cannot be loaded
   */
  @Override
  public Scene load() throws IllegalStateException {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
