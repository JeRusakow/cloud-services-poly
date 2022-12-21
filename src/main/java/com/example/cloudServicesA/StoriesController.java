package com.example.cloudServicesA;

import com.example.cloudServicesA.models.Story;
import com.example.cloudServicesA.repos.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class StoriesController {

    @Autowired
    private StoryRepository storyRepo;

    @GetMapping
    public String getStories(Map<String, Object> model){
        Iterable<Story> stories = storyRepo.findAll();
        model.put("stories", stories);

        return "main_model";
    }

    @PostMapping
    public String addStory(
            @RequestParam String story,
            @RequestParam String username,
            Map<String, Object> model
    ){
        Story newStory = new Story(username, story);
        storyRepo.save(newStory);

        Iterable<Story> stories =  storyRepo.findAll();
        model.put("stories", stories);

        return "main_model";
    }

    @GetMapping("/greet")
    public String greeting(Map<String, Object> model){
        model.put("some_par", "World");
        return "main_model";
    }


}
