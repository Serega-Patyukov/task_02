package com.example.task_02.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class CreateStudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void viewCreateStudentTest() throws Exception {
        mockMvc.perform(get("/createStudent"))
                .andExpect(view().name("createStudent"))
                .andExpect(content().string(containsString("Добавление студента в БД")))
                .andExpect(content().string(containsString("назад")))
                .andExpect(content().string(containsString("Фамилия:")))
                .andExpect(content().string(containsString("Имя:")))
                .andExpect(content().string(containsString("Отчество:")))
                .andExpect(content().string(containsString("Дата рождения:")))
                .andExpect(content().string(containsString("Группа:")))
                .andExpect(content().string(containsString("добавить")))
                .andExpect(status().isOk());
    }

}
