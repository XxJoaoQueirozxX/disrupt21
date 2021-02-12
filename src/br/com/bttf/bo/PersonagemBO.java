package br.com.bttf.bo;

import java.util.List;

import br.com.bttf.beans.Personagem;
import br.com.bttf.dao.PersonagemDAO;

public class PersonagemBO {

	public static Personagem getByID(int id) throws Exception{
		if (id < 0) {return null;}
		
		PersonagemDAO dao = new PersonagemDAO();
		Personagem p = dao.selectByID(id);
		dao.close();
		return p;
	}
	
	public static List<Personagem> getAll() throws Exception{
		PersonagemDAO dao = new PersonagemDAO();
		List<Personagem> personagens = dao.selectAll();
		dao.close();
		return personagens;
	}
}
