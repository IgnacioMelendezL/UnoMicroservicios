package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UnoServiceImpl implements UnoService {
//	public String urlMano = "http://mano/";
	public String urlMano = "http://localhost:11114/";
	
	public String urlBaraja = "http://baraja/";
	
//	public String urlJuego = "http://juego/";
	public String urlJuego = "http://localhost:11112/";
	
	public String urlUsuario = "http://usuario/";

	@Autowired
	RestTemplate template;

	@Override
	public List<Object> usuarios() {
		return List.of(template.getForObject(urlUsuario + "usuarios", Object[].class));
	}

	@Override
	public List<Object> mano(int id_usuario) {
		return List.of(template.getForObject(urlMano + "mano/" + id_usuario, Object[].class));
	}

	@Override
	public int turno() {
		return template.getForObject(urlJuego + "turno", Integer.class);
	}

	@Override
	public Object carta() {
		return template.getForObject(urlJuego + "juego", Object.class);
	}

	@Override
	public void pedir(int id_usuario) {
		template.getForObject(urlUsuario + "pedir/" + id_usuario, Object[].class);
	}

	@Override
	public void pasar(int id_usuario) {
		template.put(urlUsuario + "pasar/" + id_usuario, Object[].class);
	}

	@Override
	public void poner(int id_usuario, int id_carta, int tipo, int numero, String color) {
		template.put(urlUsuario + "poner/" + id_usuario + "/" + id_carta + "/" + tipo + "/" + numero + "/" + color, Object[].class);
	}
}