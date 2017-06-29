package io.egen.service;

import com.sun.org.apache.regexp.internal.RE;
import io.egen.entity.Readings;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aastha Jain on 6/27/2017.
 */
@Service
public interface ReadingsService {

    List<Readings> findAllReadings();

    List<Readings> findByVin(String vin);

    Readings createReadings(Readings readings);

    void updateReadings(Readings readings);

     void deleteReadings(String vehicleId);
}
