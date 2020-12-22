package br.com.bttf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.bttf.beans.Acontecimento;
import br.com.bttf.beans.Consequencia;
import br.com.bttf.beans.Personagem;
import br.com.bttf.conexao.Conexao;
import br.com.bttf.interfaces.DAOFactory;

public class AcontecimentoDAO implements DAOFactory<Acontecimento> {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet result;
	
	public AcontecimentoDAO() throws Exception {
		con = Conexao.conectar();
	}

	@Override
	public int insert(Acontecimento o) throws Exception {

		stmt = con.prepareStatement("INSERT INTO T_BTTF_ACONTECIMENTO\r\n" + 
				"(ID_ACONTECIMENTO, DS_ACONTECIMENTO, NM_ACONTECIMENTO, DT_ACONTECIMENTO, BL_ALTERNATIVO, URL_FOTO)\r\n" + 
				"VALUES (SQ_T_BTTF_ACONTECIMENTO.NEXTVAL, ?, ?, ?, ?, ?)");
				
		stmt.setString(1, o.getDescricao());		
		stmt.setString(2, o.getNome());
		stmt.setDate(3, Date.valueOf(o.getData()));
		stmt.setBoolean(4, o.isAlternativo());
		stmt.setString(5, o.getUrlFoto());		
		return stmt.executeUpdate();
	}

	@Override
	public int update(Acontecimento o) throws Exception {
		stmt = con.prepareStatement("UPDATE T_BTTF_ACONTECIMENTO\r\n" + 
				"SET DS_ACONTECIMENTO = ?, NM_ACONTECIMENTO = ?, DT_ACONTECIMENTO = ?, BL_ALTERNATIVO = ?, URL_FOTO = ?\r\n" + 
				"WHERE ID_ACONTECIMENTO = ?");
		
		stmt.setString(1, o.getDescricao());		
		stmt.setString(2, o.getNome());
		stmt.setDate(3, Date.valueOf(o.getData()));
		stmt.setBoolean(4, o.isAlternativo());
		stmt.setString(5, o.getUrlFoto());		
		return stmt.executeUpdate();
	}

	@Override
	public int delete(int id) throws Exception {
		stmt = con.prepareStatement("DELETE T_BTTF_ACONTECIMENTO WHERE ID_ACONTECIMENTO = ?");
		stmt.setInt(1, id);
		return stmt.executeUpdate();
	}

	@Override
	public Acontecimento selectByID(int id) throws Exception {		
		stmt = con.prepareStatement("SELECT A.ID_ACONTECIMENTO, A.DS_ACONTECIMENTO,\r\n" + 
				"	   A.NM_ACONTECIMENTO, A.DT_ACONTECIMENTO,\r\n" + 
				"	   A.BL_ALTERNATIVO, A.URL_FOTO,\r\n" + 
				"	   C.ID_CONSEQUENCIA, C.DS_CONSEQUENCIA\r\n" + 
				"FROM T_BTTF_ACONTECIMENTO A \r\n" + 
				"INNER JOIN T_BTTF_CONSEQUENCIA C\r\n" + 
				"ON A.ID_ACONTECIMENTO = C.ID_ACONTECIMENTO\r\n" + 
				"WHERE A.ID_ACONTECIMENTO = ?");
		
		stmt.setInt(1, id);	
		Acontecimento acontecimento = new Acontecimento();		
		result = stmt.executeQuery();		
		if (result.next()) {
			acontecimento.setId(result.getInt("ID_ACONTECIMENTO"));
			acontecimento.setDescricao(result.getString("DS_ACONTECIMENTO"));
			acontecimento.setNome(result.getString("NM_ACONTECIMENTO"));		
			acontecimento.setData(result.getDate("DT_ACONTECIMENTO").toLocalDate());		
		    acontecimento.setAlternativo(result.getBoolean("BL_ALTERNATIVO"));
			acontecimento.setUrlFoto(result.getString("URL_FOTO"));	
			
			Consequencia consequencia = new Consequencia();
			consequencia.setId(result.getInt("ID_CONSEQUENCIA"));
			consequencia.setDescricao(result.getNString("DS_CONSEQUENCIA"));
			acontecimento.setConsequencia(consequencia);
		}	
		
		stmt = con.prepareStatement("SELECT \r\n" + 
				"	    P.ID_PERSONAGEM,\r\n" + 
				"       P.NM_PERSONAGEM,\r\n" + 
				"       P.NM_ATOR,\r\n" + 
				"       P.DS_PERSONAGEM,\r\n" + 
				"       P.RELACAO_MARTY,\r\n" + 
				"       P.URL_FOTO,\r\n" + 
				"       P.BL_VIAJANTE,\r\n" + 
				"       P.BL_ALTERNATIVO\r\n" + 
				"FROM ((T_BTTF_PERSONAGEM_ACONT PC\r\n" + 
				"INNER JOIN T_BTTF_ACONTECIMENTO A ON PC.ID_ACONTECIMENTO = A.ID_ACONTECIMENTO)\r\n" + 
				"INNER JOIN T_BTTF_PERSONAGEM P ON PC.ID_PERSONAGEM = P.ID_PERSONAGEM)\r\n" + 
				"WHERE A.ID_ACONTECIMENTO = ?");
		
		stmt.setInt(1, id);	
		result = stmt.executeQuery();
		List<Personagem> lstGetPersonagem = new ArrayList<Personagem>();
		
		while (result.next()) {
			Personagem p = new Personagem();
			p.setId(result.getInt("ID_PERSONAGEM"));
			p.setNome(result.getString("NM_PERSONAGEM"));
			p.setAtor(result.getString("NM_ATOR"));
			p.setDescricao(result.getString("DS_PERSONAGEM"));
			p.setRelacao(result.getString("RELACAO_MARTY"));
			p.setUrlFoto(result.getString("URL_FOTO"));
			p.setViajante(result.getBoolean("BL_VIAJANTE"));
			p.setAlternativo(result.getBoolean("BL_ALTERNATIVO"));
			
			lstGetPersonagem.add(p);		
		}
			
		acontecimento.setPersonagens(lstGetPersonagem);
		return acontecimento;
	}

