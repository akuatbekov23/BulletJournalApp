package cs3500.pa05.model;

import java.time.LocalTime;

/**
 * Represents an event.
 */
public class Event {

  public String name;
  public String description;
  public String day;
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
  public Event(String name, String description, String day, LocalTime startTime,
               LocalTime duration) {
    this.name = name;
    this.description = description;
    this.day = day;
    this.startTime = startTime;
    this.duration = duration;
  }
}
