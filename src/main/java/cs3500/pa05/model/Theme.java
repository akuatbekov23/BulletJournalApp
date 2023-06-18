package cs3500.pa05.model;

import javafx.scene.paint.Color;

/**
 * Represents a theme.
 */
public class Theme {

  public static final Theme THEME_1 = new Theme(Color.rgb(255, 255, 255),
      Color.rgb(0, 0, 0), "Arial");
  public static final Theme THEME_2 = new Theme(Color.rgb(0, 0, 0),
      Color.rgb(255, 255, 255), "Calibri");
  public static final Theme THEME_3 = new Theme(new Color(0.477, 0.030, 0.9, 1),
      new Color(0, 0, 0, 1), "Bauhaus 93");

  public Color backgroundColor;
  public Color fontColor;
  public String fontFamily;

  /**
   * Constructs a theme.
   *
   * @param backgroundColor the background color of the theme
   * @param fontColor       the font color of the theme
   * @param fontFamily      the font family of the theme
   */
  public Theme(Color backgroundColor, Color fontColor, String fontFamily) {
    this.backgroundColor = backgroundColor;
    this.fontColor = fontColor;
    this.fontFamily = fontFamily;
  }

  /**
   * update the background color of the theme.
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

}
