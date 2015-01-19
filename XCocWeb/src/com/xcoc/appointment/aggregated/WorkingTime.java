package com.xcoc.appointment.aggregated;

import java.io.Serializable;
import java.util.Date;

import com.xcoc.appointment.Appointment;

public class WorkingTime implements Serializable {
	
	private Date date;
	private Appointment appointment;
	
	public WorkingTime() {
	}

	public Date getDate() {
		return date;

	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	

}
