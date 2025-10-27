package com.MarvellousREST.RESTAPI;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/batches")
public class BatchEntryController
{
    private Map<Long,BatchEntry> batchentries = new HashMap<>();

    //HTTP:GET
    //R : Read
    //select * from batches
    public List<BatchEntry> getAll()
    {
        return new ArrayList<>(batchentries.values());
    }

    //HTTP:POST
    //c : create
    //insert into batches values(1,'PPA',25000)
    @PostMapping
    public  boolean createEntry(@RequestBody BatchEntry myentry)
    {
        batchentries.put(myentry.getId(),myentry);
        return  true;
    }
    //HTTP:GET
    //R : Read
    //select * from batches where id = 1;

    @GetMapping("/id/{myid}")
    public  BatchEntry getBatchEntryById(@PathVariable Long myid)
    {
        return batchentries.get(myid);
    }

    //HTTP:DELETE
    //D : Delete
    //delete from batches where id = 1;
    @DeleteMapping
    public BatchEntry deleteEntryById(@PathVariable Long myid)
    {
        return batchentries.remove(myid);
    }

    //HTTP : PUT
    //update batches set fees = 30000 where id = 1;

    @PutMapping("/id/{myid}")
    public BatchEntry updateEntryById(@PathVariable Long myid,BatchEntry myentry)
    {
        return batchentries.put(myid,myentry);
    }

}
