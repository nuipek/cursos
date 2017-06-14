package com.saparicio.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.saparicio.proyecto.aspect.Mensaje;
import com.saparicio.proyecto.dbms.pojo.Curso;
import com.saparicio.proyecto.service.interfaces.CursoService;


/**
 * <div>
 * <p>
 *  En esta clase implementamos el controlador de las urls de la entidad curso de la aplicacion 
 * </p>
 * </div>
 * 
 * @author Sergio aparicio.
 *
 */

@Controller
@RequestMapping(value="/cursos")
public class CursoController {

private static final Logger LOGGER = LoggerFactory.getLogger(CursoController.class);
	
	
	@Autowired
	private CursoService cS=null;
	
	
	@Resource(name="cursoValidator")
	private Validator validator=null;
	
	
	List<Curso> cursos=null;
	String textoMensaje="";
	Mensaje mensaje = null;

	@InitBinder("curso") // Esta clase llama al init del servlet de spring para binder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(validator);
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"), false, 19));
	}
	
	@RequestMapping(method=RequestMethod.GET, value ="/{id}")
	public String getById(@PathVariable("id") int codigo, Model model){
		LOGGER.info("Hemos seleccionado la opcion de curso con codigo " + codigo);
		model.addAttribute("curso",cS.getById(codigo));
		return "cursos/curso";
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getAll(Model model){
		try{
		 cursos = cS.getAll();
		 textoMensaje="Mostramos los " + cursos.size() + " cursos realizados";
		 mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_SUCCESS);
		}catch (EmptyResultDataAccessException e) {
			cursos = new ArrayList<Curso>();
			textoMensaje="No hay datos en la BBDD para mostrar";
			mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_WARNING);
			LOGGER.info(textoMensaje);
		}catch(Exception e){
			cursos = new ArrayList<Curso>();
			textoMensaje="Error al mostrar los cursos";
			mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_DANGER);
			LOGGER.error("Excepcion en la aplicacion " + e.getMessage());
		}
		
		//model.addAttribute("mensaje",mensaje);
		model.addAttribute("listadoCursos",cursos);
		return "cursos/cursos";
	}

	
	@RequestMapping(value="/addCurso")
	public String addCurso(Model model){
		model.addAttribute("curso", new Curso());
		return "cursos/curso";
	}
	
	
	@RequestMapping(value="/deleteCurso/{id}")
	public String  deleteProducto(@PathVariable("id") int codigo, RedirectAttributes redirectMap)
	{
				
		try {
			cS.delete(codigo);
			textoMensaje="Se ha borrado correctamente el curso.";
			mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_SUCCESS);
		} catch (Exception e) {
			textoMensaje="Error al eliminar el curso. ";
			mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_DANGER);
		}
		
		
		redirectMap.addFlashAttribute("mensaje",mensaje);
		
		return "redirect:/cursos"; // Le indicamos que vaya a la URL y se procese el metodo GET 
									
	}
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String saveCliente( ModelMap model, @ModelAttribute("curso") @Valid Curso curso, 
							 BindingResult bindingResult,RedirectAttributes redirectMap){
		String destino="";
		String textoMensaje="";
		Mensaje mensaje = null;
		
		if (bindingResult.hasErrors()){
			LOGGER.info("Curso tiene errores " + 
			bindingResult.getAllErrors().toString());
			textoMensaje = "Los datos de formulario contienen errores ";
			mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_DANGER);
			model.addAttribute("mensaje", mensaje);
			destino = "cursos/curso";
		}
		else
		{
			destino="redirect:/cursos";
			if (curso.getCodigo() > Curso.CODIGO_NULO){
				
				
				try {
					cS.update(curso);
					textoMensaje="Se ha realizado correctamente la actualizacion del curso. ";
					mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_SUCCESS);
					//LOGGER.info(textoMensaje + curso.toString());
				} catch (Exception e) {
					textoMensaje="Error al crear el curso. ";
					mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_DANGER);
				}
			}
			else
			{
				
				try {
					cS.create(curso);
					textoMensaje="Se ha realizado correctamente la creacion del curso. ";
					mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_SUCCESS);
					//LOGGER.info(textoMensaje + curso.toString());
				} catch (Exception e) {
					textoMensaje="Error al crear el curso. ";
					mensaje = new Mensaje(textoMensaje, Mensaje.MSG_TYPE_DANGER);
				}	
			}
			redirectMap.addFlashAttribute("mensaje", mensaje);	
		}
	 
	return destino;
		
	}
	
}
