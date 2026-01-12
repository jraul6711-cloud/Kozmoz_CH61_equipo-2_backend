package com.kozmoz.Kozmoz_CH61_equipo_2_backend.config;

import java.io.IOException;
import java.security.Key;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class JwtFilter {
	private static final String SECRET = "semana_13_estoy_muy_cansado_hijo_el_diablo_ya_acabo";
	private static Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
	public static Key getSigningKey() {
		return key;
	}//getSigningKey
	
}//class JwtFilter
