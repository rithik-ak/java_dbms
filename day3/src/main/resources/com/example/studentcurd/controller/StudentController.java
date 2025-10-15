package com.example.studentcrud.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentcrud.entitty.Student;

import java.util.*;
@RestController
@RequestMapping("/student")
public class StudentController {
 private StudentRepository   studentRepository;
 
 @PostMapping
 public Student CreateStudent( @RequestBody Student student) {
	 return studentRepository.save(student);
	 
 }
 
 @GetMapping
 public List<Student> getAllStudents(){
	 return studentRepository.findAll();
 }
 
 @GetMapping("{/id}")
  public Student  getStudentById(@PathVariable Long id) {
	 return studentRepository.findById(id).orElse(null);
	 
 }
 
 @PutMapping("{/id}")
 public Student  updateStudents(@PathVariable Long Id,@RequestBody Student updateStudent) {
	 Student student = studentRepository.findById(id).orElse(null);
	 if(Student!=null) {
		 student.setName(updateStudent.getName());
		 student.setEmail(updateStudent.getEmail());
		 return studentRepository.save(student);
	 }
	 return null;
	 
 }
 @DeleteMapping("{/id}")
 public String deletestudent(@PathVariable long id) {
	 studentRepository.deleteById(id);
	 return "student deleted successfully!";
 }
 
 
}