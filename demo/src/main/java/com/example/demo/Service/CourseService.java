package com.example.demo.Service;

import java.util.List;

import com.example.demo.Courses.Course;


//This we are doing to achieve the loose coupling
public interface CourseService {
	public List<Course> getCourses();
	public Course getCourse(long id);
	public void addCourse(Course course);
	public boolean updateCourse(Course course);
	public boolean deleteCourse(long courseId);
}
