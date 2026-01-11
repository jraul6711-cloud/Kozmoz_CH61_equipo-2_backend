package com.kozmoz.Kozmoz_CH61_equipo_2_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kozmoz.Kozmoz_CH61_equipo_2_backend.service.UsuarioService;

import com.kozmoz.Kozmoz_CH61_equipo_2_backend.dto.ChangePassword;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Usuario;

@RestController
@RequestMapping(path="/api/usuarios/")
public class UsuariosController {

	//GET Usuarios
	
	private final UsuarioService service;
	
	@Autowired
	public UsuariosController(UsuarioService service) {
		this.service = service;
	}//constructor UsuariosController
	
	@GetMapping //http://localhost:8080/api/usuarios/
	public List<Usuario> getUsers() {
		return service.getAllUsers();
	}//Get Usuarios
	
	//GET Usuario
	
	@GetMapping(path="{userId}") //http://localhost:8080/api/usuarios/
	public Usuario getUser(@PathVariable("userId") Long id) {
		return service.getUser(id);
	}//getUser
	
	//POST
	
	@PostMapping //http://localhost:8080/api/usuarios/
	public Usuario addUser(@RequestBody Usuario usuario) {
		return service.addUser(usuario);
	}//addUser
	
	//DELETE
	
	@DeleteMapping(path="{userId}") //http://localhost:8080/api/usuarios/
	public Usuario deleteUser(@PathVariable("userId") Long id) {
		return service.deleteUser(id);
	}//deleteUser
	
	//PUT
	@PutMapping(path="{userId}")
	public Usuario updateUser(@PathVariable("userId") Long id, @RequestBody ChangePassword changePassword) {
		return service.updateUser(id, changePassword);
	}//updateUser
	
}//class UsuariosController
