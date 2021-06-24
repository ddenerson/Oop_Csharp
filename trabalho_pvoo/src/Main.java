import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import model.Cliente;
import model.ClienteDAO;
import model.EntradaProduto;
import model.EntradaProdutoDAO;
import model.Estoque;
import model.EstoqueDAO;
import model.Fornecedor;
import model.FornecedorDAO;
import model.NotaFiscal;
import model.NotaFiscalDAO;
import model.OrdemServico;
import model.OrdemServicoDAO;
import model.Produto;
import model.ProdutoDAO;
import model.SaidaProduto;
import model.EntradaProduto;
import model.SaidaProdutoDAO;
import model.Usuario;
import model.UsuarioDAO;

public class Main {

	ClienteDAO clienteDAO = new ClienteDAO();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	// OrdemServicoDAO ordemServicoDAO = new
	// OrdemServicoDAO(clienteDAO.getClientes());
	FornecedorDAO fornecedorDAO = new FornecedorDAO();
	ProdutoDAO produtoDAO = new ProdutoDAO();
	// EntradaProdutoDAO entradaProdutoDAO = new
	// EntradaProdutoDAO(produtoDAO.getProduto(), fornecedorDAO.getFornecedor());
	// EstoqueDAO estoqueDAO = new EstoqueDAO(produtoDAO.getProduto());
	// SaidaProdutoDAO saidaProdutoDAO = new
	// SaidaProdutoDAO(produtoDAO.getProduto(), fornecedorDAO.getFornecedor());
	NotaFiscalDAO notaFiscalDAO = new NotaFiscalDAO();

	public Main() {
		// Login();
		menuPrincipal();
	}

	public static void main(String[] args) {
		new Main();
	}

	public void menuUsuario() {
		int opcao;

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- USUARIO  --").append("\n");
			menu.append("1. Novo usuario").append("\n");
			menu.append("2. Consultar usuario").append("\n");
			menu.append("3. Listar usuarios cadastrados").append("\n");
			menu.append("4. Atualizar usuario").append("\n");
			menu.append("5. Remover usuario").append("\n");
			menu.append("6. Voltar").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a op��o escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));

			// Menu que realiza as opera��es
			switch (opcao) {

			// Cria um novo usuario e insere no DAO
			case 1:

				System.out.println("-- NOVO USUARIO -- \n");

				// Captura os dados necess�rios para criar um usu�rio
				String nome = JOptionPane.showInputDialog("Nome: ");
				String endereco = JOptionPane.showInputDialog("Endere�o: ");
				String cpf = JOptionPane.showInputDialog("CPF: ");
				String telefone = JOptionPane.showInputDialog("Telefone: ");
				String login = JOptionPane.showInputDialog("Login: ");
				String senha = JOptionPane.showInputDialog("Senha: ");
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				// Inst�ncia um objeto Usu�rio usando os dados capturados anteriormente
				Usuario usuario = new Usuario(nome, endereco, cpf, telefone, login, senha, dataCriacao,
						dataModificacao);

				// Insere o novo usu�rio no vetor do DAO
				int resultado = usuarioDAO.insereUsuario(usuario);

				if (resultado > 0) {
					System.out.println("Usuario criado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel criar o usuario!");
				}

				break;
			case 2:

				System.out.println("-- CONSULTAR USUARIO -- \n");

				// Captura o id do usu�rio que ser� consultado
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuário: "));
				usuario = usuarioDAO.buscaUsuario(id);

				if (usuario == null) {
					System.out.println("Usuário não encontrado.");
				} else {
					System.out.println(usuario);
				}

				break;
			case 3:
				System.out.println("-- USUARIOS CADASTRADOS -- \n");

				// Retorna uma string contendo todos os usu�rios do vetor que est� no DAO
				List<Usuario> usuarios = usuarioDAO.listarUsuarios();

				if (usuarios.isEmpty()) {
					System.out.println("Nenhum usuário encontrado");
				} else {
					// Lista todos os usu�rios
					for (Usuario u : usuarios) {
						System.out.println(u);
					}
				}

				break;
			case 4:
				System.out.println("-- ATUALIZAR USUARIOS -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuario: "));
				menuAtualizarUsuario(id);
				break;
			case 5:
				System.out.println("-- REMOVER USUARIOS -- \n");

				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuario: "));
				resultado = usuarioDAO.deletaUsuario(id);

				if (resultado > 0) {
					System.out.println("Usuario deletado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel deletar o usuario!");
				}
				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;

			}
		} while (opcao != 6);
	}

	public void menuCliente() {
		int opcao;
		Cliente cliente = new Cliente();

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- CLIENTES --").append("\n");
			menu.append("1. Novo cliente").append("\n");
			menu.append("2. Consultar cliente").append("\n");
			menu.append("3. Listar clientes").append("\n");
			menu.append("4. Atualizar cliente").append("\n");
			menu.append("5. Remover cliente").append("\n");
			menu.append("6. Voltar").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a op��o escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));

			// Menu que realiza as opera��es
			switch (opcao) {
			// Cria um novo cliente e insere no DAO
			case 1:
				System.out.println("-- NOVO CLIENTE -- \n");

				String nome = JOptionPane.showInputDialog("Nome: ");
				String endereco = JOptionPane.showInputDialog("Endere�o: ");
				String cpf = JOptionPane.showInputDialog("CPF: ");
				String telefone = JOptionPane.showInputDialog("Telefone: ");
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				cliente = new Cliente(nome, endereco, cpf, telefone, dataCriacao, dataModificacao);
				int resultado = clienteDAO.insereCliente(cliente);

				if (resultado > 0) {
					System.out.println("Cliente criado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel criar o cliente!");
				}

				break;
			case 2:
				System.out.println("-- CONSULTAR CLIENTE -- \n");

				// Recebe o id do cliente que ser� buscado
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
				// Realiza a pesquisa usando o objeto criado anteriormente
				cliente = clienteDAO.buscaCliente(id);

				// Se o cliente existir os dados s�o mostrados
				if (cliente == null) {
					System.out.println("Cliente não encontrado.");
				} else {
					System.out.println(cliente);
				}

				break;
			case 3:
				System.out.println("-- CLIENTES CADASTRADOS -- \n");
				List<Cliente> clientes = clienteDAO.listarClientes();

				if (clientes.isEmpty()) {
					System.out.println("Nenhum cliente encontrado");
				} else {
					// Lista todos os clientes
					for (Cliente c : clientes) {
						System.out.println(c);
					}
				}

				break;
			case 4:
				System.out.println("-- ATUALIZAR CLIENTE -- \n");

				// Captura o id do cliente que ser� atualizado
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));

				// M�todo que apresenta o menu com as op��es
				menuAtualizarCliente(id);
				break;
			case 5:
				System.out.println("-- REMOVER CLIENTE -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
				resultado = clienteDAO.deletaCliente(id);

				if (resultado > 0) {
					System.out.println("Cliente deletado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel deletar o cliente!");
				}

				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;
			}
		} while (opcao != 6);
	}

