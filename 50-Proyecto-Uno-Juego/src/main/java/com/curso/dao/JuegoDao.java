package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.modelo.Juego;

public interface JuegoDao extends JpaRepository<Juego, Integer> {

	@Query(value = "SELECT id_usuario FROM juego WHERE id_juego=1", nativeQuery = true)
	int getIdUsuario();
}
