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

public class UsuarioDAO {

	// Insere um novo usuário no banco de dados.
	public int insereUsuario(Usuario u) {

		int resultado = 0;

		String insert = "INSERT INTO usuario"
				+ "(nome, endereco, cpf, telefone, dataCriacao, dataModificacao, login, senha)"
				+ "VALUES(?,?,?,?,?,?,?,?)";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(insert)) {

			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEndereco());
			stmt.setString(3, u.getCpf());
			stmt.setString(4, u.getTelefone());
			stmt.setDate(5, Date.valueOf(u.getDataCriacao()));
			stmt.setDate(6, Date.valueOf(u.getDataModificacao()));
			stmt.setString(7, u.getLogin());
			stmt.setString(8, u.getSenha());

			resultado = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Error:" + e);
		}

		return resultado;
	}

	// Realiza a busca pelo usuário usando o id e retorna um objeto
	// Usuario com os dados encontrados
	public Usuario buscaUsuario(int id) {

		Usuario usuario = null;
		String select = "SELECT nome,endereco,cpf,telefone,dataCriacao,dataModificacao,login,senha FROM usuario WHERE id = ?";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(select)) {

			stmt.setLong(1, id);

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {
					usuario = new Usuario();
					usuario.setId(id);
					usuario.setNome(rs.getString("nome"));
					usuario.setEndereco(rs.getString("endereco"));
					usuario.setCpf(rs.getString("cpf"));
					usuario.setTelefone(rs.getString("telefone"));
					usuario.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
					usuario.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
					usuario.setLogin(rs.getString("login"));
					usuario.setSenha(rs.getString("senha"));
				}
				rs.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException("Error:" + e);
		}

		return usuario;
	}

	// Recebe um objeto do tipo usuario contendo o id e as informa��es que ser�o
	// atualizadas
	public int atualizaUsuario(Usuario u) {

		String update = "UPDATE usuario SET nome = ?, endereco = ?, cpf = ?, telefone = ?, dataCriacao = ?, dataModificacao = ?, login = ?, senha = ? WHERE id = ?";
		int resultado = 0;

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(update)) {

			stmt.setString(1, u.getNome());
			stmt.setString(2, u.getEndereco());
			stmt.setString(3, u.getCpf());
			stmt.setString(4, u.getTelefone());
			stmt.setDate(5, Date.valueOf(u.getDataCriacao()));
			stmt.setDate(6, Date.valueOf(u.getDataModificacao()));
			stmt.setString(7, u.getLogin());
			stmt.setString(8, u.getSenha());
			stmt.setLong(9, u.getId());

			resultado = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}

	// Recebe o id do usuario e o exclui do banco de dados
	public int deletaUsuario(int id) {
		String delete = "DELETE FROM usuario WHERE id = ?";
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

	// Lista todos os usuarios cadastrados
	public List<Usuario> listarUsuarios() {

		List<Usuario> usuarios = null;

		String select = "SELECT id,nome,endereco,cpf,telefone,dataCriacao,dataModificacao,login,senha FROM usuario";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(select)) {

			try (ResultSet rs = stmt.executeQuery()) {
				usuarios = new ArrayList<Usuario>();
				while (rs.next()) {
					Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"),
							rs.getString("cpf"), rs.getString("telefone"), rs.getString("login"), rs.getString("senha"),
							rs.getDate("dataCriacao").toLocalDate(), rs.getDate("dataModificacao").toLocalDate());

					usuarios.add(usuario);
				}
				rs.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException("Error:" + e);
		}

		return usuarios;
	}

	public Usuario[] getClientes() {
		return null;
	}

}
