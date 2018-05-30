package com.standup.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Standup
{

    
    
    @Id
    private String  id;
    private String  name;
    private String  date;
    private List<String> today;
    private List<String> tomorrow;
    private List<String> roadBlocks;
    
    public Standup(String name, String date)
    {
        super();
        this.name = name;
        this.date = date;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public List<String> getToday()
    {
        return today;
    }

    public void setToday(List<String> today)
    {
        this.today = today;
    }

    public List<String> getTomorrow()
    {
        return tomorrow;
    }

    public void setTomorrow(List<String> tomorrow)
    {
        this.tomorrow = tomorrow;
    }

    public List<String> getRoadBlocks()
    {
        return roadBlocks;
    }

    public void setRoadBlocks(List<String> roadBlocks)
    {
        this.roadBlocks = roadBlocks;
    }

    @Override
    public String toString()
    {
        return "Standup [id=" + id + ", name=" + name + ", date=" + date + ", today=" + today + ", tomorrow=" + tomorrow
                + ", roadBlocks=" + roadBlocks + "]";
    }
    
    
    

}
