package com.springcrud.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springcrud.crud.entity.School;
import com.springcrud.crud.repository.SchoolRepository;

@Service
public class SchoolService {
	
   private  SchoolRepository schoolRepository; 
   
   public SchoolService(SchoolRepository schoolRepository) {
	   this.schoolRepository = schoolRepository;
   }
   
   public List<School> retrieveAllSchool(){
       return this.schoolRepository.findAll();
   }
   
   public School retrieveSchoolById(Long id) {
       School school = schoolRepository.findById(id).orElseThrow(null);
       return school;
   }
//   public Optional<School> retrieve(Long id) {
//	   return schoolRepository.findById(id);
//   }

   public School addSchool(final School schoolEntity) {
       return this.schoolRepository.save(schoolEntity);
   }
   
   public String deleteSchool(Long id) {
       this.schoolRepository.deleteById(id);
       return "Deleted Successfully";
   }
   
   public String updateSchool(Long id, School school) {
       Optional<School> existingSchoolOptional = schoolRepository.findById(id);
       
       //School schoolGet = new School();
       if (existingSchoolOptional.isPresent()) {
           School existingSchool = existingSchoolOptional.get();
           
           if(school.getName()!= null)
           {
               existingSchool.setName(school.getName());

           }
           if(school.getAddress()!= null) {
               existingSchool.setAddress(school.getAddress());

           }
           schoolRepository.save(existingSchool);
           return "Edited Successfully";
       } else {
           return "School with ID " + id + " not found";
       }
   }
   
//   public School update(Long id,School school) {
//	   
//	   School exitsSchool=schoolRepository.findById(id).orElseThrow();
//	   if(school.getName()!=null) {
//		   exitsSchool.setName(school.getName());
//	   }
//	   
//	   if(school.getAddress()!=null) {
//		   exitsSchool.setAddress(school.getAddress());
//	   }
//	   return schoolRepository.save(exitsSchool);
//   }
}
