package com.springbootlearn.springJDBCdatabasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springbootlearn.databasedemo.entity.Person;
import com.springbootlearn.databasedemo.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class springJDBCDemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(springJDBCDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.FindAll());
		logger.info("User 10002 -> {}", dao.FindByID(10002));
		logger.info("User deleted 10001 -> # of rows affected -> {}", dao.deleteByID(10001));
		logger.info("Inserting user 10004 -> {}", dao.insert(new Person(10004, "Hari", "Amsterdam", new Date())));
		//logger.info("Update user 10002 -> {}", dao.update(new Person(10002, "SHRUTI", "Bangalore", new Date())));
	}		

}
