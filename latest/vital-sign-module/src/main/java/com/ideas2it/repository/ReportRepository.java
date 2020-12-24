package com.ideas2it.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.entity.ReportClass;

@Repository
public interface ReportRepository extends MongoRepository<ReportClass,Long> {

}
