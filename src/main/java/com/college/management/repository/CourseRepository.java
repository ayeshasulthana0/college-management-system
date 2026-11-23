package com.college.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.college.management.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}