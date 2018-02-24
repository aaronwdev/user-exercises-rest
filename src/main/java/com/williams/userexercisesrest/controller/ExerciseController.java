package com.williams.userexercisesrest.controller;

import com.williams.userexercisesrest.entity.ExerciseEntity;
import com.williams.userexercisesrest.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;

@RestController
@RequestMapping(path = "/exercises")
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepository;

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(ConstraintViolationException.class)
    public String return400(ConstraintViolationException ex) {
        return ex.getMessage();
    }

//
//    @RequestMapping(method = RequestMethod.GET)
//    public ExerciseEntity returnExercise(@RequestParam(required = false) int id) {
//        return exerciseRepository.findById(id);
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public void saveExercise(@RequestParam(required = false) String description) {
//    exerciseRepository.save(new ExerciseEntity(description));
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.OK)
//    public void deleteExercise(@RequestParam(required = false) int id) {
//        exerciseRepository.delete(id);
//    }
}
