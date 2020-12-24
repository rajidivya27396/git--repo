package com.ideas2it.patientmodule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ideas2it.patientmodule.entity.Address;
import com.ideas2it.patientmodule.entity.Patient;
import com.ideas2it.patientmodule.repository.PatientRepository;
import com.ideas2it.patientmodule.serviceimpl.PatientServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientmoduleApplicationTests {

	@Autowired
	private PatientServiceImpl service;
	@MockBean
	private PatientRepository patientRepo;
	@Test
	public void saveUser() throws ParseException {
		Address address=new Address();
		Patient patient =new Patient(1,"raji","sp","female",24,false,new SimpleDateFormat("yyyy-MM-dd").parse("2020-10-03"),"9677980214","ram","9567898234","brother","GK",address);
        when(patientRepo.save(patient)).thenReturn(patient);
        assertEquals(patientRepo.count(),1);
    }
 
     @Test
     public void getUserByName() throws ParseException {
    	long id=1;
    	Address address=new Address();
 		Patient patient =new Patient(1,"raji","sp","female",24,false,new SimpleDateFormat("yyyy-MM-dd").parse("2020-10-03"),"9677980214","ram","9567898234","brother","GK",address);
     	when(patientRepo.findByPatientId(id)).thenReturn(patient); 
     	assertEquals(patient.getPatientId(),service.getPatientById(id));
    }
				
     @Test
	 public void updateUser() throws ParseException {
    	 Address address=new Address();
 		Patient patient =new Patient(1,"raji","sp","female",24,false,new SimpleDateFormat("yyyy-MM-dd").parse("2020-10-03"),"9677980214","ram","9567898234","brother","GK",address);
         when(patientRepo.save(patient)).thenReturn(patient);
         assertEquals(patientRepo.count(),1);
    }

}
