package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionFactory;

public class ClienteDAO {

	// Insere um novo cliente.Se existe um espa�o vazio entre 2 cliente,
	// Ent�o o novo cliente ser� criado nessa posi��o
	public int insereCliente(Cliente c) {

		int resultado = 0;

		String insert = "INSERT INTO cliente" + "(nome, endereco, cpf, telefone, dataCriacao, dataModificacao)"
				+ "VALUES(?,?,?,?,?,?)";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(insert)) {

			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEndereco());
			stmt.setString(3, c.getCpf());
			stmt.setString(4, c.getTelefone());
			stmt.setDate(5, Date.valueOf(c.getDataCriacao()));
			stmt.setDate(6, Date.valueOf(c.getDataModificacao()));

			resultado = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Error:" + e);
		}

		return resultado;
	}

	// Realiza a busca pelo cliente usando o id e retorna um objeto
	// Cliente com os dados encontrados
	public Cliente buscaCliente(int id) {

		Cliente cliente = null;
		String select = "SELECT nome,endereco,cpf,telefone,dataCriacao,dataModificacao FROM cliente WHERE id = ?";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(select)) {

			stmt.setLong(1, id);

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {
					cliente = new Cliente();
					cliente.setId(id);
					cliente.setNome(rs.getString("nome"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setTelefone(rs.getString("telefone"));
					cliente.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
					cliente.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
				}
				rs.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException("Error:" + e);
		}

		return cliente;
	}

	// Recebe um objeto do tipo cliente contendo o id e as informa��es que ser�o
	// atualizadas
	public int atualizaCliente(Cliente c) {

		String update = "update cliente set nome = ?, endereco = ?, cpf = ?, telefone = ?, dataCriacao = ?, dataModificacao = ? where id = ?";
		int resultado = 0;
		
		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(update)) {
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEndereco());
			stmt.setString(3, c.getCpf());
			stmt.setString(4, c.getTelefone());
			stmt.setDate(5, Date.valueOf(c.getDataCriacao()));
			stmt.setDate(6, Date.valueOf(c.getDataModificacao()));
			stmt.setLong(7, c.getId());

			resultado = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Error:" + e);
		}
		
		return resultado;
	}

	// Recebe o id do cliente e o exclui do banco de dados
	public int deletaCliente(int id) {
		String delete = "DELETE FROM cliente WHERE id = ?";
		int resultado = 0;

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(delete)) {

			stmt.setLong(1, id);
			resultado = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Error:" + e);
		}

		return resultado;
	}

	// Lista todos os clientes cadastrados
	public List<Cliente> listarClientes() {

		List<Cliente> clientes = new ArrayList<Cliente>();

		String select = "SELECT id,nome,endereco,cpf,telefone,dataCriacao,dataModificacao FROM cliente";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(select)) {

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {
					Cliente cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"),
							rs.getString("cpf"), rs.getString("telefone"), rs.getDate("dataCriacao").toLocalDate(),
							rs.getDate("dataModificacao").toLocalDate());

					clientes.add(cliente);
				}

			}

		} catch (SQLException e) {
			throw new RuntimeException("Error:" + e);
		}

		return clientes;
	}

	public Cliente[] getClientes() {
		return null;
	}

}
