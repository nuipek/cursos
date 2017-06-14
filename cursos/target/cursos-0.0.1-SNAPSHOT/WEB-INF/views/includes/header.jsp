<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html lang="es">
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js">
 </script>
  
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">


 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
 </script>
 
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<![endif]-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<header class="container-fluid">
<h1 class="row text-center"><spring:message code="aplicacion.nombre"  text="Aplicacion Cursos"/></h1>
<a href="<c:url value="/"/>"><img class="img-responsive center-block" alt="Imagen inicio" role="presentation" src="<c:url value='/resources/img/descarga.jpg'/>"></a>

</br>
</header>
 
</body>
</html>

