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
      return List.of(theme1().build(), theme2().build(), theme3().build());
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

    public ThemeBuilder nullTheme() {
      this.backgroundColor = null;
      this.fontColor = null;
      this.fontFamily = null;
      this.images = null;
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
   * update the background color of the theme.
   *
   * @param backgroundColor the background color of the theme
   */
  public void updateBackgroundColor(Color backgroundColor) {
    this.backgroundColor = backgroundColor;
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
   * update the font color of the theme.
   *
   * @param fontColor the font color of the theme
   */
  public void updateFontColor(Color fontColor) {
    this.fontColor = fontColor;
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
   * update the font family of the theme.
   *
   * @param fontFamily the font family of the theme
   */
  public void updateFontFamily(String fontFamily) {
    this.fontFamily = fontFamily;
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

  /**
   * update the images of the theme.
   *
   * @param images the images of the theme
   */
  public void updateImages(List<Image> images) {
    this.images = images;
  }

  /**
   * adds the image to the image list in the theme
   *
   * @param imagePath the path of the image
   */
  public void addImageToTheme(String imagePath) {
    Image image = new Image("file:" + imagePath);
    this.images.add(image);
    updateImages(this.images);
  }
}
