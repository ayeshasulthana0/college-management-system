package com.college.management.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.college.management.entity.Faculty;
import com.college.management.repository.FacultyRepository;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Faculty not found"));
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        Faculty existing = getFacultyById(id);
        existing.setName(faculty.getName());
        existing.setFacultyId(faculty.getFacultyId());
        existing.setDepartment(faculty.getDepartment());
        existing.setSubject(faculty.getSubject());
        existing.setEmail(faculty.getEmail());
        existing.setPhone(faculty.getPhone());
        return facultyRepository.save(existing);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}