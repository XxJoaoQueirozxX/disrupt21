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
        <link rel="stylesheet" href="css/personagem.css">
	</head>
	<body>
		<%@ include file="snippets/menu.jsp" %>
		
		<div id="conteudo">
            <header class="header">
                <span style="cursor:pointer;" id="menu-botao" onclick="openNav()">&#9776;</span>
            	<h1>${ personagem.getNome() }</h1>
            </header>
     			
            <main>
		
				<p class="col-10 offset-1 ">
		            <img alt="${ personagem.getAtor()} como ${ personagem.getNome() }" class="foto-personagem" src="${ personagem.getUrlFoto() }">
					${personagem.getDescricao() }
				<p>
				
				<table class="table col-10 offset-1 col-sm-8 offset-sm-2 col-md-6 offset-md-3 border">
					<thead>
						<tr>
							<th colspan="2" style="text-align:center;">informaçoes</th>
						</tr>
					</thead>
			
					<tbody>
						<tr>
							<td>ATOR</td>
							<td>${ personagem.getAtor() }</td>
						</tr>
						<tr>
							<td>RELAÇÃO COM O PERSONAGEM PRINCIPAL</td>
							<td>${ personagem.getRelacao() }</td>
						</tr>
						<tr>
							<td>VIAJANTE DO TEMPO</td>
							<td>
								<c:choose>
									<c:when test="${ personagem.isViajante() }">Sim</c:when>
									<c:otherwise>Não</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td>VERSÃO ALTERNATIVA</td>
							<td>
								<c:choose>
									<c:when test="${ personagem.isAlternativo() }">Sim</c:when>
									<c:otherwise>Não</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</tbody>					
				</table>
            </main>
        </div>
        
	
        <%@ include file="snippets/scripts.html" %>
	</body>
</html>