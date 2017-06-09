package com.saparicio.proyecto.service.interfaces;

import java.util.List;

import com.saparicio.proyecto.dbms.dao.interfaces.CursoDAO;
import com.saparicio.proyecto.dbms.pojo.Curso;

public interface CursoService {

		public Curso create(Curso curso);
		
		public List<Curso> getAll();
		
		public List<Curso> getLastTen();
		
		public List<Curso> getSearch(String busqueda);
		
		public Curso getById(int codigo);
		
		public Curso update(Curso curso);
		
		public void delete(int codigo);
		
		public void setCursoDao(CursoDAO cursoDao);
}
