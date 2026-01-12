package com.kozmoz.Kozmoz_CH61_equipo_2_backend.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kozmoz.Kozmoz_CH61_equipo_2_backend.config.JwtFilter;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.dto.Token;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Usuario;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	
	private final UsuarioService service;
	@Autowired
	public LoginController(UsuarioService service) {
		this.service = service;
	}//constructor LoginController
	
	@PostMapping
	public Token login(@RequestBody Usuario usuario) throws ServletException {
		if (service.validateUser(usuario)) {
			return new Token(generateToken(usuario.getEmail()));
		}//if
		throw new ServletException("Nombre de usuario o contraseña incorrectos [" + usuario.getEmail() + "]");
	}//login
	
	private String generateToken(String email) {
		Calendar calendar = Calendar.getInstance(); //Fecha y hora actual
		//calendar.add(calendar.minute, 30);
		calendar.add(Calendar.HOUR, 72); //Sólo para pruebas
		
		return Jwts.builder().setSubject(email)
					.claim("role", "user")
					.claim("type", "client")
					.setIssuedAt(new Date())
					.setExpiration(calendar.getTime())
					.signWith(JwtFilter.getSigningKey(), SignatureAlgorithm.HS256)
					.compact();
	}//generateToken
	
}//class LoginController
