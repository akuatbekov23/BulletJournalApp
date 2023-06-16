package cs3500.pa05.viewer;

import javafx.scene.Scene;

public interface Viewer {
  Scene load() throws IllegalStateException;
}
