package com.saparicio.proyecto.controller.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.saparicio.proyecto.dbms.pojo.Curso;

public class CursoValidator implements Validator {

	private static final Logger logger = LoggerFactory.getLogger(CursoValidator.class);
	
	@Override
	public boolean supports(Class<?> paramClass) {
		
		  return Curso.class.equals(paramClass);
		
		/*boolean resultado =  Curso.class.isAssignableFrom(paramClass);
		  return resultado;
		*/
		
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		Curso curso = (Curso)obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codCurso", "form.curso.codigoCursoRequerido", "El codigo del curso debe estar informado.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nomCurso","form.curso.nombreRequerido", "El nombre del curso debe estar informado.");
		
		
		if (curso.getCodCurso().length()> 50){
			 errors.rejectValue("codCurso", "WrongSize", 
					 			new Object[]{"'codCurso'"}, "Tamaño Incorrecto, debe ser menor de 50 caracteres");
		 
		 }
		
		if (curso.getNomCurso().length()> 200){
			 errors.rejectValue("nomCurso", "WrongSize", 
					 			new Object[]{"'nomCurso'"}, "Tamaño Incorrecto, debe ser menor de 200 caracteres");
		 
		 }
	
		
		 
	}
}