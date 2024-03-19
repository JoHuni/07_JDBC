package edu.kh.bbs.model.dto;


public class BBSUser {
	private String userId;
	private String userPw;
	private String userName;
	private String phoneNumber;
	private String gradeNo;
	
	public BBSUser(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}
	public BBSUser() {
		
	}

	public BBSUser(String userPw, String userName, String phoneNumber) {
		super();
		this.userPw = userPw;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
	}
	public BBSUser(String userId, String userPw, String userName, String phoneNumber) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.phoneNumber = phoneNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(String gradeNo) {
		this.gradeNo = gradeNo;
	}	
}
