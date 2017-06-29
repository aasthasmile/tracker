package io.egen.controller;

import io.egen.entity.Readings;
import io.egen.service.ReadingsService;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

/**
 * Created by Aastha Jain on 6/27/2017.
 */
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value="/readings")
public class ReadingsController {

    @Autowired
    private ReadingsService service;

    //Readings Enpoints

    @RequestMapping(method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> findAllReadings(){
        System.out.println("Inside the controller-- Readings");
        return service.findAllReadings();
    }

    @RequestMapping(method= RequestMethod.GET,value="/{vehicleId}")
    public List<Readings> findOneReading(@PathVariable("vehicleId") String vehicleId){
        return service.findByVin(vehicleId);
    }

    @RequestMapping(method= RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void createReadings(@RequestBody Readings readings){
        System.out.println("Creating new readings ");
        service.createReadings(readings);
    }

    @RequestMapping(method= RequestMethod.PUT
            ,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE
            ,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateReadings(@RequestBody Readings readings){
        service.updateReadings(readings);
    }

    @RequestMapping(method= RequestMethod.DELETE,value="/{vehicleId}")
    public void deleteReadings(@PathVariable("vehicleId") String vehicleId){
        service.deleteReadings(vehicleId);

    }

}
