package br.com.bttf.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bttf.beans.Acontecimento;
import br.com.bttf.beans.Personagem;
import br.com.bttf.bo.AcontecimentoBO;
import br.com.bttf.bo.PersonagemBO;
import br.com.bttf.excecao.Excecao;


@WebServlet({ "/index.jsp", "/acontecimentos", "/personagens", "/file", "/personagem", "/acontecimento" })
public class BTTFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BTTFServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		switch (request.getRequestURI()) {
			case "/disrupt-storm-bttf/index.jsp":
				index(request, response);
				break;
			
			case "/disrupt-storm-bttf/acontecimentos":
				acontecimentos(request, response);
				break;
			
			case "/disrupt-storm-bttf/acontecimento":
				acontecimento(request, response);
				break;
			
			case "/disrupt-storm-bttf/personagens":
				personagens(request, response);
				break;

			case "/disrupt-storm-bttf/personagem":
				personagem(request, response);
				break;	
			
			case "/disrupt-storm-bttf/file":
				file(request, response);
				break;
				
			default:
				break;
		}
	}

	protected void index (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
	}	
	
	protected void acontecimentos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer nrLinha = Integer.parseInt(request.getParameter("linha"));
		try {
			
			List<Acontecimento> acontecimentos = AcontecimentoBO.getAllAcontecimentosByNrLinha(nrLinha);
			
			switch (nrLinha) {
				case 1:
					request.setAttribute("textoBotao", "1985 - 1955");
					request.setAttribute("linkBotao", "acontecimentos?linha=2");
					break;
				case 2:
					request.setAttribute("textoBotao", "1955 - 1985");
													
					request.setAttribute("linkBotao", "acontecimentos?linha=1");
					break;
				default:
					
			}
			request.setAttribute("acontecimentos", acontecimentos);
			request.getRequestDispatcher("WEB-INF/acontecimentos.jsp").forward(request, response);
		}catch (Exception e) {
			System.out.println(Excecao.tratarExcecao(e));
			response.sendRedirect("index.jsp");
		}
	}
	
	protected void acontecimento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		try {
			Acontecimento a = AcontecimentoBO.getAcontecimentoByID(id);
			request.setAttribute("acontecimento", a);
			request.getRequestDispatcher("WEB-INF/acontecimento.jsp").forward(request, response);
			
		}catch (Exception e) {
			System.out.println(Excecao.tratarExcecao(e));
			response.sendRedirect("index.jsp");
		}
		
		
	}
	
	protected void file(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt( request.getParameter("id"));
		switch(id) {
			case 1:
				request.getRequestDispatcher("WEB-INF/files/uml.pdf").forward(request, response); // UML
				break;
			case 2:
				request.getRequestDispatcher("WEB-INF/files/ml.pdf").forward(request, response); // Documento Machine Learn
				break;
			default:
				response.sendRedirect("index.jsp");
		}
	}
	
	protected void personagens(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Personagem> personagens = PersonagemBO.getAll();
			request.setAttribute("personagens", personagens);
			request.getRequestDispatcher("WEB-INF/personagens.jsp").forward(request, response);		
		}catch (Exception e) {
			System.out.println(Excecao.tratarExcecao(e));
			System.out.println(e.getMessage());
			e.printStackTrace();
			response.sendRedirect("index.jsp");
		}		
	}
	
	protected void personagem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		if (id != null) {
			try {
				Personagem p = PersonagemBO.getByID(id); 
				request.setAttribute("personagem", p);
				request.getRequestDispatcher("WEB-INF/personagem.jsp").forward(request, response);				
			} catch (Exception e) {
				System.out.println(Excecao.tratarExcecao(e));
				e.printStackTrace();
				
				response.sendRedirect("index.jsp");
			}
		}		
	}
}
