package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.*;

import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	List<Student> studentlist;
	
	@PostConstruct
	public void loadData() {
		studentlist=new ArrayList<>();
		studentlist.add(new Student("dhiraj","kumar"));
		studentlist.add(new Student("manish","kumar"));
		studentlist.add(new Student("bihar","kumar"));
		studentlist.add(new Student("patna","kumar"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return studentlist;
	}
	@GetMapping("/students/{studentid}")
	public Student getSingleStu(@PathVariable int studentid){
			
		
		if(studentid>studentlist.size()) {
			throw new StudentNotFoundException("student Id not found");
		}
		return studentlist.get(studentid);
	}
		
}
