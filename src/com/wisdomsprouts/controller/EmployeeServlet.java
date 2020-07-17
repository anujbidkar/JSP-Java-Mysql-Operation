package com.wisdomsprouts.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wisdomsprouts.dao.EmployeeDao;
import com.wisdomsprouts.model.Employee;


@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeDao employeeDao;

    public void init() {
        employeeDao = new EmployeeDao(); 
    }
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {

    	        String firstName = request.getParameter("firstName");
    	        String lastName = request.getParameter("lastName");
    	        String username = request.getParameter("username");
    	        String password = request.getParameter("password");
    	        String address = request.getParameter("address");
    	        String contact = request.getParameter("contact");

    	        Employee employee = new Employee();
    	        employee.setFirstName(firstName);
    	        employee.setLastName(lastName);
    	        employee.setUsername(username);
    	        employee.setPassword(password);
    	        employee.setContact(contact);
    	        employee.setAddress(address);

    	        try {
    	            employeeDao.registerEmployee(employee);
        	        response.sendRedirect("employeedetails.jsp");

    	        } catch (Exception e) {
    	            // TODO Auto-generated catch block
    	            e.printStackTrace();
    	        }

    	    }
	

}
