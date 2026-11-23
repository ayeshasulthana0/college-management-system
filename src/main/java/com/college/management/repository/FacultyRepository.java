package com.college.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.college.management.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}