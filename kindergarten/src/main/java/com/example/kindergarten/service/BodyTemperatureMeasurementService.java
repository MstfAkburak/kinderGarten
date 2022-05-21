package com.example.kindergarten.service;

import com.example.kindergarten.model.BodyTemperatureMeasurement;

import java.util.List;

public interface BodyTemperatureMeasurementService {

    void saveBodyTemperatureMeasurement(BodyTemperatureMeasurement bodyTemperatureMeasurement, String schoolNumber);

    void deleteBodyTemperatureMeasurement(String id);

    void updateBodyTemperatureMeasurement(String id, Double bodyTemperature);

    List<BodyTemperatureMeasurement> getBodyTemperatureMeasurement(String schoolNumber);
}
