package com.example.cloudServicesA;

import com.example.cloudServicesA.models.Story;
import com.example.cloudServicesA.repos.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Immutable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class StoriesController {

    @Autowired
    private StoryRepository storyRepo;

    @GetMapping("/stories")
    public String getStories(Map<String, Object> model){
        Iterable<Story> stories = storyRepo.findAll();

        List<Story> storyList = new ArrayList<>();
        stories.forEach(storyList::add);
        Collections.reverse(storyList);
        model.put("stories", storyList);

        return "main_model";
    }

    @PostMapping("/stories")
    public String addStory(
            @RequestParam String story,
            @RequestParam String username,
            Map<String, Object> model
    ){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String timestamp = formatter.format(LocalDateTime.now());
        Story newStory = new Story(username, story, timestamp);
        storyRepo.save(newStory);

        Iterable<Story> stories =  storyRepo.findAll();
        model.put("stories", stories);

        return "redirect:/stories";
    }

    @GetMapping("/greet")
    public String greeting(Map<String, Object> model){
        model.put("some_par", "World");
        return "main_model";
    }


}
