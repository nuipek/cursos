package com.saparicio.proyecto.dbms.dao.interfaces;

import javax.sql.DataSource;

/**
 * Esta Interfaz define el metodo de inicializacion de la conexion a la DB
 * @author Sergio aparicio
 *
 */


public interface DAOSetter {

	public void setDataSource(DataSource dataSource);
	
}
