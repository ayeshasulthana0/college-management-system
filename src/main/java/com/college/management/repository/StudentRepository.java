package com.college.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.college.management.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}