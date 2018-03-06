package com.williams.userexercisesrest.controller;

import com.williams.userexercisesrest.entity.ExerciseEntity;
import com.williams.userexercisesrest.repository.ExerciseRepository;
import com.williams.userexercisesrest.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/exercises")
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    ExerciseService exerciseService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ExerciseEntity saveExercise(@RequestBody ExerciseEntity exerciseEntity) {
        return exerciseRepository.save(new ExerciseEntity(exerciseEntity.getDescription()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{exerciseId}")
    public ExerciseEntity returnExercise(@PathVariable Integer exerciseId) {
        return exerciseService.findExercise(exerciseId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ExerciseEntity> returnAllExercise() {
        return (List<ExerciseEntity>) exerciseRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteExercise(@RequestParam(required = false) int id) {
        exerciseRepository.delete(id);
    }


}