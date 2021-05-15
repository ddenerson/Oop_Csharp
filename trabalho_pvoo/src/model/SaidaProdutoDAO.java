package model;

import java.time.LocalDate;

public class SaidaProdutoDAO {

	private SaidaProduto[] saidaProdutos = new SaidaProduto[50];
	int contador;

	public SaidaProdutoDAO(Produto[] produto, Fornecedor[] fornecedor) {

		SaidaProduto sP1 = new SaidaProduto(1, produto[0], 10, 150, fornecedor[0], LocalDate.now(), LocalDate.now());
		SaidaProduto sP2 = new SaidaProduto(2, produto[1], 15, 200, fornecedor[1], LocalDate.now(), LocalDate.now());
		
		this.insereSaidaProduto(sP1);
		this.insereSaidaProduto(sP2);

	}

	public int verificaPosicao() {

		for (int i = 0; i < saidaProdutos.length; i++) {
			if (saidaProdutos[i] == null) {
				return i;
			}
			contador++;
		}

		return -1;
	}

	public boolean insereSaidaProduto(SaidaProduto novaSaidaProduto) {

		int posicao = verificaPosicao();
		if (posicao == -1) {
			return false;
		}
		novaSaidaProduto.setId(posicao+1);
		this.saidaProdutos[posicao] = novaSaidaProduto;
		return true;

	}

	public int encontraSaidaProduto(SaidaProduto SaidaProdutoASerExcluido) {
		for (int i = 0; saidaProdutos.length > i; i++) {
			if (saidaProdutos[i] != null && saidaProdutos[i].equals(SaidaProdutoASerExcluido)) {
				return i;
			}
		}
		return -1;
	}

	public boolean deletaSaidaProduto(SaidaProduto SaidaprodutoASerExcluido) {
		int posicaoSaidaProduto = encontraSaidaProduto(SaidaprodutoASerExcluido);

		if (posicaoSaidaProduto == -1) {
			return false;
		}

		saidaProdutos[posicaoSaidaProduto] = null;
		return true;
	}

	public String listarSaidaProduto(SaidaProduto c) {
		if (encontraSaidaProduto(c) != -1) {
			return saidaProdutos[encontraSaidaProduto(c)].toString();
		}
		return "Não encontrado.";
	}

	public String listarSaidaProdutoTodos() {

		String listaSaidaProduto = "-- Saida Produtos -- " + "\n";

		for (int i = 0; saidaProdutos.length > i; i++) {
			if (saidaProdutos[i] != null) {
				listaSaidaProduto += saidaProdutos[i].toString();
			}
		}
		if (listaSaidaProduto.contentEquals("-- Saida Produtos -- " + "\n")) {
			listaSaidaProduto = "Nenhum produto cadastrado.";
		}

		return listaSaidaProduto;
	}

}
