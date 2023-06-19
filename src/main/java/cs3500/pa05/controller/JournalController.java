package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.controller.reader.BujoReader;
import cs3500.pa05.controller.writer.BujoWriter;
import cs3500.pa05.model.Day;
import cs3500.pa05.model.DayEnum;
import cs3500.pa05.model.Events;
import cs3500.pa05.model.Task;
import cs3500.pa05.model.Theme;
import cs3500.pa05.model.Week;
import cs3500.pa05.model.json.DayJson;
import cs3500.pa05.model.json.EventJson;
import cs3500.pa05.model.json.JsonUtils;
import cs3500.pa05.model.json.TaskJson;
import cs3500.pa05.model.json.ThemeJson;
import cs3500.pa05.model.json.WeekJson;
import cs3500.pa05.viewer.DayView;
import cs3500.pa05.viewer.TaskQueueView;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Represents a controller for the journal.
 */
public class JournalController implements Controller {
  private Week week;

  @FXML
  private Scene weekScene;
  @FXML
  private VBox taskQueue;
  @FXML
  private GridPane weekGrid;
  @FXML
  private AnchorPane weekPane1;
  @FXML
  private HBox titleHBox;
  @FXML
  private TextArea noteTextArea;

  /**
   * Constructs a new JournalController.
   *
   * @param week the week to use
   */
  public JournalController(Week week) {
    this.week = week;
  }

  @Override
  public void run() {
    initialize();
  }

  /**
   * Initializes the GUI.
   */
  private void initialize() {
    // Week View
    for (int i = 0; i < 7; i++) {
      weekGrid.add(new DayView(week.getDay(i)), i, 0);
    }

    // Task Queue
    for (int i = 0; i < week.getTaskQueue().size(); i++) {
      taskQueue.getChildren().add(new TaskQueueView(week.getTaskQueue().get(i)));
    }

    noteTextArea.setText(week.getNotes());

    // Create the theme buttons
    Button themeButton1 = new Button("Light Mode");
    Button themeButton2 = new Button("Dark Mode");
    Button themeButton3 = new Button("Funky Mode");

    themeButton1.setStyle("-fx-background-color: #ffffff;");
    themeButton2.setStyle("-fx-background-color: #000000;");
    themeButton3.setStyle("-fx-background-color: #c0c0c0;");


    Button saveBtn = new Button("Save");
    Button loadBtn = new Button("Load");
    saveBtn.setOnAction(e -> new BujoWriter().write(convertWeekToJson(week)));
    loadBtn.setOnAction(e -> load());

    HBox themeButtonsContainer = new HBox(themeButton1, themeButton2,
        themeButton3, saveBtn, loadBtn);
    themeButtonsContainer.setAlignment(Pos.CENTER_LEFT);
    themeButtonsContainer.setSpacing(10);
    themeButtonsContainer.setPadding(new Insets(0, 40, 0, 0));

    titleHBox.getChildren().add(themeButtonsContainer);

    themeButton1.setOnAction(event -> setTheme(Theme.THEME_1));
    themeButton2.setOnAction(event -> setTheme(Theme.THEME_2));
    themeButton3.setOnAction(event -> setTheme(Theme.THEME_3));

    Label weekTitle = new Label(week.getTitle());
    titleHBox.getChildren().add(weekTitle);

    noteTextArea.setOnKeyTyped(e -> week.updateNotes(noteTextArea.getText()));

    setTheme(week.getTheme());
  }

  private void load() {
    Week newWeek = convertJsonToWeek(new BujoReader().read());
    week = newWeek;
    week.update(newWeek);
    setTheme(newWeek.getTheme());
    noteTextArea.setText(week.getNotes());
  }

