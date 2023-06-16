package cs3500.pa05.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a task in JSON format.
 */
public record TaskJson(
    @JsonProperty("Name") String name,
    @JsonProperty("Description") String description,
    @JsonProperty("Day") String day,
    @JsonProperty("Completed") boolean completed
) {
}
