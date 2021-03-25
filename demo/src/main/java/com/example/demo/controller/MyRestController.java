package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Courses.Course;
import com.example.demo.Service.CourseService;


//All the requests will be placed over there
@RestController
public class MyRestController {
	
	//Injecting the loose coupling
	@Autowired
	private CourseService courseService;
	
	//This is to map the default page with our application when we hit the url:- Like hopscotch.in
	@GetMapping("/")
	public String home() {
		return "Welcome to the Course application";
	}
	
	//To get the all courses
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		return this.courseService.getCourses();
	}
	
	//to get the single course
	@GetMapping("/courses/{course_id}")
	public Course getCourse(@PathVariable long course_id)
	{
		System.out.println(course_id);
		//return null;
		return this.courseService.getCourse(course_id);
	}
	
	//to add the course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		this.courseService.addCourse(course);
		return course;
	}
	
	//to update the course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		if(this.courseService.updateCourse(course))
			return course;
		return null;
	}
	
	//delete the course
	@DeleteMapping("/courses/{CourseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long CourseId){
		if(this.courseService.deleteCourse(CourseId))
			return new ResponseEntity<>(HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
