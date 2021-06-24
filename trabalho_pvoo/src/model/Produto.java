package model;

import java.time.LocalDate;
import java.util.Date;

public class Produto {

	private int id;
	private String status;
	private String descricao;
	private int estoqueMinimo;
	private int estoqueMaximo;
	private LocalDate dataCriacao;
	private LocalDate dataModificacao;

	public Produto(int id) {
		super();
		this.id = id;
	}

	public Produto(String status, String descricao, int estoque_minimo, int estoque_maximo,
			LocalDate dataCriacao, LocalDate dataModificacao) {
		super();
		this.status = status;
		this.descricao = descricao;
		this.estoqueMinimo = estoque_minimo;
		this.estoqueMaximo = estoque_maximo;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
	}

	
	public Produto(int id, String status, String descricao, int estoque_minimo, int estoque_maximo,
			LocalDate dataCriacao, LocalDate dataModificacao) {
		super();
		this.id = id;
		this.status = status;
		this.descricao = descricao;
		this.estoqueMinimo = estoque_minimo;
		this.estoqueMaximo = estoque_maximo;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoque_minimo) {
		this.estoqueMinimo = estoque_minimo;
	}

	public int getEstoqueMaximo() {
		return estoqueMaximo;
	}

	public void setEstoqueMaximo(int estoque_maximo) {
		this.estoqueMaximo = estoque_maximo;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate data_criacao) {
		this.dataCriacao = data_criacao;
	}

	public LocalDate getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(LocalDate data_modificacao) {
		this.dataModificacao = data_modificacao;
	}

	@Override
	public String toString() {
		return "Produto[id=" + id + ", status=" + status + ", descricao=" + descricao + ", estoqueMinimo="
				+ estoqueMinimo + ", estoqueMaximo=" + estoqueMaximo + ", dataCriacao=" + dataCriacao
				+ ", dataModificacao=" + dataModificacao + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
