package cs3500.pa05.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a JournalJson.
 */
public record JournalJson(
    @JsonProperty("week") WeekJson week,
    @JsonProperty("Task Queue") List<TaskJson> taskQueue,
    @JsonProperty("Theme") ThemeJson theme) {
}
