package com.curso.service;

import java.util.List;

public interface UnoService {
	List<Object> usuarios();

	List<Object> mano(int id_usuario);

	int turno();
	
	Object carta();
	
	void pedir(int id_usuario);

	void pasar(int id_usuario);

	void poner(int id_usuario, int id_carta, int tipo, int numero, String color);
}