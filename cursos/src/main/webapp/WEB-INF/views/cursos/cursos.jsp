<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<jsp:include page="../includes/header.jsp" />

<main class="container-fluid">
   <section class="row">
   	<header class="col-xs-12"><h2 class="text-center text-capitalize">Listado de Cursos</h2></header>
   </section>
   <section class="row">
     <div class="container">
     <c:if test="${not empty mensaje}">
        <div class="${mensaje.type}">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>${mensaje.msg}</strong> 
        </div>
    </c:if>
  </div>	
  </section>
  <section class="row">
   	<a class="btn btn-info "  href="<c:url value='cursos/addCurso'/>">Añadir Curso </a>
   	<div class="col-xs-12">
		<!-- Si se anidan las columnas tiene que haber un row -->
			<div class="row">
				<div class="col-xs-2">Codigo Curso</div>
				<div class="col-xs-7">Nombre Curso</div>
				<div class="col-xs-3">Acciones</div>
			</div>
		</div>	
   </section>
	<section class="col-xs-12">
		<c:forEach var="curso" items="${listadoCursos}">
			<div class="row">
				<div class="col-xs-2">${curso.codCurso}</div>
				<div class="col-xs-7">${curso.nomCurso}</div>
				<div class="col-xs-3">
					<a class ="btn btn-info" href="<c:url value='cursos/${curso.codigo}'/>">Editar</a>
					<button type="button" class="btn btn-danger direccion" data-toggle="modal"  data-direccion="<c:url value='cursos/deleteCurso/${curso.codigo}'/>"  data-target="#confirmacion">
					 Borrar
					</button>
		 			<!-- 	<a class ="btn btn-danger direccion"  data-toggle="modal"  data-target="#confirmacion" href="<c:url value='cursos/deleteCurso/${curso.codigo}'/>">Borrar</a> -->
	 			</div>
			</div>	
		</c:forEach>
	</section>
</main>
<!-- Modal -->
<div class="modal fade" id="confirmacion" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Eliminar</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ¿Desea realmente borrar el curso?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <a class ="btn btn-primary" href="<c:url value='cursos/deleteCurso/${curso.codigo}'/>">Confirmar</a>
      </div>
    </div>
  </div>
</div>
<footer>
<jsp:include page="../includes/footer.jsp" />
</footer>
</body>
</html>

   

