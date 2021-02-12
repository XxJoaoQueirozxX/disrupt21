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
        <link rel="stylesheet" href="css/index.css">
	</head>
	<body>
		<%@ include file="snippets/menu.jsp" %>
		
		<div id="conteudo">
            <header class="header">
                <span style="cursor:pointer;" id="menu-botao" onclick="openNav()">&#9776;</span>
                <div id="img-logo">
                    <a href="index.jsp"><img src="img/backtothefuture-logo-svg-vector.svg" alt=""></a>
                </div>
            </header>
            
            <main class="main">
				<p id="titulo" class="col-10 offset-1">
					<span class="filme-titulo">DE VOLTA PARA O FUTURO</span> considerado por muitos o melhor filme de viagem no tempo, por conseguir contemplar os gêneros de aventura, romance, comédia e ficção cientifica em uma mesma trama. Esse site foi desenvolvido com o intuito de fornecer informações sobre o filme e seus acontecimentos, para que assim o espectador consiga entender os multiplos acontecimentos de sua linha do tempo.
				</p>
            </main>
        </div>
        
        <%@ include file="snippets/scripts.html" %>
	</body>
</html>