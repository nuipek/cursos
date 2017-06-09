package com.saparicio.proyecto.controller;




import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saparicio.proyecto.aspect.Mensaje;
import com.saparicio.proyecto.dbms.pojo.Curso;
import com.saparicio.proyecto.service.interfaces.CursoService;




@Controller
@RequestMapping(value = "/")
public class ArranqueAplicacionController {

	private static final Logger logger = LoggerFactory.getLogger(ArranqueAplicacionController.class);

	@Autowired
	private CursoService cS=null;
	List<Curso> cursos = null;
	String textoMensaje="";
	Mensaje mensaje = null;
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		logger.info("Arrancamos la aplicacion");
		
		
		logger.info("Mostramos los ultimos Cursos de la aplicacion");
		try{
			cursos = cS.getLastTen();
			textoMensaje="Mostramos los ultimos 10 cursos";
			//mensaje = new Mensaje(textoMensaje);
		}
		catch (EmptyResultDataAccessException e) {
			cursos = new ArrayList<Curso>();
			textoMensaje="No hay datos que cumplan los criterios solicitados";
			mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_WARNING);
			logger.info("No hay datos en la BBDD que cumplan los criterios solicitados");
		}
		
		catch(Exception e){
			cursos = new ArrayList<Curso>();
			textoMensaje="Error al mostrar los cursos";
			mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_DANGER);
			logger.error("Excepcion en la aplicacion " + e.getMessage());
		}
		
		
		model.addAttribute("mensaje",mensaje);
		model.addAttribute("listadoUltimosCursos",cursos);
		logger.info("Nos dirigimos a la pagina de inicio");
		return "inicio";
	}

}
