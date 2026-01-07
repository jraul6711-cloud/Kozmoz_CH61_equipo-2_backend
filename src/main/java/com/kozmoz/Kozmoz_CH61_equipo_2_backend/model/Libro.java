package com.kozmoz.Kozmoz_CH61_equipo_2_backend.model;

public class Libro {
	private Long id;
	private String nombre;
	private String descripcion;
	private String imagen;
	private Double precio;
	
	public Libro(String nombre, String descripcion, String imagen, Double precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
	}// constructor Libro
	
	public Libro() {} //Constructor vacio

	public String getNombre() {
		return nombre;
	}// getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}// setNombre

	public String getDescripcion() {
		return descripcion;
	}//getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion

	public String getImagen() {
		return imagen;
	}//getImagen

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}//setImagen

	public Double getPrecio() {
		return precio;
	}//getPrecio

	public void setPrecio(Double precio) {
		this.precio = precio;
	}//setPrecio

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", precio=" + precio + "]";
	}//toString
	

}// Class Libro 
