package com.xcoc.appointment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xcoc.account.Dentist;
import com.xcoc.account.Patient;
import com.xcoc.appointment.Appointment;
import com.xcoc.appointment.AppointmentItem;
import com.xcoc.appointment.AppointmentService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:META-INF/application-context.xml"})
public class AppointmentServiceIntegratedTest {
	
	@Autowired
	private AppointmentService service;

	@Test
	public void givenValidAppointmentWhenIsCreatedThenAppointmentAndBillingIsCreated () {
		
		Appointment appointment = new Appointment();
		
		appointment.setDentist( new Dentist(1L) );
		appointment.setPatient( new Patient(1L,"Ze Ruela") );
		appointment.addItem( new AppointmentItem("Canal no dentao podrao" , 1200.00) );
		appointment.addItem( new AppointmentItem("taxa do nao sei" , 120.00) );
		
		service.create(appointment);
		
	}
}
