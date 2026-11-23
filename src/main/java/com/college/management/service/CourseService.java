package com.college.management.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.college.management.entity.Course;
import com.college.management.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course updateCourse(Long id, Course course) {
        Course existing = getCourseById(id);
        existing.setCourseName(course.getCourseName());
        existing.setCourseCode(course.getCourseCode());
        existing.setDepartment(course.getDepartment());
        existing.setCredits(course.getCredits());
        existing.setSemester(course.getSemester());
        return courseRepository.save(existing);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}