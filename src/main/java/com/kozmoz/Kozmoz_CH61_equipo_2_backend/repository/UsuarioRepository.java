package com.kozmoz.Kozmoz_CH61_equipo_2_backend.repository;

import com.kozmoz.Kozmoz_CH61_equipo_2_backend.model.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByNombre(String nombre); 
	Optional<Usuario> findByEmail(String email); 
	List<Usuario> findAll();
}//interface Usuariorepository
