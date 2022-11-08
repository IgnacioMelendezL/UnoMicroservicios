package com.curso.service;

import java.util.List;

import com.curso.model.Carta;

public interface BarajaService {
	List<Carta> cartas();
	
	Carta pedirCarta();
	
	void reiniciarBaraja();	
	
	void eliminarCarta(int id_carta);	
}