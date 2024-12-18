package com.springcrud.crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StudentEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private Long id;
@Column
private String name;
@Column
private String address;
@Column
private int contactNumber;

@ManyToOne()
@JoinColumn(name = "School_id")
private School school;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getContactNumber() {
	return contactNumber;
}

public void setContactNumber(int contactNumber) {
	this.contactNumber = contactNumber;
}

public School getSchool() {
	return school;
}

public void setSchool(School school) {
	this.school = school;
}


}
