<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
   <section class="row">
   	<header class="col-xs-12"><h2 class="text-center text-capitalize">Listado de Cursos</h2></header>
   	<a class="btn btn-info "  href="<c:url value='cursos/addCurso'/>">Añadir Curso </a>
   	<div class="col-xs-12">
		<!-- Si se anidan las columnas tiene que haber un row -->
			<div class="row">
				<div class="col-xs-2">Codigo Curso</div>
				<div class="col-xs-5">Nombre Curso</div>
				<div class="col-xs-5">Acciones</div>
			</div>
		</div>	
   </section>
	<section class="col-xs-12">
	
			<c:forEach var="curso" items="${listadoCursos}">
				<div class="row">
					<div class="col-xs-2">${curso.codCurso}</div>
					<div class="col-xs-5">${curso.nomCurso}</div>
					<div class="col-xs-5">
						<a class ="btn btn-info" href="<c:url value='cursos/${curso.codigo}'/>">Editar</a>
		 				<a class ="btn btn-danger" href="<c:url value='cursos/deleteCurso/${curso.codigo}'/>">Borrar</a>
		 			</div>
				</div>	
			</c:forEach>
	</section>

