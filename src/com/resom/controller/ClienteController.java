package com.resom.controller;

import java.util.List;

import com.resom.dao.ClienteDAO;
import com.resom.model.Cliente;

public class ClienteController {

	private ClienteDAO clienteDAO = new ClienteDAO();

	public void cadastrar(Cliente cliente) {
		System.out.println("Cadastrando cliente: " + cliente.getNome());
		clienteDAO.cadastrar(cliente);
	}

	public List<Cliente> buscarTodos() {
		return clienteDAO.buscarTodos();
	}

}
