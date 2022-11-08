package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.CartaMano;
import com.curso.service.ManoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class ManoController {

	@Autowired
	ManoService service;

	@ApiOperation(value = "Devuelve la mano del usuario según su ID")
	@GetMapping(value = "mano/{id_usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CartaMano> getCarta(@ApiParam(value = "ID de usuario") @PathVariable("id_usuario") int id_usuario) {
		return service.manoUsuario(id_usuario);
	}

	@ApiOperation(value = "Guarda una carta nueva en la mano del usuario")
	@PostMapping(value = "mano/{id_carta}/{id_usuario}/{tipo}/{numero}/{color}")
	public void putCartaMano(@ApiParam(value = "ID de carta") @PathVariable("id_carta") int id_carta, 
								@ApiParam(value = "ID de usuario") @PathVariable("id_usuario") int id_usuario, 
								@ApiParam(value = "Tipo de la carta") @PathVariable("tipo") int tipo, 
								@ApiParam(value = "Número de la carta") @PathVariable("numero") int numero, 
								@ApiParam(value = "Color de la carta") @PathVariable("color") String color) {
		service.nuevaCarta(id_carta, id_usuario, tipo, numero, color);
	}

	@ApiOperation(value = "Elimina una carta de la mano del usuario")
	@DeleteMapping(value = "mano/{id_usuario}/{id_carta}")
	public void deleteCartaMano(@ApiParam(value = "ID de usuario") @PathVariable("id_usuario") int id_usuario, 
			@ApiParam(value = "ID de carta") @PathVariable("id_carta") int id_carta) {
		service.borrarCarta(id_usuario, id_carta);
	}

	@ApiOperation(value = "Elimina todas las manos")
	@DeleteMapping(value = "manos")
	public void deleteCarta() {
		service.borrarManos();
	}
}