package cs3500.pa05.controller;

import cs3500.pa05.model.Events;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Theme;
import cs3500.pa05.viewer.CreateEventDialog;
import cs3500.pa05.viewer.CustomThemeDialog;
import java.util.List;
import java.util.Optional;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Dialog;

public class CustomThemeHandler implements EventHandler {
  List<Theme> themes;

  public CustomThemeHandler(List<Theme> themes) {
    this.themes = themes;
  }

  @Override
  public void handle(Event event) {
    Dialog popup = new CustomThemeDialog();

    Optional<Theme> result = popup.showAndWait();

    result.ifPresent((Theme theme) -> {
      themes.add(theme);
    });

  }
}
