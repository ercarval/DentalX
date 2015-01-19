package com.xcoc.account.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.xcoc.account.Address;
import com.xcoc.account.Patient;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/application-context.xml"})
@TransactionConfiguration(defaultRollback=true)
public class PatientRepositoryIntegratedTest {
	
	private Address baseAddress;
	
	@Autowired
	private PatientRepository repository;
	
	@Before
	public void setUp() {
		baseAddress = new Address();
		baseAddress.setAddress("Address 1");
		baseAddress.setCity("City 1");
		baseAddress.setCountry("Country 1");
		baseAddress.setState("State 1");
		baseAddress.setZipCode("1123213");
	}
	
	
	@Test
	public void givenValidPatientWhenIsCreatedThenReturnNewValidId() {
		//Preparação = SetUp = Fixture
		Patient patient = new Patient();
		patient.setAddress( baseAddress );
		repository.create(patient);
		
		assertTrue(patient.getId() != null );
		
		Patient storedPatient = repository.findById( patient.getId()  );	
		
		assertEquals(storedPatient, patient);
	}

}
