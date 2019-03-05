package com.ts.dto;

public class Chequebook {
	private int cbNo;
	private int custAccNo;
	private String issueDate;
	
	public int getCbNo() {
		return cbNo;
	}
	public void setCbNo(int cbNo) {
		this.cbNo = cbNo;
	}
	public int getCustomerAccNo() {
		return custAccNo;
	}
	public void setCustomerAccNo(int custAccNo) {
		this.custAccNo = custAccNo;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	@Override
	public String toString() {
		return "Chequebook [CbNo=" + cbNo + ", CustomerAccNo=" + custAccNo + ", IssueDate="+issueDate+ "]";
	}

}
