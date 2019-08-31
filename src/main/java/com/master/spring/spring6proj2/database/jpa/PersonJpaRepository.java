package com.master.spring.spring6proj2.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.master.spring.spring6proj2.database.entities.Person;

/**
 * <code>@Transactional</code> annotation manages transactions, if a transaction
 * failed within a set of transactions, all transactions roll back.
 * 
 * @author Abd-Elrahman Adel
 *
 */
@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * When there's no predefined query to do our logic, we create our own
	 * NamedQuery using JPQL. We use named queries using
	 * <code>entityManager.createNamedQuery(..)</code> and set our parameters, if
	 * any, using <code>TypedQuery.setParameter(..)</code> or
	 * <code>Query.setParameter(..)</code> according to your logic.
	 * 
	 * @return a list of <code>Person</code>
	 */
	public List<Person> findAll() {
		TypedQuery<Person> findAll = entityManager.createNamedQuery("findAll", Person.class);
		return findAll.getResultList();
	}

	/**
	 * <code>EntityManager.find(..)</code> finds a record given the primary key.
	 * 
	 * @param id
	 * @return
	 */
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}

	public List<Person> findByName(String name) {
		TypedQuery<Person> findByName = entityManager.createNamedQuery("findByName", Person.class);
		findByName.setParameter("name", name);
		return findByName.getResultList();
	}

	public List<Person> findByLocation(String location) {
		TypedQuery<Person> findByLocation = entityManager.createNamedQuery("findByLocation", Person.class);
		findByLocation.setParameter("location", location);
		return findByLocation.getResultList();
	}

	/**
	 * <code>EntityManager.remove(Object)</code> deletes the specified row when
	 * matches the given Object.
	 * 
	 * @param id
	 */
	public void deleteById(int id) {
		Person person = findById(id);
		if (null != person) {
			entityManager.remove(person);
		}
	}

	/**
	 * <code>EntityManager.merge(Object)</code> finds the given Object in the DB by
	 * primary key, if it doesn't exist, it inserts it, but if it does, it updates
	 * it with the given Object.
	 * 
	 * @param person
	 * @return
	 */
	public Person insert(Person person) {
		return entityManager.merge(person);
	}

	public Person update(Person person) {
		return entityManager.merge(person);
	}
}
