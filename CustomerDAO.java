package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ts.dbutility.DBConnection;
import com.ts.dto.Customer;

public class CustomerDAO {
	public int add(Customer customer){
		final String INSERT_QUERY="insert into customer(custName,custEmail,custPhone,custUserName,custPassword,custAccNo,custBal) values(?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, customer.getcustomerName());
			pst.setString(2, customer.getEmail());
			pst.setLong(3, customer.getPhone());
			pst.setString(4, customer.getUserName());
			pst.setString(5, customer.getPassword());
			pst.setInt(6, customer.getCustomerAccNo());
			pst.setInt(7, customer.getCustomerBalance());
			//System.out.println(pst);
			status=pst.executeUpdate();
			//System.out.println(status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(status);
		return status;
	}
	public Customer getCustomer(int custAccNo){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Customer customer=null;
	final String SELECT_QUERY = "select * from customer where custAccNo = ? ";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setInt(1, custAccNo);
		//pst.setString(2, custPassword);
		rst = pst.executeQuery();
		//System.out.println(pst);
		if(rst.next()){
			 customer=new Customer();
			 customer.setcustomerId(rst.getInt(1));
			 customer.setCustomerName(rst.getString(2));
			 customer.setEmail(rst.getString(3));
			 customer.setPhone(rst.getLong(4));		 
			 customer.setUserName(rst.getString(5));
			 customer.setPassword(rst.getString(6));
			 customer.setCustomerAccNo(rst.getInt(7));
			 customer.setCustomerBalance(rst.getInt(8));
			 
		//System.out.println(customer);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return customer;
	}
	public void depositBalance(Customer cust, int custAmount ) {
		int bal = cust.getCustomerBalance() + custAmount;
		PreparedStatement pst = null;
		int x = 0;
		final String UPDATE_QUERY = "update customer set custBal = ? where custUserName=?";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(UPDATE_QUERY);
			pst.setString(2,cust.getUserName());
			pst.setInt(1, bal);
			x = pst.executeUpdate();
			System.out.println(bal);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void withdrawlBalance(Customer cust, int custAmount ) {
		int bal = cust.getCustomerBalance() - custAmount;
		PreparedStatement pst = null;
		int x = 0;
		final String UPDATE_QUERY = "update customer set custBal = ? where custUserName=?";
		try(Connection con = DBConnection.getConnection();){
			pst = con.prepareStatement(UPDATE_QUERY);
			pst.setString(2,cust.getUserName());
			pst.setInt(1, bal);
			x = pst.executeUpdate();
			System.out.println(bal);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