//	public void menuOrdemServico() {
//		int opcao;
//		OrdemServico ordem;
//
//		do {
//			// Constroi o menu
//			StringBuilder menu = new StringBuilder("-- ORDEM DE SERVICO --").append("\n");
//			menu.append("1. Nova ordem de servi�o").append("\n");
//			menu.append("2. Consultar ordem de servi�o").append("\n");
//			menu.append("3. Listar ordens de servi�o").append("\n");
//			menu.append("4. Atualizar ordens de servi�o").append("\n");
//			menu.append("5. Remover ordem de servi�o").append("\n");
//			menu.append("6. Voltar").append("\n");
//
//			// Exibe o menu no terminal
//			System.out.println(menu);
//
//			// Captura a op��o escolhida
//			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));
//
//			// Menu que realiza as opera��es
//			switch (opcao) {
//			// Cria uma nova ordem de servico e insere no DAO
//			case 1:
//				System.out.println("-- NOVA ORDEM DE SERVI�O -- \n");
//
//				String descricao = JOptionPane.showInputDialog("Descri��o: ");
//				String estado = JOptionPane.showInputDialog("Estado: ");
//				int clienteId = Integer.parseInt(JOptionPane.showInputDialog("N�mero do cliente: "));
//				Cliente cliente = clienteDAO.buscaCliente(clienteId);
//				double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor: "));
//				String mecanico = JOptionPane.showInputDialog("Mec�nico: ");
//				LocalDate dataCriacaoOS = LocalDate.now();
//				LocalDate dataModificacaoOS = LocalDate.now();
//
//				OrdemServico novaOrdem = new OrdemServico(0, descricao, estado, cliente, valor, mecanico, dataCriacaoOS,
//						dataModificacaoOS);
//
//				// Usa o DAO para salvar
//				boolean resultado = ordemServicoDAO.insereOrdem(novaOrdem);
//
//				if (resultado) {
//					System.out.println("Ordem de servi�o criada com sucesso!");
//				} else {
//					System.out.println("N�o foi poss�vel criar a nova ordem de servi�o.");
//				}
//				break;
//			case 2:
//				System.out.println("-- CONSULTAR ORDEM DE SERVI�O -- \n");
//
//				// Recebe o id da ordem de servico que ser� buscada
//				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da ordem de servi�o: "));
//				// Realiza a pesquisa usando o objeto criado anteriormente
//				OrdemServico osEncontrada = ordemServicoDAO.buscaOrdem(id);
//				// Se o cliente existir os dados s�o mostrados
//				System.out.println(osEncontrada);
//
//				break;
//			case 3:
//				System.out.println("-- LISTA ORDENS DE SERVICO -- \n");
//				String listaOS = ordemServicoDAO.listarTodasOrdens();
//				System.out.println(listaOS);
//				break;
//			case 4:
//				System.out.println("-- ATUALIZAR ORDEM DE SERVICO -- \n");
//				int idOS = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da ordem de servi�o: "));
//				menuAtualizarOrdemServico(idOS);
//				break;
//			case 5:
//				System.out.println("-- REMOVER ORDEM DE SERVI�O -- \n");
//
//				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da ordem de servi�o: "));
//				ordem = new OrdemServico(idDeleta);
//
//				boolean resultadoDeleta = ordemServicoDAO.deletaOrdemServico(ordem);
//
//				if (resultadoDeleta) {
//					System.out.println("Ordem de servi�o exclu�da com sucesso!");
//				} else {
//					System.out.println("N�o foi poss�vel excluir a ordem de servi�o!");
//				}
//				break;
//			case 6:
//				System.out.println("Retorna ao menu principal");
//				break;
//			default:
//				System.out.println("Op��o inv�lida!");
//				break;
//			}
//		} while (opcao != 6);
//	}

	public void menuFornecedor() {

		int opcao;

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- FORNECEDOR  --").append("\n");
			menu.append("1. Novo Fornecedor").append("\n");
			menu.append("2. Consultar Fornecedor").append("\n");
			menu.append("3. Listar Fornecedor").append("\n");
			menu.append("4. Atualizar Fornecedor").append("\n");
			menu.append("5. Remover Fornecedor").append("\n");
			menu.append("6. Voltar").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a op��o escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));

			switch (opcao) {

			case 1:

				System.out.println("-- NOVO FORNECEDOR -- \n");

				String nome = JOptionPane.showInputDialog("Nome: ");
				String telefone = JOptionPane.showInputDialog("Telefone: ");
				String cnpj = JOptionPane.showInputDialog("CNPJ: ");
				int estoqueMaximo = Integer.parseInt(JOptionPane.showInputDialog("Estoque Maximo: "));
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				Fornecedor fornecedor = new Fornecedor(nome, telefone, cnpj, estoqueMaximo, dataCriacao,
						dataModificacao);
				int resultado = fornecedorDAO.insereFornecedor(fornecedor);

				if (resultado > 0) {
					System.out.println("Fornecedor cadastrado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel cadastrar o fornecedor!");
				}
				break;
			case 2:
				System.out.println("-- CONSULTAR FORNECEDOR -- \n");
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do fornecedor: "));
				fornecedor = fornecedorDAO.buscaFornecedor(id);

				if (fornecedor == null) {
					System.out.println("Fornecedor não encontrado.");
				} else {
					System.out.println(fornecedor);
				}

				break;
			case 3:
				System.out.println("-- FORNECEDORES CADASTRADOS -- \n");
				List<Fornecedor> fornecedores = fornecedorDAO.listarFornecedores();

				if (!fornecedores.isEmpty()) {
					for (Fornecedor f : fornecedores) {
						System.out.println(f);
					}
				} else {
					System.out.println("Nenhum fornecedor encontrado.");
				}

				break;
			case 4:
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do fornecedor: "));
				menuAtualizarFornecedor(id);
				break;
			case 5:
				System.out.println("-- REMOVER FORNECEDOR -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do fornecedor: "));

				resultado = fornecedorDAO.deletaFornecedor(id);
				if (resultado > 0) {
					System.out.println("Fornecedor deletado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel deletar o fornecedor!");
				}
				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;
			}

		} while (opcao != 6);

	}

	public void menuProduto() {
		int opcao;

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- PRODUTO  --").append("\n");
			menu.append("1. Novo Produto").append("\n");
			menu.append("2. Consultar Produto").append("\n");
			menu.append("3. Listar Produto").append("\n");
			menu.append("4. Atualizar Produto").append("\n");
			menu.append("5. Remover Produto").append("\n");
			menu.append("6. Voltar").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a op��o escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));

			switch (opcao) {

			case 1:

				System.out.println("-- NOVO PRODUTO -- \n");

				// Captura os dados necess�rios para criar um novo produto
				String status = JOptionPane.showInputDialog("Status: ");
				String descricao = JOptionPane.showInputDialog("Descricao: ");
				int estoqueMinimo = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque minimo: "));
				int estoqueMaximo = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque maximo: "));
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				// Cria um objeto do tipo Produto que ser� inserido no DAO
				Produto produto = new Produto(status, descricao, estoqueMinimo, estoqueMaximo, dataCriacao,
						dataModificacao);
				int resultado = produtoDAO.insereProduto(produto);

				if (resultado > 0) {
					System.out.println("Produto cadastrado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel cadastrar o produto!");
				}
				break;
			case 2:

				System.out.println("-- CONSULTAR PRODUTO -- \n");

				// Captura o id do produto que ser� pesquisado
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));

				// Recebe o objeto em forma de string
				produto = produtoDAO.buscaProduto(id);

				if (produto != null) {
					System.out.println(produto);
				} else {
					System.out.println("Produto não encontrado.");
				}

				break;
			case 3:

				System.out.println("-- PRODUTOS CADASTRADOS -- \n");
				List<Produto> produtos = produtoDAO.listarProdutos();

				if (!produtos.isEmpty()) {
					for (Produto p : produtos) {
						System.out.println(p);
					}
				} else {
					System.out.println("Nenhum produto encontrado.");
				}

				break;
			case 4:
				System.out.println("-- ATUALIZAR PRODUTOS -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
				menuAtualizarProduto(id);
				break;
			case 5:
				System.out.println("-- REMOVER PRODUTOS -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
				resultado = produtoDAO.deletaProduto(id);

				if (resultado > 0) {
					System.out.println("Produto deletado com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel deletar o produto!");
				}

				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;

			default:
				System.out.println("Op��o inv�lida!");
				break;
			}

		} while (opcao != 6);
	}

