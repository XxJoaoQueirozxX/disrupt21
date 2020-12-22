<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>.: PERSONAGENS :.</title>
		<%@ include file="snippets/css.jsp" %>
		
		
        <link rel="stylesheet" href="css/personagens.css">
		<link rel="stylesheet" href="css/personagemCard.css">
	</head>
	
	<body>
		<%@ include file="snippets/menu.jsp" %>
		<header class="header">
           	<span style="cursor:pointer;" id="menu-botao" onclick="openNav()">&#9776;</span>
        	<h1>PERSONAGENS</h1>
        </header>
		
		<div id="personagens" class="col-10 offset-1">		
			<c:forEach var="personagem" items="${ personagens }">
				<%@ include file="snippets/personagemCard.jsp" %>
			</c:forEach>
		</div>
		
		<script src="js/menu-lateral.js"></script>
	</body>
</html>