package model;

import java.time.LocalDate;

public class NotaFiscalDAO {

	NotaFiscal[] ntFiscal = new NotaFiscal[50];
	int contador;


	public NotaFiscalDAO() {
		
		NotaFiscal nF1 = new NotaFiscal(1,15000,"preta com azul","pequena",LocalDate.now(), LocalDate.now());
		NotaFiscal nF2 = new NotaFiscal(2,15025,"verde","grande",LocalDate.now(),LocalDate.now());
		
		this.insereNotaFiscal(nF1);
		this.insereNotaFiscal(nF2);

	}
	
	
	public int verificaPosicao() {

		for (int i = 0; i < ntFiscal.length; i++) {
			if (ntFiscal[i] == null) {
				return i;
			}
			contador++;
		}

		return -1;
	}
	
	public boolean insereNotaFiscal(NotaFiscal novaNotaFiscal) {

		int posicao = verificaPosicao();
		if (posicao == -1) {
			return false;
		}
		novaNotaFiscal.setId(posicao + 1);
		this.ntFiscal[posicao] = novaNotaFiscal;
		return true;

	}
	
	public int encontrarNotaFiscal(NotaFiscal notaASerExcluido) {
		for (int i = 0; ntFiscal.length > i; i++) {
			if (ntFiscal[i] != null && ntFiscal[i].equals(notaASerExcluido)) {
				return i;
			}
		}
		return -1;
	}
	
	public NotaFiscal buscaNotaFiscal(int id) {
		NotaFiscal notaFiscal = new NotaFiscal(id);
		int pos = encontrarNotaFiscal(notaFiscal);
		
		if (pos != -1) {
			return this.ntFiscal[pos];
		}
		
		return null;
	}
	
	
	
	public boolean deletaNotaFiscal(NotaFiscal notaASerExcluido) {
		int posicaoNotaFiscal = encontrarNotaFiscal(notaASerExcluido);

		if (posicaoNotaFiscal == -1) {
			return false;
		}

		ntFiscal[posicaoNotaFiscal] = null;
		return true;
	}
	
	
	public String listarNotaFiscal(NotaFiscal c) {
		if (encontrarNotaFiscal(c) != -1) {
			return ntFiscal[encontrarNotaFiscal(c)].toString();
		}
		return "Não encontrado.";
	}
	

	public String listarTodasNotaFiscais() {

		String listaNotasFiscais = "-- Nota Fiscais -- " + "\n";

		for (int i = 0; ntFiscal.length > i; i++) {
			if (ntFiscal[i] != null) {
				listaNotasFiscais += ntFiscal[i].toString();
			}
		}
		if (listaNotasFiscais.contentEquals("-- Nota Fiscais -- " + "\n")) {
			listaNotasFiscais = "Nenhum nota fiscal.";
		}

		return listaNotasFiscais;
	}

	
}