//	public void menuEntradaProduto() {
//
//		int opcao;
//
//		do {
//			// Constroi o menu
//			StringBuilder menu = new StringBuilder("-- ENTRADA DE PRODUTO  --").append("\n");
//			menu.append("1. Nova Entrada de Produto").append("\n");
//			menu.append("2. Consultar Entrada de Produto").append("\n");
//			menu.append("3. Listar Entrada de Produto").append("\n");
//			menu.append("4. Atualizar Entrada de Produto").append("\n");
//			menu.append("5. Remover Entrada de Produto").append("\n");
//			menu.append("6. Voltar").append("\n");
//
//			// Exibe o menu no terminal
//			System.out.println(menu);
//
//			// Captura a op��o escolhida
//			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));
//
//			switch (opcao) {
//
//			case 1:
//
//				System.out.println("-- NOVA ENTRADA DE PRODUTO -- \n");
//				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
//				Produto produto = produtoDAO.buscaProduto(id);
//				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
//				double valorUnitario = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor unitario: "));
//				Fornecedor fornecedor = fornecedorDAO.buscaFornecedor(id);
//				LocalDate dataCriacao = LocalDate.now();
//				LocalDate dataModificacao = LocalDate.now();
//
//				EntradaProduto novoEntradaProduto = new EntradaProduto(produto, quantidade, valorUnitario, fornecedor,
//						dataCriacao, dataModificacao);
//				boolean resultado = entradaProdutoDAO.insereEntradaProduto(novoEntradaProduto);
//
//				if (resultado) {
//					System.out.println("Entrada de produto cadastrado com sucesso!");
//				} else {
//					System.out.println("N�o foi poss�vel cadastrar entrada de produto!");
//				}
//				break;
//			case 2:
//				System.out.println("-- CONSULTAR ENTRADA DE PRODUTOS -- \n");
//				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da entrada de produto: "));
//				EntradaProduto entradaProdutoPesquisado = new EntradaProduto(id);
//				String usuarioString = entradaProdutoDAO.listarEntradaProduto(entradaProdutoPesquisado);
//				System.out.println(usuarioString);
//				break;
//			case 3:
//				System.out.println("--  CADASTRADOS ENTRADA DE PRODUTOS -- \n");
//				String listaEntradaProdutos = entradaProdutoDAO.listarTodasEntradasProduto();
//				System.out.println(listaEntradaProdutos);
//				break;
//			case 4:
//				System.out.println("-- ATUALIZAR ENTRADA DE PRODUTOS -- \n");
//				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da entrada de produto: "));
//				menuAtualizarEntradaProduto(id);
//				break;
//			case 5:
//				System.out.println("-- REMOVER ENTRADA PRODUTOS -- \n");
//				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id de entrada produtos: "));
//				EntradaProduto entradaProdutoDeleta = new EntradaProduto(idDeleta);
//				boolean resultadoDeleta = entradaProdutoDAO.deletaEntradaProduto(entradaProdutoDeleta);
//				if (resultadoDeleta) {
//					System.out.println(" deletado com sucesso!");
//				} else {
//					System.out.println("N�o foi poss�vel deletar !");
//				}
//				break;
//			case 6:
//				System.out.println("Retorna ao menu principal");
//				break;
//			default:
//				System.out.println("Op��o inv�lida!");
//				break;
//			}
//
//		} while (opcao != 6);
//
//	}

