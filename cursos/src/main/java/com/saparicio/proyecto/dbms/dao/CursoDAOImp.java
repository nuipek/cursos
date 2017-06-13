/**
* <div>
* <p>
* Esta clase se va encargar de gestionar las operaciones de CRUD del Curso y demas funcionalidades asociadas a la DB.
* </p>
* <ul>
* <li>C: Create</li>
* <li>R: Read</li>
* <li>D: Delete</li>
* <li>U: Update</li>
* <li>S: Search</li>
* <li>L: LastTen</li>
* </ul>
* </div>
* 
* @author Sergio aparicio.
*
*/


package com.saparicio.proyecto.dbms.dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;


import com.saparicio.proyecto.dbms.dao.interfaces.CursoDAO;
import com.saparicio.proyecto.dbms.dao.mappers.CursoMapper;
import com.saparicio.proyecto.dbms.pojo.Curso;

@Repository("cursoDAOImp")
public class CursoDAOImp implements CursoDAO {

	private Logger logger = LoggerFactory.getLogger(CursoDAOImp.class);
	
    @SuppressWarnings("unused")
	@Resource(name="mysqlDataSource")
	private DataSource dataSource;
	private JdbcTemplate template;
	private SimpleJdbcCall jdbcCall;
	
	private Curso curso = null;
	private List<Curso> cursos = null;
	

	@Value("${curso.getAll}")
	private String sqlprocgetAll;
	
	@Value("${curso.getById}")
	private String sqlprocgetById;
	
	@Value("${curso.delete}")
	private String sqlprocdelete;
	
	@Value("${curso.create}")
	private String sqlproccreate;
	
	@Value("${curso.update}")
	private String sqlprocupdate;
	
	@Value("${curso.getSearch}")
	private String sqlprocgetSearch;
	
	@Value("${curso.getLastTen}")
	private String sqlprocgetLastTen;
	
	@Value("${curso.getByCodCurso}")
	private String sqlprocCodCursoDuplicado;
	
	

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.template = new JdbcTemplate(this.dataSource);
		this.jdbcCall = new SimpleJdbcCall(this.dataSource);

	}

	@Override
	public Curso create(Curso curso) {
		
		jdbcCall = new SimpleJdbcCall(dataSource);
		
		jdbcCall.withProcedureName(sqlproccreate);
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("pCodCurso", curso.getCodCurso())
					.addValue("pNomCurso",curso.getNomCurso());
		
		logger.debug(curso.toString());
		Map<String,Object> out = jdbcCall.execute(in);
		
		curso.setCodigo((Integer)out.get("pcodigo"));
		
		logger.info("Se ha creado el curso - codigo:" + String.valueOf(curso.getCodigo()));
		
		return curso;
	}

	@Override
	public List<Curso> getAll() {
		
		template = new JdbcTemplate(this.dataSource);
		cursos = template.query(sqlprocgetAll, new CursoMapper());
		
		logger.info("Se han recuperado todos los cursos");
		
		return cursos;
	}

	@Override
	public Curso getById(int codigo) {
		template = new JdbcTemplate(this.dataSource);
		
		curso = template.queryForObject(sqlprocgetById, new CursoMapper(),new Object[]{codigo});
		logger.info(" Se ha recuperado el curso con codigo" + codigo + " - " + curso.toString());
		
		return curso;
	}

	@Override
	public Curso update(Curso curso) {
		this.jdbcCall = new SimpleJdbcCall(this.dataSource);
		
		// Se asigna el nombre del procedimiento almacenado
		jdbcCall.withProcedureName(sqlprocupdate);
		
		// Crear un mapa con los parametros de procedimiento almacenado  de entrada IN
		SqlParameterSource in = new MapSqlParameterSource().addValue("pCodCurso",curso.getCodCurso())
				.addValue("pNomCurso", curso.getNomCurso())
				.addValue("pcodigo", curso.getCodigo());
		
		jdbcCall.execute(in);
		
		logger.info(" Se ha actualizado el curso con codigo" + curso.getCodigo() + " - " + curso.toString());
		
		return curso;
	}

	@Override
	public void delete(int codigo) {
		
		this.jdbcCall = new SimpleJdbcCall(this.dataSource);
		
		SqlParameterSource in = new MapSqlParameterSource().addValue("pcodigo", codigo);
		jdbcCall.withProcedureName(sqlprocdelete);
		jdbcCall.execute(in);
		logger.info("Se ha borrado el cliente con codigo " + String.valueOf(codigo));

	}

	@Override
	public List<Curso> getLastTen() {
		
		template = new JdbcTemplate(this.dataSource);
		cursos = template.query(sqlprocgetLastTen, new CursoMapper());
		
		logger.debug("Se han recuperado los ultimos 10 cursos");
		
		return cursos;
	}

	@Override
	public List<Curso> getSearch(String busqueda) {
		
			template = new JdbcTemplate(this.dataSource);
			//logger.info("Dentro " + sqlprocgetSearch  );
			cursos = template.query(sqlprocgetSearch, new Object[]{busqueda},new CursoMapper());
			
			logger.info(" Se ha recuperado los cursos con criterio de busqueda %" + busqueda + "%");
	
	
		
		return cursos;
	}
	
	@Override
	public boolean getByCodCurso(Curso curso) {
	   	boolean resultado = false;    
	   	Curso aux;
		template = new JdbcTemplate(this.dataSource);
		
		try {
			
			String codigoCurso = curso.getCodCurso();
			aux =  template.queryForObject(sqlprocCodCursoDuplicado, new CursoMapper(),new Object[]{codigoCurso});
		} catch (EmptyResultDataAccessException e) {
			aux = new Curso();
			logger.debug("Curso CodigoCurso  nulo");
			
		}catch(Exception e){
			aux = new Curso();
			e.printStackTrace();
			logger.error("Error al recuperar Curso CodCurso " + e.getMessage());
		}// fin del catch
		
		 
		    
			if (curso.getCodigo() != aux.getCodigo() && 
				curso.getCodCurso().equals(aux.getCodCurso())){
				resultado = true;
		}
			  
		
		return resultado;
	}

}
