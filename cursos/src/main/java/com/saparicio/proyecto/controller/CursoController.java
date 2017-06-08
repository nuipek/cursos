package com.saparicio.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping(value="/cursos")
public class CursoController {

private static final Logger logger = LoggerFactory.getLogger(CursoController.class);
	
	/*
	@Autowired
	private CursoService cS=null;
	
	
	@Resource(name="cursoValidator")
	private Validator validator=null;
	
	private ModelAndView mav=null;

	@InitBinder("curso") // Esta clase llama al init del servlet de spring para binder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"), false, 19));
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getAll(Model model){
		List<Curso> cursos = cS.getAll();
		model.addAttribute("listadoCursos",cursos);
		return "cursos/cursos";
	}
	
	
	*/
	
	
	
	
}
