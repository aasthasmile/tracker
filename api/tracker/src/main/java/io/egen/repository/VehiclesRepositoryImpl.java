package io.egen.repository;

import io.egen.entity.Readings;
import io.egen.entity.Vehicles;
import io.egen.service.VehicleService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Aastha Jain on 6/21/2017.
 */

@Repository
public class VehiclesRepositoryImpl implements VehiclesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicles> findAll() {
        System.out.println("Inside the Vehicles Repository");
        TypedQuery<Vehicles> query=entityManager.createNamedQuery("Vehicles.findByAll",Vehicles.class);
        List<Vehicles> resultList=query.getResultList();
        return resultList;
    }

    public Vehicles findOne(String id) {
        TypedQuery<Vehicles> query=entityManager.createNamedQuery("Vehicles.findByOne",Vehicles.class);
        query.setParameter("paramVehicleId",id);
        List<Vehicles> resultList=query.getResultList();

        if(resultList!=null && resultList.size()==1)
            return resultList.get(0);
        else
            return  null;

    }

    public Vehicles create(Vehicles vehicles) {
        entityManager.persist(vehicles);
        return  vehicles;
    }

    public Vehicles[] create(Vehicles[] vehicles) {
        for(Vehicles veh : vehicles)
            entityManager.persist(veh);
        return vehicles;
    }

    public Vehicles update(Vehicles vehicles) {
        System.out.println("Inside the PUT Repository function");
        return entityManager.merge(vehicles);
    }

    public Vehicles[] update(Vehicles[] vehicles) {
        for(Vehicles veh : vehicles)
            entityManager.merge(veh);
        return vehicles;
    }

    public void delete(Vehicles veh) {
        TypedQuery<Vehicles> query=entityManager.createNamedQuery("Vehicles.findByOne",Vehicles.class);
        query.setParameter("paramVehicleId",veh.getVin());

        Vehicles existing=query.getResultList().get(0);

        entityManager.remove(existing);
    }

}
