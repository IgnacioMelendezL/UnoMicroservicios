package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.service.JuegoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class JuegoController {

	@Autowired
	JuegoService service;

	@ApiOperation(value = "Cambia el turno del jugador.")
	@PutMapping(value = "pasar")
	public void pasar() {
		service.pasar();
	}
	
	@PutMapping(value= "poner/{id_carta}/{tipo}/{numero}/{color}")
	public void poner(@ApiParam(value = "Identificador de la carta")@PathVariable(value="id_carta") int id_carta,
			 		  @ApiParam(value = "Numero de la carta") @PathVariable(value="tipo") int tipo, 
				      @ApiParam(value = "Numero de la carta") @PathVariable(value="numero") int numero, 
				      @ApiParam(value = "Color de la carta") @PathVariable(value="color") String color) {
		service.poner(id_carta, tipo, numero, color);
	}
	
	@DeleteMapping(value="reiniciar")
	public void reiniciarJuego() {
		service.reiniciarJuego();
	}
	
	@GetMapping(value="turno")
	public int obtenerTurno() {
		return service.turno();
	}
	
	@GetMapping(value="juego")
	public Object juego() {
		return service.juego();
	}
}
