package io.egen.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Aastha Jain on 6/25/2017.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicles.findByAll",
                query = "SELECT veh FROM  Vehicles veh ORDER BY veh.make DESC"),
        @NamedQuery(name="Vehicles.findByOne",
            query="SELECT veh FROM Vehicles veh where veh.vin=:paramVehicleId")
})
public class Vehicles {

    @Id
    @Column(columnDefinition = "VARCHAR(17)")
    private String vin;

    private String make;
    private String model;
    private String year;
    private int redlineRpm;
    private double maxFuelVolume;
    private Date lastServiceDate;

   /* @OneToMany
    @JoinColumn(name="vin")
    private List<Readings> readings;

    public List<Readings> getReadings() {
        return readings;
    }

    public void setReadings(List<Readings> readings) {
        this.readings = readings;
    }*/

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", redlineRpm=" + redlineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                ", lastServiceDate=" + lastServiceDate +
                '}';
    }
}
