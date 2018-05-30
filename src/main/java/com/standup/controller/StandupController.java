package com.standup.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.standup.dao.StandupRepository;
import com.standup.model.Standup;
import com.standup.model.StandupBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/standup")
@Api(value = "Standup API", tags = { "standup" })
public class StandupController
{
    
    @Autowired
    private StandupRepository standupRepository;
    
    
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ApiOperation(value = "Ping to test if the service is up and running", response = String.class)
    public ResponseEntity<String> ping()
    {
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @RequestMapping(path = "/", params = { "!name", "!date" }, method = RequestMethod.GET)
    @ApiOperation(value = "Returns Standup data", response = String.class)
    public List<Standup> getStandups()
    {

        return standupRepository.findAll();
    }
    
    @RequestMapping(path = "/", params = { "!date" }, method = RequestMethod.GET)
    @ApiOperation(value = "Returns Standup data", response = String.class)
    public List<Standup> getStandupsByName(@RequestParam("name") String  name)
    {

        return standupRepository.findByName(name);
    }
    
    @RequestMapping(path = "/", params = { "!name" }, method = RequestMethod.GET)
    @ApiOperation(value = "Returns Standup data", response = String.class)
    public List<Standup> getStandupsByDate(@RequestParam("date") String  date)
    {
        return standupRepository.findByDate(date);
    }
    
    @RequestMapping(path = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns Standup data", response = String.class)
    public List<Standup> getStandupsByNameAndDate(@RequestParam("name") String  name, @RequestParam("date") String  date)
    {
        return standupRepository.findByNameAndDate(name, date);
    }
    
    @RequestMapping(path = "/{name}/{date}",  method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Standup putStandup(@PathVariable("name") String  name, @PathVariable("date") String  date, @RequestBody StandupBody standupBody) {
        
        Standup standup = null;
        List<Standup> standupList = standupRepository.findByNameAndDate(name, date);
        if (!standupList.isEmpty()) {
            standup = standupList.get(0);
        } else {
            standup = new Standup(name, date);
        }
        BeanUtils.copyProperties(standupBody, standup);
        standupRepository.save(standup);
        return standup;
    }

}