//	public void menuEstoque() {
//		int opcao;
//
//		do {
//			// Constroi o menu
//			StringBuilder menu = new StringBuilder("-- ESTOQUE  --").append("\n");
//			menu.append("1. Novo Estoque").append("\n");
//			menu.append("2. Consultar Estoque").append("\n");
//			menu.append("3. Listar Estoque").append("\n");
//			menu.append("4. Atualizar Estoque").append("\n");
//			menu.append("5. Remover Estoque").append("\n");
//			menu.append("6. Voltar").append("\n");
//
//			// Exibe o menu no terminal
//			System.out.println(menu);
//
//			// Captura a op��o escolhida
//			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));
//
//			switch (opcao) {
//
//			case 1:
//
//				System.out.println("-- NOVO ESTOQUE -- \n");
//				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
//				Produto produto = produtoDAO.buscaProduto(id);
//				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
//				double valorUnitario = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor unitario: "));
//				LocalDate dataCriacao = LocalDate.now();
//				LocalDate dataModificacao = LocalDate.now();
//
//				Estoque novoEstoque = new Estoque(produto, quantidade, valorUnitario, dataCriacao, dataModificacao);
//				boolean resultado = estoqueDAO.insereEstoque(novoEstoque);
//
//				if (resultado) {
//					System.out.println("Estoque cadastrado com sucesso!");
//				} else {
//					System.out.println("N�o foi poss�vel cadastrar o estoque!");
//				}
//				break;
//			case 2:
//				System.out.println("-- CONSULTAR ESTOQUE -- \n");
//				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do estoque: "));
//				Estoque estoquePesquisado = new Estoque(id);
//				String estoqueString = estoqueDAO.listarEstoque(estoquePesquisado);
//
//				System.out.println(estoqueString);
//				break;
//			case 3:
//				System.out.println("-- ESTOQUE CADASTRADOS -- \n");
//				String listaEstoque = estoqueDAO.listarTodasEstoque();
//				System.out.println(listaEstoque);
//				break;
//			case 4:
//				System.out.println("-- ATUALIZAR ESTOQUE -- \n");
//				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do estoque: "));
//				menuAtualizarEstoque(id);
//				break;
//			case 5:
//				System.out.println("-- REMOVER ESTOQUE -- \n");
//				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do estoque: "));
//				Estoque estoqueDeleta = new Estoque(idDeleta);
//				boolean resultadoDeleta = estoqueDAO.deletaEstoque(estoqueDeleta);
//
//				if (resultadoDeleta) {
//					System.out.println("Estoque removido com sucesso!");
//				} else {
//					System.out.println("N�o foi poss�vel remover o estoque!");
//				}
//				break;
//			case 6:
//				System.out.println("Retorna ao menu principal");
//				break;
//			default:
//				System.out.println("Op��o inv�lida!");
//				break;
//
//			}
//
//		} while (opcao != 6);
//
//	}

