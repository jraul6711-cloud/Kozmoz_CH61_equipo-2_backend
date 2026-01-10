package com.kozmoz.Kozmoz_CH61_equipo_2_backend.controller;

import java.util.List;

import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Libro;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path="/api") 
public class LibroController  {
	//GET
	@GetMapping("/libro/")
	public List<Libro> getLibros(){
		return List.of(
				new Libro("nombre: Clean Code", "descripcion: Manual de manual de estilo para el desarrollo de software", "imagen.jpg", 850.00),
				new Libro("nombre: El Hobbit", "descripcion: Una aventura épica en la Tierra Media", "imagenjpg", 420.00)
				);
		
	}//getLibros 
	
	//POST
	//DELETE
	//PUT

}// Class LibroController
