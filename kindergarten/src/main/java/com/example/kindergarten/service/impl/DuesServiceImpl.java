package com.example.kindergarten.service.impl;

import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.Dues;
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
    public void saveDues(Dues dues) {
        try {
            if (Objects.nonNull(studentRepository.findById(dues.getStudentId()).get())) {
                duesRepository.save(dues);
            }
        } catch (Exception exception) {
            throw new NotFoundException(" idli öğrenci bulunadı.");
        }
    }

    @Override
    public List<Dues> getDues(String studentId) {
        return duesRepository.findAllByStudentIdOrderByDate(studentId);
    }

    @Override
    public void updateDues(String id, Double value, String date, String paymentDate) {
        Dues dues = duesRepository.findById(id).get();

        if (Objects.isNull(dues)) {
            throw new NotFoundException("No activity found to update with this day = " + dues.getId());
        }

        dues.setValue(value);
        dues.setDate(date);
        dues.setPaymentDate(paymentDate);

        duesRepository.save(dues);
    }

    @Override
    public void deleteDues(String id) {
        Dues dues = duesRepository.findById(id).get();
        duesRepository.delete(dues);
    }
}
