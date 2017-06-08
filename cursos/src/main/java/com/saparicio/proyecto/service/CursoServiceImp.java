package com.saparicio.proyecto.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saparicio.proyecto.dbms.dao.interfaces.CursoDAO;
import com.saparicio.proyecto.dbms.pojo.Curso;
import com.saparicio.proyecto.service.interfaces.CursoService;

@Service
public class CursoServiceImp implements CursoService {

	 private static final Logger logger = LoggerFactory.getLogger(CursoServiceImp.class);
	 
	@Autowired
	private CursoDAO cursoDao;
    
	@Override
	public Curso create(Curso curso) {
		
		return cursoDao.create(curso);
	}

	@Override
	public List<Curso> getAll() {
		
		return cursoDao.getAll();
	}

	@Override
	public Curso getById(int codigo) {
		
		return cursoDao.getById(codigo);
	}

	@Override
	public Curso update(Curso curso) {
		
		return cursoDao.update(curso);
	}

	@Override
	public void delete(int codigo) {
		cursoDao.delete(codigo);
	}

	@Override
	public void setCursoDao(CursoDAO cursoDao) {
		this.cursoDao = cursoDao;

	}

}
