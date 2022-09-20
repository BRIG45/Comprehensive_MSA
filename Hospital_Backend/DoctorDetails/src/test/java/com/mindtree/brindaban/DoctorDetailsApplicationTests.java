package com.mindtree.brindaban;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.brindaban.controller.DoctorController;
import com.mindtree.brindaban.entity.Doctor;
import com.mindtree.brindaban.exception.CustomException;
import com.mindtree.brindaban.repository.DoctorRepository;

@SpringBootTest
class DoctorDetailsApplicationTests {

	@Autowired
	private DoctorRepository dRepo;

	@Autowired
	DoctorController dControl;

	@Test
	void testAdd() {
		Doctor dc = new Doctor(9L, "Dr Dhinesh Khara", 52, "Male", "Heart Surgen");
		Doctor addDc = dControl.add(dc);
		assertEquals(dRepo.ByName("dr Dhinesh Khara").getName(), addDc.getName());
	}

	@Test
	void testList() throws CustomException {
		assertEquals(dRepo.findAll().size(), dControl.list().size());
	}
}
