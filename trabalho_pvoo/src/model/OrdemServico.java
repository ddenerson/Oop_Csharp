package model;

import java.util.Date;

public class OrdemServico {
	
	private int id;
	private String descricao;
	private String estado;
	private Cliente cliente;
	private double valor;
	private String mecanico;
	private Date dataCriacao;
	private Date dataModificacao;
	
	
	
	public OrdemServico()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdemServico(int id, String descricao, String estado, Cliente cliente, double valor, String mecanico,
			Date data_criacao, Date data_modificacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.estado = estado;
		this.cliente = cliente;
		this.valor = valor;
		this.mecanico = mecanico;
		this.dataCriacao = data_criacao;
		this.dataModificacao = data_modificacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getMecanico() {
		return mecanico;
	}

	public void setMecanico(String mecanico) {
		this.mecanico = mecanico;
	}

	public Date getData_criacao() {
		return dataCriacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.dataCriacao = data_criacao;
	}

	public Date getData_modificacao() {
		return dataModificacao;
	}

	public void setData_modificacao(Date data_modificacao) {
		this.dataModificacao = data_modificacao;
	}
	
	

	
}
