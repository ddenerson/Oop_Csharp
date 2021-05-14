import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Cliente;
import model.ClienteDAO;
import model.EntradaProduto;
import model.EntradaProdutoDAO;
import model.Estoque;
import model.EstoqueDAO;
import model.Fornecedor;
import model.FornecedorDAO;
import model.OrdemServico;
import model.OrdemServicoDAO;
import model.Produto;
import model.ProdutoDAO;
import model.SaidaProduto;
import model.SaidaProdutoDAO;
import model.Usuario;
import model.UsuarioDAO;

public class Main {

	ClienteDAO clienteDAO = new ClienteDAO();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO(clienteDAO.getClientes());
	FornecedorDAO fornecedorDAO = new FornecedorDAO();
	ProdutoDAO produtoDAO = new ProdutoDAO();
	EntradaProdutoDAO entradaProdutoDAO = new EntradaProdutoDAO(produtoDAO.getProduto(), fornecedorDAO.getFornecedor());
	EstoqueDAO estoqueDAO = new EstoqueDAO(produtoDAO.getProduto());
	SaidaProdutoDAO saidaProdutoDAO = new SaidaProdutoDAO(produtoDAO.getProduto(), fornecedorDAO.getFornecedor());

	public Main() {
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
			menu.append("3. Listar usuario").append("\n");
			menu.append("4. Atualizar usuario").append("\n");
			menu.append("5. Remover usuario").append("\n");
			menu.append("6. Voltar").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			// Menu que realiza as operações
			switch (opcao) {

			// Cria um novo cliente e insere no DAO
			case 1:

				System.out.println("-- NOVO USUARIO -- \n");

				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuario: "));
				String nome = JOptionPane.showInputDialog("Nome: ");
				String endereco = JOptionPane.showInputDialog("Endereço: ");
				String cpf = JOptionPane.showInputDialog("CPF: ");
				String telefone = JOptionPane.showInputDialog("Telefone: ");
				String login = JOptionPane.showInputDialog("Login: ");
				String senha = JOptionPane.showInputDialog("Senha: ");
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				Usuario novoUsario = new Usuario(id, nome, endereco, cpf, telefone, login, senha, dataCriacao,
						dataModificacao);
				boolean resultado = usuarioDAO.insereUsuario(novoUsario);

				if (resultado) {
					System.out.println("Usuario cadastrado com sucesso!");
				} else {
					System.out.println("Não foi possível cadastrar o usuario!");
				}
				break;
			case 2:

				System.out.println("-- CONSULTAR USUARIO -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
				Usuario usuarioPesquisado = new Usuario(id);
				String usuarioString = usuarioDAO.listarUsario(usuarioPesquisado);

				// Se o cliente existir os dados são mostrados
				System.out.println(usuarioString);
				break;
			case 3:
				System.out.println("-- USUARIOS CADASTRADOS -- \n");
				String listaUsuarios = usuarioDAO.listarTodosUsuarios();
				System.out.println(usuarioDAO);
				break;
			case 4:
				System.out.println("-- ATUALIZAR USUARIOS -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuarios: "));
				// menuAtualizarUsuario(id);
				break;
			case 5:
				System.out.println("-- REMOVER USUARIOS -- \n");
				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuarios: "));
				Usuario usuarioDeleta = new Usuario(idDeleta);
				boolean resultadoDeleta = usuarioDAO.deletaUsuario(usuarioDeleta);
				if (resultadoDeleta) {
					System.out.println("Usuario deletado com sucesso!");
				} else {
					System.out.println("Não foi possível deletar o usuario!");
				}
				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;
			default:
				System.out.println("Opção inválida!");
				break;

			}
		} while (opcao != 6);
	}

	public void menuCliente() {
		int opcao;

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

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			// Menu que realiza as operações
			switch (opcao) {
			// Cria um novo cliente e insere no DAO
			case 1:
				System.out.println("-- NOVO CLIENTE -- \n");

				String nome = JOptionPane.showInputDialog("Nome: ");
				String endereco = JOptionPane.showInputDialog("Endereço: ");
				String cpf = JOptionPane.showInputDialog("CPF: ");
				String telefone = JOptionPane.showInputDialog("Telefone: ");
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				Cliente novoCliente = new Cliente(0, nome, endereco, cpf, telefone, dataCriacao, dataModificacao);
				boolean resultado = clienteDAO.insereCliente(novoCliente);

				if (resultado) {
					System.out.println("Cliente cadastrado com sucesso!");
				} else {
					System.out.println("Não foi possível cadastrar o cliente!");
				}
				break;
			case 2:
				System.out.println("-- CONSULTAR CLIENTE -- \n");

				// Recebe o id do cliente que será buscado
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
				// Cria um objeto do tipo Cliente com o id recebido anteriormente
				Cliente clientePesquisado = new Cliente(id);
				// Realiza a pesquisa usando o objeto criado anteriormente
				String clienteString = clienteDAO.listarCliente(clientePesquisado);
				// Se o cliente existir os dados são mostrados
				System.out.println(clienteString);

				break;
			case 3:
				System.out.println("-- CLIENTES CADASTRADOS -- \n");
				String listaClientes = clienteDAO.listarTodosClientes();
				System.out.println(listaClientes);
				break;
			case 4:
				System.out.println("-- ATUALIZAR CLIENTE -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
				menuAtualizarCliente(id);
				break;
			case 5:
				System.out.println("-- REMOVER CLIENTE -- \n");
				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
				Cliente clienteDeleta = new Cliente(idDeleta);
				boolean resultadoDeleta = clienteDAO.deletaCliente(clienteDeleta);
				if (resultadoDeleta) {
					System.out.println("Cliente deletado com sucesso!");
				} else {
					System.out.println("Não foi possível deletar o cliente!");
				}
				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (opcao != 6);
	}

	public void menuOrdemServico() {
		int opcao;

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ORDEM DE SERVICO --").append("\n");
			menu.append("1. Nova ordem de serviço").append("\n");
			menu.append("2. Consultar ordem de serviço").append("\n");
			menu.append("3. Listar ordens de serviço").append("\n");
			menu.append("4. Atualizar ordens de serviço").append("\n");
			menu.append("5. Remover ordem de serviço").append("\n");
			menu.append("6. Voltar").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			// Menu que realiza as operações
			switch (opcao) {
			// Cria uma nova ordem de servico e insere no DAO
			case 1:
				System.out.println("-- NOVA ORDEM DE SERVIÇO -- \n");

				String descricao = JOptionPane.showInputDialog("Descrição: ");
				String estado = JOptionPane.showInputDialog("Estado: ");
				int clienteId = Integer.parseInt(JOptionPane.showInputDialog("Número do cliente: "));
				Cliente cliente = clienteDAO.buscaCliente(clienteId);
				double valor = Integer.parseInt(JOptionPane.showInputDialog("Valor: "));
				String mecanico = JOptionPane.showInputDialog("Mecânico: ");
				LocalDate dataCriacaoOS = LocalDate.now();
				LocalDate dataModificacaoOS = LocalDate.now();

				OrdemServico novaOrdem = new OrdemServico(0, descricao, estado, cliente, valor, mecanico, dataCriacaoOS,
						dataModificacaoOS);

				// Usa o DAO para salvar
				boolean resultado = ordemServicoDAO.insereOrdem(novaOrdem);

				if (resultado) {
					System.out.println("Ordem de serviço criada com sucesso!");
				} else {
					System.out.println("Não foi possível criar a nova ordem de serviço.");
				}
				break;
			case 2:
				System.out.println("-- CONSULTAR ORDEM DE SERVIÇO -- \n");

				// Recebe o id da ordem de servico que será buscada
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da ordem de serviço: "));
				// Realiza a pesquisa usando o objeto criado anteriormente
				OrdemServico osEncontrada = ordemServicoDAO.buscaOrdem(id);
				// Se o cliente existir os dados são mostrados
				System.out.println(osEncontrada);

				break;
			case 3:
				System.out.println("-- LISTA ORDENS DE SERVICO -- \n");
				String listaOS = ordemServicoDAO.listarTodasOrdens();
				System.out.println(listaOS);
				break;
			case 4:
				System.out.println("-- ATUALIZAR ORDEM DE SERVICO -- \n");
				int idOS = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da ordem de serviço: "));
				menuAtualizarOrdemServico(idOS);
				break;
//			case 5:
//				System.out.println("-- REMOVER CLIENTE -- \n");
//				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
//				Cliente clienteDeleta = new Cliente(idDeleta);
//				boolean resultadoDeleta = clienteDAO.deletaCliente(clienteDeleta);
//				if (resultadoDeleta) {
//					System.out.println("Cliente deletado com sucesso!");
//				}else {
//					System.out.println("Não foi possível deletar o cliente!");
//				}
//				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (opcao != 6);
	}

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

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			switch (opcao) {

			case 1:

				System.out.println("-- NOVO FORNECEDOR -- \n");

				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuario: "));
				String nome = JOptionPane.showInputDialog("Nome: ");
				String telefone = JOptionPane.showInputDialog("Telefone: ");
				String cnpj = JOptionPane.showInputDialog("CNPJ: ");
				int estoqueMaximo = Integer.parseInt(JOptionPane.showInputDialog("Estoque Maximo: "));
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				Fornecedor novofornecedor = new Fornecedor(id, nome, telefone, cnpj, estoqueMaximo, dataCriacao,
						dataModificacao);
				boolean resultado = fornecedorDAO.insereFornecedor(novofornecedor);

				if (resultado) {
					System.out.println("Fornecedor cadastrado com sucesso!");
				} else {
					System.out.println("Não foi possível cadastrar o fornecedor!");
				}
				break;
			case 2:
				System.out.println("-- CONSULTAR FORNECEDOR -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
				Fornecedor fornecedorPesquisado = new Fornecedor(id);
				String fornecedorString = fornecedorDAO.listarFornecedor(fornecedorPesquisado);

				System.out.println(fornecedorString);
				break;
			case 3:
				System.out.println("-- FORNECEDOR CADASTRADOS -- \n");
				String listaFornecedor = fornecedorDAO.listarTodosFornecedor();
				System.out.println(fornecedorDAO);
				break;
			case 4:
				System.out.println("-- ATUALIZAR FORNECEDOR -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuarios: "));
				// menuAtualizarUsuario(id);
				break;
			case 5:
				System.out.println("-- REMOVER FORNECEDOR -- \n");
				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuarios: "));
				Fornecedor fornecedorDeleta = new Fornecedor(idDeleta);
				boolean resultadoDeleta = fornecedorDAO.deletaFornecedor(fornecedorDeleta);
				if (resultadoDeleta) {
					System.out.println("Fornecedor deletado com sucesso!");
				} else {
					System.out.println("Não foi possível deletar o fornecedor!");
				}
				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;
			default:
				System.out.println("Opção inválida!");
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

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			switch (opcao) {

			case 1:

				System.out.println("-- NOVO PRODUTO -- \\n");

				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuario: "));
				String status = JOptionPane.showInputDialog("Status: ");
				String descricao = JOptionPane.showInputDialog("Descricao: ");
				int estoqueMinimo = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque minimo: "));
				int estoqueMaximo = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque maximo: "));
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				Produto novoProduto = new Produto(id, status, descricao, estoqueMinimo, estoqueMaximo, dataCriacao,
						dataModificacao);
				boolean resultado = produtoDAO.insereProduto(novoProduto);

				if (resultado) {
					System.out.println("Usuario cadastrado com sucesso!");
				} else {
					System.out.println("Não foi possível cadastrar o usuario!");
				}
				break;
			case 2:

				System.out.println("-- CONSULTAR PRODUTO -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
				Produto produtoPesquisado = new Produto(id);
				String produtoString = produtoDAO.listarProduto(produtoPesquisado);

				System.out.println(produtoString);

				break;
			case 3:

				System.out.println("-- PRODUTOS CADASTRADOS -- \n");
				String listaProdutos = produtoDAO.listarTodosProdutos();
				System.out.println(produtoDAO);

				break;
			case 4:
				System.out.println("-- ATUALIZAR PRODUTOS -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produtos: "));
				break;
			case 5:
				System.out.println("-- REMOVER USUARIOS -- \n");
				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuarios: "));
				Produto produtoDeleta = new Produto(idDeleta);
				boolean resultadoDeleta = produtoDAO.deletaProduto(produtoDeleta);

				if (resultadoDeleta) {
					System.out.println("Usuario deletado com sucesso!");
				} else {
					System.out.println("Não foi possível deletar o usuario!");
				}
				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (opcao != 6);
	}

	public void menuEntradaProduto() {

		int opcao;

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ENTRADA DE PRODUTO  --").append("\n");
			menu.append("1. Novo Produto").append("\n");
			menu.append("2. Consultar Produto").append("\n");
			menu.append("3. Listar Produto").append("\n");
			menu.append("4. Atualizar Produto").append("\n");
			menu.append("5. Remover Produto").append("\n");
			menu.append("6. Voltar").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			switch (opcao) {

			case 1:

				System.out.println("-- NOVA ENTRADA DE PRODUTO -- \n");
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da entrada do produto: "));
				Produto produto = produtoDAO.buscaProduto(id);
				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
				int valorUnitario = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor unitario: "));
				Fornecedor fornecedor = fornecedorDAO.buscaFornecedor(id);
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				EntradaProduto novoEntradaProduto = new EntradaProduto(id, produto, quantidade, valorUnitario,
						fornecedor, dataCriacao, dataModificacao);
				boolean resultado = entradaProdutoDAO.insereEntradaProduto(novoEntradaProduto);

				if (resultado) {
					System.out.println("Usuario cadastrado com sucesso!");
				} else {
					System.out.println("Não foi possível cadastrar o usuario!");
				}
				break;
			case 2:
				System.out.println("-- CONSULTAR ENTRADA DE PRODUTOS -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da entrada de produto: "));
				EntradaProduto entradaProdutoPesquisado = new EntradaProduto(id);
				String usuarioString = entradaProdutoDAO.listarEntradaProduto(entradaProdutoPesquisado);
				System.out.println(usuarioString);
				break;
			case 3:
				System.out.println("--  CADASTRADOS ENTRADA DE PRODUTOS -- \n");
				String listaEntradaProdutos = entradaProdutoDAO.listarTodasEntradasProduto();
				System.out.println(entradaProdutoDAO);
				break;
			case 4:
				System.out.println("-- ATUALIZAR ENTRADA DE PRODUTOS -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuarios: "));
				break;
			case 5:
				System.out.println("-- REMOVER ENTRADA PRODUTOS -- \n");
				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id de entrada produtos: "));
				EntradaProduto entradaProdutoDeleta = new EntradaProduto(idDeleta);
				boolean resultadoDeleta = entradaProdutoDAO.deletaEntradaProduto(entradaProdutoDeleta);
				if (resultadoDeleta) {
					System.out.println("Usuario deletado com sucesso!");
				} else {
					System.out.println("Não foi possível deletar o usuario!");
				}
				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}

		} while (opcao != 6);

	}

	public void menuEstoque() {
		int opcao;

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ESTOQUE  --").append("\n");
			menu.append("1. Novo Produto").append("\n");
			menu.append("2. Consultar Estoque").append("\n");
			menu.append("3. Listar Estoque").append("\n");
			menu.append("4. Atualizar Estoque").append("\n");
			menu.append("5. Remover Estoque").append("\n");
			menu.append("6. Voltar").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			switch (opcao) {

			case 1:

				System.out.println("-- NOVO USUARIO ESTOQUE -- \n");
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuario: "));
				Produto produto = produtoDAO.buscaProduto(id);
				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
				double valorUnitario = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor unitario: "));
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				Estoque novoEstoque = new Estoque(id, produto, quantidade, valorUnitario, dataCriacao, dataModificacao);
				boolean resultado = estoqueDAO.insereEstoque(novoEstoque);

				if (resultado) {
					System.out.println("Usuario cadastrado com sucesso!");
				} else {
					System.out.println("Não foi possível cadastrar o usuario!");
				}
				break;
			case 2:
				System.out.println("-- CONSULTAR ESTOQUE -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do estoque: "));
				Estoque estoquePesquisado = new Estoque(id);
				String estoqueString = estoqueDAO.listarEstoque(estoquePesquisado);

				System.out.println(estoqueString);
				break;
			case 3:
				System.out.println("-- ESTOQUE CADASTRADOS -- \n");
				String listaEstoque = estoqueDAO.listarTodasEstoque();
				System.out.println(estoqueDAO);
				break;
			case 4:
				System.out.println("-- ATUALIZAR ESTOQUE -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do estoque: "));
				break;
			case 5:
				System.out.println("-- REMOVER ESTOQUE -- \n");
				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do estoque: "));
				Estoque estoqueDeleta = new Estoque(idDeleta);
				boolean resultadoDeleta = estoqueDAO.deletaEstoque(estoqueDeleta);
				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;
			default:
				System.out.println("Opção inválida!");
				break;

			}

		} while (opcao != 6);

	}

	public void menuSaidaProduto() {
		int opcao;

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- SAIDA PRODUTO  --").append("\n");
			menu.append("1. Novo Produto").append("\n");
			menu.append("2. Consultar Saida Produto").append("\n");
			menu.append("3. Listar Saida de Produtos ").append("\n");
			menu.append("4. Atualizar Saida Produto").append("\n");
			menu.append("5. Remover Saida Produto").append("\n");
			menu.append("6. Voltar").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			switch (opcao) {

			case 1:

				System.out.println("-- NOVO PRODUTO -- \n");

				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
				Produto produto = produtoDAO.buscaProduto(id);
				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
				double valorUnitario = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor unitario: "));
				Fornecedor fornecedor = fornecedorDAO.buscaFornecedor(id);
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				SaidaProduto novoSaidaProduto = new SaidaProduto(id, produto, quantidade, valorUnitario, fornecedor,
						dataCriacao, dataModificacao);
				boolean resultado = saidaProdutoDAO.insereSaidaProduto(novoSaidaProduto);

				if (resultado) {
					System.out.println("Usuario cadastrado com sucesso!");
				} else {
					System.out.println("Não foi possível cadastrar o usuario!");
				}
				break;
			case 2:

				System.out.println("-- CONSULTAR SAIDA DO PRODUTO -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id saida do produto: "));
				SaidaProduto saidaProdutoPesquisado = new SaidaProduto(id);
				String produtoPesquisadoString = saidaProdutoDAO.listarSaidaProduto(saidaProdutoPesquisado);
				System.out.println(produtoPesquisadoString);
				break;
			case 3:
				System.out.println("-- SAIDA PRODUTOS CADASTRADOS -- \n");
				String listaProdutos = saidaProdutoDAO.listarSaidaProdutoTodos();
				System.out.println(saidaProdutoDAO);
				break;
			case 4:
				System.out.println("-- ATUALIZAR SAIDA PRODUTOS -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: "));
				break;

			case 5:
				System.out.println("-- REMOVER SAIDA PRODUTOS -- \n");
				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id : "));
				SaidaProduto saidaProdutoDeleta = new SaidaProduto(idDeleta);
				boolean resultadoDeleta = saidaProdutoDAO.deletaSaidaProduto(saidaProdutoDeleta);

				if (resultadoDeleta) {
					System.out.println("Usuario deletado com sucesso!");
				} else {
					System.out.println("Não foi possível deletar o usuario!");
				}
				break;
			case 6:
				System.out.println("Retorna ao menu principal");
				break;

			default:
				System.out.println("Opção inválida!");
				break;

			}

		} while (opcao != 6);
	}

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

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			switch (opcao) {

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
			menu.append("7. ORDENS DE SERVIÇO").append("\n");
			menu.append("8. SAIR").append("\n");
			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			// Menu que realiza as operações
			switch (opcao) {
			// Direciona para os menus
			case 1:

				break;
			case 2:
				menuCliente();
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:
				break;
			case 7:
				menuOrdemServico();
				break;
			case 8:
				System.out.println("Retornando a tela de login...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (opcao != 8);
	}

	public void menuAtualizarCliente(int id) {
		int opcao;
		Cliente cliente = new Cliente(id);

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ATUALIZAR CLIENTE --").append("\n");
			menu.append("1. NOME").append("\n");
			menu.append("2. ENDEREÇO").append("\n");
			menu.append("3. CPF").append("\n");
			menu.append("4. TELEFONE").append("\n");
			menu.append("5. VOLTAR").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			// Menu que realiza as operações
			switch (opcao) {
			// Direciona para os menus
			case 1:
				String nome = JOptionPane.showInputDialog("Digite o novo nome: ");
				cliente.setNome(nome);
				clienteDAO.atualizaCliente(cliente);
				break;
			case 2:
				String endereco = JOptionPane.showInputDialog("Digite o novo endereço: ");
				cliente.setEndereco(endereco);
				clienteDAO.atualizaCliente(cliente);
				break;
			case 3:
				String cpf = JOptionPane.showInputDialog("Digite o novo CPF: ");
				cliente.setCpf(cpf);
				clienteDAO.atualizaCliente(cliente);
				break;
			case 4:
				String telefone = JOptionPane.showInputDialog("Digite o novo telefone: ");
				cliente.setTelefone(telefone);
				clienteDAO.atualizaCliente(cliente);
				break;
			case 5:
				System.out.println("Retornando a tela de menu...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (opcao != 5);

	}

	public void menuAtualizarOrdemServico(int id) {
		int opcao;
		OrdemServico ordemServico = new OrdemServico(id);

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ATUALIZAR ORDEM SERVICO --").append("\n");
			menu.append("1. DESCRIÇÃO").append("\n");
			menu.append("2. ESTADO").append("\n");
			menu.append("3. CLIENTE").append("\n");
			menu.append("4. VALOR").append("\n");
			menu.append("5. MECÂNICO").append("\n");
			menu.append("6. VOLTAR").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			// Menu que realiza as operações
			switch (opcao) {
			// Direciona para os menus
			case 1:
				String descricao = JOptionPane.showInputDialog("Digite a nova descrição: ");
				ordemServico.setDescricao(descricao);

				break;
			case 2:
				String estado = JOptionPane.showInputDialog("Digite o novo estado: ");
				ordemServico.setEstado(estado);

				break;
			case 3:
				String clienteId = JOptionPane.showInputDialog("Digite o id do cliente: ");
				Cliente cliente = clienteDAO.buscaCliente(id);
				System.out.println("Cliente encontrado? " + cliente);
				ordemServico.setCliente(cliente);
				ordemServicoDAO.atualizarOrdem(ordemServico);
				break;
			case 4:
				double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo valor: "));
				ordemServico.setValor(valor);

				break;
			case 5:
				String mecanico = JOptionPane.showInputDialog("Digite o novo mecânico: ");
				ordemServico.setMecanico(mecanico);

				break;
			case 6:
				System.out.println("Retornando a tela de menu...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (opcao != 6);

	}

}

	
