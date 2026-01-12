package com.kozmoz.Kozmoz_CH61_equipo_2_backend.dto;

public class ChangePassword {
	private String password;
	private String npassword;
	public ChangePassword(String password, String npassword) {
		super();
		this.password = password;
		this.npassword = npassword;
	}//constructor ChangePassword
	
	public ChangePassword() {}//constructor ChangePassword vacío

	public String getPassword() {
		return password;
	}//getPassword

	public void setPassword(String password) {
		this.password = password;
	}//setPassword

	public String getNpassword() {
		return npassword;
	}//getnPassword

	public void setNpassword(String nPassword) {
		this.npassword = nPassword;
	}//setnPassword

	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", nPassword=" + npassword + "]";
	}//toString
	
}//class ChangePassword
