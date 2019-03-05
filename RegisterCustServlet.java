package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.CustomerDAO;
import com.ts.dao.EmployeeDAO;
import com.ts.dto.Customer;
import com.ts.dto.Employee;

/**
 * Servlet implementation class RegisterCustServlet
 */
@WebServlet("/RegisterCustServlet")
public class RegisterCustServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out=response.getWriter();
	
		String custName = request.getParameter("CustomerName");
		String custEmail = request.getParameter("CustomerEmail");
		Long custPhone = Long.parseLong(request.getParameter("CustomerPhone"));
		String custUserName = request.getParameter("CustomerUserName");
		String custPassword = request.getParameter("CustomerPassword");
		int custAccNo = Integer.parseInt(request.getParameter("CustomerAccountNo"));
		int custBal = Integer.parseInt(request.getParameter("CustomerBalance"));
		
		Customer customer = new Customer();
		customer.setCustomerName(custName);
		customer.setEmail(custEmail);
		customer.setPhone(custPhone);
		customer.setUserName(custUserName);
		customer.setPassword(custPassword);
		customer.setCustomerAccNo(custAccNo);
		customer.setCustomerBalance(custBal);
		
		System.out.println(customer);
		CustomerDAO customerDAO = new CustomerDAO();
		if(customerDAO.add(customer) != 0) {
			response.getWriter().println("<h1>Registration Successful..</h1>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./employeeHomePanel.jsp");
			dispatcher.include(request, response);
		}
		
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
