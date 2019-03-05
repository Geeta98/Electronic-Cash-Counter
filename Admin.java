package com.ts.dto;

public class Admin {
	private int adId;
	private String adUserName;
	private String adPassword;
	
	public int getAdId() {
		return adId;
	}
	public void setAdId(int adId) {
		this.adId = adId;
	}
	public String getAdUserName() {
		return adUserName;
	}
	public void setAdUserName(String adUserName) {
		this.adUserName = adUserName;
	}
	public String getAdPassword() {
		return adPassword;
	}
	public void setAdPassword(String adPassword) {
		this.adPassword = adPassword;
	}
	public String toString() {
		return "Admin [AdminId=" + adId + ", AdminUserName=" + adUserName + ",AdminPassword=" + adPassword+"]";
	}
}
