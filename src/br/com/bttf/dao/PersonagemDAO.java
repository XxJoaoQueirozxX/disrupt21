package br.com.bttf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.bttf.beans.Personagem;
import br.com.bttf.conexao.Conexao;
import br.com.bttf.interfaces.DAOFactory;

public class PersonagemDAO implements DAOFactory<Personagem> {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet result;
	
	
	public PersonagemDAO() throws Exception{
		con = Conexao.conectar();
	}
	
	
	@Override
	public int insert(Personagem o) throws Exception {
		
		stmt = con.prepareStatement("INSERT INTO T_BTTF_PERSONAGEM\r\n" + 
				"(ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO)\r\n" + 
				"VALUES (SQ_T_BTTF_PERSONAGEM.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
		
		stmt.setString(1, o.getNome());
		stmt.setString(2, o.getAtor());
		stmt.setString(3, o.getDescricao());
		stmt.setString(4, o.getRelacao());
		stmt.setString(5, o.getUrlFoto());
		stmt.setBoolean(6, o.isViajante());
		stmt.setBoolean(7, o.isAlternativo());
		
		return stmt.executeUpdate();
	}

	@Override
	public int update(Personagem o) throws Exception {
		
		stmt = con.prepareStatement("UPDATE T_BTTF_PERSONAGEM\r\n" + 
				"SET NM_PERSONAGEM = ?, NM_ATOR = ?, DS_PERSONAGEM = ?, RELACAO_MARTY = ?, URL_FOTO = ?, BL_VIAJANTE = ?, BL_ALTERNATIVO = ?\r\n" + 
				"WHERE ID_PERSONAGEM = ?");
		
		stmt.setString(1, o.getNome());
		stmt.setString(2, o.getAtor());
		stmt.setString(3, o.getDescricao());
		stmt.setString(4, o.getRelacao());
		stmt.setString(5, o.getUrlFoto());
		stmt.setBoolean(6, o.isViajante());
		stmt.setBoolean(7, o.isAlternativo());
		
		return stmt.executeUpdate();
	}

	@Override
	public int delete(int id) throws Exception {
		
		stmt = con.prepareStatement("DELETE T_BTTF_PERSONAGEM WHERE ID_PERSONAGEM = ?");
					
	    stmt.setInt(1, id);
		
		return stmt.executeUpdate();
	}

	@Override
	public Personagem selectByID(int id) throws Exception {
		// TODO Auto-generated method stub
		stmt = con.prepareStatement("SELECT ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, "
				+ "DS_PERSONAGEM, RELACAO_MARTY, URL_FOTO, "
				+ "BL_VIAJANTE, BL_ALTERNATIVO\r\n" + 
				"FROM T_BTTF_PERSONAGEM\r\n" +
				"WHERE ID_PERSONAGEM = ?");
	
		stmt.setInt(1, id);
		result = stmt.executeQuery();
		
		Personagem p = new Personagem();
		
		if (result.next()) {
			
			p.setId(result.getInt("ID_PERSONAGEM"));
			p.setNome(result.getString("NM_PERSONAGEM"));
			p.setAtor(result.getString("NM_ATOR"));
			p.setDescricao(result.getString("DS_PERSONAGEM"));
			p.setRelacao(result.getString("RELACAO_MARTY"));
			p.setUrlFoto(result.getString("URL_FOTO"));
			p.setViajante(result.getBoolean("BL_VIAJANTE"));
			p.setAlternativo(result.getBoolean("BL_ALTERNATIVO"));
		}

		return p;
	}
	
	@Override
	public List<Personagem> selectAll() throws Exception {
		
		List<Personagem> lstGetAllPersonagens = new ArrayList<Personagem>();
		
		stmt = con.prepareStatement("SELECT ID_PERSONAGEM, NM_PERSONAGEM, NM_ATOR, "
				+ "DS_PERSONAGEM, "
				+ "RELACAO_MARTY, URL_FOTO, BL_VIAJANTE, BL_ALTERNATIVO\r\n" + 
				"FROM T_BTTF_PERSONAGEM");
		
		result = stmt.executeQuery();
		
		while (result.next()) {
			Personagem personagem = new Personagem();
			personagem.setId(result.getInt("ID_PERSONAGEM"));
			personagem.setNome(result.getString("NM_PERSONAGEM"));
			personagem.setAtor(result.getString("NM_ATOR"));
			personagem.setDescricao(result.getString("DS_PERSONAGEM"));
			personagem.setRelacao(result.getString("RELACAO_MARTY"));
			personagem.setUrlFoto(result.getString("URL_FOTO"));
			personagem.setViajante(result.getBoolean("BL_VIAJANTE"));
			personagem.setAlternativo(result.getBoolean("BL_ALTERNATIVO"));
			
			lstGetAllPersonagens.add(personagem);
		}

		return lstGetAllPersonagens;
	}

	@Override
	public void close() throws Exception {
		con.close();		
	}
}