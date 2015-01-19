package com.xcoc.appointment;

import org.springframework.stereotype.Repository;

import com.xcoc.shared.repository.BaseRepository;

@Repository
public class AppointmentRepository extends BaseRepository<Appointment, Long> {
	
	public AppointmentRepository() {
	}


	@Override
	public void setClass() {
		clazz = Appointment.class;
	}
	
	
	
}
