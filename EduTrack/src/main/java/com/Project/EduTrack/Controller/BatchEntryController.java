package com.Project.EduTrack.Controller;

import com.Project.EduTrack.Entity.BatchEntry;
import com.Project.EduTrack.Service.BatchEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/batches")
public class BatchEntryController
{
    @Autowired
    private BatchEntryService service;

    @PostMapping
    public BatchEntry add(@RequestBody BatchEntry batch)
    {
        return service.save(batch);
    }
    @GetMapping
    public List<BatchEntry>getAll()
    {
        return service.getAll();
    }
    @GetMapping
    public Optional<BatchEntry>getById(@PathVariable String id)
    {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public  BatchEntry update(@PathVariable String id,@RequestBody BatchEntry batch)
    {
        return service.update(id,batch);
    }

    @DeleteMapping("/{id}")
    public  String delete(@PathVariable String id)
    {
        service.delete(id);
        return  "Deleted batch with id :"+id;
    }


}
