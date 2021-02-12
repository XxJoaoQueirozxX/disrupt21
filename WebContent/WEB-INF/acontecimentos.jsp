<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>.: Acontecimentos :.</title>
		<%@ include file="snippets/css.jsp" %>
		
        <link rel="stylesheet" href="css/acontencimentos.css">
	</head>
	
	<body>
		<%@ include file="snippets/menu.jsp" %>
		<header class="header">
           	<span style="cursor:pointer;" id="menu-botao" onclick="openNav()">&#9776;</span>
        	<h1>ACONTECIMENTOS</h1>
        </header>
		
		<main class="col-10 offset-1 col-sm-10 offset-sm-1 col-md-8 offset-md-2 col-lg-6 offset-lg-3 mb-3">
				<c:forEach var="acontecimento" items="${ acontecimentos }">
					<%@ include file="snippets/acontecimentoCard.jsp" %>
				</c:forEach>
			<a class="btn col-8 col-sm-6 col-md-4 btn-voltar" href="${linkBotao }">${ textoBotao }</a>
		</main>
		
		<script src="js/menu-lateral.js"></script>
	</body>
</html>