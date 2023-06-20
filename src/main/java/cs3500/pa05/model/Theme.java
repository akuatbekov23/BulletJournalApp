package cs3500.pa05.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 * Represents a theme.
 */
public class Theme {

  /**
   * Represents theme 1.
   */
  public static final Theme THEME_1 = new Theme(Color.rgb(255, 255, 255),
      Color.rgb(0, 0, 0), "Arial", null);

  /**
   * Represents theme 2.
   */
  public static final Theme THEME_2 = new Theme(Color.rgb(50, 50, 50),
      Color.rgb(200, 100, 0), "Britannic Bold", null);

  /**
   * Represents theme 3.
   */
  public static final Theme THEME_3 = new Theme(Color.rgb(192, 192, 192),
      Color.rgb(0, 70, 0), "Times New Roman", null);



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
  public Theme(Color backgroundColor, Color fontColor, String fontFamily, List<Image> images) {
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
    return this.images;
  }

  /**
   * update the images of the theme.
   *
   * @param images the images of the theme
   */
  public void updateImages(List<Image> images) {
    this.images = images;
  }




}
