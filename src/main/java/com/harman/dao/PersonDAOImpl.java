package com.harman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.harman.exception.PersonException;
import com.harman.model.Person;

public class PersonDAOImpl {
	private static Connection con = null;
	private static PreparedStatement pst;
	private static final String INS_QRY = "INSERT INTO PERSON(NAME, EMAIL, LOCATION) VALUES (?, ?,?)";
	private static final String DELETE_QRY = "DELETE FROM PERSON WHERE ID=?";
	private static final String SELECT_QRY = "SELECT * FROM PERSON";
	private static final String UPDATE_QRY = "UPDATE PERSON SET NAME= ?, EMAIL=?, LOCATION=? WHERE ID = ?";
	public Person add(Person detail) throws PersonException {

		if(detail != null)
		{
			try
			{
				con = ConnectionProvider.getConnection();
				pst = con.prepareStatement(INS_QRY);
				pst.setString(1, detail.getName());
				pst.setString(2, detail.getEmail());
				pst.setString(3, detail.getLocation());
				pst.executeUpdate();
				System.out.println("Successfully Added");
				con.close();
			}catch(Exception excep)
			{
				System.out.println(excep);
			}
		}
		return detail;
	}

	public void delete(Integer personId) throws PersonException {
		con = ConnectionProvider.getConnection();
		try {
			pst = con.prepareStatement(DELETE_QRY);
			pst.setInt(1, personId);
			pst.executeUpdate();
			con.close();
			System.out.println("Deleted Succesfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Person> list() throws PersonException {

		List<Person> detailList = new ArrayList<Person>();
		con = ConnectionProvider.getConnection();
		  try {
	            pst = con.prepareStatement(SELECT_QRY);
	            ResultSet rs = pst.executeQuery();
	            Person detail = null;
	            
	            while(rs.next())
	            {
	                detail = new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	                detailList.add(detail);
	            }
	            con.close();
	        }catch(SQLException excep)
	        {
	            System.out.println(excep);
	        }
	        return detailList;
	}

	public void save(Person detail) throws PersonException {

		con = ConnectionProvider.getConnection();
		try {
			pst = con.prepareStatement(UPDATE_QRY);
			pst.setString(1, detail.getName());
			pst.setString(2, detail.getEmail());
			pst.setString(3, detail.getLocation());
			pst.setInt(4, detail.getId());
			
			pst.executeUpdate();
			System.out.println("Succesfully Updated");
			con.close();
		}catch(Exception excep)
		{
			System.out.println(excep);
		}
	}
}
