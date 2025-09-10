package com.fsd.project.service;

import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Student;
import com.fsd.project.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student existingStudent = getStudentById(id);
        existingStudent.setName(studentDetails.getName());
        existingStudent.setRgNo(studentDetails.getRgNo());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setContact(studentDetails.getContact());
        existingStudent.setDob(studentDetails.getDob());
        existingStudent.setGender(studentDetails.getGender());
        // Note: Managing relationships (like semester, department) might need more specific logic
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}