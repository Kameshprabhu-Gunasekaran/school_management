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
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentsService;

    public StudentController(final StudentService studentsService) {
        this.studentsService = studentsService;
    }

    @PostMapping("create")
    public StudentEntity createStudents(@RequestBody final StudentEntity students) {
        return this.studentsService.createStudents(students);
    }

    @GetMapping("retrieve/{id}")
    public StudentEntity getStudentById(@PathVariable("id") final Long id) {
        return this.studentsService.getStudentById(id);
    }
//    @GetMapping("retrieve")
//    public List<StudentEntity>getStudent(@RequestBody final String name){
//        System.err.println(name);
//        return this.studentsService.getStudent(name);
//  }

    @GetMapping("retrieveAll")
    public List<StudentEntity> getAllStudents() {
        return this.studentsService.getAllStudents();
    }

    @PutMapping("update/{id}")
    public StudentEntity updateStudentById(@RequestBody final StudentEntity students, @PathVariable("id") final Long id) {
        students.setId(id);
        return this.studentsService.updateStudentById(id,students);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable("id") final Long id) {
        this.studentsService.deleteStudentById(id);
    }
}