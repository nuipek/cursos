package com.saparicio.proyecto.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saparicio.proyecto.aspect.Mensaje;
import com.saparicio.proyecto.dbms.pojo.Curso;
import com.saparicio.proyecto.service.interfaces.CursoService;


/**
 * <div>
 * <p>
 *  En esta clase implementamos controlador de las urls de arranque de la aplicacion y la gestion del login
 * </p>
 * </div>
 * 
 * @author Sergio aparicio.
 *
 */


@Controller
@RequestMapping(value = "/")
public class ArranqueAplicacionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArranqueAplicacionController.class);

	@Autowired
	private CursoService cS=null;
	List<Curso> cursos = null;
	String textoMensaje="";
	Mensaje mensaje = null;
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
	
		LOGGER.info("Arrancamos la aplicacion");
		
		
		LOGGER.info("Mostramos los ultimos Cursos de la aplicacion");
		try{
			cursos = cS.getLastTen();
			textoMensaje="Mostramos los ultimos 10 cursos";
			//mensaje = new Mensaje(textoMensaje);
		}
		catch (EmptyResultDataAccessException e) {
			cursos = new ArrayList<Curso>();
			textoMensaje="No hay datos que cumplan los criterios solicitados";
			mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_WARNING);
			LOGGER.info("No hay datos en la BBDD que cumplan los criterios solicitados");
		}
		
		catch(Exception e){
			cursos = new ArrayList<Curso>();
			textoMensaje="Error al mostrar los cursos";
			mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_DANGER);
			LOGGER.error("Excepcion en la aplicacion " + e.getMessage());
		}
		
		
		model.addAttribute("mensaje",mensaje);
		model.addAttribute("listadoUltimosCursos",cursos);
		LOGGER.info("Nos dirigimos a la pagina de inicio");
		return "inicio";
	}
	
	
	@RequestMapping(value = "login")
	public String loginPage(Model model, @RequestParam(value = "logout", required = false) String logout) {

		if (logout != null) {
			LOGGER.info("login-logout");
			model.addAttribute("mensaje", "Se ha deslogueado con exito.");
		}
		return "login";
	}

	@RequestMapping(value = "Access_Denied")
	public String accesoDenegado(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		model.addAttribute("error","error");
		return "login";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login.html")
	public String accessLogin() {
		return "redirect:/login";
	}

	private String getPrincipal() {
		String username = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}

	@RequestMapping(value = "logout")
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		model.addAttribute("mensaje", "Se ha deslogueado con exito.");
		return "redirect:login?logout=true";// se recomienda que la pagina de
		// logout sea la de login
	}

}
