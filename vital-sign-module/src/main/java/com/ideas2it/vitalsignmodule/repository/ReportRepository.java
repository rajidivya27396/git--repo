package com.ideas2it.vitalsignmodule.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.vitalsignmodule.entity.ReportClass;

@Repository
public interface ReportRepository extends MongoRepository<ReportClass,Long> {

}
