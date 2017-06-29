package io.egen.service;

import com.sun.org.apache.regexp.internal.RE;
import io.egen.entity.Alerts;
import io.egen.entity.Readings;
import io.egen.entity.Tires;
import io.egen.entity.Vehicles;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.ReadingsRepository;
import io.egen.repository.VehiclesRepository;
import javafx.scene.control.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;

/**
 * Created by Aastha Jain on 6/27/2017.
 */
@Service
public class ReadingsServiceImpl implements ReadingsService{

    @Autowired
    private ReadingsRepository readingsRepository;

    @Transactional(readOnly = true)
    public List<Readings> findAllReadings() {
        return readingsRepository.findAllReadings();
    }

    @Transactional(readOnly = true)
    public List<Readings> findByVin(String vin) {
        List<Readings> existing =readingsRepository.findByVin(vin);
        if(existing==null){
            throw new ResourceNotFoundException("Resource Not found with Readings id ="+vin);
        }
        return existing;
    }

    @Transactional
    public Readings createReadings(Readings readings) {
        Tires tires=readings.getTires();

        if(readings.isEngineCoolantLow()||readings.isCheckEngineLightOn()){
            readingsRepository.createAlert(readings.getVin(),"Engine Light is On or Engine Coolant is Low",new Timestamp(new Date().getTime()),"LOW");
        }

        if (tires.getFrontLeft() < 32 || tires.getFrontLeft() > 36 || tires.getFrontRight() < 32 || tires.getFrontRight() > 36
                || tires.getRearLeft() < 32 || tires.getRearLeft() > 36 || tires.getRearRight() < 32 || tires.getRearRight() > 36) {
            readingsRepository.createAlert(readings.getVin(),"Tire Pressure of tires is low",new Timestamp(new Date().getTime()),"LOW");
        }

        return readingsRepository.createReadings(readings,tires);
    }

    @Transactional
    public void updateReadings(Readings readings) {
        readingsRepository.updateReadings(readings);
    }

    @Transactional
    public void deleteReadings(String vehicleId) {
        readingsRepository.deleteReading(vehicleId);
    }

}
