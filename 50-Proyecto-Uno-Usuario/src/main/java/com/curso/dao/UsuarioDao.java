package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

}