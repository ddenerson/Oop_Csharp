package model;

import java.time.LocalDate;

public class ClienteDAO {

	Cliente[] clientes = new Cliente[50];
	int contador;
	
	public ClienteDAO()
	{
		Cliente cl1 = new Cliente(1,"Denerson","ANTONIO ALVES","10543213617","34984137603",LocalDate.now(),LocalDate.now());
		Cliente cl2 = new Cliente(2,"Alex","ANTONIO ALVES DUTRA","105432136","984137603",LocalDate.now(),LocalDate.now());
	}
	
	public int verificaPosicao() {

		for (int i = 0; i < clientes.length; i++) {
			if (clientes[i] == null) {
				return i;
			}
			contador++;
		}

		return -1;
	}
	
	
	// Insere um novo Produto.Se existe um espaço vazio entre 2 produtos,
		// Então o novo produto será criado nessa posição

		public boolean insereCliente(Cliente novoCliente) {

			int posicao = verificaPosicao();
			if (posicao == -1) {
				return false;
			}
			this.clientes[posicao] = novoCliente;
			return true;

		}
		
		
		//Encontra a posição do produto

		public int encontrarCliente(Cliente clienteASerExcluido) {
			for (int i = 0; clientes.length > i; i++) {
				if (clientes[i] != null && clientes[i].equals(clienteASerExcluido)) {
					return i;
				}
			}
			return -1;
		}
		
		
		
		//Recebe um produto como parâmetro e "exclui" - null

				public boolean deletaCliente(Cliente clienteASerExcluido) {
					int posicaoCliente = encontrarCliente(clienteASerExcluido);

					if (posicaoCliente == -1 || posicaoCliente == 0) {
						return false;
					}

					clientes[posicaoCliente] = null;
					return true;
				}
				
				
				public String listarCliente(Cliente c) {
					if (encontrarCliente(c) != -1) {
						return clientes[encontrarCliente(c)].toString();
					}
					return "Não encontrado.";
				}
				
				
				//Funcional
				
				public String listarTodosClientes() {

					String listaClientes = "-- Clientes -- " + "\n";

					for (int i = 0; clientes.length > i; i++) {
						if (clientes[i] != null) {
							listaClientes += clientes[i].toString();
						}
					}
					if (listaClientes.contentEquals("-- Clientes -- " + "\n")) {
						listaClientes = "Nenhum produto usuarios.";
					}

					return listaClientes;
				}

	
	
}
