package cs3500.pa05.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a day in the week in JSON format.
 */
public record DayJson(
    @JsonProperty("Day") String day,
    @JsonProperty("Max Events") int maxEvents,
    @JsonProperty("Max Tasks") int maxTasks,
    @JsonProperty("Events") List<EventJson> events,
    @JsonProperty("Tasks") List<TaskJson> tasks
) {
}
