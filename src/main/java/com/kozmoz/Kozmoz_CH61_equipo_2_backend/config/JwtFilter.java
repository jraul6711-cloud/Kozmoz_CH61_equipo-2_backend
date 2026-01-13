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

public class JwtFilter extends GenericFilterBean{
	private static final String SECRET = "semana_13_estoy_muy_cansado_hijo_el_diablo_ya_acaba_por_favor";
	private static Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
	public static Key getSigningKey() {
		return key;
	}//getSigningKey
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//GET /api/productos/ -> NO
		//POST /api/usuarios/ -> NO
		
		//POST, PUT, DELETE /api/productos/ -> SI
		//GET, PUT, DELETE /api/productos/ -> SI
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authHeader = httpServletRequest.getHeader("Authorization");
		String method = httpServletRequest.getMethod(); //GET POST PUT DELETE
		String URI = httpServletRequest.getRequestURI(); // /api/*

		if ( 
				( (method.equals("POST")) && (!URI.contains("/api/usuarios/")) )//por facilidad se valida si son GET o POST
				||
				( (method.equals("GET")) && (!URI.contains("/api/productos/")) )
				||
				(method.equals("PUT"))
				||
				(method.equals("DELETE"))
				) {
			if ( (authHeader == null) || (!authHeader.startsWith("Bearer ")) ) {
				System.out.println("1. Invalid Token");
				throw new ServletException("1. Invalid Token");
			}//authHeader == null
			String token = authHeader.substring(7);
			
			try {
				Claims claims = Jwts.parserBuilder()
						.setSigningKey(getSigningKey())
						.build()
						.parseClaimsJws(token).getBody();
				
				claims.forEach((key, value) -> System.out.println("Kay["+ key + "] Value[" + value + "]"));
				
				System.out.println("Type: " + claims.get("type"));
				System.out.println("Type: " + claims.get("role"));
				
			} catch(ExpiredJwtException | MalformedJwtException | SignatureException e) {
				System.out.println("1. Invalid Token" + e.toString());
				throw new ServletException("1. Invalid Token");
			}//catch
			
		}//if method URI
		
		chain.doFilter(request, response);
	}//doFilter
	
}//class JwtFilter
