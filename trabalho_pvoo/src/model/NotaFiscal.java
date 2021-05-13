package model;

import java.time.LocalDate;

public class NotaFiscal {
	
	private int id;
	private double valorTotal;
	private String descricao;
	private String tipo;
	private LocalDate dataCriacao;
	private LocalDate dataModificacao;
	
	
	public NotaFiscal(int id) {
		super();
		this.id = id;
		// TODO Auto-generated constructor stub
	}


	public NotaFiscal(int id, double valorTotal, String descricao, String tipo, LocalDate dataCriacao,
			LocalDate dataModificacao) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.descricao = descricao;
		this.tipo = tipo;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public LocalDate getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public LocalDate getDataModificacao() {
		return dataModificacao;
	}


	public void setDataModificacao(LocalDate dataModificacao) {
		this.dataModificacao = dataModificacao;
	}


	@Override
	public String toString() {
		return "NotaFiscal [id=" + id + ", valorTotal=" + valorTotal + ", descricao=" + descricao + ", tipo=" + tipo
				+ ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + "]";
	}
	
	
}
