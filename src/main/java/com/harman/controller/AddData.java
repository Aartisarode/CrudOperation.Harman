package com.harman.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harman.exception.PersonException;
import com.harman.model.Person;
import com.harman.services.CurdService;
import com.harman.services.CurdServiceImpl;

/**
 * Servlet implementation class AddData
 */
public class AddData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private static CurdService services;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 services = new CurdServiceImpl();
	    response.setContentType("text/html");
	    PrintWriter pt = response.getWriter();
		Person prs = new Person();
        prs.setName(request.getParameter("name"));
        prs.setEmail(request.getParameter("email"));
        prs.setLocation(request.getParameter("Location"));
        
        try {
            services.add(prs);
            pt.print("<h3>Record Saved Successfully");
            request.getRequestDispatcher("Add.html").include(request, response);
            
        }
        catch(PersonException excep )
        {
            System.err.println("Error"+ excep.getMessage());
        }
	}
	

}