//	public void menuSaidaProduto() {
//		int opcao;
//
//		do {
//			// Constroi o menu
//			StringBuilder menu = new StringBuilder("-- SAIDA PRODUTO  --").append("\n");
//			menu.append("1. Nova Saida de Produto").append("\n");
//			menu.append("2. Consultar Saida Produto").append("\n");
//			menu.append("3. Listar Saida de Produtos ").append("\n");
//			menu.append("4. Atualizar Saida Produto").append("\n");
//			menu.append("5. Remover Saida Produto").append("\n");
//			menu.append("6. Voltar").append("\n");
//
//			// Exibe o menu no terminal
//			System.out.println(menu);
//
//			// Captura a op��o escolhida
//			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));
//
//			switch (opcao) {
//
//			case 1:
//
//				System.out.println("-- NOVA SAIDA DE PRODUTO -- \n");
//
//				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
//				Produto produto = produtoDAO.buscaProduto(id);
//				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
//				double valorUnitario = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor unitario: "));
//				Fornecedor fornecedor = fornecedorDAO.buscaFornecedor(id);
//				LocalDate dataCriacao = LocalDate.now();
//				LocalDate dataModificacao = LocalDate.now();
//
//				SaidaProduto novoSaidaProduto = new SaidaProduto(produto, quantidade, valorUnitario, fornecedor,
//						dataCriacao, dataModificacao);
//				boolean resultado = saidaProdutoDAO.insereSaidaProduto(novoSaidaProduto);
//
//				if (resultado) {
//					System.out.println("Produto cadastrado com sucesso!");
//				} else {
//					System.out.println("N�o foi poss�vel cadastrar o produto!");
//				}
//				break;
//			case 2:
//
//				System.out.println("-- CONSULTAR SAIDA DO PRODUTO -- \n");
//				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id saida do produto: "));
//				SaidaProduto saidaProdutoPesquisado = new SaidaProduto(id);
//				String produtoPesquisadoString = saidaProdutoDAO.listarSaidaProduto(saidaProdutoPesquisado);
//				System.out.println(produtoPesquisadoString);
//				break;
//			case 3:
//				System.out.println("-- SAIDA PRODUTOS CADASTRADOS -- \n");
//				String listaProdutos = saidaProdutoDAO.listarSaidaProdutoTodos();
//				System.out.println(listaProdutos);
//				break;
//			case 4:
//				System.out.println("-- ATUALIZAR SAIDA PRODUTOS -- \n");
//				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
//				menuAtualizarSaidaProduto(id);
//				break;
//
//			case 5:
//				System.out.println("-- REMOVER SAIDA PRODUTOS -- \n");
//				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id : "));
//				SaidaProduto saidaProdutoDeleta = new SaidaProduto(idDeleta);
//				boolean resultadoDeleta = saidaProdutoDAO.deletaSaidaProduto(saidaProdutoDeleta);
//
//				if (resultadoDeleta) {
//					System.out.println("Deletado com sucesso!");
//				} else {
//					System.out.println("N�o foi poss�vel deletar!");
//				}
//				break;
//			case 6:
//				System.out.println("Retorna ao menu principal");
//				break;
//
//			default:
//				System.out.println("Op��o inv�lida!");
//				break;
//
//			}
//
//		} while (opcao != 6);
//	}

	public void menuNotaFiscal() {
		int opcao;

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- NOTA FISCAL  --").append("\n");
			menu.append("1. Nova Nota Fiscal").append("\n");
			menu.append("2. Consultar Nota Fiscal").append("\n");
			menu.append("3. Listar Nota Fiscal ").append("\n");
			menu.append("4. Atualizar Nota Fiscal").append("\n");
			menu.append("5. Remover Nota Fiscal").append("\n");
			menu.append("6. Voltar").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a op��o escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));

			switch (opcao) {

			case 1:

				System.out.println("-- NOVA NOTA FISCAL -- \n");
				double valorTotal = Double.parseDouble(JOptionPane.showInputDialog("Valor total: "));
				String descricao = JOptionPane.showInputDialog("Descri��o: ");
				String tipo = JOptionPane.showInputDialog("Tipo: ");
				LocalDate dataCriacaoNF = LocalDate.now();
				LocalDate dataModificacaoNF = LocalDate.now();

				NotaFiscal novaNotaFiscal = new NotaFiscal(valorTotal, descricao, tipo, dataCriacaoNF,
						dataModificacaoNF);

				boolean resultado = notaFiscalDAO.insereNotaFiscal(novaNotaFiscal);

				if (resultado) {
					System.out.println("Nota Fiscal criada com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel criar nota fiscal.");
				}
				break;
			case 2:
				System.out.println("-- CONSULTAR NOTA FISCAL -- \n");

				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da nota fiscal: "));
				NotaFiscal encontrarNotaFiscal = notaFiscalDAO.buscaNotaFiscal(id);
				System.out.println(encontrarNotaFiscal);
				break;
			case 3:
				System.out.println("-- LISTAR NOTAS FISCAIS -- \n");
				String listaNF = notaFiscalDAO.listarTodasNotaFiscais();
				System.out.println(listaNF);
				break;
			case 4:
				System.out.println("-- ATUALIZAR NOTA FISCAL -- \n");
				int idNF = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da Nota Fiscal: "));
				menuAtualizarNotaFiscal(idNF);
				break;
			case 5:
				System.out.println("-- REMOVER NOTA FISCAL -- \n");
				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da nota fiscal: "));
				NotaFiscal notaFiscal = new NotaFiscal(idDeleta);

				boolean resultadoDeleta = notaFiscalDAO.deletaNotaFiscal(notaFiscal);

				if (resultadoDeleta) {
					System.out.println("Nota Fiscal exclu�da com sucesso!");
				} else {
					System.out.println("N�o foi poss�vel excluir a nota fiscal !");
				}
				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;

			}

		} while (opcao != 6);
	}

	public void menuPrincipal() {
		int opcao;

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- TELA PRINCIPAL --").append("\n");
			menu.append("1. USUARIOS").append("\n");
			menu.append("2. CLIENTES").append("\n");
			menu.append("3. FORNECEDORES").append("\n");
			menu.append("4. PRODUTOS").append("\n");
			menu.append("5. ESTOQUE").append("\n");
			menu.append("6. NOTAS FISCAIS").append("\n");
			menu.append("7. ORDENS DE SERVI�O").append("\n");
			menu.append("8. ENTRADA DE PRODUTO").append("\n");
			menu.append("9. SAIDA DE PRODUTO").append("\n");
			menu.append("10. SAIR").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a op��o escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));

			// Menu que realiza as opera��es
			switch (opcao) {
			// Direciona para os menus
			case 1:
				menuUsuario();
				break;
			case 2:
				menuCliente();
				break;
			case 3:
				menuFornecedor();
				break;
			case 4:
				menuProduto();
				break;
			case 5:
				// menuEstoque();
				break;
			case 6:
				menuNotaFiscal();
				break;
			case 7:
				// menuOrdemServico();
				break;
			case 8:
				// menuEntradaProduto();
				break;
			case 9:
				// menuSaidaProduto();
				break;
			case 10:
				System.out.println("Retornando a tela de login...");
				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;
			}
		} while (opcao != 10);
	}

	public void menuAtualizarCliente(int id) {
		int opcao;

		Cliente cliente = clienteDAO.buscaCliente(id);
		if (cliente == null) {
			System.out.println("Não foi possível encontrar o cliente.");
			return;
		}

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ATUALIZAR CLIENTE --").append("\n");
			menu.append("1. NOME").append("\n");
			menu.append("2. ENDERE�O").append("\n");
			menu.append("3. CPF").append("\n");
			menu.append("4. TELEFONE").append("\n");
			menu.append("5. SALVAR").append("\n");
			menu.append("6. VOLTAR").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a op��o escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));

			// Menu que realiza as opera��es
			switch (opcao) {
			// Direciona para os menus
			case 1:
				String nome = JOptionPane.showInputDialog("Digite o novo nome: ");
				cliente.setNome(nome);
				break;
			case 2:
				String endereco = JOptionPane.showInputDialog("Digite o novo endere�o: ");
				cliente.setEndereco(endereco);
				break;
			case 3:
				String cpf = JOptionPane.showInputDialog("Digite o novo CPF: ");
				cliente.setCpf(cpf);
				break;
			case 4:
				String telefone = JOptionPane.showInputDialog("Digite o novo telefone: ");
				cliente.setTelefone(telefone);
				break;
			case 5:
				int resultado = clienteDAO.atualizaCliente(cliente);
				if (resultado > 0) {
					System.out.println("Cliente atualizado com sucesso!");
				} else {
					System.out.println("Não foi possível atualizar o cliente.");
				}
				break;
			case 6:
				System.out.println("Retornando a tela de menu...");
				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;
			}
		} while (opcao != 6);

	}

	public void menuAtualizarUsuario(int id) {
		int opcao;
		Usuario usuario = usuarioDAO.buscaUsuario(id);

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ATUALIZAR USU�RIO --").append("\n");
			menu.append("1. NOME").append("\n");
			menu.append("2. ENDERE�O").append("\n");
			menu.append("3. CPF").append("\n");
			menu.append("4. TELEFONE").append("\n");
			menu.append("5. LOGIN").append("\n");
			menu.append("6. SENHA").append("\n");
			menu.append("7. SALVAR").append("\n");
			menu.append("8. VOLTAR").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a op��o escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));

			// Menu que realiza as opera��es
			switch (opcao) {
			case 1:
				String nome = JOptionPane.showInputDialog("Digite o novo nome: ");
				usuario.setNome(nome);
				break;
			case 2:
				String endereco = JOptionPane.showInputDialog("Digite o novo endere�o: ");
				usuario.setEndereco(endereco);
				break;
			case 3:
				String cpf = JOptionPane.showInputDialog("Digite o novo CPF: ");
				usuario.setCpf(cpf);
				break;
			case 4:
				String telefone = JOptionPane.showInputDialog("Digite o novo telefone: ");
				usuario.setTelefone(telefone);
				break;
			case 5:
				String login = JOptionPane.showInputDialog("Digite o novo login: ");
				usuario.setLogin(login);
				break;
			case 6:
				String senha = JOptionPane.showInputDialog("Digite a nova senha: ");
				usuario.setSenha(senha);
				break;
			case 7:
				int resultado = usuarioDAO.atualizaUsuario(usuario);

				if (resultado > 0) {
					System.out.println("Salvo!");
				} else {
					System.out.println("Não foi possível salvar!");
				}

				break;
			case 8:
				System.out.println("Retornando a tela ao menu anterior...");
				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;
			}
		} while (opcao != 8);

	}

