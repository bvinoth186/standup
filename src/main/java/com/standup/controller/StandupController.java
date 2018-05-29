package com.standup.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.standup.dao.StandupRepository;
import com.standup.model.Standup;

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
    public List<Standup> getStandups(@RequestParam("name") String  name)
    {

        return standupRepository.findByName(name);
    }
    
    @RequestMapping(path = "/", params = { "!name" }, method = RequestMethod.GET)
    @ApiOperation(value = "Returns Standup data", response = String.class)
    public List<Standup> getStandups(@RequestParam("date") Date  date)
    {

        return standupRepository.findByDate("");
    }

}
