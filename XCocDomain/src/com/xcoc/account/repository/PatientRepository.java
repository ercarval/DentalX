package com.xcoc.account.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xcoc.account.Patient;

@Repository
@NamedQueries({
	@NamedQuery(name="findByName",query="select p from Patient p where p.name = :name")

})
public class PatientRepository {

	@PersistenceContext
	private EntityManager em;
	
	public PatientRepository() {
	}

	@Transactional
	public void create (Patient patient) {
		em.persist(patient);
	}
	
	public Patient findById ( Long id ) {
		return em.find(Patient.class, id);
	}
	
	public List<Patient> findByName (String name) {
		TypedQuery<Patient> query = em.createNamedQuery("findByName", Patient.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
	
	
	
	
}
