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

			// Cria um novo usuario e insere no DAO
			case 1:

				System.out.println("-- NOVO USUARIO -- \n");

				// Captura os dados necessários para criar um usuário
				String nome = JOptionPane.showInputDialog("Nome: ");
				String endereco = JOptionPane.showInputDialog("Endereço: ");
				String cpf = JOptionPane.showInputDialog("CPF: ");
				String telefone = JOptionPane.showInputDialog("Telefone: ");
				String login = JOptionPane.showInputDialog("Login: ");
				String senha = JOptionPane.showInputDialog("Senha: ");
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				// Instância um objeto Usuário usando os dados capturados anteriormente
				Usuario novoUsario = new Usuario(nome, endereco, cpf, telefone, login, senha, dataCriacao,
						dataModificacao);
				
				// Insere o novo usuário no vetor do DAO
				boolean resultado = usuarioDAO.insereUsuario(novoUsario);

				if (resultado) {
					System.out.println("Usuario cadastrado com sucesso!");
				} else {
					System.out.println("Não foi possível cadastrar o usuario!");
				}
				
				break;
			case 2:

				System.out.println("-- CONSULTAR USUARIO -- \n");
				
				// Captura o id do usuário que será consultado
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
				Usuario usuarioPesquisado = new Usuario(id);
				String usuarioString = usuarioDAO.listarUsario(usuarioPesquisado);

				// Se o usuário existir os dados são mostrados
				System.out.println(usuarioString);
				
				break;
			case 3:
				System.out.println("-- USUARIOS CADASTRADOS -- \n");
				
				// Retorna uma string contendo todos os usuários do vetor que está no DAO
				String listaUsuarios = usuarioDAO.listarTodosUsuarios();
				
				// Lista todos os usuários
				System.out.println(listaUsuarios);
				
				break;
			case 4:
				System.out.println("-- ATUALIZAR USUARIOS -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuarios: "));
				menuAtualizarUsuario(id);
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
				
				// Captura o id do cliente que será atualizado
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
				
				// Método que apresenta o menu com as opções
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
		OrdemServico ordem;

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
			case 5:
				System.out.println("-- REMOVER ORDEM DE SERVIÇO -- \n");
				
				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da ordem de serviço: "));
				ordem = new OrdemServico(idDeleta);
				
				boolean resultadoDeleta = ordemServicoDAO.deletaOrdemServico(ordem);
						
				if (resultadoDeleta) {
					System.out.println("Ordem de serviço excluída com sucesso!");
				}else {
					System.out.println("Não foi possível excluir a ordem de serviço!");
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

				String nome = JOptionPane.showInputDialog("Nome: ");
				String telefone = JOptionPane.showInputDialog("Telefone: ");
				String cnpj = JOptionPane.showInputDialog("CNPJ: ");
				int estoqueMaximo = Integer.parseInt(JOptionPane.showInputDialog("Estoque Maximo: "));
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				Fornecedor novofornecedor = new Fornecedor(nome, telefone, cnpj, estoqueMaximo, dataCriacao,
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
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do fornecedor: "));
				Fornecedor fornecedorPesquisado = new Fornecedor(id);
				String fornecedorString = fornecedorDAO.listarFornecedor(fornecedorPesquisado);

				System.out.println(fornecedorString);
				break;
			case 3:
				System.out.println("-- FORNECEDOR CADASTRADOS -- \n");
				String listaFornecedor = fornecedorDAO.listarTodosFornecedor();
				System.out.println(listaFornecedor);
				
				break;
			case 4:
				System.out.println("-- ATUALIZAR FORNECEDOR -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do fornecedor: "));
				menuAtualizarFornecedor(id);
				break;
			case 5:
				System.out.println("-- REMOVER FORNECEDOR -- \n");
				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do fornecedor: "));
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

				System.out.println("-- NOVO PRODUTO -- \n");
				
				// Captura os dados necessários para criar um novo produto
				String status = JOptionPane.showInputDialog("Status: ");
				String descricao = JOptionPane.showInputDialog("Descricao: ");
				int estoqueMinimo = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque minimo: "));
				int estoqueMaximo = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque maximo: "));
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				// Cria um objeto do tipo Produto que será inserido no DAO
				Produto novoProduto = new Produto(status, descricao, estoqueMinimo, estoqueMaximo, dataCriacao,
						dataModificacao);
				boolean resultado = produtoDAO.insereProduto(novoProduto);

				if (resultado) {
					System.out.println("Produto cadastrado com sucesso!");
				} else {
					System.out.println("Não foi possível cadastrar o produto!");
				}
				break;
			case 2:

				System.out.println("-- CONSULTAR PRODUTO -- \n");
				
				// Captura o id do produto que será pesquisado
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
				
				// Cria um objeto do tipo produto contendo apenas o id
				Produto produtoPesquisado = new Produto(id);
				
				// Recebe o objeto em forma de string
				String produtoString = produtoDAO.listarProduto(produtoPesquisado);

				// Exibe a string do objeto Produto
				System.out.println(produtoString);

				break;
			case 3:

				System.out.println("-- PRODUTOS CADASTRADOS -- \n");
				String listaProdutos = produtoDAO.listarTodosProdutos();
				System.out.println(listaProdutos);

				break;
			case 4:
				System.out.println("-- ATUALIZAR PRODUTOS -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
				menuAtualizarProduto(id);
				break;
			case 5:
				System.out.println("-- REMOVER PRODUTOS -- \n");
				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
				Produto produtoDeleta = new Produto(idDeleta);
				boolean resultadoDeleta = produtoDAO.deletaProduto(produtoDeleta);

				if (resultadoDeleta) {
					System.out.println("Produto deletado com sucesso!");
				} else {
					System.out.println("Não foi possível deletar o produto!");
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
			menu.append("1. Nova Entrada de Produto").append("\n");
			menu.append("2. Consultar Entrada de Produto").append("\n");
			menu.append("3. Listar Entrada de Produto").append("\n");
			menu.append("4. Atualizar Entrada de Produto").append("\n");
			menu.append("5. Remover Entrada de Produto").append("\n");
			menu.append("6. Voltar").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			switch (opcao) {

			case 1:

				System.out.println("-- NOVA ENTRADA DE PRODUTO -- \n");
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
				Produto produto = produtoDAO.buscaProduto(id);
				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
				double valorUnitario = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor unitario: "));
				Fornecedor fornecedor = fornecedorDAO.buscaFornecedor(id);
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				EntradaProduto novoEntradaProduto = new EntradaProduto(produto, quantidade, valorUnitario,
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
				System.out.println(listaEntradaProdutos);
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
			menu.append("1. Novo Estoque").append("\n");
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

				System.out.println("-- NOVO ESTOQUE -- \n");
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
				Produto produto = produtoDAO.buscaProduto(id);
				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
				double valorUnitario = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor unitario: "));
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				Estoque novoEstoque = new Estoque(produto, quantidade, valorUnitario, dataCriacao, dataModificacao);
				boolean resultado = estoqueDAO.insereEstoque(novoEstoque);

				if (resultado) {
					System.out.println("Estoque cadastrado com sucesso!");
				} else {
					System.out.println("Não foi possível cadastrar o estoque!");
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
				System.out.println(listaEstoque);
				break;
			case 4:
				System.out.println("-- ATUALIZAR ESTOQUE -- \n");
				id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do estoque: "));
				menuAtualizarEstoque(id);
				break;
			case 5:
				System.out.println("-- REMOVER ESTOQUE -- \n");
				int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do estoque: "));
				Estoque estoqueDeleta = new Estoque(idDeleta);
				boolean resultadoDeleta = estoqueDAO.deletaEstoque(estoqueDeleta);
				
				if (resultadoDeleta) {
					System.out.println("Estoque removido com sucesso!");
				}else {
					System.out.println("Não foi possível remover o estoque!");
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

	public void menuSaidaProduto() {
		int opcao;

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- SAIDA PRODUTO  --").append("\n");
			menu.append("1. Nova Saida de Produto").append("\n");
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

				System.out.println("-- NOVA SAIDA DE PRODUTO -- \n");

				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do produto: "));
				Produto produto = produtoDAO.buscaProduto(id);
				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: "));
				double valorUnitario = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor unitario: "));
				Fornecedor fornecedor = fornecedorDAO.buscaFornecedor(id);
				LocalDate dataCriacao = LocalDate.now();
				LocalDate dataModificacao = LocalDate.now();

				SaidaProduto novoSaidaProduto = new SaidaProduto(produto, quantidade, valorUnitario, fornecedor,
						dataCriacao, dataModificacao);
				boolean resultado = saidaProdutoDAO.insereSaidaProduto(novoSaidaProduto);

				if (resultado) {
					System.out.println("Produto cadastrado com sucesso!");
				} else {
					System.out.println("Não foi possível cadastrar o produto!");
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
				System.out.println(listaProdutos);
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
			menu.append("8. ENTRADA DE PRODUTO").append("\n");
			menu.append("9. SAIDA DE PRODUTO").append("\n");
			menu.append("10. SAIR").append("\n");


			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			// Menu que realiza as operações
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
				menuEstoque();
				break;
			case 6:
				break;
			case 7:
				menuOrdemServico();
				break;
			case 8:
				menuEntradaProduto();
				break;
			case 9:
				menuSaidaProduto();
				break;
			case 10:
				System.out.println("Retornando a tela de login...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (opcao != 10);
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
	
	public void menuAtualizarUsuario(int id) {
		int opcao;
		Usuario usuario = new Usuario(id);

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ATUALIZAR USUÁRIO --").append("\n");
			menu.append("1. NOME").append("\n");
			menu.append("2. ENDEREÇO").append("\n");
			menu.append("3. CPF").append("\n");
			menu.append("4. TELEFONE").append("\n");
			menu.append("5. LOGIN").append("\n");
			menu.append("6. SENHA").append("\n");
			menu.append("7. VOLTAR").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			// Menu que realiza as operações
			switch (opcao) {
			case 1:
				String nome = JOptionPane.showInputDialog("Digite o novo nome: ");
				usuario.setNome(nome);
				usuarioDAO.atualizaUsuario(usuario);
				break;
			case 2:
				String endereco = JOptionPane.showInputDialog("Digite o novo endereço: ");
				usuario.setEndereco(endereco);
				usuarioDAO.atualizaUsuario(usuario);
				break;
			case 3:
				String cpf = JOptionPane.showInputDialog("Digite o novo CPF: ");
				usuario.setCpf(cpf);
				usuarioDAO.atualizaUsuario(usuario);
				break;
			case 4:
				String telefone = JOptionPane.showInputDialog("Digite o novo telefone: ");
				usuario.setTelefone(telefone);
				usuarioDAO.atualizaUsuario(usuario);
				break;
			case 5:
				String login = JOptionPane.showInputDialog("Digite o novo login: ");
				usuario.setLogin(login);
				usuarioDAO.atualizaUsuario(usuario);
				break;
			case 6:
				String senha = JOptionPane.showInputDialog("Digite a nova senha: ");
				usuario.setSenha(senha);
				usuarioDAO.atualizaUsuario(usuario);
				break;
			case 7:
				System.out.println("Retornando a tela ao menu anterior...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (opcao != 7);

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
				ordemServicoDAO.atualizarOrdem(ordemServico);

				break;
			case 2:
				String estado = JOptionPane.showInputDialog("Digite o novo estado: ");
				ordemServico.setEstado(estado);
				ordemServicoDAO.atualizarOrdem(ordemServico);
				break;
			case 3:
				int clienteId = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do cliente: "));
				Cliente cliente = clienteDAO.buscaCliente(clienteId);
				ordemServico.setCliente(cliente);
				ordemServicoDAO.atualizarOrdem(ordemServico);
				break;
			case 4:				
				double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo valor: "));
				ordemServico.setValor(valor);
				ordemServicoDAO.atualizarOrdem(ordemServico);
				break;
			case 5:
				String mecanico = JOptionPane.showInputDialog("Digite o novo mecânico: ");
				ordemServico.setMecanico(mecanico);
				ordemServicoDAO.atualizarOrdem(ordemServico);
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
	
	public void menuAtualizarProduto(int id) {
		int opcao;
		Produto produto = new Produto(id);

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ATUALIZAR PRODUTO --").append("\n");
			menu.append("1. STATUS").append("\n");
			menu.append("2. DESCRICAO").append("\n");
			menu.append("3. ESTOQUE MINÍMO").append("\n");
			menu.append("4. ESTOQUE MÁXIMO").append("\n");
			menu.append("5. VOLTAR").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			// Menu que realiza as operações
			switch (opcao) {
			// Direciona para os menus
			case 1:
				String status = JOptionPane.showInputDialog("Digite o novo status: ");
				produto.setStatus(status);
				produtoDAO.atualizaProduto(produto);
				break;
			case 2:
				String descricao = JOptionPane.showInputDialog("Digite a nova descrição: ");
				produto.setDescricao(descricao);
				produtoDAO.atualizaProduto(produto);
				break;
			case 3:
				int estoqueMin = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque minímo: "));
				produto.setEstoque_minimo(estoqueMin);
				produtoDAO.atualizaProduto(produto);
				break;
			case 4:
				int estoqueMax = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque máximo: "));
				produto.setEstoque_maximo(estoqueMax);
				produtoDAO.atualizaProduto(produto);
				break;
			case 5:
				System.out.println("Retornando a tela anterior...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (opcao != 5);

	}
	
	public void menuAtualizarFornecedor(int id) {
		int opcao;
		Fornecedor fornecedor = new Fornecedor(id);

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ATUALIZAR FORNECEDOR --").append("\n");
			menu.append("1. NOME").append("\n");
			menu.append("2. TELEFONE").append("\n");
			menu.append("3. CNPJ").append("\n");
			menu.append("4. ESTOQUE MÁXIMO").append("\n");
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
				fornecedor.setNome(nome);
				fornecedorDAO.atualizaFornecedor(fornecedor);
				break;
			case 2:
				String telefone = JOptionPane.showInputDialog("Digite o novo telefone: ");
				fornecedor.setTelefone(telefone);
				fornecedorDAO.atualizaFornecedor(fornecedor);
				break;
			case 3:
				String cnpj = JOptionPane.showInputDialog("Digite o novo CNPJ: ");
				fornecedor.setCnpj(cnpj);
				fornecedorDAO.atualizaFornecedor(fornecedor);
				break;
			case 4:
				int estoqueMax = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque máximo: "));
				fornecedor.setEstoqueMaximo(estoqueMax);
				fornecedorDAO.atualizaFornecedor(fornecedor);
				break;
			case 5:
				System.out.println("Retornando a tela anterior...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (opcao != 5);

	}
	
	public void menuAtualizarEstoque(int id) {
		int opcao;
		Estoque estoque = new Estoque(id);

		do {
			// Constroi o menu
			StringBuilder menu = new StringBuilder("-- ATUALIZAR ESTOQUE --").append("\n");
			menu.append("1. PRODUTO").append("\n");
			menu.append("2. QUANTIDADE").append("\n");
			menu.append("3. VALOR UNITÁRIO").append("\n");
			menu.append("4. VOLTAR").append("\n");

			// Exibe o menu no terminal
			System.out.println(menu);

			// Captura a opção escolhida
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada: "));

			// Menu que realiza as operações
			switch (opcao) {
			// Direciona para os menus
			case 1:
				int produtoId = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do novo produto: "));
				Produto produto = produtoDAO.buscaProduto(produtoId);
				estoque.setProduto(produto);
				estoqueDAO.atualizaEstoque(estoque);
				break;
			case 2:
				int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade: "));
				estoque.setQuantidade(quantidade);
				estoqueDAO.atualizaEstoque(estoque);
				break;
			case 3:
				double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo valor unitário: "));
				estoque.setValor_unitario(valor);
				estoqueDAO.atualizaEstoque(estoque);
				break;
			case 4:
				System.out.println("Retornando a tela anterior...");
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (opcao != 4);

	}

}

	
