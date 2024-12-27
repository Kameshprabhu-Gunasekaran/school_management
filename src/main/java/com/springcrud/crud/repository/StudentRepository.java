package com.springcrud.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springcrud.crud.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository <StudentEntity, Long>{

	//	@Query(value = "Select * From student WHERE name =:name", nativeQuery = true)
//	List<StudentEntity> findByName(@Param("name") String name);
	Optional<StudentEntity> findByName(@Param("name")String name);

//	@Query(value = "select s FROM Student s " +
//            "join s.school sc " +
//            "where (:search is null or " +
//            "(s.name like %:search% or s.address like %:search% " +
//            "OR sc.name like %:search% or sc.address like %:search%))",
//            nativeQuery = false)
//    List<StudentEntity> findBySearch(@Param("search") final String search);
}
