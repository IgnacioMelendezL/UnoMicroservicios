package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.CartaMano;

public interface ManoDao extends JpaRepository<CartaMano, Integer> {

	@Query(value = "SELECT * FROM mano WHERE id_usuario = ?1", nativeQuery = true)
	List<CartaMano> manoUsuario(int id_usuario);
}