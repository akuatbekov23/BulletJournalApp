package cs3500.pa05.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a theme in JSON format.
 */
public record ThemeJson(
    @JsonProperty("Background Color") String backgroundColor,
    @JsonProperty("Font Color") String fontColor,
    @JsonProperty("Font Family") String fontFamily
) {
}
