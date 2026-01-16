package com.kozmoz.Kozmoz_CH61_equipo_2_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Libro {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBook")
	private Long id;
	
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "imagen", nullable = false)
	private String imagen;
	
	@Column(name = "precio", nullable = false)
	private Double precio;
	
	@Column(name = "total", nullable = false)
	private static long total;
	
	public Libro(String nombre, String descripcion, String imagen, Double precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		Libro.total++;
		this.id=Libro.total;
		
	}// constructor Libro
	
	public Libro() {
		Libro.total++;
		this.id=Libro.total;	
	} //Constructor vacio

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
