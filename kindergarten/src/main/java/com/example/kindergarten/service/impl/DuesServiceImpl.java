package com.example.kindergarten.service.impl;

import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.Dues;
import com.example.kindergarten.model.Student;
import com.example.kindergarten.repository.DuesRepository;
import com.example.kindergarten.repository.StudentRepository;
import com.example.kindergarten.service.DuesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DuesServiceImpl implements DuesService {

    private DuesRepository duesRepository;
    private StudentRepository studentRepository;

    public DuesServiceImpl(DuesRepository duesRepository, StudentRepository studentRepository) {
        this.duesRepository = duesRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveDues(Dues dues, String schoolNumber) {
        try {
            Student student = studentRepository.findBySchoolNumber(schoolNumber);
            if (Objects.nonNull(student)) {
                dues.setStudentId(student.getId());
                duesRepository.save(dues);
            }
        } catch (Exception exception) {
            throw new NotFoundException(" idli öğrenci bulunadı.");
        }
    }

    @Override
    public List<Dues> getDues(String schoolNumber) {
        try {
            Student student = studentRepository.findBySchoolNumber(schoolNumber);
            if(Objects.nonNull(student)) {
                return duesRepository.findAllByStudentIdOrderByDate(student.getId());
            }
        } catch (NotFoundException ex) {
            throw new NotFoundException(" idli öğrenci bulunadı.");
        }
        return null;
    }

    @Override
    public void updateDues(String duesId) {
        try{
            Dues dues = duesRepository.findById(duesId).get();

            if (Objects.isNull(dues)) {
                throw new NotFoundException("No activity found to update with this day = " + dues.getId());
            }
            dues.setIsPaid(Boolean.TRUE);
            duesRepository.save(dues);
        }catch (Exception ex) {
            throw new NotFoundException( "Update Dues error : " + ex.getLocalizedMessage());
        }
    }

    @Override
    public void deleteDues(String id) {
        Dues dues = duesRepository.findById(id).get();
        duesRepository.delete(dues);
    }
}
