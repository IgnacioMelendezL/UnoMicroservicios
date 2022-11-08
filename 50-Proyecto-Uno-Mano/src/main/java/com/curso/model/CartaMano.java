package com.curso.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mano")
public class CartaMano {

	@Id
	private int id_carta;
	private int id_usuario;
	private int tipo;
	private int numero;
	private String color;

	public CartaMano() {
	}

	public CartaMano(int id_carta, int id_usuario, int tipo, int numero, String color) {
		this.id_carta = id_carta;
		this.id_usuario = id_usuario;
		this.tipo = tipo;
		this.numero = numero;
		this.color = color;
	}

	public int getId_carta() {
		return id_carta;
	}

	public void setId_carta(int id_carta) {
		this.id_carta = id_carta;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
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