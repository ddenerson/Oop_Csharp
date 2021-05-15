package model;

import java.time.LocalDate;
import java.util.Date;

public class EntradaProduto {

	private int id;
	private Produto produto;
	private int quantidade;
	private double valorUnitario;
	private Fornecedor fornecedor;
	private LocalDate dataCriacao;
	private LocalDate dataModificacao;
	
	public EntradaProduto(int id)
	{
		super();
		this.id = id;
		// TODO Auto-generated constructor stub
	}
	
	public EntradaProduto(Produto produto, int quantidade, double valor_unitario, Fornecedor fornecedor,
			LocalDate dataCriaca, LocalDate dataModificacao) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorUnitario = valor_unitario;
		this.fornecedor = fornecedor;
		this.dataCriacao = dataCriaca;
		this.dataModificacao = dataModificacao;
	}
	

	public EntradaProduto(int id, Produto produto, int quantidade, double valor_unitario, Fornecedor fornecedor,
			LocalDate dataCriaca, LocalDate dataModificacao) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorUnitario = valor_unitario;
		this.fornecedor = fornecedor;
		this.dataCriacao = dataCriaca;
		this.dataModificacao = dataModificacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor_unitario() {
		return valorUnitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valorUnitario = valor_unitario;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public LocalDate getData_criacao() {
		return dataCriacao;
	}

	public void setData_criacao(LocalDate data_criacao) {
		this.dataCriacao = data_criacao;
	}

	public LocalDate getData_modificacao() {
		return dataModificacao;
	}

	public void setData_modificacao(LocalDate data_modificacao) {
		this.dataModificacao = data_modificacao;
	}

	@Override
	public String toString() {
		return "EntradaProduto [id=" + id + ", produto=" + produto + ", quantidade=" + quantidade + ", valorUnitario="
				+ valorUnitario + ", fornecedor=" + fornecedor + ", dataCriacao=" + dataCriacao + ", dataModificacao="
				+ dataModificacao + "]\n";
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
		EntradaProduto other = (EntradaProduto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
}
