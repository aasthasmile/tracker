package io.egen.service;

import io.egen.entity.Readings;
import io.egen.entity.Vehicles;
import io.egen.entity.Vehicles;
import io.egen.exception.BadRequestException;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aastha Jain on 6/21/2017.
 */

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehiclesRepository repository;

    @Transactional(readOnly = true)
    public List<Vehicles> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Vehicles findOne(String vehicleId) {
        Vehicles existing =repository.findOne(vehicleId);
        if(existing==null){
            throw new ResourceNotFoundException("Resource Not found with Vehicles id ="+vehicleId);
        }
        return existing;
    }

    @Transactional
    public void create(Vehicles[] vehicles) {
        for(Vehicles veh:vehicles){
            repository.create(veh);
        }
    }

    @Transactional
    public Vehicles[] update(Vehicles[] vehicles) {
        return repository.update(vehicles);
    }

    @Transactional
    public void delete(String vehicleId) {
        Vehicles existing=repository.findOne(vehicleId);

        if(existing==null){
            throw new ResourceNotFoundException("Resource Not found with Vehicles id ="+vehicleId);
        }
        repository.delete(existing);

   }


}
