package com.fsd.project.service;

import com.fsd.project.dto.StudentDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Department;
import com.fsd.project.model.Semester;
import com.fsd.project.model.Student;
import com.fsd.project.repo.DepartmentRepository;
import com.fsd.project.repo.SemesterRepository;
import com.fsd.project.repo.StudentRepository;
import com.fsd.project.repo.SubjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class StudentService {

    @Autowired private StudentRepository studentRepository;
    @Autowired private DepartmentRepository departmentRepository;
    @Autowired private SemesterRepository semesterRepository;
    @Autowired private SubjectRepository sr;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    public Student createStudent(StudentDTO dto) {
        Student s = new Student();
        copyDtoToEntity(dto, s);
        return studentRepository.save(s);
    }

    public Student updateStudent(Long id, StudentDTO dto) {
        Student s = getStudentById(id);
        copyDtoToEntity(dto, s);
        return studentRepository.save(s);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id))
            throw new ResourceNotFoundException("Student not found with id: " + id);
        studentRepository.deleteById(id);
    }

    private void copyDtoToEntity(StudentDTO dto, Student s) {
        s.setRgNo(dto.getRgNo());
        s.setName(dto.getName());
        s.setContact(dto.getContact());
        s.setEmail(dto.getEmail());
        s.setGender(dto.getGender());
        s.setDob(dto.getDob());

        if (dto.getDepartmentId() != null) {
            s.setDepartment(departmentRepository.findById(dto.getDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found")));
        }
        if (dto.getSemesterId() != null) {
            s.setSemester(semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new ResourceNotFoundException("Semester not found")));
        }
        if (dto.getSubjectIds() != null) {
            s.setSubjects(new HashSet<>(sr.findAllById(dto.getSubjectIds())));
        }
    }
}
