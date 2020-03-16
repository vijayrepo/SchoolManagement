/**
 * StudentService.java
 * @author Vijay Chennam
 * Created on March 15, 2020
 */
package com.smitiv.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smitiv.student.dao.StudentRepository;
import com.smitiv.student.model.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	// save or update Student
	public Student saveStudent(Student entity) {

		return studentRepo.save(entity);
	}

	// get by id
	public Optional<Student> getStudentById(long id) {
		return studentRepo.findById(id);
	}

	// get all
	public List<Student> getAll() {
		return studentRepo.findAll();
	}

	// update by id
	public Student update(long id, Student student) {
		student.setRollNumber(id);
		student.setFirstName(student.getFirstName());
		student.setLastName(student.getLastName());
		student.setGender(student.getGender());
		student.setMarks(student.getMarks());
		student.setSection(student.getSection());
		student = studentRepo.save(student);
		return student;
	}

	// delete by id
	public void deleteStudent(long id) {
		studentRepo.deleteById(id);
	}
	
}
