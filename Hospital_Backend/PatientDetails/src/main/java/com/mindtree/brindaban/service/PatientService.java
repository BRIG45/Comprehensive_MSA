package com.mindtree.brindaban.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.brindaban.entity.Patient;
import com.mindtree.brindaban.exception.CustomException;
import com.mindtree.brindaban.valueobject.PatientWithDoctor;

@Service
public interface PatientService {

	Patient add(Patient patient);

	PatientWithDoctor searchById(long id) throws CustomException;

	List<PatientWithDoctor> listWithDoctor();

	int numberOfPatientInDoctor(long docId);

	void deleteById(long id);
}
