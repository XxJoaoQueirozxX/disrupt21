package br.com.bttf.interfaces;

import java.util.List;

public interface DAOFactory<T> {
	
	int insert(T o) throws Exception;
	
	int update(T o) throws Exception;
	
	int delete (int id) throws Exception;

	T selectByID(int id) throws Exception;
	
	List<T> selectAll() throws Exception;
	
	void close() throws Exception;
}