	@Override
	public List<Acontecimento> selectAll() throws Exception {
		List<Acontecimento> acont = new ArrayList<Acontecimento>();
		stmt = con.prepareStatement("SELECT A.ID_ACONTECIMENTO, A.DS_ACONTECIMENTO,\r\n" + 
				"	   A.NM_ACONTECIMENTO, A.DT_ACONTECIMENTO,\r\n" + 
				"	   A.BL_ALTERNATIVO, A.URL_FOTO,\r\n" + 
				"	   C.ID_CONSEQUENCIA, C.DS_CONSEQUENCIA\r\n" + 
				"FROM T_BTTF_ACONTECIMENTO A \r\n" + 
				"INNER JOIN T_BTTF_CONSEQUENCIA C\r\n" + 
				"ON A.ID_ACONTECIMENTO = C.ID_ACONTECIMENTO");
		
		result = stmt.executeQuery();
	
		while (result.next()) {
			Acontecimento acontecimento = new Acontecimento();
			acontecimento.setId(result.getInt("ID_ACONTECIMENTO"));
			acontecimento.setDescricao(result.getString("DS_ACONTECIMENTO"));
			acontecimento.setNome(result.getString("NM_ACONTECIMENTO"));		
			acontecimento.setData(result.getDate("DT_ACONTECIMENTO").toLocalDate());		
		    acontecimento.setAlternativo(result.getBoolean("BL_ALTERNATIVO"));
			acontecimento.setUrlFoto(result.getString("URL_FOTO"));		
			
			Consequencia consequencia = new Consequencia();
			consequencia.setId(result.getInt("ID_CONSEQUENCIA"));
			consequencia.setDescricao(result.getNString("DS_CONSEQUENCIA"));			
			acontecimento.setConsequencia(consequencia);
			
			stmt = con.prepareStatement("SELECT \r\n" + 
					"	    P.ID_PERSONAGEM,\r\n" + 
					"       P.NM_PERSONAGEM,\r\n" + 
					"       P.NM_ATOR,\r\n" + 
					"       P.DS_PERSONAGEM,\r\n" + 
					"       P.RELACAO_MARTY,\r\n" + 
					"       P.URL_FOTO,\r\n" + 
					"       P.BL_VIAJANTE,\r\n" + 
					"       P.BL_ALTERNATIVO\r\n" + 
					"FROM ((T_BTTF_PERSONAGEM_ACONT PC\r\n" + 
					"INNER JOIN T_BTTF_ACONTECIMENTO A ON PC.ID_ACONTECIMENTO = A.ID_ACONTECIMENTO)\r\n" + 
					"INNER JOIN T_BTTF_PERSONAGEM P ON PC.ID_PERSONAGEM = P.ID_PERSONAGEM)\r\n" + 
					"WHERE A.ID_ACONTECIMENTO = ?");
			
			stmt.setInt(1, acontecimento.getId());	
			ResultSet rs = stmt.executeQuery();
			List<Personagem> personagem = new ArrayList<Personagem>();
			
			while (rs.next()) {
				Personagem p = new Personagem();
				p.setId(rs.getInt("ID_PERSONAGEM"));
				p.setNome(rs.getString("NM_PERSONAGEM"));
				p.setAtor(rs.getString("NM_ATOR"));
				p.setDescricao(rs.getString("DS_PERSONAGEM"));
				p.setRelacao(rs.getString("RELACAO_MARTY"));
				p.setUrlFoto(rs.getString("URL_FOTO"));
				p.setViajante(rs.getBoolean("BL_VIAJANTE"));
				p.setAlternativo(rs.getBoolean("BL_ALTERNATIVO"));	
				personagem.add(p);		
			}
			acontecimento.setPersonagens(personagem);
			acont.add(acontecimento);		
		}
		return acont;
	}
	
	
	public List<Acontecimento> selectAllByNrLinha(int nrLinha) throws Exception {
		List<Acontecimento> acont = new ArrayList<Acontecimento>();
		stmt = con.prepareStatement("SELECT A.ID_ACONTECIMENTO, A.DS_ACONTECIMENTO,\r\n" + 
				"	   A.NM_ACONTECIMENTO, A.DT_ACONTECIMENTO,\r\n" + 
				"	   A.BL_ALTERNATIVO, A.URL_FOTO,\r\n" + 
				"	   C.ID_CONSEQUENCIA, C.DS_CONSEQUENCIA\r\n" + 
				"FROM T_BTTF_ACONTECIMENTO A \r\n" + 
				"INNER JOIN T_BTTF_CONSEQUENCIA C\r\n" + 
				"ON A.ID_ACONTECIMENTO = C.ID_ACONTECIMENTO\r\n" +
				"WHERE A.TIMELINE = ?");
		
		stmt.setInt(1, nrLinha);
		
		result = stmt.executeQuery();
	
		while (result.next()) {
			Acontecimento acontecimento = new Acontecimento();
			acontecimento.setId(result.getInt("ID_ACONTECIMENTO"));
			acontecimento.setDescricao(result.getString("DS_ACONTECIMENTO"));
			acontecimento.setNome(result.getString("NM_ACONTECIMENTO"));		
			acontecimento.setData(result.getDate("DT_ACONTECIMENTO").toLocalDate());		
		    acontecimento.setAlternativo(result.getBoolean("BL_ALTERNATIVO"));
			acontecimento.setUrlFoto(result.getString("URL_FOTO"));		
			
			Consequencia consequencia = new Consequencia();
			consequencia.setId(result.getInt("ID_CONSEQUENCIA"));
			consequencia.setDescricao(result.getNString("DS_CONSEQUENCIA"));			
			acontecimento.setConsequencia(consequencia);
			
			stmt = con.prepareStatement("SELECT \r\n" + 
					"	    P.ID_PERSONAGEM,\r\n" + 
					"       P.NM_PERSONAGEM,\r\n" + 
					"       P.NM_ATOR,\r\n" + 
					"       P.DS_PERSONAGEM,\r\n" + 
					"       P.RELACAO_MARTY,\r\n" + 
					"       P.URL_FOTO,\r\n" + 
					"       P.BL_VIAJANTE,\r\n" + 
					"       P.BL_ALTERNATIVO\r\n" + 
					"FROM ((T_BTTF_PERSONAGEM_ACONT PC\r\n" + 
					"INNER JOIN T_BTTF_ACONTECIMENTO A ON PC.ID_ACONTECIMENTO = A.ID_ACONTECIMENTO)\r\n" + 
					"INNER JOIN T_BTTF_PERSONAGEM P ON PC.ID_PERSONAGEM = P.ID_PERSONAGEM)\r\n" + 
					"WHERE A.ID_ACONTECIMENTO = ?");
			
			stmt.setInt(1, acontecimento.getId());	
			ResultSet rs = stmt.executeQuery();
			List<Personagem> personagem = new ArrayList<Personagem>();
			
			while (rs.next()) {
				Personagem p = new Personagem();
				p.setId(rs.getInt("ID_PERSONAGEM"));
				p.setNome(rs.getString("NM_PERSONAGEM"));
				p.setAtor(rs.getString("NM_ATOR"));
				p.setDescricao(rs.getString("DS_PERSONAGEM"));
				p.setRelacao(rs.getString("RELACAO_MARTY"));
				p.setUrlFoto(rs.getString("URL_FOTO"));
				p.setViajante(rs.getBoolean("BL_VIAJANTE"));
				p.setAlternativo(rs.getBoolean("BL_ALTERNATIVO"));	
				personagem.add(p);		
			}
			acontecimento.setPersonagens(personagem);
			acont.add(acontecimento);		
		}
		return acont;
	}
	
	
	

	@Override
	public void close() throws Exception {
		con.close();
	}
}