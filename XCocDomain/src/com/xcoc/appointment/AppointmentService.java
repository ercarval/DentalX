package com.xcoc.appointment;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xcoc.billing.Billing;
import com.xcoc.billing.BillingService;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository repository;

	@Autowired
	private AppointmentItemRepository repositoryItem;

	@Autowired
	private BillingService billingService;
	
	public AppointmentService() {
		System.out.println("AppointmentService Created");
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void create(Appointment appointment) {
		repository.create(appointment);
		double total = 0;
		for (AppointmentItem item : appointment.getItems()) {
			repositoryItem.create(item);
			total += item.getAmmount();
		}
		
		Billing billing = new Billing(); 
		billing.setCreated(new Date());
		billing.setValue(total);
	
		billingService.create(billing);
	}
	
	
	public AppointmentRepository getAll() {
		return this.repository;
	}
	
}
