package com.kozmoz.Kozmoz_CH61_equipo_2_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kozmoz.Kozmoz_CH61_equipo_2_backend.dto.ChangePassword;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Usuario;

@Service
public class UsuarioService {
	private final List<Usuario> lista = new ArrayList<Usuario>();

	public UsuarioService() {
		lista.add(new Usuario("Adrian Bringas","adrian@gmail.com","fejEGH149GEs"));	        
        lista.add(new Usuario("Yessica Pérez","yessica@gmail.com","xdxdxDxDXd"));	        
        lista.add(new Usuario("Ernesto Laguardia","ernesto@gmail.com","fjhfjekASW%^&"));
	}//method UsuarioService
	
	public List<Usuario> getAllUsuarios() {
		return lista;
	}//getAllUsuarios

	public Usuario getUsuario(long id) {
		Usuario tmp = null;
		for (Usuario usuario : lista) {
			if (usuario.getId() == id) {
				tmp = usuario;
				break;
			}//if
		}//forEach
		return tmp;
	}//getUsuario

	public Usuario addUsuario(Usuario usuario) {
		lista.add(usuario);
		return usuario;
	}//addUsuario

	public Usuario deleteUsuario(Long id) {
		Usuario tmp = null;
		for (Usuario usuario : lista) {
			if (usuario.getId() == id) {
				tmp = usuario;
				lista.remove(usuario);
				break;
			}//if
		}//forEach
		return tmp;
	}//deleteUsuario

	public Usuario updateUsuario(Long id, ChangePassword changePassword) {
		Usuario tmp = null;
		for (Usuario usuario : lista) {
			if (usuario.getId() == id) {
				if (usuario.getPassword().equals(changePassword.getPassword())) {
					usuario.setPassword(changePassword.getNPassword());
					tmp = usuario;
					break;
				}//if equals
			}//if
		}//forEach
		return tmp;
	}//updateUsuario

}//class UsuarioService
