package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ts.dao.transactionDAO;
import com.ts.dto.Transaction;

/**
 * Servlet implementation class TransferServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter out=response.getWriter();
		System.out.println("Hello");
		Integer fromAccNo = Integer.parseInt(request.getParameter("fAccNo"));
		Integer toAccNo = Integer.parseInt(request.getParameter("tAccNo"));
		Integer tranAmount = Integer.parseInt(request.getParameter("amount"));
		String dateofTran = request.getParameter("date");
		String tranType = request.getParameter("tType");
		System.out.println("hey");
			
		Transaction transaction = new Transaction();
		transaction.setFromAccNo(fromAccNo);
		transaction.setToAccNo(toAccNo);
		transaction.setTranAmount(tranAmount);
		transaction.setDateofTran(dateofTran);
		transaction.setTranType(tranType);
		
		System.out.println(transaction);
		transactionDAO tranDAO = new transactionDAO();
		tranDAO.depositMoney(tranAmount, toAccNo);
		tranDAO.withdrawlMoney(tranAmount, fromAccNo);
		System.out.println("update");
		
		if(tranDAO.add(transaction) != 0) {
			response.getWriter().println("<h1>Transfer Money Update Successful..</h1>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("./employeeHomePanel.jsp");
			dispatcher.include(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
