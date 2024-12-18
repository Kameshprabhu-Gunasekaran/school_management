package com.springcrud.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springcrud.crud.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository <StudentEntity, Long>{

	@Query(value = "Select * From student WHERE name =:name", nativeQuery = true)
	List<StudentEntity> findByNameNative(@Param("name") String name);
}
