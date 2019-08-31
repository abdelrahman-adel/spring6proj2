package com.master.spring.spring6proj2.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.master.spring.spring6proj2.database.entities.Person;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * We use <code>BeanPropertyRowMapper</code> to map the returned ResultSet to
	 * the bean class Person. We will create a custom row mapper at the end.
	 * 
	 * @return
	 */
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	/**
	 * Using the custom row mapper we created at the end of this file.
	 * 
	 * @param name
	 * @return
	 */
	public Object findByName(String name) {
		return jdbcTemplate.queryForObject("select * from person where name=?", new Object[] { name },
				new PersonRowMapper());
	}

	public Object findByLocation(String location) {
		return jdbcTemplate.queryForObject("select * from person where location=?", new Object[] { location },
				new PersonRowMapper());
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?", new Object[] { id });
	}

	public int insert(Person person) {
		return jdbcTemplate.update("insert into person (id, name, location, birth_date) values (?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(), person.getBirthDate() });
	}

	public int update(Person person) {
		return jdbcTemplate.update("update person set name=?, location=?, birth_date=? where id=?",
				new Object[] { person.getName(), person.getLocation(), person.getBirthDate(), person.getId() });
	}
}

class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setId(rs.getInt("id"));
		person.setName(rs.getString("name"));
		person.setLocation(rs.getString("location"));
		person.setBirthDate(rs.getDate("birth_date"));
		return person;
	}
}
