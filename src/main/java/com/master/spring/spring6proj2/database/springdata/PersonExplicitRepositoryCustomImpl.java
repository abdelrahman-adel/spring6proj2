package com.master.spring.spring6proj1.database.springdata;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.spring.spring6proj1.database.entities.Person;

/**
 * This is the implementation of the custom repository, it adds the
 * implementation to it's extra features.
 * 
 * @author Abd-Elrahman Adel
 *
 */
@Repository
@Transactional
public class PersonExplicitRepositoryCustomImpl implements PersonExplicitRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Person> findByName(String name) {
		TypedQuery<Person> findByName = entityManager.createNamedQuery("findByName", Person.class);
		findByName.setParameter("name", name);
		return findByName.getResultList();
	}

	@Override
	public List<Person> findByLocation(String location) {
		TypedQuery<Person> findByLocation = entityManager.createNamedQuery("findByLocation", Person.class);
		findByLocation.setParameter("location", location);
		return findByLocation.getResultList();
	}

	@Override
	public List<Person> findByBirthDate(Date birthDate) {
		TypedQuery<Person> findByBirthDate = entityManager.createNamedQuery("findByBirthDate", Person.class);
		findByBirthDate.setParameter("birthDate", birthDate);
		return findByBirthDate.getResultList();
	}

	@Override
	public List<Person> findByNameAndLocation(String name, String location) {
		TypedQuery<Person> findByNameAndLocation = entityManager.createNamedQuery("findByNameAndLocation",
				Person.class);
		findByNameAndLocation.setParameter("name", name);
		findByNameAndLocation.setParameter("location", location);
		return findByNameAndLocation.getResultList();
	}

}
