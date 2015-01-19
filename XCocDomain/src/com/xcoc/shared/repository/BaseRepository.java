package com.xcoc.shared.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

public abstract
	class BaseRepository
		<Entity extends Serializable
		, Id extends Serializable> {
	
	protected Class<Entity> clazz; 
	
	@PersistenceContext
	protected EntityManager em;

	public BaseRepository() {
		setClass();
	}
	
	public abstract void setClass();
	
	@Transactional
	public void create(Entity entity) {
		em.persist(entity);
	}
	
	@Transactional
	public void update (Entity entity) {
		em.merge(entity);
	}
	
	@Transactional
	public Entity findByPk (Long id) {
		return em.find(clazz, id);
	}
	
	@Transactional(readOnly=true)
	public List<Entity> listAll () {
								  //select * from <nome da tabela> 	
		TypedQuery<Entity> query =  
				   em.createQuery("select o from " + clazz.getName() + " o" , clazz  );
		return query.getResultList();
	}
	
	//create
	
	//read
	//update
	//delete
	
}
