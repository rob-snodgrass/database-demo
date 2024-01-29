package com.database.databasedemo;

import com.database.databasedemo.JDBC.PersonJdbcDao;
import com.database.databasedemo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	//@Autowired
	PersonJdbcDao dao;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users -> {} ", dao.retrieveAll());
		logger.info("User id 1001 -> {} ", dao.retrieveById(1001));
		logger.info("Name 'Maxine' -> {} ", dao.retrieveByName("Lambchop"));
		logger.info("Location NYC -> {} ", dao.retrieveByLocation("NYC"));
		logger.info("Deleting 1004 ->  # of Rows Deleted - {} ", dao.deleteById(1004));
		logger.info("Inserting 1005 -> {}",dao.insertPerson(new Person(1005, "Riley", "Berlin", new Date())));
		logger.info("Updating 1003 -> {}",dao.updatePerson(new Person(1003, "Scrappy", "Dallas", new Date())));

	}


}
