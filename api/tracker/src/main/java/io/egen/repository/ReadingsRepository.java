package io.egen.repository;

import io.egen.entity.Readings;
import io.egen.entity.Tires;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Aastha Jain on 6/28/2017.
 */
@Repository
public interface ReadingsRepository {

    //Readings
    List<Readings> findAllReadings();
    List<Readings> findByVin(String vin);
    Readings createReadings(Readings readings,Tires tires);
    void updateReadings(Readings readings);
    void deleteReading(String vehicleId);

    //Alerts Signature
    void createAlert(String VehicleId, String Message, Timestamp date,String Priority);
}
