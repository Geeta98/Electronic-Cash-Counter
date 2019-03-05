package com.ts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ts.dbutility.DBConnection;
import com.ts.dto.Admin;

public class AdminDAO {
public Admin getAdminLogin(String adUserName,String adPassword){
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		Admin admin=null;
	final String SELECT_QUERY = "select * from admin where adUserName = ? and adPassword = ?";
	try(Connection con = DBConnection.getConnection();){
		
		pst = con.prepareStatement(SELECT_QUERY);
		pst.setString(1, adUserName);
		pst.setString(2, adPassword);
		rst = pst.executeQuery();
		//System.out.println(pst);
		if(rst.next()){
			admin=new Admin();
			admin.setAdId(rst.getInt(1));
			admin.setAdUserName(rst.getString(2));
			admin.setAdPassword(rst.getString(3));
			
		System.out.println(admin);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return admin;
	}

}
