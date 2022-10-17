package com.harman.dao;

import java.util.List;
import com.harman.exception.PersonException;
import com.harman.model.Person;

public interface PersonDAO {
	Person add(Person detail) throws PersonException;
	void delete(Integer personId) throws PersonException;
	List<Person> list() throws PersonException;
	void save(Person detail) throws PersonException;
}
