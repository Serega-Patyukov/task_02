package com.example.task_02.controller;

import com.example.task_02.model.Student;
import com.example.task_02.services.StudServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/createStudent")
public class CreateStudentController {

    private final StudServices studServices;

    @ModelAttribute(name = "student")
    public Student newModelStudent() {
        return new Student();
    }

    @GetMapping
    public String viewCreateStudent() {
        return "createStudent";
    }

    @PostMapping
    private String createStudent(
            @Valid Student student,
            Errors errors) {

        if (errors.hasErrors()) {
            return "createStudent";
        }

        studServices.createStudent(student);

        return "home";
    }

}
