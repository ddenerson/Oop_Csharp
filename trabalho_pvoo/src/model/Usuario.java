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

	public Usuario(int id) {
		super();
		this.id = id;
	}

	public Usuario(String nome, String endereco, String cpf, String telefone, String login, String senha,
			LocalDate dataCriacao, LocalDate dataModificacao) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
	}

	public Usuario(int id, String nome, String endereco, String cpf, String telefone, String login, String senha,
			LocalDate dataCriacao, LocalDate dataModificacao) {
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + ", telefone="
				+ telefone + ", login=" + login + ", senha=" + senha + ", dataCriacao=" + dataCriacao
				+ ", dataModificacao=" + dataModificacao + "]\n";
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
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
