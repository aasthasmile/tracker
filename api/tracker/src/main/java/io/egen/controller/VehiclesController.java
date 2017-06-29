package io.egen.controller;

import io.egen.entity.Readings;
import io.egen.entity.Vehicles;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Aastha Jain on 6/20/2017.
 */
@CrossOrigin(origins = {"http://mocker.egen.io","http://localhost:8080"}, maxAge = 3600)
@RestController
@RequestMapping(value="/vehicles")
public class VehiclesController {

    @Autowired
    private VehicleService service;

    //Vehicles Endpoints

    @RequestMapping(method= RequestMethod.GET)
    public List<Vehicles> findAll()
    {
        System.out.println("Inside the controller ");
        return service.findAll();
    }

    @RequestMapping(method= RequestMethod.GET,value="/{vehicleId}")
    public Vehicles findOne(@PathVariable("vehicleId") String vehicleId){
        return service.findOne(vehicleId);
    }

    @RequestMapping(method= RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void create(@RequestBody Vehicles[] vehicle){
        service.create(vehicle);
    }

    @RequestMapping(method= RequestMethod.PUT
            ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
            ,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicles[] update(@RequestBody Vehicles[] vehicle){
        System.out.println("Inside the Vehicles Controller -PUT mapping");
        return service.update(vehicle);
    }

    @RequestMapping(method= RequestMethod.DELETE,value="/{vehicleId}")
    public void delete(@PathVariable("vehicleId") String vehicleId){
        service.delete(vehicleId);
    }




}
