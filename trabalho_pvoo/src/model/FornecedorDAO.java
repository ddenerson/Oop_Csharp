package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionFactory;

public class FornecedorDAO {

	// Insere um novo fornecedor no banco de dados
	public int insereFornecedor(Fornecedor f) {
		
		int resultado = 0;

		String insert = "INSERT INTO fornecedor"
				+ "(nome, telefone, cnpj, estoqueMax, dataCriacao, dataModificacao)" + "VALUES(?,?,?,?,?,?)";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(insert)) {

			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getTelefone());
			stmt.setString(3, f.getCnpj());
			stmt.setInt(4, f.getEstoqueMaximo());
			stmt.setDate(5, Date.valueOf(f.getDataCriacao()));
			stmt.setDate(6, Date.valueOf(f.getDataModificacao()));

			resultado = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	// Usa o id para buscar os dados do fornecedor e retorna um objeto Fornecedor
	public Fornecedor buscaFornecedor(int id) {
		Fornecedor fornecedor = null;
		String select = "SELECT nome, telefone, cnpj, estoqueMax, dataCriacao, dataModificacao FROM fornecedor WHERE id = ?";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(select)) {

			stmt.setLong(1, id);

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {
					fornecedor = new Fornecedor(id);
					fornecedor.setNome(rs.getString("nome"));
					fornecedor.setTelefone(rs.getString("telefone"));
					fornecedor.setCnpj(rs.getString("cnpj"));
					fornecedor.setEstoqueMaximo(rs.getInt("estoqueMax"));
					fornecedor.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
					fornecedor.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
				}
				rs.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return fornecedor;
	}
	
	// Recebe um objeto do tipo Fornecedor contendo o id e as informa��es que ser�o atualizadas
	public int atualizaFornecedor(Fornecedor f) {

		String update = "UPDATE fornecedor SET nome = ?, telefone = ?, cnpj = ?, estoqueMax = ?, dataCriacao = ?, dataModificacao = ? WHERE id = ?";
		int resultado = 0;

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(update)) {

			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getTelefone());
			stmt.setString(3, f.getCnpj());
			stmt.setInt(4, f.getEstoqueMaximo());
			stmt.setDate(5, Date.valueOf(f.getDataCriacao()));
			stmt.setDate(6, Date.valueOf(f.getDataModificacao()));
			stmt.setInt(7, f.getId());

			resultado = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	// Recebe o id do fornecedor e o exclui do banco de dados
		public int deletaFornecedor(int id) {
			String delete = "DELETE FROM fornecedor WHERE id = ?";
			int resultado = 0;

			try (Connection connection = new ConnectionFactory().getConnection();
					PreparedStatement stmt = connection.prepareStatement(delete)) {

				stmt.setLong(1, id);
				resultado = stmt.executeUpdate();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return resultado;
		}
		
		// Lista todos os fornecedores cadastrados
		public List<Fornecedor> listarFornecedores() {

				List<Fornecedor> fornecedores = null;

				String select = "SELECT id, nome, telefone, cnpj, estoqueMax, dataCriacao, dataModificacao FROM fornecedor";

				try (Connection connection = new ConnectionFactory().getConnection();
						PreparedStatement stmt = connection.prepareStatement(select)) {

					try (ResultSet rs = stmt.executeQuery()) {
						fornecedores = new ArrayList<Fornecedor>();
						
						while (rs.next()) {
							
							Fornecedor fornecedor = new Fornecedor(
							rs.getInt("id"),
							rs.getString("nome"),
							rs.getString("telefone"),
							rs.getString("cnpj"),
							rs.getInt("estoqueMax"),
							rs.getDate("dataCriacao").toLocalDate(),
							rs.getDate("dataModificacao").toLocalDate());
							
							fornecedores.add(fornecedor);
						}
						rs.close();
					}

				} catch (SQLException e) {
					throw new RuntimeException(e);
				}

				return fornecedores;
			}
}
