package com.master.spring.spring6proj2.database.springdata;

import java.util.Date;
import java.util.List;

import com.master.spring.spring6proj2.database.entities.Person;

/**
 * This is a custom repository to be extended by the predefined repository, to
 * add extra operations to it.
 * 
 * @author Abd-Elrahman Adel
 *
 */
public interface PersonExplicitRepositoryCustom {

	List<Person> findByName(String name);

	List<Person> findByLocation(String location);

	List<Person> findByBirthDate(Date birthDate);

	List<Person> findByNameAndLocation(String name, String location);
}
