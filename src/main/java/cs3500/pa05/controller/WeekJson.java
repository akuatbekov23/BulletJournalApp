package cs3500.pa05.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a week in JSON format.
 */
public record WeekJson(
    @JsonProperty("Title") String title,
    @JsonProperty("Days") List<DayJson> days
) {
}