//	public void menuAtualizarOrdemServico(int id) {
//		int opcao;
//		OrdemServico ordemServico = new OrdemServico(id);
//
//		do {
//			// Constroi o menu
//			StringBuilder menu = new StringBuilder("-- ATUALIZAR ORDEM SERVICO --").append("\n");
//			menu.append("1. DESCRI��O").append("\n");
//			menu.append("2. ESTADO").append("\n");
//			menu.append("3. CLIENTE").append("\n");
//			menu.append("4. VALOR").append("\n");
//			menu.append("5. MEC�NICO").append("\n");
//			menu.append("6. VOLTAR").append("\n");
//
//			// Exibe o menu no terminal
//			System.out.println(menu);
//
//			// Captura a op��o escolhida
//			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));
//
//			// Menu que realiza as opera��es
//			switch (opcao) {
//			// Direciona para os menus
//			case 1:
//				String descricao = JOptionPane.showInputDialog("Digite a nova descri��o: ");
//				ordemServico.setDescricao(descricao);
//				ordemServicoDAO.atualizarOrdem(ordemServico);
//
//				break;
//			case 2:
//				String estado = JOptionPane.showInputDialog("Digite o novo estado: ");
//				ordemServico.setEstado(estado);
//				ordemServicoDAO.atualizarOrdem(ordemServico);
//				break;
//			case 3:
//				int clienteId = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
//				Cliente cliente = clienteDAO.buscaCliente(clienteId);
//				ordemServico.setCliente(cliente);
//				ordemServicoDAO.atualizarOrdem(ordemServico);
//				break;
//			case 4:
//				double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo valor: "));
//				ordemServico.setValor(valor);
//				ordemServicoDAO.atualizarOrdem(ordemServico);
//				break;
//			case 5:
//				String mecanico = JOptionPane.showInputDialog("Digite o novo mec�nico: ");
//				ordemServico.setMecanico(mecanico);
//				ordemServicoDAO.atualizarOrdem(ordemServico);
//				break;
//			case 6:
//				System.out.println("Retornando a tela de menu...");
//				break;
//			default:
//				System.out.println("Op��o inv�lida!");
//				break;
//			}
//		} while (opcao != 6);
//
//	}

	public void menuAtualizarProduto(int id) {
		int opcao;
		Produto produto = produtoDAO.buscaProduto(id);

		if (produto == null) {
			System.out.println("Produto não encontrado");
			return;
		}

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ATUALIZAR PRODUTO --").append("\n");
			menu.append("1. STATUS").append("\n");
			menu.append("2. DESCRICAO").append("\n");
			menu.append("3. ESTOQUE MIN�MO").append("\n");
			menu.append("4. ESTOQUE M�XIMO").append("\n");
			menu.append("5. SALVAR").append("\n");
			menu.append("6. VOLTAR").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a op��o escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));

			// Menu que realiza as opera��es
			switch (opcao) {
			// Direciona para os menus
			case 1:
				String status = JOptionPane.showInputDialog("Digite o novo status: ");
				produto.setStatus(status);

				break;
			case 2:
				String descricao = JOptionPane.showInputDialog("Digite a nova descri��o: ");
				produto.setDescricao(descricao);

				break;
			case 3:
				int estoqueMin = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque min�mo: "));
				produto.setEstoqueMinimo(estoqueMin);

				break;
			case 4:
				int estoqueMax = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque m�ximo: "));
				produto.setEstoqueMaximo(estoqueMax);

				break;
			case 5:
				int resultado = produtoDAO.atualizaProduto(produto);

				if (resultado > 0) {
					System.out.println("Produto atualizado com sucesso.");
				} else {
					System.out.println("Não foi possível atualizar o produto.");
				}

				break;
			case 6:
				System.out.println("Retornando a tela anterior...");
				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;
			}
		} while (opcao != 6);

	}

	public void menuAtualizarFornecedor(int id) {
		int opcao;
		Fornecedor fornecedor = fornecedorDAO.buscaFornecedor(id);
		
		if (fornecedor == null) {
			System.out.println("Não foi possível encontrar o fornecedor.");
			return;
		}

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ATUALIZAR FORNECEDOR --").append("\n");
			menu.append("1. NOME").append("\n");
			menu.append("2. TELEFONE").append("\n");
			menu.append("3. CNPJ").append("\n");
			menu.append("4. ESTOQUE M�XIMO").append("\n");
			menu.append("5. SALVAR").append("\n");
			menu.append("6. VOLTAR").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a op��o escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));

			// Menu que realiza as opera��es
			switch (opcao) {
			// Direciona para os menus
			case 1:
				String nome = JOptionPane.showInputDialog("Digite o novo nome: ");
				fornecedor.setNome(nome);
				break;
			case 2:
				String telefone = JOptionPane.showInputDialog("Digite o novo telefone: ");
				fornecedor.setTelefone(telefone);
				break;
			case 3:
				String cnpj = JOptionPane.showInputDialog("Digite o novo CNPJ: ");
				fornecedor.setCnpj(cnpj);
				break;
			case 4:
				int estoqueMax = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque m�ximo: "));
				fornecedor.setEstoqueMaximo(estoqueMax);
				break;
			case 5:
				int resultado = fornecedorDAO.atualizaFornecedor(fornecedor);
				if (resultado > 0) {
					System.out.println("Salvo com sucesso.");
				} else {
					System.out.println("Não foi possível salvar as alterações.");
				}
				break;
			case 6:
				System.out.println("Retornando a tela anterior...");
				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;
			}
		} while (opcao != 6);

	}

