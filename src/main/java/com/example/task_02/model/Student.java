package com.example.task_02.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 1, message = "Введите корректно имя")
    private String name;

    @NotNull
    @Size(min = 1, message = "Введите корректно фамилию")
    private String surname;

    @NotNull
    @Size(min = 1, message = "Введите корректно отчество")
    private String patronymic;

    @NotNull
    @Pattern(regexp = "^(0[1-9]|1[0-9]|2[0-9]|3[0-1])([\\.])(0[1-9]|1[0-2])([\\.])([1-2][0-9][0-9][0-9])$" , message = "Введите корректно дату рождения ДД.ММ.ГГГГ")
    private String dob;

    @NotNull
    @Size(min = 1, message = "Введите корректно группу")
    private String grp;

    public Student() {
    }

    public Student(String name, String surname, String patronymic, String dob, String grp) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dob = dob;
        this.grp = grp;
    }
}
