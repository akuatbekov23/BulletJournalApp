package cs3500.pa05.model;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
    Platform.startup(() -> {
      // Initialize JavaFX components here
    });
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


  @Test
  public void testTheme1() {
    Theme.ThemeBuilder builder = new Theme.ThemeBuilder();
    Theme theme = builder.theme1().build();

    Assertions.assertEquals(Color.rgb(255, 255, 255), theme.getBackgroundColor());
    Assertions.assertEquals(Color.rgb(0, 0, 0), theme.getFontColor());
    Assertions.assertEquals("Arial", theme.getFontFamily());
    //Assertions.assertEquals(3, theme.getImages().size());
    // Add more assertions if needed
  }

  @Test
  public void testTheme2() {
    Theme.ThemeBuilder builder = new Theme.ThemeBuilder();
    Theme theme = builder.theme2().build();

    Assertions.assertEquals(Color.rgb(250, 218, 221), theme.getBackgroundColor());
    Assertions.assertEquals(Color.rgb(255, 0, 0), theme.getFontColor());
    Assertions.assertEquals("Lucida Calligraphy", theme.getFontFamily());
    //Assertions.assertEquals(3, theme.getImages().size());
    // Add more assertions if needed
  }

  @Test
  public void testTheme3() {
    Theme.ThemeBuilder builder = new Theme.ThemeBuilder();
    Theme theme = builder.theme3().build();

    Assertions.assertEquals(Color.rgb(0, 0, 0), theme.getBackgroundColor());
    Assertions.assertEquals(Color.rgb(255, 255, 255), theme.getFontColor());
    Assertions.assertEquals("Jokerman", theme.getFontFamily());
    //Assertions.assertEquals(3, theme.getImages().size());
    // Add more assertions if needed
  }

  @Test
  public void testDefaultTheme() {
    Theme.ThemeBuilder builder = new Theme.ThemeBuilder();
    List<Theme> themes = builder.defaultTheme();

    Assertions.assertEquals(3, themes.size());
    // Add assertions to verify the properties of each theme
  }

  @Test
  public void testSetBackgroundColor() {
    Theme.ThemeBuilder builder = new Theme.ThemeBuilder();
    Color backgroundColor = Color.rgb(123, 45, 67);
    Theme theme = builder.setBackgroundColor(backgroundColor).build();

    Assertions.assertEquals(backgroundColor, theme.getBackgroundColor());
  }

  @Test
  public void testSetFontColor() {
    Theme.ThemeBuilder builder = new Theme.ThemeBuilder();
    Color fontColor = Color.rgb(12, 34, 56);
    Theme theme = builder.setFontColor(fontColor).build();

    Assertions.assertEquals(fontColor, theme.getFontColor());
  }

  @Test
  public void testSetFontFamily() {
    Theme.ThemeBuilder builder = new Theme.ThemeBuilder();
    String fontFamily = "Verdana";
    Theme theme = builder.setFontFamily(fontFamily).build();

    Assertions.assertEquals(fontFamily, theme.getFontFamily());
  }

  @Test
  public void testSetImages() {
    Platform.runLater(() -> {
      Theme.ThemeBuilder builder = new Theme.ThemeBuilder();
      List<Image> images = List.of(new Image("image1.png"), new Image("image2.png"));
      Theme theme = builder.setImages(images).build();

      Assertions.assertEquals(images, theme.getImages());
    });
  }

}
