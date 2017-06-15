<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<spring:message var="men" code="form.crear" text="nombre" />

<jsp:include page="../includes/header.jsp" />
<main>
<c:if test="${curso.codigo > 0}" >
	<spring:message var="men"  code="form.editar" text="nombre" />
</c:if>   
<spring:message var="seccion" code="curso.titulo" text="curso" />
<c:url var="cancelUrl" value="/cursos"/>
<section class="col-xs-12">

		<form:form action="save" method="post" cssClass="form-horizontal"  modelAttribute="curso"> 
			<c:if test="${!empty curso}">
				<form:hidden path="codigo"/>
			</c:if>
			<div class = "form-group">
				<form:label cssClass ="control-label col-xs-2" path="codCurso">Codigo Curso</form:label>
				<div class="col-xs-5">
					<form:input placeholder="Introduzca el Codigo de Curso" path="codCurso" cssErrorClass="" cssClass="form-control"/>
				</div>
				<div class="col-xs-5">
				<form:errors path="codCurso" cssClass="text-danger" />
				</div>
			</div>
				<div class = "form-group">
				<form:label cssClass ="control-label col-xs-2" path="nomCurso">Nombre Curso</form:label>
				<div class="col-xs-5">
					<form:input placeholder="Introduzca el  Nombre del curso" path="nomCurso" cssErrorClass="" cssClass="form-control"/>
				</div>
				<div class="col-xs-5">
				<form:errors path="nomCurso" cssClass="text-danger" />
				</div>
			</div>
			
			<div class = "form-group ">
				<div class="col-xs-offset-3 col-xs-5">
			   	<c:set var="men" value="Crear"/>
			   	<c:if test="${curso.codigo > 0}">
			   		<c:set var="men" value="Editar"/>
			   	</c:if>
			   	<input type="submit" class="btn btn-info" value="${men}">
			   	<a class="btn btn-warning" href="${cancelUrl}">Cancelar</a>
			   </div>
			</div>
		</form:form>	

</section>
</main>
<footer>
<jsp:include page="../includes/footer.jsp" />
</footer>
</html>
