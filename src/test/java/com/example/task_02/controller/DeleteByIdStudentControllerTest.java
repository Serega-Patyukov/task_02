package com.example.task_02.controller;

import com.example.task_02.model.Student;
import com.example.task_02.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class DeleteByIdStudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void viewDeleteByIdStudentTest() throws Exception {
        mockMvc.perform(get("/deleteByIdStudent"))
                .andExpect(view().name("deleteByIdStudent"))
                .andExpect(content().string(containsString("Удаление студента по id")))
                .andExpect(content().string(containsString("назад")))
                .andExpect(content().string(containsString("id:")))
                .andExpect(content().string(containsString("удалить")))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteByIdStudentTest() throws Exception {

        Student student = studentRepository.save(new Student("Сергей", "Патюков", "Сергеевич", "08.08.1992", "613"));
        mockMvc.perform(post("/deleteByIdStudent")
                        .param("id", String.valueOf(student.getId())))
                .andExpect(view().name("home"))
                .andExpect(status().isOk());

        mockMvc.perform(post("/deleteByIdStudent")
                        .param("id", String.valueOf(10)))
                .andExpect(view().name("errorId"))
                .andExpect(content().string(containsString("назад")))
                .andExpect(content().string(containsString("id студента введен не корректно")))
                .andExpect(status().isOk());

        mockMvc.perform(post("/deleteByIdStudent")
                        .param("id", String.valueOf(-10)))
                .andExpect(view().name("errorId"))
                .andExpect(content().string(containsString("назад")))
                .andExpect(content().string(containsString("id студента введен не корректно")))
                .andExpect(status().isOk());

        mockMvc.perform(post("/deleteByIdStudent")
                        .param("id", "kgkcfhk"))
                .andExpect(view().name("errorId"))
                .andExpect(content().string(containsString("назад")))
                .andExpect(content().string(containsString("id студента введен не корректно")))
                .andExpect(status().isOk());
    }

}
