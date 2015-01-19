package com.xcoc.billing;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BillingService {

	@Autowired
	private BillingRepository repository;
	
	public BillingService() {
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void create (Billing billing) {
		repository.create(billing);
	}
	
}
