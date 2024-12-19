package com.springcrud.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

//import com.springcrud.crud.entity.School;
import com.springcrud.crud.entity.StudentEntity;
import com.springcrud.crud.repository.SchoolRepository;
import com.springcrud.crud.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
    private final StudentRepository studentsRepository;

    // private final SchoolRepository schoolRepository;

    public StudentService(final StudentRepository studentsRepository,SchoolRepository schoolRepository) {
        this.studentsRepository = studentsRepository;
        //this.schoolRepository=schoolRepository;
    }

    public StudentEntity createStudents(final StudentEntity students) {
        return this.studentsRepository.save(students);
    }

    public StudentEntity retrieveStudentById(Long id) {
        StudentEntity student = studentsRepository.findById(id).orElseThrow(null);
        return student;
    }


    public void studentName() {

    }



    public List<StudentEntity>retrieveStudentByName(final String name){
        return this.studentsRepository.findByName(name);
    }

    public List<StudentEntity> retrieveAllStudents() {
        return this.studentsRepository.findAll();
    }

    @Transactional
    public String updateStudent(Long id, StudentEntity students) {
        Optional<StudentEntity> existingStudentsOptional = studentsRepository.findById(id);

        if (existingStudentsOptional.isPresent()) {
            StudentEntity existingStudent = existingStudentsOptional.get();

            if(students.getName()!= null)
            {
                existingStudent.setName(students.getName());
            }

            if(students.getAddress()!= null) {
                existingStudent.setAddress(students.getAddress());
            }

            if(students.getContactNumber()!= 0) {
                existingStudent.setContactNumber(students.getContactNumber());
            }
            if(students.getSchool()!=null) {
                existingStudent.setSchool(students.getSchool());
            }
            studentsRepository.save(existingStudent);
            return "Edited Successfully";
        } else {
            return "Student with ID " + id + " not found";
        }
    }

    public String deleteStudent(Long id) {
        this.studentsRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
