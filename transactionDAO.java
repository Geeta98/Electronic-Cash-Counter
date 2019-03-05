package com.ts.dao;
import com.ts.dto.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ts.dbutility.DBConnection;
import com.ts.dto.Transaction;

public class transactionDAO {
	public int add(Transaction transaction){
		final String INSERT_QUERY="insert into transaction(tranId,fromAccNo,toAccNo,tranAmount,dateofTran,tranType) values(?,?,?,?,?,?)";
		PreparedStatement pst = null;
		
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setInt(1, transaction.getTranId());
			pst.setInt(2, transaction.getFromAccNo());
			pst.setInt(3, transaction.getToAccNo());
			pst.setInt(4, transaction.getTranAmount());
			pst.setString(5, transaction.getDateofTran());
			pst.setString(6, transaction.getTranType());
			//System.out.println(pst);
			status=pst.executeUpdate();
			//System.out.println(status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(status);
		return status;
	}
	public int depositMoney(int tranAmount,int toAccNo ) {
		final String UPDATE_QUERY = "update customer set custBal = custBal + ? where custAccNo = ?";
		PreparedStatement pst = null;
		int status = 0;
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(UPDATE_QUERY);
			pst.setInt(2, toAccNo);
			pst.setInt(1, tranAmount);
			status=pst.executeUpdate();
			//System.out.println(status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(status);
		return status;
	}
	public int withdrawlMoney(int tranAmount,int toAccNo ) {
		final String UPDATE_QUERY = "update customer set custBal = custBal - ? where custAccNo = ?";
		PreparedStatement pst = null;
		int status = 0;
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(UPDATE_QUERY);
			pst.setInt(2, toAccNo);
			pst.setInt(1, tranAmount);
			status=pst.executeUpdate();
			//System.out.println(status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(status);
		return status;
	}
	public List<Transaction> getAllTransactions(int fromAccNo, int toAccNo ) {
		final String SELECT_QUERY = "select * from transaction where fromAccNo = ? OR toAccNo = ?";
		PreparedStatement pst = null;
		List<Transaction> transactionList=new ArrayList<>();
		ResultSet rst = null;
		try(Connection con=DBConnection.getConnection();) {
			pst=con.prepareStatement(SELECT_QUERY);
			pst.setInt(1, fromAccNo);
			pst.setInt(2, toAccNo);
			rst=pst.executeQuery();
			while(rst.next()){
				Transaction transaction=new Transaction();
				transaction.setTranId(rst.getInt(1));
				transaction.setFromAccNo(rst.getInt(2));
				transaction.setToAccNo(rst.getInt(3));
				transaction.setTranAmount(rst.getInt(4));
				transaction.setDateofTran(rst.getString(5));
				transaction.setTranType(rst.getString(6));
				transactionList.add(transaction);
				System.out.println(transaction);
			}
			//System.out.println(status);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactionList;
	}
}
