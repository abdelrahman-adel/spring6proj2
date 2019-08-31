package com.master.spring.spring6proj1.database.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.master.spring.spring6proj1.database.entities.Person;

/**
 * When you create an interface and inherit the <code>JpaRepository</code>, this
 * becomes interface of the predefined repository.
 * 
 * Here we extends a custom Repository. Spring injects the implementation of the
 * custom repository to the predefined repository, to get the logic of both.
 * 
 * @author Abd-Elrahman Adel
 *
 */
public interface PersonExplicitRepository extends JpaRepository<Person, Integer>, PersonExplicitRepositoryCustom {

}
