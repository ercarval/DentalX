package com.xcoc.appointment;

import org.springframework.stereotype.Repository;

import com.xcoc.shared.repository.BaseRepository;

@Repository
public class AppointmentItemRepository 
	extends BaseRepository<AppointmentItem,Long> {

	public AppointmentItemRepository() {
	}
	
	@Override
	public void setClass() {
		clazz = AppointmentItem.class;
	}
	
}
