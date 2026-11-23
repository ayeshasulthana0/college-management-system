package com.college.management.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.college.management.entity.Attendance;
import com.college.management.repository.AttendanceRepository;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public Attendance addAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));
    }

    public Attendance updateAttendance(Long id, Attendance attendance) {
        Attendance existing = getAttendanceById(id);
        existing.setStudentName(attendance.getStudentName());
        existing.setCourseName(attendance.getCourseName());
        existing.setAttendanceDate(attendance.getAttendanceDate());
        existing.setStatus(attendance.getStatus());
        return attendanceRepository.save(existing);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}