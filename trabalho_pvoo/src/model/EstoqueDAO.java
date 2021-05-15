package model;

import java.time.LocalDate;

public class EstoqueDAO {
	
	private Estoque[] estoque = new Estoque[50];
	int contador;
	
	public EstoqueDAO(Produto[] produto ) {
		
		Estoque estoque1 = new Estoque(produto[0],100,150,LocalDate.now(),LocalDate.now());
		Estoque estoque2 = new Estoque(produto[1],120,130,LocalDate.now(),LocalDate.now());
		this.insereEstoque(estoque1);
		this.insereEstoque(estoque2);
		
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

		   if (posicaoOrdem == -1) {
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
	
	// Recebe um objeto do tipo Fornecedor contendo o id e as informações que serão atualizadas
		public boolean atualizaEstoque(Estoque e) {

			// É realizada a busca pelo Estoque que será atualizado
			Estoque estoque = this.buscaEstoque(e.getId());
			
			// É verificado quais informações foram preenchidas para atualizar
			if (e.getProduto() != null) {
				estoque.setProduto(e.getProduto());
			}
			if (e.getQuantidade() != 0) {
				estoque.setQuantidade(e.getQuantidade());
			}
			if (e.getValor_unitario() != 0.0d) {
				estoque.setValor_unitario(e.getValor_unitario());
			}
			
			// atualiza a data de modificação para o momento em que é atualizada
			estoque.setData_modificado(LocalDate.now());

			return true;
		}
	
}
