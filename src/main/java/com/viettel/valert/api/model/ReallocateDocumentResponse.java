package com.viettel.valert.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReallocateDocumentResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private String status;

    @Override
    public String toString() {
        return String.format("ReallocateDocumentResponse{message='%s', status='%s'}", message, status);
    }
}
