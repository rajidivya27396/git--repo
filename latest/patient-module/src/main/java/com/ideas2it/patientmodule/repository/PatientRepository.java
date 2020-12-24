package com.ideas2it.patientmodule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ideas2it.patientmodule.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
	
	@Query("select p from Patient p where p.patientId=?1")
	public Patient findByPatientId(long id);
	@Query("select p from Patient p where p.firstname=?1 or p.lastname=?1")
	public Patient findByPatientname(String name);

}
