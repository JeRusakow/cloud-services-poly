package com.example.cloudServicesA.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stories")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    private String username;

    @NonNull
    private String story;

    @NonNull
    private String timestamp;

    public Story(String username, String story, String timestamp) {
        if (username.equals("")) {
            this.username = "Anon";
        } else {
            this.username = Objects.requireNonNullElse(username, "Anon");
        }

        if (story.equals("")) {
            this.story = "N/A";
        } else {
            this.story = Objects.requireNonNullElse(story, "N/A");
        }

        this.timestamp = Objects.requireNonNullElse(timestamp, "N/A");
    }

    public Story() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
