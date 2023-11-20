package com.prasad.springweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prasad.springweb.entity.Student;
import com.prasad.springweb.repository.StudentRepository;



@RestController
public class StudentRestController {
	
	@Autowired
	StudentRepository studentRepository;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentRestController.class);
	
	@RequestMapping(value="/students/",method=RequestMethod.GET)
	public List<Student> getStudents()
	{
		return studentRepository.findAll(); 
	}
	
	@RequestMapping(value="/students/{id}",method=RequestMethod.GET)
	public Student getStudent(@PathVariable("id") int id)
	{
		LOGGER.info("Finding Student by ID:"+id);
		return studentRepository.findById(id).get(); 
	}
	
	@RequestMapping(value="/students/",method=RequestMethod.POST)
	public Student createStudent(@RequestBody Student student)
	{
		LOGGER.info("Finding Students");
		return studentRepository.save(student);
	}
	
	@RequestMapping(value="/students/",method=RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student)
	{
		LOGGER.info("Updating Student details");
		return studentRepository.save(student);
	}
	
	@RequestMapping(value="/students/",method=RequestMethod.DELETE)
	public void deleteStudent(@PathVariable("id") int id)
	{
		LOGGER.info("Deleting Student by id");
		studentRepository.deleteById(id);
	}

}
