package com.kozmoz.Kozmoz_CH61_equipo_2_backend.controller;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Usuario;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.service.UsuarioService;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	
	private final UsuarioService service;
	@Autowired
	public LoginController(UsuarioService service) {
		this.service = service;
	}//constructor LoginController
	@PostMapping
	public String login(@RequestBody Usuario usuario) {
		if (service.validateUser(usuario)) {
			return "Válido";
		}//if
		throw new ServiceException("Nombre de usuario o contraseña incorrectos [" + usuario.getEmail() + "]");
	}//login
	
}//class LoginController
