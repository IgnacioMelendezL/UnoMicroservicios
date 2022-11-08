package com.curso.service;

public interface JuegoService {
	void pasar();

	void poner(int id_carta, int tipo, int numero, String color);

	void reiniciarJuego();

	int turno();

	Object juego();
}
