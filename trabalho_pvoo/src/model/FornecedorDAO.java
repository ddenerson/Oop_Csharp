package model;

import java.time.LocalDate;

public class FornecedorDAO {

	Fornecedor[] fornecedor = new Fornecedor[50];
	int contador;

	public FornecedorDAO() {
		Fornecedor fr1 = new Fornecedor(1, "Luiz", "3433141622", "01585368525", 10, LocalDate.now(), LocalDate.now());
		this.insereFornecedor(fr1);
	}

	public int verificaPosicao() {

		for (int i = 0; i < fornecedor.length; i++) {
			if (fornecedor[i] == null) {
				return i;
			}
			contador++;
		}

		return -1;
	}

	// Insere um novo Produto.Se existe um espaço vazio entre 2 produtos,
	// Então o novo produto será criado nessa posição
	public boolean insereFornecedor(Fornecedor novoFornecedor) {

		int posicao = verificaPosicao();
		if (posicao == -1) {
			return false;
		}
		novoFornecedor.setId(posicao + 1);
		this.fornecedor[posicao] = novoFornecedor;
		return true;

	}

	// Encontra a posição do produto
	public int encontrarFornecedor(Fornecedor fornecedorASerExcluido) {
		for (int i = 0; fornecedor.length > i; i++) {
			if (fornecedor[i] != null && fornecedor[i].equals(fornecedorASerExcluido)) {
				return i;
			}
		}
		return -1;
	}

	public Fornecedor buscaFornecedor(int id) {
		Fornecedor fornecedorBusca = new Fornecedor(id);
		int pos = encontrarFornecedor(fornecedorBusca);

		if (pos != -1) {
			return this.fornecedor[pos];
		}

		return null;
	}

	// Recebe um produto como parâmetro e "exclui" - null
	public boolean deletaFornecedor(Fornecedor fornecedorASerExcluido) {
		int posicaoFornecedor = encontrarFornecedor(fornecedorASerExcluido);

		if (posicaoFornecedor == -1 || posicaoFornecedor == 0) {
			return false;
		}

		fornecedor[posicaoFornecedor] = null;
		return true;
	}

	public String listarFornecedor(Fornecedor c) {
		if (encontrarFornecedor(c) != -1) {
			return fornecedor[encontrarFornecedor(c)].toString();
		}
		return "Não encontrado.";
	}

	// Funcional

	public String listarTodosFornecedor() {

		String listaClientes = "-- Fornecedores -- " + "\n";

		for (int i = 0; fornecedor.length > i; i++) {
			if (fornecedor[i] != null) {
				listaClientes += fornecedor[i].toString();
			}
		}
		if (listaClientes.contentEquals("-- Fornecedor -- " + "\n")) {
			listaClientes = "Nenhum produto usuarios.";
		}

		return listaClientes;
	}
	
	// Recebe um objeto do tipo Fornecedor contendo o id e as informações que serão atualizadas
	public boolean atualizaFornecedor(Fornecedor f) {

		// É realizada a busca pelo Fornecedor que será atualizado
		Fornecedor fornecedor = this.buscaFornecedor(f.getId());
		
		// É verificado quais informações foram preenchidas para atualizar
		if (f.getNome() != null) {
			fornecedor.setNome(f.getNome());
		}
		if (f.getTelefone() != null) {
			fornecedor.setTelefone(f.getTelefone());
		}
		if (f.getCnpj() != null) {
			fornecedor.setCnpj(f.getCnpj());
		}
		if (f.getEstoqueMaximo() != 0) {
			fornecedor.setEstoqueMaximo(f.getEstoqueMaximo());
		}
		// atualiza a data de modificação para o momento em que é atualizada
		fornecedor.setDataModificado(LocalDate.now());

		return true;
	}

	public Fornecedor[] getFornecedor() {
		return fornecedor;
	}
}
