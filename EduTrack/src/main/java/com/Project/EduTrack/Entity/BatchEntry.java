package com.Project.EduTrack.Entity;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
@Document(collection = "batch_entry")
public class BatchEntry
{
    @Id
    private String id;
    private String batchName;
    private String duration;
    private double fees;

    public BatchEntry()
    {

    }
    public  BatchEntry(String batchName,String duration,double fees)
    {
    this.batchName = batchName;
    this. duration = duration;
    this.fees = fees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }
}
