package com.foodparcel.controller;

import com.foodparcel.Service.VolunteerService;
import com.foodparcel.Service.impl.VolunteerServiceImpl;
import com.foodparcel.entity.Volunteer;
import com.foodparcel.factory.VolunteerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4500")
@RequestMapping("/volunteer")
public class VolunteerController {

    @Autowired
    private  VolunteerServiceImpl volunteerService;

    @PostMapping("/create")
    public Volunteer create(@RequestBody Volunteer volunteer){

        Volunteer newVolunteer = VolunteerFactory.builderVolunteer(volunteer.getfName(),volunteer.getlName(),volunteer.getPhoneNum(), volunteer.getIdNumber());
        return volunteerService.create(newVolunteer);

    }

    @GetMapping("/all")
    public Set<Volunteer> getAll(){

        return volunteerService.getAll();
    }

    @GetMapping("/read/{id}")
    public Volunteer read(@PathVariable String id){

        return volunteerService.read(id);
    }

    @PostMapping("/update")
    public Volunteer update(@RequestBody Volunteer volunteer){
        return volunteerService.update(volunteer);
    }



    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){

        return volunteerService.delete1(id);
    }

    @PostMapping("/availability")
    public Volunteer availability(@RequestBody Volunteer volunteer){

        return volunteerService.isAvailable(volunteer);
    }


}
