package com.kozmoz.Kozmoz_CH61_equipo_2_backend.repository;

import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario> findByNombre(String nombre); 
	Optional<Usuario> findByEmail(String email); 
}//interface Usuariorepository
