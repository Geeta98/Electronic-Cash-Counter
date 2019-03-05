package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.AdminDAO;
import com.ts.dao.EmployeeDAO;
import com.ts.dto.Admin;
import com.ts.dto.Customer;
import com.ts.dto.Employee;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Starting LoginServlet");
		String action = request.getParameter("action");
		PrintWriter out=response.getWriter();
		if(action.equalsIgnoreCase("eLogin")) {
			String empUserName=request.getParameter("ename");
			request.setAttribute("ename", empUserName);
			String empPassword=request.getParameter("epwd");
			request.setAttribute("epwd", empPassword);
			System.out.println("LoginServlet entered");
			//HttpSession session=request.getSession();
			//session.setAttribute("loggedUser", empUserName);
			//session.setAttribute("userPassword", empPassword);
			//response.setContentType("text/html");
			//System.out.println("hello");
		
			EmployeeDAO employeeDao = new EmployeeDAO();
			Employee employee=employeeDao.getEmployeeLogin(empUserName, empPassword);
			System.out.println("Inside servlet:"+employee);
			out.println("<html>");
			if(employee != null){
				RequestDispatcher dispatcher=request.getRequestDispatcher("employeeHomePanel.jsp");	
				dispatcher.forward(request, response);			
			}
			else{
				out.println("<body bgcolor=yellow text=red> Invalid credentials.!</body>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
				dispatcher.include(request, response);		
			}
			out.println("</html>");
		}
		
		if(action.equalsIgnoreCase("aLogin")) {
			String adUserName=request.getParameter("aname");
			request.setAttribute("aname", adUserName);
			String adPassword=request.getParameter("apwd");
			request.setAttribute("apwd", adPassword);
			response.setContentType("text/html");
		
			AdminDAO adminDao = new AdminDAO();
			Admin admin=adminDao.getAdminLogin(adUserName, adPassword);
			System.out.println("Inside servlet:"+admin);
			out.println("<html>");
			if(admin != null){
				RequestDispatcher dispatcher=request.getRequestDispatcher("adminHomePage.jsp");	
				dispatcher.forward(request, response);			
			}
			else{
				out.println("<body bgcolor=yellow text=red> Invalid credentials.!</body>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
				dispatcher.include(request, response);		
			}
			out.println("</html>");
		}
		
	}
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
