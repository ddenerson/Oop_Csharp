package model;

import java.time.LocalDate;

public class ProdutoDAO {

	Produto[] produtos = new Produto[50];
	int contador;

	public ProdutoDAO() {

		Produto p1 = new Produto(1, "ATIVO", "TELEFONE CELULAR", 10, 100, LocalDate.now(), LocalDate.now());
		Produto p2 = new Produto(2, "INATIVO", "IPHONE", 5, 50, LocalDate.now(), LocalDate.now());
		this.insereProduto(p1);
		this.insereProduto(p2);
	}

	// Encontra uma posição está vazia

	public int verificaPosicao() {

		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] == null) {
				return i;
			}
			contador++;
		}

		return -1;
	}

	// Insere um novo Produto.Se existe um espaço vazio entre 2 produtos,
	// Então o novo produto será criado nessa posição

	public boolean insereProduto(Produto novoProduto) {

		int posicao = verificaPosicao();
		if (posicao == -1) {
			return false;
		}
		novoProduto.setId(posicao + 1);
		this.produtos[posicao] = novoProduto;
		return true;

	}
	
	public Produto buscaProduto(int id) {
		Produto produtoBusca = new Produto(id);
		int pos = encontrarProduto(produtoBusca);
		
		if (pos != -1) {
			return this.produtos[pos];
		}
		
		return null;
	}
	
	
	

//Encontra a posição do produto

	public int encontrarProduto(Produto produtoBusca) {
		for (int i = 0; produtos.length > i; i++) {
			if (produtos[i] != null && produtos[i].equals(produtoBusca)) {
				return i;
			}
		}
		return -1;
	}

//Recebe um produto como parâmetro e "exclui" - null

	public boolean deletaProduto(Produto produtoASerExcluido) {
		int posicaoProduto = encontrarProduto(produtoASerExcluido);

		if (posicaoProduto == -1) {
			return false;
		}

		produtos[posicaoProduto] = null;
		return true;
	}

	public String listarProduto(Produto c) {
		if (encontrarProduto(c) != -1) {
			return produtos[encontrarProduto(c)].toString();
		}
		return "Não encontrado.";
	}

	//Funcional
	
	public String listarTodosProdutos() {

		String listaProduto = "-- Produto -- " + "\n";

		for (int i = 0; produtos.length > i; i++) {
			if (produtos[i] != null) {
				listaProduto += produtos[i].toString();
			}
		}
		if (listaProduto.contentEquals("-- Produto -- " + "\n")) {
			listaProduto = "Nenhum produto cadastrado.";
		}

		return listaProduto;
	}
	
	// Recebe um objeto do tipo Produto contendo o id e as informações que serão atualizadas
		public boolean atualizaProduto(Produto p) {
			
			// É realizada a busca pelo Produto que será atualizado
			Produto produto = this.buscaProduto(p.getId());
			// É verificado quais informações foram preenchidas para atualizar
			if (p.getStatus() != null) {
				produto.setStatus(p.getStatus());
			}
			if (p.getDescricao() != null) {
				produto.setDescricao(p.getDescricao());
			}
			if (p.getEstoque_minimo() != 0) {
				produto.setEstoque_minimo(p.getEstoque_minimo());
			}
			if (p.getEstoque_maximo() != 0) {
				produto.setEstoque_maximo(p.getEstoque_maximo());
			}
			// atualiza a data de modificação para o momento em que é atualizada
			produto.setData_modificacao(LocalDate.now());

			return true;
		}
	
	public Produto[] getProduto() {
		return produtos;
	}

}
