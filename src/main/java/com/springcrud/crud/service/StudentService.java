package com.springcrud.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springcrud.crud.entity.StudentEntity;
import com.springcrud.crud.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
    private final StudentRepository studentsRepository;

    public StudentService(final StudentRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public StudentEntity createStudents(final StudentEntity students) {
        return this.studentsRepository.save(students);
    }

    public StudentEntity getStudentById(final Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid ID");
        }
        Optional<StudentEntity> students = this.studentsRepository.findById(id);
        if (students.isPresent()) {
            return students.get();
        } else {
            throw new IllegalArgumentException("Student not found for ID: " + id);
        }
    }

    public List<StudentEntity>getStudent(final String name){
        return this.studentsRepository.findByNameNative(name);
    }

    public List<StudentEntity> getAllStudents() {
        return this.studentsRepository.findAll();
    }

    @Transactional
    public StudentEntity updateStudentById(final Long id, final StudentEntity students) {
        Optional<StudentEntity> studentsOptional = this.studentsRepository.findById(id);
        if (!studentsOptional.isPresent()) {
            throw new RuntimeException("Student not found");
        }
        StudentEntity student = studentsOptional.get();
        if (students.getName() != null) {
            student.setName(students.getName());
        }
        if (students.getAddress() != null) {
            student.setAddress(students.getAddress());
        }
        if (students.getContactNumber() != 0) {
            student.setContactNumber(students.getContactNumber());
        }
        return this.studentsRepository.save(student);
    }

    public void deleteStudentById(final Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Invalid ID");
        }
        Optional<StudentEntity> students = this.studentsRepository.findById(id);
        if (students.isPresent()) {
            studentsRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Student not found");
        }
        this.studentsRepository.deleteById(id);
    }

}
