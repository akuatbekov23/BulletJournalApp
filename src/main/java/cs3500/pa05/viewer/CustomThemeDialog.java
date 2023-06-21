package cs3500.pa05.viewer;

import cs3500.pa05.model.Theme;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class CustomThemeDialog extends Dialog<Theme> {

  private final Theme theme;
  private ColorPicker backgroundColorPicker;
  private ColorPicker fontColorPicker;
  private TextField fontFamilyTextField;
  private ListView<File> imageListView;

  public CustomThemeDialog(Theme theme) {
    super();
    this.theme = theme;
    this.setTitle("Customize Theme");

    buildUI();
    setResultConverter();
  }

  private void buildUI() {
    VBox content = new VBox(10);

    backgroundColorPicker = new ColorPicker();
    fontColorPicker = new ColorPicker();
    fontFamilyTextField = new TextField();
    imageListView = new ListView<>();

    content.getChildren().addAll(
        createColorPickerItem("Background Color:", backgroundColorPicker),
        createColorPickerItem("Font Color:", fontColorPicker),
        createTextFieldItem("Font Family:", fontFamilyTextField),
        createImagePickerItem("Image Bottom Right:", imageListView),
        createImagePickerItem("Image Quotes and Notes:", imageListView),
        createImagePickerItem("Image Top Left:", imageListView)
    );

    getDialogPane().setContent(content);

    getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
  }

  private VBox createColorPickerItem(String label, ColorPicker colorPicker) {
    VBox item = new VBox(5);

    item.getChildren().addAll(
        new javafx.scene.control.Label(label),
        colorPicker
    );

    return item;
  }

  private VBox createTextFieldItem(String label, TextField textField) {
    VBox item = new VBox(5);

    item.getChildren().addAll(
        new javafx.scene.control.Label(label),
        textField
    );

    return item;
  }

  private VBox createImagePickerItem(String label, ListView<File> listView) {
    VBox item = new VBox(5);
    item.setPrefHeight(120);

    item.getChildren().addAll(
        new javafx.scene.control.Label(label),
        listView
    );

    Button importButton = new Button("Import");
    importButton.setOnAction(event -> {
      Stage fileChooserStage = (Stage) getDialogPane().getScene().getWindow();

      FileChooser fileChooser = new FileChooser();
      fileChooser.getExtensionFilters().addAll(
          new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
          new ExtensionFilter("All Files", "*.*")
      );

      List<File> selectedFiles = fileChooser.showOpenMultipleDialog(fileChooserStage);
      if (selectedFiles != null) {
        ObservableList<File> fileList = FXCollections.observableArrayList(selectedFiles);
        listView.getItems().add(fileList.get(0));
      }
    });

    item.getChildren().add(importButton);

    return item;
  }

  private void setResultConverter() {
    setResultConverter(buttonType -> {
      if (buttonType == ButtonType.OK) {
        Color backgroundColor = backgroundColorPicker.getValue();
        Color fontColor = fontColorPicker.getValue();
        String fontFamily = fontFamilyTextField.getText();
        List<File> images = imageListView.getItems();

        Theme themeSettings = new Theme.ThemeBuilder().setBackgroundColor(backgroundColor)
            .setFontColor(fontColor).setFontFamily(fontFamily)
            .setImages(convertFilesToImages(images)).build();
        return themeSettings;
      } else {
        return null;
      }
    });
  }

  public List<Image> convertFilesToImages(List<File> files) {
    List<Image> images = new ArrayList<>();

    for (File file : files) {
      try {
        Image image = new Image(file.toURI().toString());
        images.add(image);
      } catch (Exception e) {
        // Handle any exceptions that may occur during image loading
        // For example, you can log the error or display an error message
        e.printStackTrace();
      }
    }

    return images;
  }
}
