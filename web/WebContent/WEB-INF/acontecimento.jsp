<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>.: DE VOLTA PRO FUTURO :.</title>
		<%@ include file="snippets/css.jsp" %>
	        <link rel="stylesheet" href="css/personagemCard.css">
    	    <link rel="stylesheet" href="css/acontecimento.css">
    	    <link>
        <style>
        
        </style>
	</head>
	<body>
		<%@ include file="../WEB-INF/snippets/menu.jsp" %>
		
		
		<div id="conteudo">
               <header class="header">
                    <span style="cursor:pointer;" id="menu-botao" onclick="openNav()">&#9776;</span>
                    <h1>${ acontecimento.getNome() }</h1>
               </header>
               
               <main class="main col-10 offset-1">
               		<img alt="" src="${ acontecimento.getUrlFoto() }" class="col-10 offset-1">
                    <p>
                         ${ acontecimento.getDescricao() }
                    </p>
                    
                    <c:if test="${ acontecimento.getConsequencia() != null}">
                    
	                    <div class="consequencia">
	                         <h3>CONSEQUENCIAS</h3>
	                         <ul>
		                         <li>
		                              ${ acontecimento.getConsequencia().getDescricao() }
		                         </li>
	                         </ul>
	                    </div>
                    
                    </c:if>
                    

                    <div id="personagens">
                         <h3>PERSONAGENS</h3>
                         <div>
						 	 <c:forEach var="personagem" items="${ acontecimento.getPersonagens() }">
						  		 <%@ include file="snippets/personagemCard.jsp" %>
						 	 </c:forEach>
						</div>
                    </div>
               </main>
               
               <footer class="footer">
                    <img src="img/backtothefuture-logo-svg-vector.svg" alt="">
               </footer>
		<%@ include file="snippets/scripts.html" %>
	</body>
</html>