package com.xcoc.account;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Contact implements Serializable {

	@Id
	@GeneratedValue ( strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	private Patient patient;
	
	
	
	
}
