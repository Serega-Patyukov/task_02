package com.example.task_02.controller;

import com.example.task_02.model.Student;
import com.example.task_02.services.StudServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/findAllStudent")
public class FindAllStudentController {

    private final StudServices studServices;

    @GetMapping
    public String viewFindAllStudent() {
        return "findAllStudent";
    }

    @ModelAttribute(name = "listStudent")
    public List<Student> newModelStudent() {
        return studServices.findAllStudent();
    }

}
