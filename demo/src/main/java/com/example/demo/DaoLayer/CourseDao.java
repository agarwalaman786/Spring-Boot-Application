package com.example.demo.DaoLayer;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Courses.Course;
public interface CourseDao extends JpaRepository<Course,Long>{
	
}
