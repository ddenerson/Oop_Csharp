package model;

import java.time.LocalDate;
import java.util.Date;

public class Estoque {

	private int id;
	private Produto produto;
	private int quantidade;
	private double valor_unitario;
	private LocalDate dataCriacao;
	private LocalDate dataModificado;
	
	
	public Estoque(int id) {
		super();
		this.id = id;
	}
	
	public Estoque(Produto produto, int quantidade, double valor_unitario, LocalDate dataCriação,
			LocalDate dataModificado) {
		super();
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor_unitario = valor_unitario;
		this.dataCriacao = dataCriação;
		this.dataModificado = dataModificado;
	}	

	public Estoque(int id, Produto produto, int quantidade, double valor_unitario, LocalDate dataCriação,
			LocalDate dataModificado) {
		super();
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.valor_unitario = valor_unitario;
		this.dataCriacao = dataCriação;
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
		Estoque other = (Estoque) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", produto=" + produto + ", quantidade=" + quantidade + ", valor_unitario="
				+ valor_unitario + ", dataCriacao=" + dataCriacao + ", dataModificado=" + dataModificado + "]\n";
	}
	
		
	
}
