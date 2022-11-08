package com.curso.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.ManoDao;
import com.curso.model.CartaMano;

@Service
public class ManoServiceImpl implements ManoService {
	
	private String queryAutoincrement = "ALTER TABLE mano AUTO_INCREMENT = 1";

	@Autowired
	ManoDao dao;

	@Override
	public List<CartaMano> manoUsuario(int id_usuario) {
		return dao.manoUsuario(id_usuario);
	}
	
	@Override
	public void nuevaCarta(int id_carta, int id_usuario, int tipo, int numero, String color) {
		dao.save(new CartaMano(id_carta, id_usuario, tipo, numero, color));
	}

	@Override
	public void borrarCarta(int id_usuario, int id_carta) {
		dao.deleteById(id_carta);
	}
	
	@Override
	public void borrarManos() {
		String cadenaConexion = "jdbc:mysql://localhost:3306/uno";
		try (Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "root")) {
			conexion.prepareStatement(queryAutoincrement).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dao.deleteAll();
	}
}