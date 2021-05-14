package model;

import java.time.LocalDate;
import java.util.Date;

public class Fornecedor
{
	private int id;
	private String nome;
	private String telefone;
	private String cnpj;
	private int estoqueMaximo;
	private LocalDate dataCriacao;
	private LocalDate dataModificado;
	
	public Fornecedor(int id) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
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
				+ dataModificado + "]";
	}
	
	
	
	
		
}
