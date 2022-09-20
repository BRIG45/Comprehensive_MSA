package com.mindtree.brindaban.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.brindaban.entity.Patient;
import com.mindtree.brindaban.repository.PatientRepository;


@SpringBootTest
public class PatientControllerApplicatonTests {

	@Autowired
    PatientController pControl;
     
    @Autowired
    PatientRepository pRepo;
    
    @Test
    void testList()
    {
    	assertThat(pControl.listPatient().size()).isGreaterThan(0);
    }
    
    @Test
    void testAdd()
    {
    	Patient p3=null;
		try {
			p3 = new Patient(9L,"Joydeep Karmakar",44,4L,new SimpleDateFormat("yyyy-MM-dd").parse("2022-09-19"),"Feaver");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	pControl.add(p3);
    	
    	assertEquals("Joydeep Karmakar",pRepo.byName("Joydeep Karmakar").getName());
    }
    
    @Test
    void testListPatient()
    {
    	assertThat(pControl.listPatient().size()).isGreaterThan(0);
    }
    
    void testNumberOfPatientOfDoctor()
    {
    	assertThat(pControl.numberOfPatientInDoctor(3L)).isGreaterThan(0);
    }
}
