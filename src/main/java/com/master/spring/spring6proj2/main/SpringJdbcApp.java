package com.master.spring.spring6proj1.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.master.spring.spring6proj1.database.entities.Person;
import com.master.spring.spring6proj1.database.jdbc.PersonJdbcDao;

//@SpringBootApplication(scanBasePackages = "com.master.spring.spring6proj1")
public class SpringJdbcApp implements CommandLineRunner {

	@Autowired
	PersonJdbcDao personDao;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> persons = personDao.findAll();
		for (Person person : persons) {
			logger.info("personDao.findAll() -> {}", person);
		}

		logger.info("personDao.findById(100001) -> {}", personDao.findById(100001));
		logger.info("personDao.findByName(Lotfi) -> {}", personDao.findByName("Lotfi"));
		logger.info("personDao.findByLocation(UK) -> {}", personDao.findByLocation("UK"));
		logger.info("personDao.deleteById(100002), rows deleted: {}", personDao.deleteById(100002));

		persons = personDao.findAll();
		for (Person person : persons) {
			logger.info("personDao.findAll() -> {}", person);
		}

		Person nour = new Person(100006, "Nour", "UAE", new GregorianCalendar(2005, Calendar.JUNE, 17).getTime());
		logger.info("personDao.insert(), rows affected: {}", personDao.insert(nour));

		Person abdo = personDao.findById(100001);
		abdo.setLocation("UAE");
		logger.info("personDao.update(), rows affected: {}", personDao.update(abdo));

		persons = personDao.findAll();
		for (Person person : persons) {
			logger.info("personDao.findAll() -> {}", person);
		}

	}

}
