package com.curso.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="juego") //nombre de la tabla de la bbdd
public class Juego {
	
	@Id //Clave primaria
	private int id_juego;
	private int id_usuario;
	private int id_carta;
	private int tipo;
	private int numero;
	private String color;
	
	public Juego(int id_juego, int id_usuario, int id_carta, int tipo, int numero, String color) {
		super();
		this.id_juego = id_juego;
		this.id_usuario = id_usuario;
		this.id_carta = id_carta;
		this.tipo = tipo;
		this.numero = numero;
		this.color = color;
	}

	public Juego() {
		super();
	}

	public int getId_juego() {
		return id_juego;
	}

	public void setId_juego(int id_juego) {
		this.id_juego = id_juego;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_carta() {
		return id_carta;
	}

	public void setId_carta(int id_carta) {
		this.id_carta = id_carta;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}

