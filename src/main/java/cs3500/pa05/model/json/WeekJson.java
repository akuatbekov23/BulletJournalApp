package cs3500.pa05.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a week in JSON format.
 */
public record WeekJson(
    @JsonProperty("Title") String title,
    @JsonProperty("Days") List<DayJson> days,
    @JsonProperty("Task Queue") List<TaskJson> taskQueue,
    @JsonProperty("Theme") ThemeJson theme,
    @JsonProperty("Notes") String notes,
    @JsonProperty("maxEvents") int maxEvents,
    @JsonProperty("maxTasks") int maxTasks
) {
}
