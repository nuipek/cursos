package com.saparicio.proyecto.controller;



import java.util.Locale;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping(value = "/")
public class ArranqueAplicacionController {

	private static final Logger logger = LoggerFactory.getLogger(ArranqueAplicacionController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		logger.info("Arrancamos la aplicacion");
		logger.info("Nos dirigimos a la pagina de inicio");
		
		
		return "inicio";
	}

}
