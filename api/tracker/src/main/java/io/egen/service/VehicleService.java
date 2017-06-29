package io.egen.service;

import io.egen.entity.Readings;
import io.egen.entity.Vehicles;
import io.egen.entity.Vehicles;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aastha Jain on 6/21/2017.
 */

@Service
public interface VehicleService {

    List<Vehicles> findAll();
    Vehicles findOne(String vin);
    void create(Vehicles[] vehicle);
    Vehicles[] update( Vehicles[] vehicle);
    void delete(String id);

    }
