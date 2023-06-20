package cs3500.pa05.viewer;

import cs3500.pa05.model.DayEnum;
import cs3500.pa05.model.Events;
import java.time.LocalTime;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class CreateEventDialog extends Dialog {

  private final Events events;
  private TextField title = new TextField();
  private TextField description = new TextField();
  private TextField start = new TextField();
  private TextField duration = new TextField();
  private TextField day = new TextField();

  /**
   * @param events the Event to edit
   */
  public CreateEventDialog(Events events) {
    super();
    this.events = events;
    this.setTitle("Create a New Event");

    buildUI();
    setEvents();
    setResultConverter();
  }

  /**
   * builds the Dialog box for creating a new Event
   */
  private void buildUI() {
    Pane pane = buildDialog();
    getDialogPane().setContent(pane);

    getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.CANCEL);

    Button button = (Button) getDialogPane().lookupButton(ButtonType.FINISH);
    button.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

      /**
       * @param event the event which occurred
       */
      @Override
      public void handle(ActionEvent event) {
        if (validate()) {
          event.consume();
        }
      }

      /**
       * @return boolean on whether the text fields are empty
       */
      private boolean validate() {
        return (title.getText().isEmpty() || start.getText().isEmpty() || duration.getText().isEmpty()
            || day.getText().isEmpty());
      }
    });

  }

  /**
   * @return the basic dialog pane
   */
  private Pane buildDialog() {
    VBox content = new VBox(10);

    Label titleLabel = new Label("Title: ");
    Label descriptionLabel = new Label("Desc: ");
    Label startLabel = new Label("Start Time: ");
    Label durationLabel = new Label("Duration: ");
    Label dayLabel = new Label("Day: ");

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(5);
    grid.add(titleLabel, 0, 0);
    grid.add(descriptionLabel, 0, 1);
    grid.add(startLabel, 0, 2);
    grid.add(durationLabel, 0, 3);
    grid.add(dayLabel, 0, 4);

    grid.add(title, 1, 0);
    GridPane.setHgrow(this.title, Priority.ALWAYS);
    grid.add(description, 1, 1);
    GridPane.setHgrow(this.description, Priority.ALWAYS);
    start.setPromptText("Enter as: hh/mm");
    grid.add(start, 1, 2);
    GridPane.setHgrow(this.start, Priority.ALWAYS);
    duration.setPromptText("Enter as: hh/mm");
    grid.add(duration, 1, 3);
    GridPane.setHgrow(this.duration, Priority.ALWAYS);
    grid.add(day, 1, 4);
    GridPane.setHgrow(this.day, Priority.ALWAYS);

    content.getChildren().add(grid);

    return content;

  }

  /**
   * sets the Event
   */
  private void setEvents() {
    events.name = title.getText();
    events.description = description.getText();
    String hour = start.getText().substring(0, 1);
    String minutes = start.getText().substring(1);
    events.startTime = LocalTime.of(Integer.parseInt(hour), Integer.parseInt(minutes));
    String durHour = duration.getText().substring(0, 1);
    String durMin = duration.getText().substring(1);
    events.duration = LocalTime.of(Integer.parseInt(durHour), Integer.parseInt(durMin));
    String dayString = day.getText();
    if (dayString.equals("Monday")) {
      events.day = DayEnum.MONDAY;
    } else if (dayString.equals("Tuesday")) {
      events.day = DayEnum.TUESDAY;
    } else if (dayString.equals("Wednesday")) {
      events.day = DayEnum.WEDNESDAY;
    } else if (dayString.equals("Thursday")) {
      events.day = DayEnum.THURSDAY;
    } else if (dayString.equals("Friday")) {
      events.day = DayEnum.FRIDAY;
    } else if (dayString.equals("Saturday")) {
      events.day = DayEnum.SATURDAY;
    } else if (dayString.equals("Sunday")) {
      events.day = DayEnum.SUNDAY;
    }
  }

  /**
   * returns the Event made
   */
  public void setResultConverter() {
    Callback<ButtonType, Events> eventsResult = new Callback<ButtonType, Events>() {

      @Override
      public Events call(ButtonType param) {
        if (param == ButtonType.FINISH) {
          return events;
        } else {
          return null;
        }
      }
    };
    setResultConverter(eventsResult);
  }


}
