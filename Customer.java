package com.ts.dto;

public class Customer {
	private int custId;
	private String custName;
	private String custEmail;
	private long custPhone;
	private String custUserName;
	private String custPassword;
	private int custAccNo;
	private int custBal;
	
	public int getcustomerId() {
		return custId;
	}
	public void setcustomerId(int custId) {
		this.custId = custId;
	}
	public String getcustomerName() {
		return custName;
	}
	public void setCustomerName(String custName) {
		this.custName = custName;
	}
	public String getEmail() {
		return custEmail;
	}
	public void setEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public long getPhone() {
		return custPhone;
	}
	public void setPhone(long custPhone) {
		this.custPhone = custPhone;
	}
	public String getUserName() {
		return custUserName;
	}
	public void setUserName(String custUserName) {
		this.custUserName = custUserName;
	}
	public String getPassword() {
		return custPassword;
	}
	public void setPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public int getCustomerAccNo() {
		return custAccNo;
	}	
	public void setCustomerAccNo(int custAccNo) {
		this.custAccNo = custAccNo;
	}
	public int getCustomerBalance() {
		return custBal;
	}	
	public void setCustomerBalance(int custBal) {
		this.custBal = custBal;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + custId + ", customerName=" + custName + ", Email="+custEmail+",+Phone=" + custPhone
				+ ",  userName=" + custUserName + ", password=" + custPassword + " customerAccNo=" + custAccNo +", customerBalance=" + custBal + "]";
	}

}
