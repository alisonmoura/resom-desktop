package com.resom.dao;

import java.util.List;

public interface DAO<T, K> {

	public T cadastrar(T obj);

	public T atualisar(T obj);

	public void remover(T obj);

	public T buscar(K id);

	public List<T> buscarTodos();

}
