package cs3500.pa05.viewer;

import javafx.scene.control.Label;

public class MaxView extends Label {
  String prefix;
  int current;
  int max;
  public MaxView(String prefix, int current, int max) {
    this.prefix = prefix;
    this.current = current;
    this.max = max;
    show();
  }

  public void subtract() {
    this.current -= 1;
    show();
  }

  private void show() {
    if (current > max) {
      this.setText(prefix + current + "/" + max + " Warning!");
    } else {
      this.setText(prefix + current + "/" + max);
    }
  }

}
