package com.example.cloudServicesA.repos;

import com.example.cloudServicesA.models.Story;
import org.springframework.data.repository.CrudRepository;

public interface StoryRepository extends CrudRepository<Story, Long> {
}
