package com.aurva.rolwin.assignment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FileDeleteResponse {
    @JsonProperty("fileDeleteStatus")
    private Boolean fileDeleteStatus;

    @JsonProperty("message")
    private String message;

    @JsonProperty("error")
    private String error;
}
