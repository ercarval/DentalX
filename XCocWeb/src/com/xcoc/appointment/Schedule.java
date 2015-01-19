package com.xcoc.appointment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.xcoc.appointment.aggregated.WorkingTime;

public class Schedule implements Serializable {

	private static final int BUSINESS_HOURS = 8;
	private static final int START_TIME = 9;

	private Date date;
	private String time;

	private List<WorkingTime> workingHours;

	public Schedule(Date date) {
		workingHours = buildWorkingHours(date);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private List<WorkingTime> buildWorkingHours(Date date) {

		List<WorkingTime> businessHours = new ArrayList<WorkingTime>();

		for (int i = 0; i < BUSINESS_HOURS; i++) {
			WorkingTime workingTime = new WorkingTime();
			workingTime.setDate(addHour(date, i));
			businessHours.add(workingTime);
		}

		return businessHours;

	}

	private Date addHour(Date date, int value) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, value);
		return calendar.getTime();
	}

	public List<WorkingTime> getWorkingHours() {
		return workingHours;
	}

	public List<WorkingTime> enrichWorkingHoursWithAppointments(
			List<Appointment> appointments) {

		Map<Date, Appointment> indexedAppointements = Appointment
				.indexAppointmentsByCreatedDate(appointments);
		for (WorkingTime workingTime : workingHours) {
			Appointment appointment = indexedAppointements.get(workingTime
					.getDate());
			workingTime.setAppointment(appointment);
		}

		return workingHours;
	}

}
