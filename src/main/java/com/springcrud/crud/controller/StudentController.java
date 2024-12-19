package com.springcrud.crud.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcrud.crud.entity.StudentEntity;
import com.springcrud.crud.service.StudentService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public StudentEntity createStudent(@RequestBody final StudentEntity student) {
        return this.studentService.createStudents(student);
    }

    @GetMapping("/retrieve/{id}")
    public StudentEntity getStudentById(@PathVariable Long id) {
        return this.studentService.retrieveStudentById(id);
    }

    @GetMapping("/retrieve-name")
    public List<StudentEntity> getStudentByName(@PathVariable String name) {
        return this.studentService.retrieveStudentByName(name);
    }

    @GetMapping("/retrieve-all")
    public List<StudentEntity> retrieveAll() {
        return this.studentService.retrieveAllStudents();
    }

    @PutMapping("/update/{id}")
    public String updateStudentById (@PathVariable("id") Long id, @RequestBody StudentEntity student) {
        System.out.println("working");
        return this.studentService.updateStudent(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById (@PathVariable("id")  Long id) {
        return this.studentService.deleteStudent(id);
    }

}