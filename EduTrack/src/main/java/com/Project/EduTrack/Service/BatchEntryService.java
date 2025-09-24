package com.Project.EduTrack.Service;

import com.Project.EduTrack.Entity.BatchEntry;
import com.Project.EduTrack.Repository.BatchEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BatchEntryService
{
    @Autowired
    private BatchEntryRepository repo;

    public BatchEntry save(BatchEntry batch)
    {
        return  repo.save(batch);
    }

    public List<BatchEntry> getAll()
    {
        return repo.findAll();
    }

    public Optional<BatchEntry>getById(String id)
    {
        return repo.findById(id);
    }

    public  BatchEntry update(String id,BatchEntry updated)
    {
        updated.setId(id);
        return repo.save(updated);
    }

    public void  delete(String id)
    {
        repo.deleteById(id);
    }
}
