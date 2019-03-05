package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.EmployeeDAO;
import com.ts.dto.Employee;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out=response.getWriter();
	
		String empName = request.getParameter("EmployeeName");
		String empEmail = request.getParameter("EmployeeEmail");
		Long empPhone = Long.parseLong(request.getParameter("EmployeePhone"));
		String empUserName = request.getParameter("EmployeeUserName");
		String empPassword = request.getParameter("EmployeePassword");
		
		Employee employee = new Employee();
		employee.setEmpName(empName);
		employee.setEmpEmail(empEmail);
		employee.setEmpPhone(empPhone);
		employee.setEmpUserName(empUserName);
		employee.setEmpPassword(empPassword);
		
		System.out.println(employee);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		if(employeeDAO.add(employee) != 0) {
			response.getWriter().println("<h1>Registration Successful..</h1>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./adminHomePage.jsp");
			dispatcher.include(request, response);
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
