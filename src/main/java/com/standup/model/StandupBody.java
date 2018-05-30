package com.standup.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "today", "tomorrow", "roadBlocks" })
public class StandupBody
{

    @JsonProperty("today")
    private List<String> today = new ArrayList<String>();
    @JsonProperty("tomorrow")
    private List<String> tomorrow = new ArrayList<String>();
    @JsonProperty("roadBlocks")
    private List<String> roadBlocks = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("today")
    public List<String> getToday()
    {
        return today;
    }

    @JsonProperty("today")
    public void setToday(List<String> today)
    {
        this.today = today;
    }

    @JsonProperty("tomorrow")
    public List<String> getTomorrow()
    {
        return tomorrow;
    }

    @JsonProperty("tomorrow")
    public void setTomorrow(List<String> tomorrow)
    {
        this.tomorrow = tomorrow;
    }

    @JsonProperty("roadBlocks")
    public List<String> getRoadBlocks()
    {
        return roadBlocks;
    }

    @JsonProperty("roadBlocks")
    public void setRoadBlocks(List<String> roadBlocks)
    {
        this.roadBlocks = roadBlocks;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties()
    {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value)
    {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString()
    {
        return "StandupBody [today=" + today + ", tomorrow=" + tomorrow + ", roadBlocks=" + roadBlocks
                + ", additionalProperties=" + additionalProperties + "]";
    }

    

}