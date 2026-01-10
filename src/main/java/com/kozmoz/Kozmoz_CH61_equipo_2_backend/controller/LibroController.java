package com.kozmoz.Kozmoz_CH61_equipo_2_backend.controller;

import java.util.List;

import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Libro;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.service.LibroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api") 
public class LibroController  {
	//GET
	
	private final LibroService service;
	
	@Autowired
	public LibroController(LibroService service) {
		this.service= service;
	}//constructor

	@GetMapping("/libro/")  // http://localhost:8080/api/libro/
	public List<Libro> getLibros(){
		return service.getBook();	
	}//getLibros 
	
	@GetMapping("/libro/{prodid}")  // http://localhost:8080/api/libro/2
	public Libro getLibro(@PathVariable("prodid") long id){
		return service.getBooks(id);
	}//getLibro

	//POST
	
	@PostMapping ("/libro/")
	public Libro addLibro(@RequestBody Libro libro) {
		return service.addBook(libro);
		
	}//addLibro
	
	//DELETE
	
	@DeleteMapping("/libro/{prodid}")
	public Libro deleteLibro(@PathVariable("prodid") long id) {
		return service.deleteBook(id);
	}//deleteLibro
	
	//PUT
	@PutMapping ("/libro/{prodid}")
	public Libro updateLibro(@PathVariable("prodid") long id, 
			@RequestParam(name="nombre",required = false) String nombre,
			@RequestParam(name="descripcion",required = false) String descripcion,
			@RequestParam(name="imagen",required = false) String imagen,
			@RequestParam(name="precio",required = false) Double precio) {
		return service.updateBook(id, nombre, descripcion, imagen, precio);
		
	}//updateLibro 

}// Class LibroController
