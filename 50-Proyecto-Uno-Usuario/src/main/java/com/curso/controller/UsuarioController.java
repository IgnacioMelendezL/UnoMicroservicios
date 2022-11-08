package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Usuario;
import com.curso.service.UsuarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@ApiOperation(value = "Devuelve todos los usuarios")
	@GetMapping(value = "usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> getUsuarios() {
		return service.usuarios();
	}

	@ApiOperation(value = "Devuelve toda la mano del usuario")
	@GetMapping(value = "mano/{id_usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Object> getMano(@ApiParam(value = "ID de usuario") @PathVariable("id_usuario") int id_usuario) {
		return service.mano(id_usuario);
	}

	@ApiOperation(value = "Pide una nueva carta para la mano del usuario")
	@GetMapping(value = "pedir/{id_usuario}")
	public void pedir(@ApiParam(value = "ID de usuario") @PathVariable("id_usuario") int id_usuario) {
		service.pedir(id_usuario);
	}

	@ApiOperation(value = "Registra un nuevo usuario")
	@PostMapping(value = "usuario/{id_usuario}/{usuario}/{codigo}")
	public void usuario(@ApiParam(value = "ID de usuario") @PathVariable("id_usuario") int id_usuario,
			@ApiParam(value = "Nombre de usuario") @PathVariable("usuario") String usuario,
			@ApiParam(value = "Contraseña del usuario") @PathVariable("codigo") String codigo) {
		service.registrarUsuario(id_usuario, usuario, codigo);
	}

	@ApiOperation(value = "Pasa de turno al siguiente jugador")
	@PutMapping(value = "pasar/{id_usuario}")
	public void pasar(@ApiParam(value = "ID del usuario") @PathVariable("id_usuario") int id_usuario) {
		service.pasar(id_usuario);
	}

	@ApiOperation(value = "Pone una carta en el juego")
	@PutMapping(value = "poner/{id_usuario}/{id_carta}/{tipo}/{numero}/{color}")
	public void poner(@ApiParam(value = "ID del usuario") @PathVariable("id_usuario") int id_usuario,
			@ApiParam(value = "ID de la carta") @PathVariable("id_carta") int id_carta,
			@ApiParam(value = "Tipo de la carta") @PathVariable("tipo") int tipo,
			@ApiParam(value = "Número de la carta") @PathVariable("numero") int numero,
			@ApiParam(value = "Color de la carta") @PathVariable("color") String color) {
		service.poner(id_usuario, id_carta, tipo, numero, color);
	}

	@ApiOperation(value = "Elimina todos los usuarios")
	@DeleteMapping(value = "usuarios")
	public void deleteAll() {
		service.deleteAll();
	}
}