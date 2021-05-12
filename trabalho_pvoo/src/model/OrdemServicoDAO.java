package model;

import java.time.LocalDate;
import java.util.Date;

public class OrdemServicoDAO {
	
	private OrdemServico[] ordens = new OrdemServico[40];
	int contador;
	
	public OrdemServicoDAO(Cliente[] clientes) {
		
		OrdemServico ordem1 = new OrdemServico(1, "Instala��o de m�dulo de mem�ria", "Processando",clientes[0],100,"Carl�o",LocalDate.now(), LocalDate.now());
		OrdemServico ordem2 = new OrdemServico(2, "Limpeza", "Processando",clientes[1],100,"Carl�o",LocalDate.now(), LocalDate.now());
		OrdemServico ordem3 = new OrdemServico(3, "Troca de pasta t�mica", "Processando",clientes[2],100,"Carl�o",LocalDate.now(), LocalDate.now());
		OrdemServico ordem4 = new OrdemServico(4, "Instala��o de m�dulo de mem�ria 2", "Processando",clientes[3],100,"Carl�o",LocalDate.now(), LocalDate.now());
		OrdemServico ordem5 = new OrdemServico(5, "Instala��o de m�dulo de mem�ria 3", "Processando",clientes[4],100,"Carl�o",LocalDate.now(), LocalDate.now());
		OrdemServico ordem6 = new OrdemServico(6, "Instala��o de m�dulo de mem�ria 4", "Processando",clientes[5],100,"Carl�o",LocalDate.now(), LocalDate.now());
		OrdemServico ordem7 = new OrdemServico(7, "Instala��o de m�dulo de mem�ria 5", "Processando",clientes[6],100,"Carl�o",LocalDate.now(), LocalDate.now());
		OrdemServico ordem8 = new OrdemServico(8, "Instala��o de m�dulo de mem�ria 6", "Processando",clientes[7],100,"Carl�o",LocalDate.now(), LocalDate.now());
		OrdemServico ordem9 = new OrdemServico(9, "Instala��o de m�dulo de mem�ria 7", "Processando",clientes[8],100,"Carl�o",LocalDate.now(), LocalDate.now());
		OrdemServico ordem10 = new OrdemServico(10, "Instala��o de m�dulo de mem�ria 8", "Processando",clientes[9],100,"Carl�o",LocalDate.now(), LocalDate.now());
		
		this.insereOrdem(ordem1);
		this.insereOrdem(ordem2);
		this.insereOrdem(ordem3);
		this.insereOrdem(ordem4);
		this.insereOrdem(ordem5);
		this.insereOrdem(ordem6);
		this.insereOrdem(ordem7);
		this.insereOrdem(ordem8);
		this.insereOrdem(ordem9);
		this.insereOrdem(ordem10);
	}
	
	public int verificaPosicao() {

		for (int i = 0; i < ordens.length; i++) {
			if (ordens[i] == null) {
				return i;
			}
			contador++;
		}

		return -1;
	}
	
	

	// Insere uma nova ordem de servi�o. Se existe um espa�o vazio entre duas ordens de servi�o,
	// a nova ordem de servi�o ser� criada nessa posi��o
		public boolean insereOrdem(OrdemServico novaOrdem) {

			int posicao = verificaPosicao();
			if (posicao == -1) {
				return false;
			}
			novaOrdem.setId(posicao + 1);
			this.ordens[posicao] = novaOrdem;
			return true;
		}
		
		// Encontra a posi��o da ordem de servico
		public int encontrarOrdem(OrdemServico ordem) {
			for (int i = 0; ordens.length > i; i++) {
				if (ordens[i] != null && ordens[i].equals(ordem)) {
					return i;
				}
			}
			return -1;
		}
		
		// M�todo que busca usando o id e retorna a ordem de servico
		public OrdemServico buscaOrdem(int id) {
			OrdemServico ordem = new OrdemServico(id);
			int pos = encontrarOrdem(ordem);
			
			if (pos != -1) {
				return this.ordens[pos];
			}
			
			return null;
		}
		
		// M�todo que recebe um objeto que cont�m o id e as informa��es que devem ser atualizadas
		public boolean atualizarOrdem(OrdemServico ordemServico) {
			
			// � realizada a busca pela ordem de servico que ser� atualizado
			OrdemServico ordem = this.buscaOrdem(ordemServico.getId());
			
			// � verificado quais informa��es foram preenchidas para atualizar
			if (ordemServico.getDescricao() != null) {
				ordem.setDescricao(ordemServico.getDescricao());
			}
			if (ordemServico.getEstado() != null) {
				ordem.setEstado(ordemServico.getEstado());
			}
			// TODO: Implementar busca por cliente para que ele possa ser inserido na ordem de servico
			if (ordemServico.getCliente() != null) {
				ordem.setCliente(ordemServico.getCliente());
			}
			if (ordemServico.getValor() != 0.0d) {
				ordem.setValor(ordemServico.getValor());
			}
			if (ordemServico.getMecanico() != null) {
				ordem.setMecanico(ordemServico.getMecanico());
			}
			// atualiza a data de modifica��o para o momento em que o objeto � atualizado
			ordem.setData_modificacao(LocalDate.now());
			
			return true;
		}
		
		// Lista todas as ordens de servico
		public String listarTodasOrdens() {

			String listaOrdens = "-- Ordens de Servi�o -- " + "\n";

			for (int i = 0; ordens.length > i; i++) {
				if (ordens[i] != null) {
					listaOrdens += ordens[i].toString();
				}
			}
			if (listaOrdens.contentEquals("-- Ordens de Servi�o -- " + "\n")) {
				listaOrdens = "Nenhuma ordem de servico encontrada.";
			}

			return listaOrdens;
		}
		
}
