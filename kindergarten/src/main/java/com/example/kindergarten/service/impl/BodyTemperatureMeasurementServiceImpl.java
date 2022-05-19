package com.example.kindergarten.service.impl;

import com.example.kindergarten.exception.model.NotFoundException;
import com.example.kindergarten.model.BodyTemperatureMeasurement;
import com.example.kindergarten.model.Student;
import com.example.kindergarten.repository.BodyTemperatureMeasurementRepository;
import com.example.kindergarten.repository.StudentRepository;
import com.example.kindergarten.service.BodyTemperatureMeasurementService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class BodyTemperatureMeasurementServiceImpl implements BodyTemperatureMeasurementService {

    private BodyTemperatureMeasurementRepository bodyTemperatureMeasurementRepository;
    private StudentRepository studentRepository;

    public BodyTemperatureMeasurementServiceImpl(BodyTemperatureMeasurementRepository bodyTemperatureMeasurementRepository, StudentRepository studentRepository) {
        this.bodyTemperatureMeasurementRepository = bodyTemperatureMeasurementRepository;
        this.studentRepository = studentRepository;
    }


    @Override
    public void saveBodyTemperatureMeasurement(BodyTemperatureMeasurement bodyTemperatureMeasurement, String schoolNumber) {

        try {
            Student student = studentRepository.findBySchoolNumber(schoolNumber);

            if (Objects.isNull(student)) {
                throw new NotFoundException(schoolNumber + " numaraya ait öğrenci bulunamadı");
            }
            bodyTemperatureMeasurement.setStudentId(student.getId());
            bodyTemperatureMeasurement.setIsEmergency((bodyTemperatureMeasurement.getBodyTemperature() > 38.0) ? true : false);
            bodyTemperatureMeasurement.setDate(String.valueOf(new Date()));
            bodyTemperatureMeasurementRepository.save(bodyTemperatureMeasurement);

        } catch (Exception ex) {
            throw new NotFoundException("saveBodyTemperatureMeasurement error : " + ex.getLocalizedMessage());
        }
    }

    @Override
    public void deleteBodyTemperatureMeasurement(String id) {
        try {
            if (!StringUtils.isEmpty(id)) {
                BodyTemperatureMeasurement bodyTemperatureMeasurement = bodyTemperatureMeasurementRepository.findById(id).get();
                if (Objects.nonNull(bodyTemperatureMeasurement)) {
                    bodyTemperatureMeasurementRepository.delete(bodyTemperatureMeasurement);
                }
            }
        } catch (Exception e) {
            throw new NotFoundException(id + "'ye sahip bodyTemperatureMeasurement bulunamadı");
        }
    }

    @Override
    public void updateBodyTemperatureMeasurement(String id, String studentId, Double bodyTemperature) {
        try {
            BodyTemperatureMeasurement bodyTemperatureMeasurement = bodyTemperatureMeasurementRepository.findById(id).get();
            Student student = studentRepository.findById(studentId).get();
            if (Objects.nonNull(bodyTemperatureMeasurement) && Objects.nonNull(student)) {
                bodyTemperatureMeasurement.setDate(String.valueOf(new Date()));
                bodyTemperatureMeasurement.setBodyTemperature(bodyTemperature);
                bodyTemperatureMeasurement.setIsEmergency((bodyTemperature > 38.0) ? true : false);
                bodyTemperatureMeasurementRepository.save(bodyTemperatureMeasurement);
            }
        } catch (Exception e) {
            throw new NotFoundException(id + "'ye sahip bodyTemperatureMeasurement bulunamadı");
        }
    }

    @Override
    public List<BodyTemperatureMeasurement> getBodyTemperatureMeasurement(String schoolNumber) {
        try {
            Student student = studentRepository.findBySchoolNumber(schoolNumber);

            if (Objects.isNull(student)) {
                throw new NotFoundException(schoolNumber + " numaraya ait öğrenci bulunamadı");
            }

            return bodyTemperatureMeasurementRepository.findAllByStudentId(student.getId());
        } catch (Exception ex) {
            throw new NotFoundException("getBodyTemperatureMeasurement error : " + ex.getLocalizedMessage());
        }
    }
}
