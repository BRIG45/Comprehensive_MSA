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

import com.mindtree.brindaban.entity.Doctor;
import com.mindtree.brindaban.exception.CustomException;
import com.mindtree.brindaban.service.DoctorService;
import com.mindtree.brindaban.valueobject.DoctorWithPatient;

@RestController
@RequestMapping("/doctor")

public class DoctorController {

	@Autowired
	DoctorService docService;

	@PostMapping
	public Doctor add(@RequestBody Doctor doc) {
		return docService.add(doc);
	}

	@GetMapping
	public List<Doctor> list() throws CustomException {
		if (docService.list().isEmpty()) {
			throw new CustomException("No doctor there in the database");
		}
		return docService.list();
	}

	@GetMapping("/search-by-id/{id}")
	public DoctorWithPatient getByID(@PathVariable long id) throws CustomException {
		try {
			return docService.getById(id);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@DeleteMapping("/delete/{id}")
	public Doctor delete(@PathVariable long id) throws CustomException {
		return docService.delete(id);
	}

	@GetMapping("/get-name/{id}")
	public String getName(@PathVariable long id) {
		return docService.getName(id);
	}
}