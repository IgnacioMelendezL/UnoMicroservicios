package com.curso.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.JuegoDao;
import com.curso.modelo.Juego;

@Service
public class JuegoServiceImpl implements JuegoService {
	private String urlMano = "http://mano/";
	private String urlUsuario = "http://usuario/";
	private String urlBaraja = "http://baraja/";

	@Autowired
	JuegoDao dao;
	
	@Autowired
	RestTemplate template;

	@Override
	public void pasar() {
		Juego juego = dao.findAll().get(0);
		int maxUsuarios = template.getForObject(urlUsuario + "usuarios", Object[].class).length;
		if (juego.getId_usuario() >= maxUsuarios) {
			juego.setId_usuario(1);
		} else {
			juego.setId_usuario(juego.getId_usuario() + 1);
		}
		dao.deleteAll();
		dao.save(juego);
	}

	@Override
	public void poner(int id_carta, int tipo, int numero, String color) {
		pasar();
		Juego juego = dao.findById(1).orElse(null);
		juego.setId_carta(id_carta);
		juego.setTipo(tipo);
		juego.setNumero(numero);
		juego.setColor(color);
		
		dao.save(juego);
	}

	@Override
	public void reiniciarJuego() {
		Juego juego = new Juego();
//		dao.deleteAll();
		template.delete(urlMano +"manos");
		template.delete(urlUsuario + "usuarios");
		template.postForLocation(urlBaraja + "cartas", null);
		
		Object objeto = template.getForObject(urlBaraja + "carta", Object.class);
		juego.setId_juego(1);
		juego.setId_carta((Integer) (((HashMap) objeto).get("id_carta")));
		juego.setId_usuario(1);
		juego.setTipo(((Integer) (((HashMap) objeto).get("tipo"))));
		juego.setNumero(((Integer) (((HashMap) objeto).get("numero"))));
		juego.setColor(((String) (((HashMap) objeto).get("color"))));
		
		dao.save(juego);
	}

	@Override
	public int turno() {
		return dao.getIdUsuario();
	}
	
	@Override
	public Object juego() {
		return dao.findById(1).orElse(null);
	}
}
