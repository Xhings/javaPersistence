package com.springbootlearn.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springbootlearn.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJPARepository {
	
	@PersistenceContext	
	EntityManager entityManager;
	
	public Person FindByID(int id) {
		return entityManager.find(Person.class, id); 
	}

}
