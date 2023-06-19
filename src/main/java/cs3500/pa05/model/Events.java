package cs3500.pa05.model;

import java.time.LocalTime;

/**
 * Represents an event.
 */
public class Events {

  public String name;
  public String description;
  public DayEnum day;
  public LocalTime startTime;
  public LocalTime duration;

  /**
   * Constructs an event.
   *
   * @param name        the name of the event
   * @param description the description of the event
   * @param day         the day of the event
   * @param startTime   the start time of the event
   * @param duration    the duration of the event
   */
  public Events(String name, String description, DayEnum day, LocalTime startTime,
                LocalTime duration) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.startTime = startTime;
    this.duration = duration;
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public LocalTime getStartTime() {
    return this.startTime;
  }

  public LocalTime  getDuration() {
    return this.duration;
  }
}
