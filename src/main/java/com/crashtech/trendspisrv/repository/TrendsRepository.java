package com.crashtech.trendspisrv.repository;

import com.crashtech.trendspisrv.models.Trend;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrendsRepository extends MongoRepository<Trend,String> {
}
