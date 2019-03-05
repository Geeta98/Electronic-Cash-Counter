package com.ts.dto;

import java.util.Date;

public class Transaction {
	private int tranId;
	private int fromAccNo;
	private int toAccNo;
	private int tranAmount;
	private String dateofTran;
	private String tranType;
	
	public int getTranId() {
		return tranId;
	}
	public void setTranId(int tranId) {
		this.tranId = tranId;
	}
	public int getFromAccNo() {
		return fromAccNo;
	}
	public void setFromAccNo(int fromAccNo) {
		this.fromAccNo = fromAccNo;
	}
	public int getToAccNo() {
		return toAccNo;
	}
	public void setToAccNo(int toAccNo) {
		this.toAccNo = toAccNo;
	}
	public int getTranAmount() {
		return tranAmount;
	}
	public void setTranAmount(int tranAmount) {
		this.tranAmount = tranAmount;
	}
	public String getDateofTran() {
		return dateofTran;
	}
	public void setDateofTran(String dateofTran) {
		this.dateofTran = dateofTran;
	}
	public String getTranType() {
		return tranType;
	}
	public void setTranType(String tranType) {
		this.tranType = tranType;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + tranId + ", fromAccountNo=" + fromAccNo + ", toAccountNo="+toAccNo+", transactionAmount=" + tranAmount
				+ ",  transactionDate=" + dateofTran + ", transactionType=" + tranType + "]";
	}

}
