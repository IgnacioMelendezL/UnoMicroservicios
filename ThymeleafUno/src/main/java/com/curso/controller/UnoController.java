package com.curso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.curso.service.UnoService;

@Controller
public class UnoController {

	@Autowired
	UnoService service;

	@GetMapping(value = "/index")
	public String index(Model model) {
		return "index";
	}

	@GetMapping(value = "/uno/{id_usuario}")
	public String uno(Model model, @PathVariable("id_usuario") int id_usuario) {
		model.addAttribute("turno", service.turno());
		model.addAttribute("carta", service.carta());
		model.addAttribute("mano", service.mano(id_usuario));
		return "uno";
	}
}