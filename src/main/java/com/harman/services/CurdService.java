package com.harman.services;

import java.util.List;
import com.harman.exception.PersonException;
import com.harman.model.Person;

public interface CurdService {
	Person add(Person detail) throws PersonException;
	void remove(Integer personId ) throws PersonException;
	List<Person> ShowList() throws PersonException;
	void update(Person detail) throws PersonException;
}