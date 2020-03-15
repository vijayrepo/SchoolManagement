/**
 * StudentController.java
 * @author Vijay Chennam
 * Created on March 15, 2020
 */
package com.smitiv.student.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.smitiv.student.exception.RecordNotFoundException;
import com.smitiv.student.model.Student;
import com.smitiv.student.service.StudentService;

@RestController
@RequestMapping("/student/service")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// create resource
	@PostMapping(value = "/save", consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	public ResponseEntity<Student> create(@Valid @RequestBody Student Student) {
		Student studentObj = studentService.saveStudent(Student);
		return new ResponseEntity<Student>(studentObj, HttpStatus.CREATED);

	}

	// get student by id
	@GetMapping(value = "/getById/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Student> getStudentById(
			@PathVariable("id") @Min(value = 1, message = "Id must be graterthan 1") long id)
			throws RecordNotFoundException {

		Optional<Student> student = studentService.getStudentById(id);
		if (!student.isPresent()) {
			throw new RecordNotFoundException("Student does not exist with id " + id);
		}
		return ResponseEntity.ok(student.get());
	}

	// get all students
	@GetMapping(value = "/getAll", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> emps = studentService.getAll();
		return new ResponseEntity<List<Student>>(emps, new HttpHeaders(), HttpStatus.OK);

	}

	// update resource by id
	@PutMapping(value = "/updateById/{id}", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<Student> updateStudent(
			@PathVariable("id") @Min(value = 1, message = "Id must be graterthan 1") long sid,
			@RequestBody Student student) {

		if (!studentService.getStudentById(sid).isPresent()) {
			throw new RecordNotFoundException("Student does not exist with id " + sid);
		} else {
			studentService.update(sid, student);
		}
		return ResponseEntity.ok(student);
	}

	// delete student by id
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<?> deleteEmp(@PathVariable long id) {

		if (!studentService.getStudentById(id).isPresent()) {
			throw new RecordNotFoundException("Student does not exist with id " + id);
		}
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Student object deleted with id " + id);
	}

}