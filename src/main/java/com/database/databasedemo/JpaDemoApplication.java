package com.database.databasedemo;

import com.database.databasedemo.JDBC.PersonJdbcDao;
import com.database.databasedemo.JPA.PersonJpaRepository;
import com.database.databasedemo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	PersonJpaRepository repository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users -> {}", repository.findAll());
		logger.info("User id 1001 -> {} ", repository.findById(1001));
		logger.info("Inserting -> {}", repository.insert(new Person("Riley", "Berlin", new Date())));
		logger.info("Updating 1003 -> {}", repository.update(new Person(1003, "Scrappy", "Dallas", new Date())));
		repository.deleteById(1002);
		logger.info("All Users -> {}", repository.findAll());
		/*
		logger.info("Name 'Maxine' -> {} ", dao.retrieveByName("Lambchop"));
		logger.info("Location NYC -> {} ", dao.retrieveByLocation("NYC"));
		logger.info("Deleting 1004 ->  # of Rows Deleted - {} ", dao.deleteById(1004));

		logger.info("All Users -> {} ", dao.retrieveAll());
		*/

	}
}
