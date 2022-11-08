package com.curso.service;

import java.util.List;

import com.curso.model.CartaMano;

public interface ManoService {
	List<CartaMano> manoUsuario(int id_usuario);
	
	void nuevaCarta(int id_carta, int id_usuario, int tipo, int numero, String color);

	void borrarCarta(int id_usuario, int id_carta);
	
	void borrarManos();
}
