package com.college.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.college.management.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}