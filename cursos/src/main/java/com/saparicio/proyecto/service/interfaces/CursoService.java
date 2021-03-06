package com.saparicio.proyecto.service.interfaces;

import java.util.List;
import com.saparicio.proyecto.dbms.dao.interfaces.CursoDAO;
import com.saparicio.proyecto.dbms.pojo.Curso;


/**
* <div>
* <p>
* Esta Interfaz contiene la funcionalidad de la capa logica de la aplicacion. 
* </p>
* </div>
* 
* @author Sergio aparicio.
*
*/

public interface CursoService {

		public Curso create(Curso curso);
		
		public List<Curso> getAll();
		
		public List<Curso> getLastTen();
		
		public List<Curso> getSearch(String busqueda);
		
		public boolean getByCodCurso(Curso curso);
		
		public Curso getById(int codigo);
		
		public Curso update(Curso curso);
		
		public void delete(int codigo);
		
		public void setCursoDao(CursoDAO cursoDao);
}
