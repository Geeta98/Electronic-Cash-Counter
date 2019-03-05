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
import com.ts.dto.Customer;

/**
 * Servlet implementation class IssueCBServlet
 */
@WebServlet("/IssueCBServlet")
public class IssueCBServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out=response.getWriter();
		Integer custAccNo = Integer.parseInt(request.getParameter("CustAccNo"));
		
		Customer cust = new Customer();
		cust.setCustomerAccNo(custAccNo);
		CustomerDAO custDAO = new CustomerDAO();
		custDAO.getCustomer(custAccNo);
		
		if(custDAO.getCustomer(custAccNo) != null) {
			response.getWriter().println("<h1>Issue of Chequebook Successful..</h1>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./employeeHomePanel.jsp");
			dispatcher.include(request, response);
		}
		else {
			response.getWriter().println("<h1>Invalid Account..Chequebook not issued</h1>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./employeeHomePanel.jsp");
			dispatcher.include(request, response);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
