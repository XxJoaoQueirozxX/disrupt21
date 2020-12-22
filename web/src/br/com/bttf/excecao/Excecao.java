package br.com.bttf.excecao;

import java.sql.SQLClientInfoException;

public class Excecao  extends Exception{

	private static final long serialVersionUID = 1L;

	public static String tratarExcecao(Exception e) {
		if (e instanceof NullPointerException) {
			return "Sem valor";
		} else if (e instanceof NumberFormatException) {
			e.printStackTrace();
			return "Valor nao e um numero";
		} else if (e instanceof SQLClientInfoException) {
			return "Erro no banco de dados";
		}else {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
