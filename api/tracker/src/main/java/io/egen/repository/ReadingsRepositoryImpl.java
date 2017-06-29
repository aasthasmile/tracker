package io.egen.repository;

import io.egen.entity.Alerts;
import io.egen.entity.Readings;
import io.egen.entity.Tires;
import io.egen.entity.Vehicles;
import javafx.scene.control.Alert;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Aastha Jain on 6/28/2017.
 */
@Repository
public class ReadingsRepositoryImpl implements ReadingsRepository{

    @PersistenceContext
    private EntityManager entityManager;

    //Readings
    public List<Readings> findAllReadings() {
        TypedQuery<Readings> query=entityManager.createNamedQuery("Readings.findByAll",Readings.class);
        List<Readings> resultList=query.getResultList();
        return resultList;
    }

    public List<Readings> findByVin(String vin) {
        TypedQuery<Readings> query=entityManager.createNamedQuery("Readings.findByOne",Readings.class);//createQuery("SELECT emp FROM  Employee emp where emp.email=:paramEmail",Employee.class);
        query.setParameter("paramVehicleId",vin);
        List<Readings> resultList=query.getResultList();
        return resultList;
    }

    public Readings createReadings(Readings readings, Tires tires) {
        System.out.println("Readings Repository Creation");

        //creating Reading data requires creation of tires data and passing to reading object(like Cascading)
        entityManager.persist(tires);
        readings.setTires(tires);
        entityManager.persist(readings);

        //Creating Alerts for the readings.
        TypedQuery<Vehicles> query=entityManager.createNamedQuery("Vehicles.findByOne",Vehicles.class);
        query.setParameter("paramVehicleId",readings.getVin());

        Vehicles existing=query.getResultList().get(0);

        if(readings.getEngineRpm()>existing.getRedlineRpm()){
            createAlert(readings.getVin(),"Red line Rpm is greater then Engine Rpm",new Timestamp(new Date().getTime()),"HIGH");
        }
        if(readings.getFuelVolume()<0.1*existing.getMaxFuelVolume()){
            createAlert(readings.getVin(),"Fuel Volume is Low.Refill the fuel",new Timestamp(new Date().getTime()),"MEDIUM");
        }

        return readings;
    }

    public void updateReadings(Readings readings) {
        entityManager.merge(readings);
    }

    public void deleteReading(String vehicleId) {
        TypedQuery<Readings> query=entityManager.createNamedQuery("Readings.findByOne",Readings.class);
        query.setParameter("paramVehicleId",vehicleId);
        List<Readings> resultList=query.getResultList();
        for (Readings read:resultList) {
            entityManager.remove(read);
        }
    }

    public void createAlert(String VehicleId, String Message, Timestamp date, String Priority){
        System.out.println("Creating Alerts");
        Alerts alert=new Alerts(VehicleId,Message,date,Priority);
        entityManager.persist(alert);
    }

}
