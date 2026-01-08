package com.kozmoz.Kozmoz_CH61_equipo_2_backend.model;

public class Usuario {
	
	private Long id;
	private String nombre;
	private String email;
	private String password;
//	private static Long total = Long.valueOf(0);
	
	public Usuario(String nombre, String email, String password) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
//		Usuario.total++;
//		this.id = Usuario.total;
	}//constructor Usuario

	public Usuario() {
//		Usuario.total++;
//		this.id = Usuario.total;
	}//constructor Usuario vacío

	public Long getId() {
		return id;
	}// getId

	public void setId(Long id) {
		this.id = id;
	}//setId

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getEmail() {
		return email;
	}// getEmail

	public void setEmail(String email) {
		this.email = email;
	}//setemail

	public String getPassword() {
		return password;
	}//getPassword

	public void setPassword(String password) {
		this.password = password;
	}//setPassword

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + "]";
	}//toString
	
}//class Usuario
