package com.atos.atoszoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ZooController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showJaula() {
		return "redirect:/cuidador/lista";
	}
}
