package com.viettel.valert.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.annotation.PostConstruct;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NonNull
public class ContentRequest {
    private String content;
    private String users;
    private String business;

    public ContentRequest(String content, String business, String users) {
        this.content = trim(content);
        this.business = trim(business);
        this.users = trim(users);
    }

    private String trim(String str) {
        return str.trim();
    }

    @PostConstruct
    public void atLeastOneReceiver() {
        if (!(!Objects.equals(business, "") || !Objects.equals(users, ""))) {
            throw new IllegalArgumentException("At least one (business or users) must be non-null or non-empty");
        }
    }
}
