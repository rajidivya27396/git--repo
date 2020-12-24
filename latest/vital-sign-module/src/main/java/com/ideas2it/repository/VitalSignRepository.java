package com.ideas2it.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ideas2it.dto.VitalSignDto;
import com.ideas2it.entity.VitalSign;

@Repository
public interface VitalSignRepository extends JpaRepository<VitalSign,Long> {
	
    @Query("select p from VitalSign p where p.patient_fk = ?1 order by p.updatedDate DESC")
	VitalSign findByPatientID(long id); 
}