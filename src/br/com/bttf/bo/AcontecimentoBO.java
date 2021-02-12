package br.com.bttf.bo;

import java.util.List;

import br.com.bttf.beans.Acontecimento;
import br.com.bttf.dao.AcontecimentoDAO;


public class AcontecimentoBO {

	public static Acontecimento getAcontecimentoByID(int id) throws Exception{
		if (id < 0) {
			return null;
		}
		
		AcontecimentoDAO dao = new AcontecimentoDAO();
		Acontecimento a = dao.selectByID(id);
		dao.close();
		return a;
	}

	public static List<Acontecimento> getAllAcontecimentos() throws Exception{
		
		AcontecimentoDAO dao = new AcontecimentoDAO();
		List<Acontecimento> acontecimentos = dao.selectAll();
		dao.close();
		
		return acontecimentos;
	}
	
	public static List<Acontecimento> getAllAcontecimentosByNrLinha(int nrLinha) throws Exception{
		if (nrLinha < 0) {
			return null;
		}
		
		AcontecimentoDAO dao = new AcontecimentoDAO();
		List<Acontecimento> a = dao.selectAllByNrLinha(nrLinha);
		dao.close();
		
		return a;
		
	}
}
