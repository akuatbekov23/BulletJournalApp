package cs3500.pa05.viewer;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;

public class MaxView extends Label {
  String prefix;
  int current;
  StringProperty max;
  public MaxView(String prefix, int current, StringProperty max) {
    this.prefix = prefix;
    this.current = current;
    this.max = max;
    this.setText(show(max.get()));
    max.addListener((obs, old, newVal) -> {
      this.setText(show(max.get()));
    });
  }

  public void subtract() {
    this.current -= 1;
    this.setText(show(max.get()));
  }

  private String show(String max) {
    if (current > Integer.parseInt(max)) {
      return prefix + current + "/" + max + " Warning!";
    } else {
      return prefix + current + "/" + max;
    }
  }
}
