package com.yimai.entity;

public class User {
	private String eu_user_id;
	private String eu_user_name;
	private String eu_password;
	private String eu_sex;
	private String eu_birthday;
	private String eu_identity_code;
	private String eu_email;
	private String eu_mobile;
	private String eu_address;
	private int eu_status;
	public String getEu_user_id() {
		return eu_user_id;
	}
	public void setEu_user_id(String euUserId) {
		eu_user_id = euUserId;
	}
	public String getEu_user_name() {
		return eu_user_name;
	}
	public void setEu_user_name(String euUserName) {
		eu_user_name = euUserName;
	}
	public String getEu_password() {
		return eu_password;
	}
	public void setEu_password(String euPassword) {
		eu_password = euPassword;
	}
	public String getEu_sex() {
		return eu_sex;
	}
	public void setEu_sex(String euSex) {
		eu_sex = euSex;
	}
	public String getEu_birthday() {
		return eu_birthday;
	}
	public void setEu_birthday(String euBirthday) {
		eu_birthday = euBirthday;
	}
	public String getEu_identity_code() {
		return eu_identity_code;
	}
	public void setEu_identity_code(String euIdentityCode) {
		eu_identity_code = euIdentityCode;
	}
	public String getEu_email() {
		return eu_email;
	}
	public void setEu_email(String euEmail) {
		eu_email = euEmail;
	}
	public String getEu_mobile() {
		return eu_mobile;
	}
	public void setEu_mobile(String euMobile) {
		eu_mobile = euMobile;
	}
	public String getEu_address() {
		return eu_address;
	}
	public void setEu_address(String euAddress) {
		eu_address = euAddress;
	}
	public int getEu_status() {
		return eu_status;
	}
	public void setEu_status(int euStatus) {
		eu_status = euStatus;
	}

	public User(String euuserid, String euusername, String eupassword, String eusex, String eubirthday,
			    String euidentitycode, String euemail, String eumobile, String euaddress, int eustatus){
		super();
		eu_user_id = euuserid;
		eu_user_name = euusername;
		eu_password = eupassword;
		eu_sex = eusex;
		eu_birthday = eubirthday;
		eu_identity_code = euidentitycode;
		eu_email = euemail;
		eu_mobile = eumobile;
		eu_address = euaddress;
		eu_status =eustatus;
	}
	public User() {
		super();
	}
}
