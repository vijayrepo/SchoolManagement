/**
 * StudentRepository.java
 * @author Vijay Chennam
 * Created on March 15, 2020
 */
package com.smitiv.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smitiv.student.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}