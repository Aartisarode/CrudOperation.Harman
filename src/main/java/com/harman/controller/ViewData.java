package com.harman.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.harman.model.Person;
import com.harman.services.CurdService;
import com.harman.services.CurdServiceImpl;

/**
 * Servlet implementation class ViewData
 */
public class ViewData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CurdService services;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * 
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		services = new CurdServiceImpl();
		response.setContentType("text/html");
		
		PrintWriter pt = response.getWriter();
		pt.print("<html><head><style>\r\n"
                + "        body\r\n"
                + "        {\r\n"
                + "            counter-reset: Serial;          \r\n"
                + "        }"
                + "        tr td:first-child:before\r\n"
                + "        {\r\n"
                + "          counter-increment: Serial;      \r\n"
                + "          content: counter(Serial); \r\n"
                + "        }"
                + "table {\r\n"
                + "  font-family: times new roman, sans-serif;\r\n"
                + "  border-collapse: collapse;\r\n"
                + "  width: 100%;\r\n"
                + "}\r\n"
                + "\r\n"
                + "td, th {\r\n"
                + "  border: 1px solid #dddddd;\r\n"
                + "  text-align: left;\r\n"
                + "  padding: 8px;\r\n"
                + "}</style></head></html>");
		pt.print("<table> <tr> \r\n"
				+ " 	<th>Sr.No</th> \r\n"
				+ "     <th>Name</th> \r\n"
				+ " 	<th>Email</th> \r\n"
				+ " 	<th>Location</th> \r\n"
				+ "  	<th>Delete</th> \r\n"
				+ "  	<th>Update</th> \r\n"
				+ "  </tr>");
		try {
            List<Person> detail = services.ShowList();
            if((detail==null) || detail.isEmpty())
            {
                System.out.println("NO List Found");
            }
            else
            {
                for(Person dt: detail)
                {
                    pt.print("  <tr>\r\n"
                            + "    <td></td>\r\n"
                            + "    <td>"+dt.getName()+"</td>\r\n"
                            + "    <td>"+dt.getEmail()+"</td>\r\n"
                            + "    <td>"+dt.getLocation()+"</td>\r\n"
                            + "    <td><a href= 'Delete?id="+dt.getId()+"'>Delete</a></td>\r\n"
                            + "    <td><a href= 'Update.jsp?id="+dt.getId()+"'>Update</a></td>\r\n"
                            + "  </tr>");
                }
            }
        }catch(Exception excep)
        {
            System.out.println(excep);
        }
	    pt.print("</table>");
	}
}