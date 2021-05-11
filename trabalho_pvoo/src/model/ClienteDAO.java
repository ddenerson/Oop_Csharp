package model;

import java.time.LocalDate;

public class ClienteDAO {

	Cliente[] clientes = new Cliente[50];
	int contador;

	public ClienteDAO() {
		Cliente cl1 = new Cliente(1, "Denerson", "ANTONIO ALVES", "10543213617", "34984137603", LocalDate.now(),
				LocalDate.now());
		Cliente cl2 = new Cliente(2, "Alex", "ANTONIO ALVES DUTRA", "105432136", "984137603", LocalDate.now(),
				LocalDate.now());
		Cliente cl3 = new Cliente(3, "Denerson", "ANTONIO ALVES", "10543213617", "34984137603", LocalDate.now(),
				LocalDate.now());
		Cliente cl4 = new Cliente(4, "Alex", "ANTONIO ALVES DUTRA", "105432136", "984137603", LocalDate.now(),
				LocalDate.now());
		Cliente cl5 = new Cliente(5, "Denerson", "ANTONIO ALVES", "10543213617", "34984137603", LocalDate.now(),
				LocalDate.now());
		Cliente cl6 = new Cliente(6, "Alex", "ANTONIO ALVES DUTRA", "105432136", "984137603", LocalDate.now(),
				LocalDate.now());
		Cliente cl7 = new Cliente(7, "Denerson", "ANTONIO ALVES", "10543213617", "34984137603", LocalDate.now(),
				LocalDate.now());
		Cliente cl8 = new Cliente(8, "Alex", "ANTONIO ALVES DUTRA", "105432136", "984137603", LocalDate.now(),
				LocalDate.now());
		Cliente cl9 = new Cliente(9, "Denerson", "ANTONIO ALVES", "10543213617", "34984137603", LocalDate.now(),
				LocalDate.now());
		Cliente cl0 = new Cliente(10, "Alex", "ANTONIO ALVES DUTRA", "105432136", "984137603", LocalDate.now(),
				LocalDate.now());
		
		this.insereCliente(cl1);
		this.insereCliente(cl2);
		this.insereCliente(cl3);
		this.insereCliente(cl4);
		this.insereCliente(cl5);
		this.insereCliente(cl6);
		this.insereCliente(cl7);
		this.insereCliente(cl8);
		this.insereCliente(cl9);
		this.insereCliente(cl0);
	}

	public int verificaPosicao() {
		contador = 0;

		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] == null) {
				return i;
			}
			contador++;
		}

		return -1;
	}

	// Insere um novo cliente.Se existe um espaço vazio entre 2 cliente,
	// Então o novo cliente será criado nessa posição
	public boolean insereCliente(Cliente novoCliente) {

		int posicao = verificaPosicao();
		if (posicao == -1) {
			return false;
		}
		novoCliente.setId(posicao + 1);
		this.clientes[posicao] = novoCliente;
		return true;

	}

	// Encontra a posição do cliente
	public int encontrarCliente(Cliente clienteASerExcluido) {
		for (int i = 0; clientes.length > i; i++) {
			if (clientes[i] != null && clientes[i].equals(clienteASerExcluido)) {
				return i;
			}
		}
		return -1;
	}
	
	// Busca cliente
	public Cliente buscaCliente(int id) {
		Cliente clienteBusca = new Cliente(id);
		int pos = encontrarCliente(clienteBusca);
		
		if (pos != -1) {
			return this.clientes[pos];
		}
		
		return null;
	}

	// Recebe um cliente como parâmetro e "exclui" - null
	public boolean deletaCliente(Cliente clienteASerExcluido) {
		int posicaoCliente = encontrarCliente(clienteASerExcluido);

		if (posicaoCliente == -1 || posicaoCliente == 0) {
			return false;
		}

		clientes[posicaoCliente] = null;
		return true;
	}

	// Lista um único cliente
	public String listarCliente(Cliente c) {
		if (encontrarCliente(c) != -1) {
			return clientes[encontrarCliente(c)].toString();
		}
		return "Não encontrado.";
	}

	// Lista todos os clientes cadastrados
	public String listarTodosClientes() {

		String listaClientes = "-- Clientes -- " + "\n";

		for (int i = 0; clientes.length > i; i++) {
			if (clientes[i] != null) {
				listaClientes += clientes[i].toString() + "\n";
			}
		}
		if (listaClientes.contentEquals("-- Clientes -- " + "\n")) {
			listaClientes = "Nenhum cliente cdadastrado.";
		}

		return listaClientes;
	}
	
	
	public Cliente[] getClientes() {
		return clientes;
	}
	

}