  private Week convertJsonToWeek(JsonNode jsonNode) {
    ObjectMapper mapper = new ObjectMapper();
    WeekJson weekJson = mapper.convertValue(jsonNode, WeekJson.class);

    Day[] days = new Day[7];
    for (int i = 0; i < 7; i++) {
      DayJson dayJson = mapper.convertValue(weekJson.days().get(i), DayJson.class);

      List<Events> events = new ArrayList<>();
      for (int j = 0; j < dayJson.events().size(); j++) {
        EventJson event = mapper.convertValue(dayJson.events().get(j), EventJson.class);
        events.add(new Events(event.name(), event.description(), DayEnum.valueOf(event.day()),
            LocalTime.parse(event.startTime()), LocalTime.parse(event.duration())));
      }
      List<Task> tasks = new ArrayList<>();
      for (int j = 0; j < dayJson.tasks().size(); j++) {
        TaskJson task = mapper.convertValue(dayJson.tasks().get(j), TaskJson.class);
        tasks.add(new Task(task.name(), task.description(), DayEnum.valueOf(task.day()),
            task.completed()));
      }

      Day day = new Day(DayEnum.valueOf(dayJson.day()), dayJson.maxEvents(), dayJson.maxTasks(),
          events, tasks);
      days[i] = day;
    }

    List<Task> taskQueue = new ArrayList<>();
    for (int j = 0; j < weekJson.taskQueue().size(); j++) {
      TaskJson task = mapper.convertValue(weekJson.taskQueue().get(j), TaskJson.class);
      taskQueue.add(new Task(task.name(), task.description(), DayEnum.valueOf(task.day()),
          task.completed()));
    }

    ThemeJson themeJson = mapper.convertValue(weekJson.theme(), ThemeJson.class);
    return new Week(weekJson.title(), days, taskQueue, new Theme(Color.web(themeJson.backgroundColor()),
        Color.web(themeJson.fontColor()), themeJson.fontFamily()), weekJson.notes());
  }

  private JsonNode convertWeekToJson(Week week) {
    List<DayJson> dayJson = new ArrayList<>();
    for (int i = 0; i < 7; i++) {
      Day day = week.getDay(i);
      List<EventJson> events = new ArrayList<>();
      for (int j = 0; j < day.getEvents().size(); j++) {
        Events e = day.getEvents().get(j);
        events.add(new EventJson(e.getName(), e.getDescription(), e.getDay(),
            e.getStartTime().toString(), e.getDuration().toString()));
      }
      List<TaskJson> tasks = new ArrayList<>();
      for (int j = 0; j < day.getTasks().size(); j++) {
        Task t = day.getTasks().get(j);
        tasks.add(new TaskJson(t.getName(), t.getDescription(), t.getDay(), t.getComplete()));
      }
      dayJson.add(new DayJson(day.getDay(), day.getMaxEvent(), day.getMaxTask(), events, tasks));
    }

    List<TaskJson> taskQueueJson = new ArrayList<>();
    for (int i = 0; i < week.getTaskQueue().size(); i++) {
      Task t = week.getTaskQueue().get(i);
      taskQueueJson.add(new TaskJson(t.getName(), t.getDescription(), t.getDay(), t.getComplete()));
    }
    Theme theme = week.getTheme();
    ThemeJson themeJson = new ThemeJson(theme.getBackgroundColor().toString(),
        theme.getFontColor().toString(), theme.getFontFamily());

    return JsonUtils.serializeRecord(new WeekJson(week.getTitle(), dayJson, taskQueueJson,
        themeJson, week.getNotes()));
  }

  /**
   * Changes the theme of the journal.
   *
   * @param theme the theme to set to
   */
  private void setTheme(Theme theme) {
    week.updateTheme(theme);
    traverseSceneGraph(weekScene.getRoot(), theme);
    weekPane1.setBackground(Background.fill(theme.getBackgroundColor()));
  }

  /**
   * Traverses the scene graph and sets the font family and font color of all labels.
   *
   * @param parent the parent node
   * @param theme  the theme to set to
   */
  private void traverseSceneGraph(Parent parent, Theme theme) {
    for (javafx.scene.Node node : parent.getChildrenUnmodifiable()) {
      if (node instanceof Label label) {
        label.setFont(javafx.scene.text.Font.font(theme.fontFamily));
        label.setTextFill(theme.fontColor);
      } else if (node instanceof Parent) {
        traverseSceneGraph((Parent) node, theme);
      }
    }
  }
}
