package cs3500.pa05.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Represents a theme.
 */
public class Theme {
  public static class ThemeBuilder {

    private Color backgroundColor;
    private Color fontColor;
    private String fontFamily;
    private List<Image> images = new ArrayList<>();

    public ThemeBuilder theme1() {
      this.backgroundColor = Color.rgb(255, 255, 255);
      this.fontColor = Color.rgb(0, 0, 0);
      this.fontFamily = "Arial";
      this.images.add(new Image("notesBottomRight.png"));
      this.images.add(new Image("notesQuotes.png"));
      this.images.add(new Image("notesTopLeft.png"));
      return this;
    }

    public ThemeBuilder theme2() {
      this.backgroundColor = Color.rgb(50, 50, 50);
      this.fontColor = Color.rgb(200, 100, 0);
      this.fontFamily = "Britannic Bold";
      this.images.add(new Image("starsBottomLeft.png"));
      this.images.add(new Image("starQuotes.png"));
      this.images.add(new Image("starsTopLeft.png"));
      return this;
    }

    public ThemeBuilder theme3() {
      this.backgroundColor = Color.rgb(192, 192, 192);
      this.fontColor = Color.rgb(0, 70, 0);
      this.fontFamily = "Times New Roman";
      this.images.add(new Image("shrekBottomRight.png"));
      this.images.add(new Image("shrekQuotes.png"));
      this.images.add(new Image("shrekTopLeft.png"));
      return this;
    }

    public List<Theme> defaultTheme() {
      return List.of(new ThemeBuilder().theme1().build(), new ThemeBuilder().theme2().build(),
          new ThemeBuilder().theme3().build());
    }

    public ThemeBuilder setBackgroundColor(Color color) {
      this.backgroundColor = color;
      return this;
    }

    public ThemeBuilder setFontColor(Color color) {
      this.fontColor = color;
      return this;
    }

    public ThemeBuilder setFontFamily(String fontFamily) {
      this.fontFamily = fontFamily;
      return this;
    }

    public ThemeBuilder setImages(List<Image> images) {
      this.images = images;
      return this;
    }

    public Theme build() {
      return new Theme(backgroundColor, fontColor, fontFamily, images);
    }
  }

  private Color backgroundColor;
  private Color fontColor;
  private String fontFamily;
  private List<Image> images;


  /**
   * Constructs a theme.
   *
   * @param backgroundColor the background color of the theme
   * @param fontColor       the font color of the theme
   * @param fontFamily      the font family of the theme
   */
  private Theme(Color backgroundColor, Color fontColor, String fontFamily, List<Image> images) {
    this.backgroundColor = backgroundColor;
    this.fontColor = fontColor;
    this.fontFamily = fontFamily;
    this.images = images;
  }

  /**
   * get the background color of the theme.
   *
   * @return the background color of the theme
   */
  public Color getBackgroundColor() {
    return this.backgroundColor;
  }

  /**
   * get the font color of the theme.
   *
   * @return the font color of the theme
   */
  public Color getFontColor() {
    return this.fontColor;
  }

  /**
   * get the font family of the theme.
   *
   * @return the font family of the theme
   */
  public String getFontFamily() {
    return this.fontFamily;
  }

  /**
   * get the images of the theme.
   *
   * @return the images of the theme
   */
  public List<Image> getImages() {
    // if images is null, then return an empty list
    if (this.images == null) {
      return new ArrayList<>();
    } else {
      return this.images;
    }
  }
}
