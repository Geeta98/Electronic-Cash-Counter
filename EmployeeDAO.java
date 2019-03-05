package com.ts.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import com.ts.dbutility.DBConnection;
import com.ts.dto.Employee;

public class EmployeeDAO {
	public int add(Employee employee){
		final String INSERT_QUERY="insert into employee(empName,empEmail,empPhone,empUserName,empPassword) values(?,?,?,?,?)";
		PreparedStatement pst = null;
		
		int status=0;
		
		try(Connection con=DBConnection.getConnection();) {
			
			pst=con.prepareStatement(INSERT_QUERY);
			pst.setString(1, employee.getEmpName());
			pst.setString(2, employee.getEmpEmail());
			pst.setLong(3, employee.getEmpPhone());
			pst.setString(4, employee.getEmpUserName());
			pst.setString(5, employee.getEmpPassword());
			
			status=pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(status);
		return status;
	}
public Employee getEmployeeLogin(String empUserName,String empPassword){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Employee employee=null;
	final String SELECT_QUERY = "select * from employee where empUserName = ? and empPassword = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, empUserName);
		pst.setString(2, empPassword);
		rst = pst.executeQuery();
		//System.out.println(pst);
		if(rst.next()){
			employee=new Employee();
			employee.setEmpId(rst.getInt(1));
			employee.setEmpName(rst.getString(2));
			employee.setEmpEmail(rst.getString(3));
			employee.setEmpPhone(rst.getLong(4));		 
			employee.setEmpUserName(rst.getString(5));
			employee.setEmpPassword(rst.getString(6));
			
		System.out.println(employee);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return employee;
	}

}
