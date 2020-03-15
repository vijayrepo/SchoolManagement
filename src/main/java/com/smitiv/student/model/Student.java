/**
 * Student.java
 * @author Vijay Chennam
 * Created on March 15, 2020
 */
package com.smitiv.student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table
@XmlRootElement
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long rollNumber;

	@Column(name = "first_Name", length = 30, nullable = false)
	@Size(max = 30, min = 3, message = "First name should should be 0 to 30")
	@NotBlank(message = "Please enter first name")
	private String firstName;

	@Column(name = "last_Name", length = 30, nullable = false)
	@Size(message = "Last name should be between 0 to 30 letters", min = 3, max = 30)
	@NotBlank(message = "Please enter last name")
	private String lastName;

	@NotEmpty(message = "Please select gender")
	@Column(length = 6)
	private String gender;

	@Column(length = 2, nullable = false)
	@NotEmpty(message = "Please enter section")
	private String section;

	@Column(length = 3, nullable = false)
	@NotNull(message = "Please enter marks")
	private Integer marks;

	@Column(length = 8, nullable = false)
	@NotNull(message = "Please enter class of study in roman numbers")
	private String classOfStudy;

	public Student() {

	}

	/**
	 * @return the rollNumber
	 */
	public Long getRollNumber() {
		return rollNumber;
	}

	/**
	 * @param rollNumber the rollNumber to set
	 */
	public void setRollNumber(Long rollNumber) {
		this.rollNumber = rollNumber;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the section
	 */
	public String getSection() {
		return section;
	}

	/**
	 * @param section the section to set
	 */
	public void setSection(String section) {
		this.section = section;
	}

	/**
	 * @return the marks
	 */
	public Integer getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	/**
	 * @return the classOfStudy
	 */
	public String getClassOfStudy() {
		return classOfStudy;
	}

	/**
	 * @param classOfStudy the classOfStudy to set
	 */
	public void setClassOfStudy(String classOfStudy) {
		this.classOfStudy = classOfStudy;
	}

}