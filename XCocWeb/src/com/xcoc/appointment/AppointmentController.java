package com.xcoc.appointment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("appointmentController")
@Scope("view")
public class AppointmentController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AppointmentService appointmentService;
	
	private Appointment appointment;

	private List<Appointment> appointments;
	
	private Schedule schedule;  
	
	public AppointmentController() {
		System.out.println("Created");
	}

	@PostConstruct
	public void init() {
		schedule = new Schedule(new Date());
		initializeSchedulesCalendar();
	}
	
	
	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}
	
	public List<Appointment> getAppointments() {
		if (appointments == null) {
			appointments = appointmentService.getAll().listAll();
		}
		return appointments;
	}
	
	public void initializeSchedulesCalendar() {
		schedule.enrichWorkingHoursWithAppointments(getAppointments());
	}
	
	public void scheduleSearch() {
		
	}

	
	
	
	
}
