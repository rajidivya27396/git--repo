package com.ideas2it.vitalsignmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ideas2it.vitalsignmodule.dto.VitalSignDto;
import com.ideas2it.vitalsignmodule.entity.VitalSign;

@Repository
public interface VitalSignRepository extends JpaRepository<VitalSign,Long> {
    @Query("select p from VitalSign p where p.patient_fk = ?1 order by p.updatedDate DESC")
	VitalSign findByPatientID(long id); 
}