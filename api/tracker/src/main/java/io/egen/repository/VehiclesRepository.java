package io.egen.repository;

import io.egen.entity.Readings;
import io.egen.entity.Vehicles;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Aastha Jain on 6/21/2017.
 */
@Repository
public interface VehiclesRepository {

    List<Vehicles> findAll();

    Vehicles findOne(String id);

    Vehicles create(Vehicles vehicles);

    Vehicles update(Vehicles vehicles);

    Vehicles[] create(Vehicles[] vehicles);

    Vehicles[] update(Vehicles[] vehicles);

    void delete(Vehicles vehicles);

}
