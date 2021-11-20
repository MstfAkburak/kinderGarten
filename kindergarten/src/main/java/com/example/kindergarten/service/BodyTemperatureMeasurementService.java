package com.example.kindergarten.service;

import com.example.kindergarten.model.BodyTemperatureMeasurement;

import java.util.List;

public interface BodyTemperatureMeasurementService {

    void saveBodyTemperatureMeasurement(BodyTemperatureMeasurement bodyTemperatureMeasurement);

    void deleteBodyTemperatureMeasurement(String id);

    void updateBodyTemperatureMeasurement(String id, String studentId, Double bodyTemperature);

    List<BodyTemperatureMeasurement> getBodyTemperatureMeasurement(String studentId);
}
