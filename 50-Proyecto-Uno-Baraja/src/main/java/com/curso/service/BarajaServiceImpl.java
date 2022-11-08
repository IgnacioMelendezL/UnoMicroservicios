package com.curso.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.BarajaDao;
import com.curso.model.Carta;

@Service
public class BarajaServiceImpl implements BarajaService {
	
	private String queryReiniciarBaraja = "INSERT INTO\r\n"
			+ "    baraja (tipo, numero, color)\r\n"
			+ "values\r\n"
			+ "    (1, 0, \"VERDE\"),\r\n"
			+ "    (1, 1, \"VERDE\"),\r\n"
			+ "    (1, 2, \"VERDE\"),\r\n"
			+ "    (1, 3, \"VERDE\"),\r\n"
			+ "    (1, 4, \"VERDE\"),\r\n"
			+ "    (1, 5, \"VERDE\"),\r\n"
			+ "    (1, 6, \"VERDE\"),\r\n"
			+ "    (1, 7, \"VERDE\"),\r\n"
			+ "    (1, 8, \"VERDE\"),\r\n"
			+ "    (1, 9, \"VERDE\"),\r\n"
			+ "    \r\n"
			+ "    (1, 0, \"ROJO\"),\r\n"
			+ "    (1, 1, \"ROJO\"),\r\n"
			+ "    (1, 2, \"ROJO\"),\r\n"
			+ "    (1, 3, \"ROJO\"),\r\n"
			+ "    (1, 4, \"ROJO\"),\r\n"
			+ "    (1, 5, \"ROJO\"),\r\n"
			+ "    (1, 6, \"ROJO\"),\r\n"
			+ "    (1, 7, \"ROJO\"),\r\n"
			+ "    (1, 8, \"ROJO\"),\r\n"
			+ "    (1, 9, \"ROJO\"),\r\n"
			+ "	   \r\n"
			+ "    (1, 0, \"AZUL\"),\r\n"
			+ "    (1, 1, \"AZUL\"),\r\n"
			+ "    (1, 2, \"AZUL\"),\r\n"
			+ "    (1, 3, \"AZUL\"),\r\n"
			+ "    (1, 4, \"AZUL\"),\r\n"
			+ "    (1, 5, \"AZUL\"),\r\n"
			+ "    (1, 6, \"AZUL\"),\r\n"
			+ "    (1, 7, \"AZUL\"),\r\n"
			+ "    (1, 8, \"AZUL\"),\r\n"
			+ "    (1, 9, \"AZUL\"),\r\n"
			+ "    \r\n"
			+ "    (1, 0, \"AMARILLO\"),\r\n"
			+ "    (1, 1, \"AMARILLO\"),\r\n"
			+ "    (1, 2, \"AMARILLO\"),\r\n"
			+ "    (1, 3, \"AMARILLO\"),\r\n"
			+ "    (1, 4, \"AMARILLO\"),\r\n"
			+ "    (1, 5, \"AMARILLO\"),\r\n"
			+ "    (1, 6, \"AMARILLO\"),\r\n"
			+ "    (1, 7, \"AMARILLO\"),\r\n"
			+ "    (1, 8, \"AMARILLO\"),\r\n"
			+ "    (1, 9, \"AMARILLO\");";
	
	private String queryAutoincrement = "ALTER TABLE baraja AUTO_INCREMENT = 1";

	@Autowired
	BarajaDao dao;

	@Override
	public List<Carta> cartas() {
		return dao.findAll();
	}

	@Override
	public Carta pedirCarta() {
		List<Carta> cartas = dao.findAll();
		if (cartas.size() > 0) {
			int indCarta = new Random().nextInt((cartas.size()));
			return cartas.get(indCarta);
		} else
			return new Carta();
	}

	@Override
	public void reiniciarBaraja() {
		dao.deleteAll();

		String cadenaConexion = "jdbc:mysql://localhost:3306/uno";
		try (Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "root")) {
			conexion.prepareStatement(queryAutoincrement).execute();
			conexion.prepareStatement(queryReiniciarBaraja).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void eliminarCarta(int id_carta) {
		dao.deleteById(id_carta);
		
		if(dao.findAll().isEmpty())
			reiniciarBaraja();
	}
}