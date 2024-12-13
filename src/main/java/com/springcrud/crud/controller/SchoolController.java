package com.springcrud.crud.controller;

import java.util.List;
//import java.util.Optional;

//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcrud.crud.entity.School;
import com.springcrud.crud.service.SchoolService;

@RestController
@RequestMapping("/api/v1")
public class SchoolController {

	
	private final SchoolService schoolService;
	
	public SchoolController(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
	
	@GetMapping("/school")
	public List<School> retrieveSchool(){
		return this.schoolService.retrieveAllSchool();
	}
	
	 @GetMapping("/school/{id}")
	    public School getSchoolById (@PathVariable Long id) {
	      return  schoolService.retrieveSchoolById(id);

	    }
	
	@PostMapping("/add-school")
    public School addSchool(@RequestBody School school) {
        return this.schoolService.addSchool(school);
    }
//	@GetMapping("/{id}")
//	public Optional<School> get(@PathVariable("id") Long id){
//		return schoolService.retrieve(id);
//	}
	
	 @DeleteMapping("/{id}")
	    public String deleteSchool(@PathVariable("id") Long id) {
	      return this.schoolService.deleteSchool(id);
	 }
	 
	 @PutMapping("/{id}")
	    public String updateSchool(@PathVariable("id") Long id, @RequestBody School school) {
	        return this.schoolService.updateSchool(id, school);
	    }
	 
//	 @PutMapping("up/{id}")
//	    public School updatesSchool(@PathVariable("id") Long id, @RequestBody School school) {
//	        return this.schoolService.update(id, school);
//	    }
}
