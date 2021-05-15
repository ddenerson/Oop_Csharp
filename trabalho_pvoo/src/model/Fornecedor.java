package model;

import java.time.LocalDate;
import java.util.Date;

public class Fornecedor {
	private int id;
	private String nome;
	private String telefone;
	private String cnpj;
	private int estoqueMaximo;
	private LocalDate dataCriacao;
	private LocalDate dataModificado;

	public Fornecedor(int id) {
		super();
		this.id = id;
	}

	public Fornecedor(String nome, String telefone, String cnpj, int estoqueMaximo, LocalDate dataCriacao,
			LocalDate dataModificado) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.estoqueMaximo = estoqueMaximo;
		this.dataCriacao = dataCriacao;
		this.dataModificado = dataModificado;
	}

	public Fornecedor(int id, String nome, String telefone, String cnpj, int estoqueMaximo, LocalDate dataCriacao,
			LocalDate dataModificado) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.estoqueMaximo = estoqueMaximo;
		this.dataCriacao = dataCriacao;
		this.dataModificado = dataModificado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public int getEstoqueMaximo() {
		return estoqueMaximo;
	}

	public void setEstoqueMaximo(int estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataModificado() {
		return dataModificado;
	}

	public void setDataModificado(LocalDate dataModificado) {
		this.dataModificado = dataModificado;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", cnpj=" + cnpj
				+ ", estoqueMaximo=" + estoqueMaximo + ", dataCriacao=" + dataCriacao + ", dataModificado="
				+ dataModificado + "]\n";
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
		Fornecedor other = (Fornecedor) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
