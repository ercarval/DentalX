package com.xcoc.account;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

//@Embeddable
public class ContactEntry implements Serializable {

	
	private String name;
	private String phone;
	private String cell;
	private String email;
	
	
	
	
}
