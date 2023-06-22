package cs3500.pa05.model;

import cs3500.pa05.model.Theme;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThemeTest {

  private Theme theme;

  @BeforeEach
  public void setUp() {
    Color backgroundColor = Color.rgb(255, 255, 255);
    Color fontColor = Color.rgb(0, 0, 0);
    String fontFamily = "Arial";
    List<Image> images = new ArrayList<>();
    theme = new Theme(backgroundColor, fontColor, fontFamily, images);
  }

  @Test
  public void testGetBackgroundColor() {
    Color backgroundColor = theme.getBackgroundColor();
    assertEquals(Color.rgb(255, 255, 255), backgroundColor);
  }

  @Test
  public void testGetFontColor() {
    Color fontColor = theme.getFontColor();
    assertEquals(Color.rgb(0, 0, 0), fontColor);
  }

  @Test
  public void testGetFontFamily() {
    String fontFamily = theme.getFontFamily();
    assertEquals("Arial", fontFamily);
  }
}
