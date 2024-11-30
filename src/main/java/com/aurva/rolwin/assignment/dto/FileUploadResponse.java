package com.aurva.rolwin.assignment.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FileUploadResponse {

    @JsonProperty("fileUploadStatus")
    private Boolean fileUploadStatus;

    @JsonProperty("message")
    private String message;

    @JsonProperty("error")
    private String error;
}
