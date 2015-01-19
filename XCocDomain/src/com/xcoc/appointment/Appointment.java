package com.xcoc.appointment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.xcoc.account.Dentist;
import com.xcoc.account.Patient;

@Entity
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@ManyToOne
	private Dentist dentist;

	@ManyToOne
	private Patient patient;

	@OneToMany(mappedBy = "appointment")
	private List<AppointmentItem> items;

	public Appointment() {
		items = new ArrayList<AppointmentItem>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Dentist getDentist() {
		return dentist;
	}

	public void setDentist(Dentist dentist) {
		this.dentist = dentist;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<AppointmentItem> getItems() {
		return items;
	}

	public void setItems(List<AppointmentItem> items) {
		this.items = items;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", dentist=" + dentist + ", patient="
				+ patient + ", items=" + items + "]";
	}

	public void addItem(AppointmentItem item) {
		item.setAppointment(this);
		this.items.add(item);
	}
	
	public static Map<Date,Appointment> indexAppointmentsByCreatedDate 
									( List<Appointment> appointments )  {
		Map<Date,Appointment> indexedAppointments = new HashMap<Date,Appointment>();
		for (Appointment appointment : appointments) {
			indexedAppointments.put (appointment.getCreated() , appointment	);
		}
		return indexedAppointments;
	}
	

}
