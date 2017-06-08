package com.saparicio.proyecto.dbms.pojo;

import java.io.Serializable;


public class Curso implements Comparable<Curso>, Serializable{

	private static final long serialVersionUID = 1L;
	public static final int CODIGO_NULO = -1;
	
	private int 	codigo;
	private String 	nomCurso;
	private String 	codCurso;


	public Curso() {
		super();
		this.codigo = CODIGO_NULO;
		this.nomCurso="";
		this.codCurso="";
		
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNomCurso() {
		return nomCurso;
	}
	
	public void setNomCurso(String nomCurso) {
		this.nomCurso = nomCurso;
	}

	public String getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;
	}

	@Override
	public String toString() {
		
		return this.getCodigo() + " " +  this.getCodCurso() + " " +  this.getNomCurso() ;
		
	}

	@Override
	public int compareTo(Curso o) {
		//return this.codigo - o.getCodigo();
		return this.nomCurso.compareToIgnoreCase(o.getNomCurso());
		// return  o.getCodigo() - this.codigo; DE MAYOR A MENOR
	}

	@Override
	public boolean equals(Object obj) {
	boolean resultado = false;
	if (obj != null && obj instanceof  Curso)
	{
		if (this == obj)
			resultado = true;
		else
		{
		  if (this.codigo == ((Curso)obj).getCodigo())
			  resultado = true;
		}
		
	}
		return resultado;
	}

}



