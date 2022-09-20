package com.mindtree.brindaban.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.brindaban.entity.Patient;
import com.mindtree.brindaban.exception.CustomException;
import com.mindtree.brindaban.service.PatientService;
import com.mindtree.brindaban.valueobject.PatientWithDoctor;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	PatientService pServe;

	@PostMapping("/add")
	public Patient add(@RequestBody Patient patient) {
		return pServe.add(patient);
	}

	@GetMapping("/search/{id}")
	public PatientWithDoctor searchById(@PathVariable long id) throws CustomException {
		try {
			return pServe.searchById(id);
		} catch (CustomException e) {
			throw new CustomException(e.getMessage());
		}
	}

	@GetMapping("/with-doctor")
	public List<PatientWithDoctor> listPatient() {
		return pServe.listWithDoctor();
	}

	@GetMapping("/patient-of-doctor/{docId}")
	public int numberOfPatientInDoctor(@PathVariable long docId) {
		return pServe.numberOfPatientInDoctor(docId);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable long id) throws CustomException {
		pServe.deleteById(id);
	}
}