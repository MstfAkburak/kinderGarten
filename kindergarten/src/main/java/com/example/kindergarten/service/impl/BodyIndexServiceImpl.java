package com.example.kindergarten.service.impl;

import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.BodyIndex;
import com.example.kindergarten.model.Student;
import com.example.kindergarten.repository.BodyIndexRepository;
import com.example.kindergarten.repository.StudentRepository;
import com.example.kindergarten.service.BodyIndexService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class BodyIndexServiceImpl implements BodyIndexService {

    private BodyIndexRepository bodyIndexRepository;
    private StudentRepository studentRepository;

    public BodyIndexServiceImpl(BodyIndexRepository bodyIndexRepository, StudentRepository studentRepository) {
        this.bodyIndexRepository = bodyIndexRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveBodyIndex(BodyIndex bodyIndex) {
        Student student = studentRepository.findById(bodyIndex.getStudentId()).get();

        if (Objects.isNull(student)) {
            throw new NotFoundException(bodyIndex.getStudentId() + " idli öğrenci bulunamadı...");
        }

        bodyIndex.setDate(String.valueOf(new Date()));
        bodyIndexRepository.save(bodyIndex);
    }

    @Override
    public void deleteBodyIndex(String id) {
        try {
            BodyIndex bodyIndex = bodyIndexRepository.findById(id).get();
            if (Objects.nonNull(bodyIndex)) {
                bodyIndexRepository.delete(bodyIndex);
            }
        } catch (Exception e) {
            throw new NotFoundException(id + "'ye sahip bodyIndex bulunamadı");
        }
    }

    @Override
    public void updateBodyIndex(String id, BodyIndex bodyIndex) {
        try {
            BodyIndex studentBodyIndex = bodyIndexRepository.findById(id).get();
            Student student = studentRepository.findById(bodyIndex.getStudentId()).get();
            if (Objects.nonNull(studentBodyIndex) && Objects.nonNull(student)) {
                studentBodyIndex.setDate(String.valueOf(new Date()));
                studentBodyIndex.setSize(bodyIndex.getSize());
                studentBodyIndex.setWeight(bodyIndex.getWeight());
                bodyIndexRepository.save(studentBodyIndex);
            }
        } catch (Exception e) {
            throw new NotFoundException(id + "'ye sahip bodyIndex bulunamadı");
        }
    }

    @Override
    public List<BodyIndex> getStudentBodyIndex(String studentId) {
        try {
            Student student = studentRepository.findById(studentId).get();
            if (Objects.nonNull(student)) {
                return bodyIndexRepository.findAllByStudentId(studentId);
            }
        } catch (Exception e) {
            throw new NotFoundException(studentId + "'ye sahip öğrenci bulunamadı");
        }
        return new ArrayList<>();
    }
}
