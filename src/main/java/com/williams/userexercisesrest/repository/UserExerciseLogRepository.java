package com.williams.userexercisesrest.repository;

import com.williams.userexercisesrest.entity.UserExerciseLogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface UserExerciseLogRepository extends CrudRepository<UserExerciseLogEntity, Integer> {
    UserExerciseLogEntity findById(int id);
}
