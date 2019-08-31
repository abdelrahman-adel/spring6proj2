package com.master.spring.spring6proj2.database.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * <code>@Entitiy</code> already maps the annotated class to a corresponding
 * table name, so there is no need to write <code>@Table(name = "person")</code>
 * 
 * @author aadel
 *
 */
@Entity
@NamedQueries(value = { @NamedQuery(name = "findAll", query = "select p from Person p"),
		@NamedQuery(name = "findByName", query = "select p from Person p where name=:name"),
		@NamedQuery(name = "findByLocation", query = "select p from Person p where location=:location"),
		@NamedQuery(name = "findByBirthDate", query = "select p from Person p where birthDate=:birthDate"),
		@NamedQuery(name = "findByNameAndLocation", query = "select p from Person p where name=:name and location=:location") })
public class Person {

	/**
	 * Here also JPA by default maps the fields to their column names. There is no
	 * need to write <code>@Column</code>
	 */
	@Column(nullable = false)
	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false)
	private String name;

	private String location;
	private Date birthDate;

	public Person() {
		super();
	}

	public Person(String name, String location, Date birthDate) {
		this();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public Person(int id, String name, String location, Date birthDate) {
		this(name, location, birthDate);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}

}
