package com.ideas2it.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.entity.AuditTrailEntity;

@Repository
public interface AuditRepository extends MongoRepository<AuditTrailEntity,UUID> {

}
