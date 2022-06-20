package com.example.task_02.services;

import com.example.task_02.model.Student;
import com.example.task_02.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudServices {

    private final StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAllStudent() {
        return (List<Student>) studentRepository.findAll();
    }

    public String deleteByIdStudent(long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "OK";
        }
        else return "NOT_FOUND";
    }

}
