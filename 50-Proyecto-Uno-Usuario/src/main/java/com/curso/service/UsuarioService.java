package com.curso.service;

import java.util.List;

import com.curso.model.Usuario;

public interface UsuarioService {
	List<Usuario> usuarios();

	List<Object> mano(int id_usuario);

	void pedir(int id_usuario);

	void registrarUsuario(int id_usuario, String usuario, String codigo);

	void pasar(int id_usuario);

	void poner(int id_usuario, int id_carta, int tipo, int numero, String color);

	void deleteAll();
}