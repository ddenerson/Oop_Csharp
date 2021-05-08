package model;

import java.util.Date;

public class Estoque {

	private int id;
	private Produto produto;
	private int quantidade;
	private double valor_unitario;
	private Date dataCriacao;
	private Date dataModificado;
	
	
	public Estoque() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estoque(int id, Produto produto, int quantidade, double valor_unitario, Date data_criacao,
			Date data_modificado) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor_unitario = valor_unitario;
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
