<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:message var="titulo" code="aplicacion.nombre" />
<c:set scope="application" var="seccion" value="${titulo}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${titulo}</title>
</head>
<body>
 
<jsp:include page="includes/header.jsp" />
<!-- <header class="col-xs-12"><h1 class="text-center text-capitalize"><spring:message code="aplicacion.nombre"  text="Aplicacion Cursos"/></h1></header> -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-braand" href="<c:url value="/"/>"><img style="max-width:90px" src="<c:url value='/resources/img/descarga.jpg'/>"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="<c:url value='cursos'/>"><spring:message code="inicio.menu.catologo"  text="Administracion de Catalogo de Cursos"/></a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<main>
<div class="container">
     <c:if test="${not empty mensaje}">
        <div class="${mensaje.type}">
            <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
            <strong>${mensaje.msg}</strong> 
        </div>
    </c:if>
  </div>	
 <!-- Aqui mostramos los 10 ultimos cursos creados -->
  <div class="container-fluid">
	  <section class="row">
	   	<header class="col-xs-12"><h2 class="text-center text-capitalize">Listado de los ultimos Cursos</h2></header>
	   	<div class="col-xs-12">
			<!-- Si se anidan las columnas tiene que haber un row -->
				<div class="row">
					<div class="col-xs-3">Codigo Curso</div>
					<div class="col-xs-9">Nombre Curso</div>
				</div>
			</div>	
	   </section>
		<section class="col-xs-12">
			<c:forEach var="curso" items="${listadoUltimosCursos}">
				<div class="row">
					<div class="col-xs-3">${curso.codCurso}</div>
					<div class="col-xs-9">${curso.nomCurso}</div>
				</div>	
			</c:forEach>
		</section>
  </div>
</main>
<footer>
<jsp:include page="includes/footer.jsp"/> 
</footer>
</body>
</html>