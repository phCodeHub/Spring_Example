package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")

public class StudentRestController {
	
	private List<Student> lStudentlist= null;
	
	@PostConstruct
	public void loadData() {
		
		lStudentlist = new ArrayList<Student>();
		
		lStudentlist.add(new Student("Pulkit","Singh"));
		lStudentlist.add(new Student("Pintu","Kundu"));
		lStudentlist.add(new Student("Deep","Gupta"));
		lStudentlist.add(new Student("Harshita","Kant"));
		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		
		
		return lStudentlist;
		
	}
	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable int studentId){
		
		if(studentId >= lStudentlist.size() || studentId < 0)
			throw new StudentNotFoundException("Student ID nt found");
		
		return lStudentlist.get(studentId);
		
	}
	
	//Exception handler-> works for only controller in whichits defined
	
	/*@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
		
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e){
		
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
