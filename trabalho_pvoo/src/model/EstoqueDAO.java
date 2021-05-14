package model;

import java.time.LocalDate;

public class EstoqueDAO {
	
	private Estoque[] estoque = new Estoque[50];
	int contador;
	
	public EstoqueDAO(Produto[] produto ) {
		
		Estoque estoque1 = new Estoque(1,produto[0],100,150,LocalDate.now(),LocalDate.now());
		Estoque estoque2 = new Estoque(1,produto[1],120,130,LocalDate.now(),LocalDate.now());
		
	}
	
	public int verificaPosicao() {

		for (int i = 0; i < estoque.length; i++) {
			if (estoque[i] == null) {
				return i;
			}
			contador++;
		}

		return -1;
	}
	
	
	public boolean insereEstoque(Estoque novoEstoque){

		int posicao = verificaPosicao();
		if (posicao == -1) {
				return false;
		  }
		novoEstoque.setId(posicao + 1);
		this.estoque[posicao] = novoEstoque;
		return true;
	}
	
	// Encontra a posição do estoque
	public int encontrarOrdemEstoque(Estoque ordemEstoque) {
		for (int i = 0; estoque.length > i; i++) {
			if (estoque[i] != null && estoque[i].equals(ordemEstoque)) {
				return i;
			}
		}
		return -1;
	}
	
	// Busca estoque
	public Estoque buscaEstoque(int id) {
		   Estoque EstoqueBusca = new Estoque(id);
		   int pos = encontrarOrdemEstoque(EstoqueBusca);
				
		   if (pos != -1) {
				return this.estoque[pos];
			}
				
			return null;
	}
	
	public boolean deletaEstoque(Estoque estoqueASerExcluido) {
		   int posicaoOrdem = encontrarOrdemEstoque(estoqueASerExcluido);

		   if (posicaoOrdem == -1 || posicaoOrdem == 0) {
					return false;
				}

			estoque[posicaoOrdem] = null;
			return true;
	}
	
	public String listarEstoque(Estoque c) {
		if (encontrarOrdemEstoque(c) != -1) {
			return estoque[encontrarOrdemEstoque(c)].toString();
		}
		return "Não encontrado.";
	}

	public String listarTodasEstoque() {

		String listaEstoques = "-- Ordens de Estoque -- " + "\n";

		for (int i = 0; estoque.length > i; i++) {
			if (estoque[i] != null) {
				listaEstoques += estoque[i].toString();
			}
		}
		if (listaEstoques.contentEquals("-- Ordens de Serviço -- " + "\n")) {
			listaEstoques = "Nenhuma ordem de servico encontrada.";
		}

		return listaEstoques;
	}
	
}
