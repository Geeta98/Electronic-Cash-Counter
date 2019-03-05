package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.CustomerDAO;
import com.ts.dao.transactionDAO;
import com.ts.dto.Customer;
import com.ts.dto.Transaction;

/**
 * Servlet implementation class ReportGenerationServlet
 */
@WebServlet("/ReportGenerationServlet")
public class ReportGenerationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out=response.getWriter();
		
		Integer fromAccNo = Integer.parseInt(request.getParameter("CustAccNo"));
		Integer toAccNo = Integer.parseInt(request.getParameter("CustAccNo"));
		System.out.println("from acc no:" +fromAccNo);
		System.out.println("to acc no:" +toAccNo);
		Transaction transaction = new Transaction();
		transaction.setFromAccNo(fromAccNo);
		transaction.setToAccNo(toAccNo);
		
		transactionDAO tranDAO = new transactionDAO();
		
		List<Transaction> transactionList=tranDAO.getAllTransactions(fromAccNo,toAccNo);
		System.out.println(transactionList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("reportGeneration.jsp");
		request.setAttribute("transactionList", transactionList);
		dispatcher.include(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
