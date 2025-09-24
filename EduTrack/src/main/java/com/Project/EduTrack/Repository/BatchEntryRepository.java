package com.Project.EduTrack.Repository;

import com.Project.EduTrack.Entity.BatchEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BatchEntryRepository  extends MongoRepository<BatchEntry,String>
{

}
