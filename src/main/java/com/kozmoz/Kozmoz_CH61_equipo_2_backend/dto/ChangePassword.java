package com.kozmoz.Kozmoz_CH61_equipo_2_backend.dto;

public class ChangePassword {
	private String password;
	private String nPassword;
	public ChangePassword(String password, String nPassword) {
		super();
		this.password = password;
		this.nPassword = nPassword;
	}//constructor ChangePassword
	
	public ChangePassword() {}//constructor ChangePassword vacío

	public String getPassword() {
		return password;
	}//getPassword

	public void setPassword(String password) {
		this.password = password;
	}//setPassword

	public String getNPassword() {
		return nPassword;
	}//getnPassword

	public void setNPassword(String nPassword) {
		this.nPassword = nPassword;
	}//setnPassword

	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", nPassword=" + nPassword + "]";
	}//toString
	
}//class ChangePassword
