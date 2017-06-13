package com.saparicio.proyecto.dbms.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.saparicio.proyecto.dbms.pojo.Curso;

/**
 * <div>
 * <p>
 *  En esta clase implementamos el mapeador de los accesos a bbdd dao con los resultados de
 *  los procedimientos de la bbdd  
 * </p>
 * </div>
 * 
 * @author Sergio aparicio.
 *
 */

public class CursoMapper implements RowMapper<Curso> {
	
private static final Logger logger = LoggerFactory.getLogger(CursoMapper.class);
	
	@Override
	public Curso mapRow(ResultSet rs, int rownum) throws SQLException {
		Curso curso = new Curso();
	
		curso.setCodigo(rs.getInt("Codigo"));
		curso.setCodCurso(rs.getString("CodCurso"));
		curso.setNomCurso(rs.getString("NomCurso"));
		return curso;
	}
}
