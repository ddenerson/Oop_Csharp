package model;

import java.time.LocalDate;
import java.util.Date;

public class SaidaProduto {

	private int id;
	private Produto produto;
	private int quantidade;
	private double valor_unitario;
	private Fornecedor fornecedor;
	private LocalDate dataCriacao;
	private LocalDate dataModificado;

	public SaidaProduto(int id) {
		super();
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	public SaidaProduto(int id, Produto produto, int quantidade, double valor_unitario, Fornecedor fornecedor,
			LocalDate dataCriaca, LocalDate dataModificado) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor_unitario = valor_unitario;
		this.fornecedor = fornecedor;
		this.dataCriacao = dataCriaca;
		this.dataModificado = dataModificado;
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
		return valor_unitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
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

	public LocalDate getData_modificado() {
		return dataModificado;
	}

	public void setData_modificado(LocalDate data_modificado) {
		this.dataModificado = data_modificado;
	}

}
