package com.example.demo.Service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Courses.Course;
import com.example.demo.DaoLayer.CourseDao;


@Service
public class CourseServiceImpl implements CourseService{
	//private List<Course>list;
	
	@Autowired
	private CourseDao courseDao;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(125,"Java","This is the java Course"));
//		list.add(new Course(126,"C++","This is the C++ Course"));
//		list.add(new Course(127,"Python","This is the Python Course"));
//		list.add(new Course(128,"HTML","This is the HTML Course"));
	}
	
	@Override
	public List<Course> getCourses(){
		//return list;
		return courseDao.findAll();
	}
	
	@Override
	public Course getCourse(long id) {
//		for(Course c:list) {
//			if(c.getId()==id)
//				return c;
//		}
//		return null;
		//System.out.println(courseDao.getOne(id).getDescription());
		//getOne return us a refrence then the actual object thats why findById will be beneficial to use and get to come out from the optional return type
	    return this.courseDao.findById(id).get();
	}
	
	@Override
	public void addCourse(Course course) {
		//list.add(course);
		courseDao.save(course);
	}
	
	@Override
	public boolean updateCourse(Course course) {
//		for(Course c:list) {
//			if(c.getId()==course.getId()) {
//				c.setTitle(course.getTitle());
//				c.setDescription(course.getDescription());
//				return true;
//			}
//		}
//		return false;
		courseDao.save(course);
		return true;
	}
	
	@Override
	public boolean deleteCourse(long courseId) {
//		for(Course c:list) {
//			if(c.getId()==courseId) {
//				list.remove(c);
//				return true;
//			}
//		}
//		return false;
		Course entity = courseDao.getOne(courseId);
		courseDao.delete(entity);
		return true;
	}
	
}
