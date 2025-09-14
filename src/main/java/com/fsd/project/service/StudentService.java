package com.fsd.project.service;

import com.fsd.project.dto.StudentDTO;
import com.fsd.project.exception.ResourceNotFoundException;
import com.fsd.project.model.Student;
import com.fsd.project.repo.DepartmentRepository;
import com.fsd.project.repo.SemesterRepository;
import com.fsd.project.repo.StudentRepository;
import com.fsd.project.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class StudentService {

    @Autowired private StudentRepository studentRepository;
    @Autowired private DepartmentRepository departmentRepository;
    @Autowired private SemesterRepository semesterRepository;
    @Autowired private SubjectRepository subjectRepository;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::mapEntityToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Student createStudent(StudentDTO dto) {
        Student student = new Student();
        copyDtoToEntity(dto, student);
        return studentRepository.save(student);
    }

    private StudentDTO mapEntityToDto(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setRgNo(student.getRgNo());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        if (student.getDepartment() != null) {
            dto.setDepartmentName(student.getDepartment().getName());
        }
        if (student.getSemester() != null) {
            dto.setSemesterInfo(student.getSemester().getSno() + " - " + student.getSemester().getStage());
        }
        return dto;
    }

    private void copyDtoToEntity(StudentDTO dto, Student student) {
        student.setRgNo(dto.getRgNo());
        student.setName(dto.getName());
        student.setContact(dto.getContact());
        student.setEmail(dto.getEmail());
        student.setGender(dto.getGender());
        student.setDob(dto.getDob());

        if (dto.getDepartmentId() != null) {
            student.setDepartment(departmentRepository.findById(dto.getDepartmentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + dto.getDepartmentId())));
        }
        if (dto.getSemesterId() != null) {
            student.setSemester(semesterRepository.findById(dto.getSemesterId())
                    .orElseThrow(() -> new ResourceNotFoundException("Semester not found with id: " + dto.getSemesterId())));
        }
    }
}