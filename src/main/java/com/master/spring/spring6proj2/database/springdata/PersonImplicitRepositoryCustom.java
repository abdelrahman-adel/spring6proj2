package com.master.spring.spring6proj1.database.springdata;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.spring.spring6proj1.database.entities.Person;

/**
 * When you create an interface and inherit the <code>JpaRepository</code>, this
 * becomes interface of the predefined repository.
 * 
 * You can customize and add your methods here and spring engine will guess and
 * generate the methods for you without implmenting them yourself, check below
 * methods as a reference.
 * 
 * @author Abd-Elrahman Adel
 *
 */
public interface PersonImplicitRepositoryCustom extends JpaRepository<Person, Integer> {

	Person findByName(String name);

	Person findByLocation(String location);

	Person findByBirthDate(Date birthDate);

	Person findByNameAndLocation(String name, String location);
}
