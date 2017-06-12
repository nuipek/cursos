<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<c:set scope="request" var="seccion" value="Login"/>
<jsp:include page="includes/header.jsp" />
<main class="container-fluid">
	<section>
		<header><h2>Login</h2></header>
		<c:if test="${not empty error}">
           <div class="alert alert-danger">
				<p>Nombre de usuario o contraseña incorrectos.</p>
			</div>
        </c:if>
		<c:url var="loginURL" value="/login"/>
		<form:form action="${loginURL}" method="post">
			<div class="input-group input-sm">
					<label>usuario:</label>
				<input value="${SPRING_SECURITY_LAST_USERNAME}" type="text" id="userId" name="userId" required/>
			</div>
			<div class="input-group input-sm">
				<label>Password:</label>
				<input type="password" id="password" name="password" required/>
			</div>
			
			<input type="submit" value="Log In" class="btn btn-block btn-primary"/>
		</form:form>
	
	</section>
</main>
<footer>
<jsp:include page="includes/footer.jsp"/> 
</footer>
</body>
</html>