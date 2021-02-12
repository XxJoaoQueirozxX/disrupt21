package br.com.bttf.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	public static Connection conectar() throws Exception{
		String dbURL = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		String user = "xxxxxxxxx";
		String pwd = "xxxxxxxxx";
		Class.forName("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection(dbURL, user, pwd);
	}
}
