package com.williams.userexercisesrest.repository;

import com.williams.userexercisesrest.entity.ExerciseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "exercises", path = "exercises")
public interface ExerciseRepository extends CrudRepository<ExerciseEntity, Integer> {
    ExerciseEntity findById(int id);
}

