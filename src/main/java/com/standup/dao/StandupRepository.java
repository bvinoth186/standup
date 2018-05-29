package com.standup.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.standup.model.Standup;

public interface StandupRepository extends MongoRepository<Standup, String>
{
    
    public List<Standup> findByName(String name);
    
    public List<Standup> findByDate(String date);

}
