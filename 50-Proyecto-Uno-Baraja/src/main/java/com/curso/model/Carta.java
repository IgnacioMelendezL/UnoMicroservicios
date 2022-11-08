package com.curso.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="baraja")
public class Carta {

	@Id
	private int id_carta;
	private int tipo;
	private int numero;
	private String color;

	public Carta() {
	}

	public Carta(int id_carta, int tipo, int numero, String color) {
		this.id_carta = id_carta;
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