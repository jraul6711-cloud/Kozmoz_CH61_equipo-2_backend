package com.kozmoz.Kozmoz_CH61_equipo_2_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Libro;

@Service
public class LibroService {
	private final List<Libro> lista = new ArrayList<Libro>();
			public LibroService () {
				lista.add(new Libro("nombre: Clean Code", "descripcion: Manual de manual de estilo para el desarrollo de software", "imagen.jpg", 850.00));
				lista.add(new Libro("nombre: El Hobbit", "descripcion: Una aventura épica en la Tierra Media", "imagenjpg", 420.00));	
			}//constructor 

			public List<Libro> getBook() {
				return lista;
			}//getBook

			public Libro getBooks(long id) {
				Libro tmp=null;
				for (Libro libro : lista) {
					if(libro.getId()==id) {
						tmp=libro;
						break;
					}//if
				}//foreach
				return tmp;
			}//getBooks

			public Libro addBook(Libro libro) {
				lista.add(libro);
				return libro;
			}//addBook

			public Libro deleteBook(long id) {
				Libro tmp=null;
				for (Libro libro : lista) {
					if(libro.getId()==id) {
						tmp=libro;
						lista.remove(libro);
						break;
					}//if
				}//foreach
				return tmp;
			}//deleteBook

			public Libro updateBook(long id, String nombre, String descripcion,
					String imagen, Double precio) {
				Libro tmp=null;
				for (Libro libro : lista) {
					if(libro.getId()==id) {
						tmp=libro;
						if(nombre!=null) libro.setNombre(nombre);
						if(descripcion!=null) libro.setDescripcion(descripcion);
						if(imagen!=null) libro.setImagen(imagen);
						if(precio!=null) libro.setPrecio(precio);
						tmp=libro;
						break;
					}//if
				}//foreach
				return tmp;
			}

}// class libroService
