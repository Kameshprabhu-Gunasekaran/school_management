package com.springcrud.crud.repository;

//import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcrud.crud.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository <School,Long>{

}
