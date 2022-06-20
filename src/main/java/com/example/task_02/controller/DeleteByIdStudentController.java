package com.example.task_02.controller;

import com.example.task_02.services.StudServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/deleteByIdStudent")
public class DeleteByIdStudentController {

    private final StudServices studServices;

    @GetMapping
    public String viewDeleteByIdStudent() {
        return "deleteByIdStudent";
    }

    @PostMapping
    public String deleteByIdStudent(String id) {

        long idL;

        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            return "errorId";
        }

        if (idL < 1) return "errorId";

        if (studServices.deleteByIdStudent(idL).equals("NOT_FOUND")) return "errorId";

        return "home";
    }
}
