package com.demopushnotification.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demopushnotification.example.model.Mensagem;
import com.demopushnotification.example.service.NotificacoesPushImpl;

@Controller
public class IndexController {
	
	@Autowired
	private NotificacoesPushImpl notificacoesPushImpl;
	
	@GetMapping(path = "/")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@GetMapping(path = "/form")
	public ModelAndView form() {
		ModelAndView model = new ModelAndView("form");
		model.addObject("mensagem", new Mensagem());
		return model;
	}
	
	@PostMapping(path = "/enviar")
	public ModelAndView enviar(@ModelAttribute("Mensagem") Mensagem mensagem) {
		 String res = notificacoesPushImpl.enviar(mensagem);
		 ModelAndView model = new ModelAndView("redirect:aviso");
		 model.addObject("res", res);
		 return model;
	}
		
	@GetMapping("/aviso")
	public ModelAndView aviso(String res) {
		ModelAndView model = new ModelAndView("aviso");	
		model.addObject("tipo", res);
		return model;
	}
	
}
