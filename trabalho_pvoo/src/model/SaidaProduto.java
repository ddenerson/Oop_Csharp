package model;

import java.util.Date;

public class SaidaProduto {

	private int id;
	private Produto produto;
	private int quantidade;
	private double valor_unitario;
	private Fornecedor fornecedor;
	private Date dataCriacao;
	private Date dataModificado;
	
	
	public SaidaProduto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaidaProduto(int id, Produto produto, int quantidade, double valor_unitario, Fornecedor fornecedor,
			Date data_criacao, Date data_modificado) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor_unitario = valor_unitario;
		this.fornecedor = fornecedor;
		this.dataCriacao = data_criacao;
		this.dataModificado = data_modificado;
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

	public Date getData_criacao() {
		return dataCriacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.dataCriacao = data_criacao;
	}

	public Date getData_modificado() {
		return dataModificado;
	}

	public void setData_modificado(Date data_modificado) {
		this.dataModificado = data_modificado;
	}
	
	
}
