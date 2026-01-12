package com.kozmoz.Kozmoz_CH61_equipo_2_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kozmoz.Kozmoz_CH61_equipo_2_backend.dto.ChangePassword;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Usuario;
import com.kozmoz.Kozmoz_CH61_equipo_2_backend.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
//		lista.add(new Usuario("Adrian Bringas","adrian@gmail.com","fejEGH149GEs"));	        
//        lista.add(new Usuario("Yessica Pérez","yessica@gmail.com","xdxdxDxDXd"));	        
//        lista.add(new Usuario("Ernesto Laguardia","ernesto@gmail.com","fjhfjekASW%^&"));
	}//method UsuarioService
	
	public List<Usuario> getAllUsers() {
		return repository.findAll();
	}//getAllUsers

	public Usuario getUser(long id) {
		return repository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("El usuario con el id[" + id + "] no esxiste")
				);
	}//getUser

	public Usuario addUser(Usuario usuario) {
		Optional<Usuario> user = repository.findByNombre(usuario.getNombre());
		if (user.isEmpty()) {
			usuario.setPassword( encoder.encode(usuario.getPassword()) );
			repository.save(usuario);
			return usuario;
		}//if isEmpty
		return null;
	}//addUser

	public Usuario updateUser(Long id, ChangePassword changePassword) { 
		Usuario tmp = null; 
		if(repository.existsById(id)) { 
			Usuario user = repository.findById(id).get(); 
			if(encoder.matches(changePassword.getPassword(), user.getPassword())) {
//			if(user.getPassword().equals(changePassword.getPassword()))  
				user.setPassword( encoder.encode(changePassword.getNpassword()));
				repository.save(user);
				tmp = user;
				}//ifEquals 
			}//ifId exists
			return tmp; 
	}//updateUsuario
	
	public Usuario deleteUser(Long id) {
		Usuario tmp = null;
		if (repository.existsById(id)) {
			tmp = repository.findById(id).get();
			repository.deleteById(id);
		}//if exists
		return tmp;
	}//deleteUser

	public boolean validateUser(Usuario usuario) {
		Optional<Usuario> usr = repository.findByEmail(usuario.getEmail());
		if (usr.isPresent()) {
			Usuario user = usr.get();
			if (encoder.matches(usuario.getPassword(), user.getPassword())) {
				return true;
			}//if matches
		}//if usr.isPresent
		return false;
	}//validateUser

}//class UsuarioService
