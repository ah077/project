package com.fsd.project.service;

import com.fsd.project.dto.FinalResultDTO;
import com.fsd.project.model.FinalResult;
import com.fsd.project.model.Semester;
import com.fsd.project.model.Student;
import com.fsd.project.repo.FinalResultRepository;
import com.fsd.project.repo.SemesterRepository;
import com.fsd.project.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalResultService {

    private final FinalResultRepository repo;
    private final StudentRepository studentRepo;
    private final SemesterRepository semesterRepo;

    public FinalResultService(FinalResultRepository repo,
                              StudentRepository studentRepo,
                              SemesterRepository semesterRepo) {
        this.repo = repo;
        this.studentRepo = studentRepo;
        this.semesterRepo = semesterRepo;
    }

    public List<FinalResult> getAll() {
        return repo.findAll();
    }

    public FinalResult create(FinalResultDTO dto) {
        FinalResult fr = new FinalResult();
        fr.setSubTotal(dto.getSubTotal());
        fr.setTotal(dto.getTotal());
        fr.setPercentage(dto.getPercentage());
        fr.setGrade(dto.getGrade());

        Student student = studentRepo.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Semester semester = semesterRepo.findById(dto.getSemesterId())
                .orElseThrow(() -> new RuntimeException("Semester not found"));

        fr.setStudent(student);
        fr.setSemester(semester);

        return repo.save(fr);
    }
}
