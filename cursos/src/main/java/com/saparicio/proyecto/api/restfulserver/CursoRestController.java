package com.saparicio.proyecto.api.restfulserver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saparicio.proyecto.dbms.pojo.Curso;
import com.saparicio.proyecto.service.interfaces.CursoService;


@RestController
@RequestMapping(value="/api/cursos")
public class CursoRestController {
	
	
	@Autowired
	private CursoService cS;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> realizarBusqueda(String busqueda){
		
		ResponseEntity<List<Curso>> response = null;
		
		List<Curso> cursos = cS.getSearch(busqueda);
		
		if (cursos == null || cursos.isEmpty()){
			response = new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
		}else
		{
			response = new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
		}
		
		return response;
	}
	


}
