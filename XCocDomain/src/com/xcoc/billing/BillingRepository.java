package com.xcoc.billing;

import org.springframework.stereotype.Repository;

import com.xcoc.shared.repository.BaseRepository;


@Repository
public class BillingRepository 
		extends BaseRepository<Billing, Long> {

	
	public BillingRepository() {
	}
	
	@Override
	public void setClass() {
		clazz = Billing.class;
	}
	
		
	
	
}
