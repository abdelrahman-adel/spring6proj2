package com.master.spring.spring6proj2.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import com.master.spring.spring6proj2.database.entities.Person;
import com.master.spring.spring6proj2.database.springdata.PersonRepository;

/**
 * We need <code>@EntityScan</code> to give it the package where it should scan
 * for entites.
 * 
 * We need <code>@EnableJpaRepositories</code> to give it the package where it
 * should scan for predefined entities.
 * 
 * @author Abd-Elrahman Adel
 *
 */
//@EntityScan(basePackages = "com.master.spring.spring6proj1.database.entities")
//@EnableJpaRepositories(basePackages = "com.master.spring.spring6proj1")
//@SpringBootApplication(scanBasePackages = "com.master.spring.spring6proj1")
public class SpringDataApp implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Person> persons = personRepository.findAll();
		for (Person person : persons) {
			logger.info("personRepository.findAll() -> {}", person);
		}

		logger.info("personRepository.findById(100001) -> {}", personRepository.findById(100001));
//		logger.info("personRepository.findByName(Lotfi) -> {}", personRepository.findByName("Lotfi"));
//		logger.info("personRepository.findByLocation(UK) -> {}", personRepository.findByLocation("UK"));
		personRepository.deleteById(100002);
		logger.info("personRepository.deleteById(100002), deleted 100002");

		persons = personRepository.findAll();
		for (Person person : persons) {
			logger.info("personRepository.findAll() -> {}", person);
		}

		Person nour = new Person("Nour", "UAE", new GregorianCalendar(2005, Calendar.JUNE, 17).getTime());
		logger.info("personRepository.insert(), row inserted: {}", personRepository.save(nour));

		Optional<Person> abdo = personRepository.findById(100001);
		abdo.get().setLocation("UAE");
		logger.info("personRepository.update(), row updated: {}", personRepository.save(abdo.get()));

		persons = personRepository.findAll();
		for (Person person : persons) {
			logger.info("personRepository.findAll() -> {}", person);
		}

	}

}
