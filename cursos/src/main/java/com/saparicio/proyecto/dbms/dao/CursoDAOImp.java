package com.saparicio.proyecto.dbms.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.saparicio.proyecto.dbms.dao.interfaces.CursoDAO;
import com.saparicio.proyecto.dbms.pojo.Curso;

@Repository("cursoDAOImp")
public class CursoDAOImp implements CursoDAO {

    @SuppressWarnings("unused")
	@Resource(name="mysqlDataSource")
	private DataSource dataSource;
	private JdbcTemplate template;
	private SimpleJdbcCall jdbcCall;
	private Logger logger = LoggerFactory.getLogger(CursoDAOImp.class);
	
	
	
	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.template = new JdbcTemplate(this.dataSource);
		this.jdbcCall = new SimpleJdbcCall(this.dataSource);

	}

	@Override
	public Curso create(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curso> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso getById(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Curso update(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int codigo) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Curso> getLastTen() {
		
		return null;
	}

}
