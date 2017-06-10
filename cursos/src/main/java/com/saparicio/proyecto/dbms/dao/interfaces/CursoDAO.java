package com.saparicio.proyecto.dbms.dao.interfaces;

import java.util.List;

import com.saparicio.proyecto.dbms.pojo.Curso;

/**
 * Esta Interfaz define los medtodos de consulta a base de datos 
 * de la entidad curso que tiene su correspondencia en la clase
 * <code>Curso</code> de la capa de persistencia
 * @author Sergio aparicio
 *
 */

public interface CursoDAO extends DAOSetter {
	
	
	public Curso create(Curso curso);
	
	public List<Curso> getAll();
	
	public List<Curso> getLastTen();
	
	public List<Curso> getSearch(String busqueda);
	
	public boolean getByCodCurso(Curso curso);
	
	public Curso getById(int codigo);
	
	public Curso update(Curso curso);
	
	public void delete(int codigo);
	
	

}
