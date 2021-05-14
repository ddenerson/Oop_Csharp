import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Cliente;
import model.ClienteDAO;
import model.OrdemServico;
import model.OrdemServicoDAO;
import model.Usuario;
import model.UsuarioDAO;

public class Main {

	ClienteDAO clienteDAO = new ClienteDAO();
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	OrdemServicoDAO ordemServicoDAO = new OrdemServicoDAO(clienteDAO.getClientes());

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
					 
					 Usuario novoUsario = new Usuario(id, nome, endereco, cpf, telefone,login,senha,dataCriacao, dataModificacao);
					 boolean resultado = usuarioDAO.insereUsuario(novoUsario);
					 
					 if (resultado){
							System.out.println("Usuario cadastrado com sucesso!");
				     }else{
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
					//menuAtualizarUsuario(id);
					break;
			   case 5:
					System.out.println("-- REMOVER USUARIOS -- \n");
					int idDeleta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuarios: "));
					Usuario usuarioDeleta = new Usuario(idDeleta);
					boolean resultadoDeleta = usuarioDAO.deletaUsuario(usuarioDeleta);
					  if (resultadoDeleta) {
						    System.out.println("Usuario deletado com sucesso!");
					  }else {
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
	   }while (opcao != 6);
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
		} while(opcao != 6);
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
			   
			   }

			
		} while(opcao != 6);
		
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
				   
				   }

				
			} while(opcao != 6);
			
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
				   
				   }

				
			} while(opcao != 6);
			
		
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
				   
				   }

				
			} while(opcao != 6);
			
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
				   
				   }

				
			} while(opcao != 6);
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

			
		}while(opcao != 6);
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
