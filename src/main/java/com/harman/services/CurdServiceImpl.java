package com.harman.services;

import java.util.List;
import com.harman.dao.PersonDAOImpl;
import com.harman.exception.PersonException;
import com.harman.model.Person;

public class CurdServiceImpl implements CurdService{
	PersonDAOImpl personDao;
	
	public CurdServiceImpl()
	{
		personDao = new PersonDAOImpl();
	}
	

	public Person add(Person detail) throws PersonException {
		// TODO Auto-generated method stub
		personDao.add(detail);
		
		return detail;
	}

	public void remove(Integer personId) throws PersonException {
		personDao.delete(personId);
	}


	public List<Person> ShowList() throws PersonException {

		return personDao.list();
		
	}


	public void update(Person detail) throws PersonException {

		personDao.save(detail);
	}


}
