package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Carta;
import com.curso.service.BarajaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class BarajaController {

	@Autowired
	BarajaService service;

	@ApiOperation(value = "Devuelve toda la baraja")
	@GetMapping(value = "cartas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Carta> getCartas() {
		return service.cartas();
	}

	@ApiOperation(value = "Devuelve una carta aleatoria de la baraja y la elimina")
	@GetMapping(value = "carta", produces = MediaType.APPLICATION_JSON_VALUE)
	public Carta getCarta() {
		Carta carta = service.pedirCarta();
		service.eliminarCarta(carta.getId_carta());
		return carta;
	}

	@ApiOperation(value = "Reinicia la baraja con todas las cartas")
	@PostMapping(value = "cartas")
	public void reiniciarBaraja() {
		service.reiniciarBaraja();
	}

	@ApiOperation(value = "Elimina la carta según su ID de carta")
	@DeleteMapping(value = "carta/{id_carta}")
	public void deleteCarta(@ApiParam(value = "ID de carta") @PathVariable("id_carta") int id_carta) {
		service.eliminarCarta(id_carta);
	}
}