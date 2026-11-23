package com.college.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.college.management.entity.Student;
import com.college.management.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Add student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // View all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // View student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // Update student
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = getStudentById(id);

        existingStudent.setName(student.getName());
        existingStudent.setRollNumber(student.getRollNumber());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYear(student.getYear());
        existingStudent.setSection(student.getSection());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhone(student.getPhone());

        return studentRepository.save(existingStudent);
    }

    // Delete student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}