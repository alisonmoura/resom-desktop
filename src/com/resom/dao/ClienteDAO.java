package com.resom.dao;

import java.util.ArrayList;
import java.util.List;

import com.resom.model.Cliente;

public class ClienteDAO implements DAO<Cliente, String> {

	List<Cliente> clientes = new ArrayList<>();

	@Override
	public Cliente cadastrar(Cliente cliente) {
		clientes.add(cliente);
		return cliente;
	}

	@Override
	public Cliente atualisar(Cliente cliente) {
		for (Cliente cli : clientes) {
			if (cli.getCpf() == cliente.getCpf()) {
				clientes.set(clientes.indexOf(cli), cliente);
				return cliente;
			}
		}
		return null;
	}

	@Override
	public void remover(Cliente cliente) {
		for (Cliente cli : clientes) {
			if (cli.getCpf() == cliente.getCpf()) {
				clientes.remove(clientes.indexOf(cli));
			}
		}
	}

	@Override
	public Cliente buscar(String cpf) {
		for (Cliente cli : clientes) {
			if (cli.getCpf() == cpf) {
				return cli;
			}
		}
		return null;
	}

	@Override
	public List<Cliente> buscarTodos() {
		return clientes;
	}

}