//	public void menuAtualizarEstoque(int id) {
//		int opcao;
//		Estoque estoque = new Estoque(id);
//
//		do {
//			// Constroi o menu
//			StringBuilder menu = new StringBuilder("-- ATUALIZAR ESTOQUE --").append("\n");
//			menu.append("1. PRODUTO").append("\n");
//			menu.append("2. QUANTIDADE").append("\n");
//			menu.append("3. VALOR UNIT�RIO").append("\n");
//			menu.append("4. VOLTAR").append("\n");
//
//			// Exibe o menu no terminal
//			System.out.println(menu);
//
//			// Captura a op��o escolhida
//			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));
//
//			// Menu que realiza as opera��es
//			switch (opcao) {
//			// Direciona para os menus
//			case 1:
//				int produtoId = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do novo produto: "));
//				Produto produto = produtoDAO.buscaProduto(produtoId);
//				estoque.setProduto(produto);
//				estoqueDAO.atualizaEstoque(estoque);
//				break;
//			case 2:
//				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade: "));
//				estoque.setQuantidade(quantidade);
//				estoqueDAO.atualizaEstoque(estoque);
//				break;
//			case 3:
//				double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo valor unit�rio: "));
//				estoque.setValor_unitario(valor);
//				estoqueDAO.atualizaEstoque(estoque);
//				break;
//			case 4:
//				System.out.println("Retornando a tela anterior...");
//				break;
//			default:
//				System.out.println("Op��o inv�lida!");
//				break;
//			}
//		} while (opcao != 4);
//
//	}

	public void menuAtualizarNotaFiscal(int id) {
		int opcao;
		NotaFiscal notaFiscal = new NotaFiscal(id);

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ATUALIZAR NOTA FISCAL --").append("\n");
			menu.append("1. VALOR TOTAL").append("\n");
			menu.append("2. DESCRI��O").append("\n");
			menu.append("3. TIPO").append("\n");
			menu.append("4. VOLTAR").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a op��o escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));

			// Menu que realiza as opera��es
			switch (opcao) {
			// Direciona para os menus
			case 1:
				double valorTotal = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo valor total: "));
				notaFiscal.setValorTotal(valorTotal);
				notaFiscalDAO.atualizaNota(notaFiscal);
				break;
			case 2:
				String descricao = JOptionPane.showInputDialog("Digite a nova descri��o: ");
				notaFiscal.setDescricao(descricao);
				notaFiscalDAO.atualizaNota(notaFiscal);
				break;
			case 3:
				String tipo = JOptionPane.showInputDialog("Digite o novo tipo: ");
				notaFiscal.setTipo(tipo);
				notaFiscalDAO.atualizaNota(notaFiscal);
				break;
			case 4:
				System.out.println("Retornando a tela anterior...");
				break;
			default:
				System.out.println("Op��o inv�lida!");
				break;
			}
		} while (opcao != 4);

	}

