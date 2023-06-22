package cs3500.pa05.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Theme class.
 */
public class ThemeTest {

  private Theme theme;



  /**
   * setup for the tests.
   */
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

  @Test
  public void testGetImages() {
    // Create a list of images
    List<Image> images = new ArrayList<>();
    images.add(new Image("L.png"));
    images.add(new Image("Loveball.png"));

    // Create a theme with the list of images
    Theme theme = new Theme(Color.WHITE, Color.BLACK, "Arial", images);

    // Retrieve the images from the theme
    List<Image> retrievedImages = theme.getImages();

    // Assert that the retrieved images match the original images
    Assertions.assertEquals(images, retrievedImages);
  }

  @Test
  public void testGetImagesNull() {
    // Create a theme with a null list of images
    Theme theme = new Theme(Color.WHITE, Color.BLACK, "Arial", null);

    // Retrieve the images from the theme
    List<Image> retrievedImages = theme.getImages();

    // Assert that the retrieved images are an empty list
    Assertions.assertEquals(Collections.emptyList(), retrievedImages);
  }


  @Test
  public void testSetImagesThemeBuilder() {
    // Create a list of images
    List<Image> images = new ArrayList<>();
    images.add(new Image("L.png"));
    images.add(new Image("Loveball.png"));

    // Create a theme using the ThemeBuilder
    Theme theme = new Theme.ThemeBuilder()
        .setImages(images)
        .build();

    // Retrieve the images from the theme
    List<Image> retrievedImages = theme.getImages();

    // Assert that the retrieved images match the original images
    Assertions.assertEquals(images, retrievedImages);
  }



}
