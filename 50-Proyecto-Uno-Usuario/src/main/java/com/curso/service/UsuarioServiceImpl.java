package com.curso.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.UsuarioDao;
import com.curso.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	public String urlMano = "http://mano/";
	public String urlBaraja = "http://baraja/";
	public String urlJuego = "http://juego/";
	
	private String queryAutoincrement = "ALTER TABLE usuario AUTO_INCREMENT = 1";

	@Autowired
	UsuarioDao dao;

	@Autowired
	RestTemplate template;

	@Override
	public List<Usuario> usuarios() {
		return dao.findAll();
	}

	@Override
	public List<Object> mano(int id_usuario) {
		return List.of(template.getForObject(urlMano + "mano/" + id_usuario, Object.class));
	}

	@Override
	public void pedir(int id_usuario) {
		Object carta = template.getForObject(urlBaraja + "carta", Object.class);

		int id_carta = (Integer) (((HashMap) carta).get("id_carta"));
		int tipo = (Integer) (((HashMap) carta).get("tipo"));
		int numero = (Integer) (((HashMap) carta).get("numero"));
		String color = (String) (((HashMap) carta).get("color"));

		template.postForLocation(urlMano + "mano/" + id_carta + "/" + id_usuario + "/" + tipo + "/" + numero + "/" + color, Object.class);
	}

	@Override
	public void registrarUsuario(int id_usuario, String usuario, String codigo) {
		dao.save(new Usuario(id_usuario, usuario, codigo));
		List<Usuario> usuarios = dao.findAll();
		
		for(int i = 0; i < 7; ++i)
			pedir(id_usuario);
	}

	@Override
	public void pasar(int id_usuario) {
		if( template.getForObject(urlJuego + "turno", Integer.class) == id_usuario)
			template.put(urlJuego + "pasar", Object.class);
	}

	@Override
	public void poner(int id_usuario, int id_carta, int tipo, int numero, String color) {
		if( template.getForObject(urlJuego + "turno", Integer.class) == id_usuario) {
			template.put(urlJuego + "poner/" + id_carta + "/" + tipo + "/" + numero + "/" + color, Object.class);
			template.delete(urlMano + "mano/" + id_usuario + "/" + id_carta);
		}
	}

	@Override
	public void deleteAll() {
		String cadenaConexion = "jdbc:mysql://localhost:3306/uno";
		try (Connection conexion = DriverManager.getConnection(cadenaConexion, "root", "root")) {
			conexion.prepareStatement(queryAutoincrement).execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dao.deleteAll();
	}
}