//	public void menuAtualizarSaidaProduto(int id) {
//		int opcao;
//		EntradaProduto saidaProduto = new EntradaProduto(id);
//
//		do {
//			// Constroi o menu
//			StringBuilder menu = new StringBuilder("-- ATUALIZAR SAIDA DE PRODUTO --").append("\n");
//			menu.append("1. PRODUTO").append("\n");
//			menu.append("2. QUANTIDADE").append("\n");
//			menu.append("3. VALOR UNIT�RIO").append("\n");
//			menu.append("4. FORNECEDOR").append("\n");
//			menu.append("5. VOLTAR").append("\n");
//
//			// Exibe o menu no terminal
//			System.out.println(menu);
//
//			// Captura a op��o escolhida
//			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));
//
//			// Menu que realiza as opera��es
//			switch (opcao) {
//			// Direciona para os menus
//			case 1:
//				int idProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
//				Produto produto = produtoDAO.buscaProduto(idProduto);
//				saidaProduto.setProduto(produto);
//				entradaProdutoDAO.atualizaEntradaProduto(saidaProduto);
//				break;
//			case 2:
//				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade: "));
//				saidaProduto.setQuantidade(quantidade);
//				entradaProdutoDAO.atualizaEntradaProduto(saidaProduto);
//				break;
//			case 3:
//				double valorUnitario = Double
//						.parseDouble(JOptionPane.showInputDialog("Digite o novo valor unit�rio: "));
//				saidaProduto.setValor_unitario(valorUnitario);
//				entradaProdutoDAO.atualizaEntradaProduto(saidaProduto);
//				break;
//			case 4:
//				int idFornecedor = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do fornecedor: "));
//				Fornecedor fornecedor = fornecedorDAO.buscaFornecedor(idFornecedor);
//				saidaProduto.setFornecedor(fornecedor);
//				entradaProdutoDAO.atualizaEntradaProduto(saidaProduto);
//				break;
//			case 5:
//				System.out.println("Retornando a tela anterior...");
//				break;
//			default:
//				System.out.println("Op��o inv�lida!");
//				break;
//			}
//		} while (opcao != 5);
//
//	}

//	public void menuAtualizarEntradaProduto(int id) {
//		int opcao;
//		EntradaProduto entradaProduto = new EntradaProduto(id);
//
//		do {
//			// Constroi o menu
//			StringBuilder menu = new StringBuilder("-- ATUALIZAR SAIDA DE PRODUTO --").append("\n");
//			menu.append("1. PRODUTO").append("\n");
//			menu.append("2. QUANTIDADE").append("\n");
//			menu.append("3. VALOR UNIT�RIO").append("\n");
//			menu.append("4. FORNECEDOR").append("\n");
//			menu.append("5. VOLTAR").append("\n");
//
//			// Exibe o menu no terminal
//			System.out.println(menu);
//
//			// Captura a op��o escolhida
//			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a op��o desejada: "));
//
//			// Menu que realiza as opera��es
//			switch (opcao) {
//			// Direciona para os menus
//			case 1:
//				int idProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
//				Produto produto = produtoDAO.buscaProduto(idProduto);
//				entradaProduto.setProduto(produto);
//				entradaProdutoDAO.atualizaEntradaProduto(entradaProduto);
//				break;
//			case 2:
//				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade: "));
//				entradaProduto.setQuantidade(quantidade);
//				entradaProdutoDAO.atualizaEntradaProduto(entradaProduto);
//				break;
//			case 3:
//				double valorUnitario = Double
//						.parseDouble(JOptionPane.showInputDialog("Digite o novo valor unit�rio: "));
//				entradaProduto.setValor_unitario(valorUnitario);
//				entradaProdutoDAO.atualizaEntradaProduto(entradaProduto);
//				break;
//			case 4:
//				int idFornecedor = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do fornecedor: "));
//				Fornecedor fornecedor = fornecedorDAO.buscaFornecedor(idFornecedor);
//				entradaProduto.setFornecedor(fornecedor);
//				entradaProdutoDAO.atualizaEntradaProduto(entradaProduto);
//				break;
//			case 5:
//				System.out.println("Retornando a tela anterior...");
//				break;
//			default:
//				System.out.println("Op��o inv�lida!");
//				break;
//			}
//		} while (opcao != 5);
//
//	}

	public void Login() {

		boolean result = false;

//		System.out.println("Bem-vindo(a) ao Sistem de Ordem de Servi�o");
//		do {
//			String nomeUsuario = JOptionPane.showInputDialog("Nome de usu�rio: ");
//			String senha = JOptionPane.showInputDialog("Senha: ");
//			result = usuarioDAO.encontraLogin(nomeUsuario, senha);
//
//			if (!result) {
//				System.out.println("Usu�rio e/ou senha incorretos!");
//			}
//
//		} while (!result);
//		menuPrincipal();
	}

}