package model;

import java.time.LocalDate;

public class EntradaProdutoDAO {
	
	private EntradaProduto[] entradaProduto = new EntradaProduto[50];
	int contador;

	public EntradaProdutoDAO(Produto[] produto, Fornecedor[] fornecedor) {
		
		EntradaProduto entrProd1 = new EntradaProduto(1,produto[0],15,1500,fornecedor[0],LocalDate.now(),LocalDate.now());
		EntradaProduto entrProd2 = new EntradaProduto(1,produto[0],15,1500,fornecedor[0],LocalDate.now(),LocalDate.now());
		this.insereEntradaProduto(entrProd1);
		this.insereEntradaProduto(entrProd2);
	}
	
	public int verificaPosicao() {

		for (int i = 0; i < entradaProduto.length; i++) {
			if (entradaProduto[i] == null) {
				return i;
			}
			contador++;
		}

		return -1;
	}
	
	public boolean insereEntradaProduto(EntradaProduto novaEntradaProduto){

		int posicao = verificaPosicao();
		if (posicao == -1) {
				return false;
		  }
		novaEntradaProduto.setId(posicao + 1);
		this.entradaProduto[posicao] = novaEntradaProduto;
		return true;
	}
	
	
	// Encontra a posi��o
		public int encontrarEntradaProduto(EntradaProduto entradaProdutoBusca) {
			for (int i = 0; entradaProduto.length > i; i++) {
				if (entradaProduto[i] != null && entradaProduto[i].equals(entradaProdutoBusca)) {
					return i;
				}
			}
			return -1;
		}
		
		public String listarEntradaProduto(EntradaProduto c) {
			if (encontrarEntradaProduto(c) != -1) {
				return entradaProduto[encontrarEntradaProduto(c)].toString();
			}
			return "N�o encontrado.";
		}
		
		// Busca estoque
		public EntradaProduto buscaEntradaProduto(int id) {
			   EntradaProduto entradaProdutoBusca = new EntradaProduto(id);
			   int pos = encontrarEntradaProduto(entradaProdutoBusca);
					
			   if (pos != -1) {
					return this.entradaProduto[pos];
				}
					
				return null;
		}
		
		public boolean deletaEntradaProduto(EntradaProduto entradaProdASerExcluido) {
			   int posicaoEntradaProduto = encontrarEntradaProduto(entradaProdASerExcluido);

			   if (posicaoEntradaProduto == -1) {
						return false;
					}

				entradaProduto[posicaoEntradaProduto] = null;
				return true;
		}
		
		public String listarTodasEntradasProduto() {

			String listaEntradaProduto = "-- Entrada Produtos  -- " + "\n";

			for (int i = 0; entradaProduto.length > i; i++) {
				if (entradaProduto[i] != null) {
					listaEntradaProduto += entradaProduto[i].toString();
				}
			}
			if (listaEntradaProduto.contentEquals("-- Entrada Produtos -- " + "\n")) {
				listaEntradaProduto = "Nenhuma ordem de servico encontrada.";
			}

			return listaEntradaProduto;
		}
		
		
		
}
