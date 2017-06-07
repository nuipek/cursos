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
<!-- <header class="col-xs-12"><h2 class="text-center text-capitalize"><spring:message code="aplicacion.nombre"  text="Aplicacion Euskalikea"/></h2></header> -->
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
      <a class="navbar-braand" href="<c:url value="/"/>"><img style="max-width:60px" src="<c:url value='/resources/img/descarga.png'/>"></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="<c:url value='ventas'/>"><spring:message code="inicio.menu.ventas"  text="Gestion de Ventas"/><span class="sr-only">(current)</span></a></li>
        <li><a href="<c:url value='productos'/>"><spring:message code="inicio.menu.catologo"  text="Administracion de Catalogo"/></a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Idiomas <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a class="btn btn-default" href="?locale=es_ES"><spring:message code="idioma.castellano"  text="Castellano"/></a></li>
            <li><a class="btn btn-default"  href="?locale=en_EN"><spring:message code="idioma.ingles" text="Ingles" /></a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<!-- 

<main class="container-fluid"> 
<div class="btn-group">
		<button class="btn btn-default btn-lg dropdown-toggle" data-toggle="dropdown"><spring:message code="idioma.idioma"  text="Idiomas"/><span class="caret"></span>
		</button>
		<ul class="dropdown-menu" >
			<li>
				<a class="btn btn-default" href="?locale=es_ES">				
					<spring:message code="idioma.castellano"  text="Castellano"/>       
				</a>
			</li>
			<li>
				<a class="btn btn-default"  href="?locale=en_EN">
					<spring:message code="idioma.ingles" text="Ingles" />       
				</a>
			</li>
						
		</ul>
	</div>

<div class="row">
	<a  class="btn btn-lg btn-info" href="<c:url value='productos'/>"><spring:message code="inicio.menu.catologo"  text="Administracion de Catalogo"/></a>
</div>
<div class="row">
	<a  class="btn btn-lg btn-success"  href="<c:url value='ventas'/>"><spring:message code="inicio.menu.ventas"  text="Gestion de Ventas"/></a>
</div>
 -->
</main>
<footer>
<jsp:include page="includes/footer.jsp"/> 
</footer>
</body>
</html>