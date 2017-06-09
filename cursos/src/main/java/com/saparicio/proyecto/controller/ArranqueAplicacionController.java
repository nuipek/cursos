package com.saparicio.proyecto.controller;



import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saparicio.proyecto.dbms.pojo.Curso;
import com.saparicio.proyecto.service.interfaces.CursoService;




@Controller
@RequestMapping(value = "/")
public class ArranqueAplicacionController {

	private static final Logger logger = LoggerFactory.getLogger(ArranqueAplicacionController.class);

	@Autowired
	private CursoService cS=null;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		logger.info("Arrancamos la aplicacion");
		logger.info("Nos dirigimos a la pagina de inicio");
		
		List<Curso> cursos = cS.getLastTen();
		model.addAttribute("listadoUltimosCursos",cursos);
		
		return "inicio";
	}

}
