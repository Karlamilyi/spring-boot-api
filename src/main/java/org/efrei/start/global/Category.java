package org.efrei.start.global;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Category {
    @JsonProperty("ACTION")
    ACTION,
    @JsonProperty("HORROR")
    HORROR,
    @JsonProperty("DRAMA")
    DRAMA
}
