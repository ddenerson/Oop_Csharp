package model;

import java.time.LocalDate;
import java.util.Date;

public class Usuario {

	private int id;
	private String nome;
	private String endereco;
	private String cpf;
	private String telefone;
	private String login;
	private String senha;
	private LocalDate dataCriacao;
	private LocalDate dataModificacao;
	
	public Usuario(int i, String string, String string2, String string3, String string4, String string5, String string6, LocalDate dataCriacao, LocalDate dataModificacao)
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(int id, String nome, String endereco, String cpf, String telefone, String login, String senha,
			Date data_criacao, Date data_modificacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	
}
