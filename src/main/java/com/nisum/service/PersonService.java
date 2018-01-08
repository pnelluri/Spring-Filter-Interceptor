package com.nisum.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.nisum.model.Person;
@Repository
public class PersonService {

	private static Map<Integer, Person> personDB;

	@PostConstruct
	public void init() throws Exception {
		personDB = new HashMap<>();
		for (int i = 0; i < 100; i++) {
			Person person = new Person(i, "Prashant-" + i, System.currentTimeMillis());
			personDB.put(new Integer(i), person);
		}
	}

	public Person getPersonById(Integer id) {
		return personDB.get(id);
	}
}
