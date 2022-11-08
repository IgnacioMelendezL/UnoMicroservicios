package com.curso.uno;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Pasar")
public class Pasar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	public String urlMano = "http://mano/";
	public String urlMano = "http://localhost:11114/";
	
	public String urlBaraja = "http://baraja/";
	
//	public String urlJuego = "http://juego/";
	public String urlJuego = "http://localhost:11112/";
	
	public String urlUsuario = "http://usuario/";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(urlUsuario + "pasar/" + request.getAttribute("id"));
		dispatch.forward(request, response);
	}
}