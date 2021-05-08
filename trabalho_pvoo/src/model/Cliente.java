package model;

import java.util.Date;

public class Cliente {

	private int id;
	private String nome;
	private String endereco;
	private String cpf;
	private String telefone;
	private Date dataCriacao;
	private Date dataModificacao;
	
	public Cliente()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(int id, String nome, String endereco, String cpf, String telefone, Date data_criacao,
			Date data_modificacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataCriacao = data_criacao;
		this.dataModificacao = data_modificacao;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
