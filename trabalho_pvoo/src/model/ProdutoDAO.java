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

public class ProdutoDAO {

	// Insere um produto no banco de dados
	public int insereProduto(Produto p) {

		int resultado = 0;

		String insert = "INSERT INTO produto"
				+ "(status, descricao, estoqueMin, estoqueMax, dataCriacao, dataModificacao)" + "VALUES(?,?,?,?,?,?)";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(insert)) {

			stmt.setString(1, p.getStatus());
			stmt.setString(2, p.getDescricao());
			stmt.setInt(3, p.getEstoqueMinimo());
			stmt.setInt(4, p.getEstoqueMaximo());
			stmt.setDate(5, Date.valueOf(p.getDataCriacao()));
			stmt.setDate(6, Date.valueOf(p.getDataModificacao()));

			resultado = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;

	}

	// Realiza a busca pelo produto usando o id e retorna um objeto
	// Produto com os dados encontrados
	public Produto buscaProduto(int id) {

		Produto produto = null;
		String select = "SELECT status, descricao, estoqueMin, estoqueMax, dataCriacao, dataModificacao FROM produto WHERE id = ?";

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(select)) {

			stmt.setLong(1, id);

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {
					produto = new Produto(id);
					produto.setStatus(rs.getString("status"));
					produto.setDescricao(rs.getString("descricao"));
					produto.setEstoqueMinimo(rs.getInt("estoqueMin"));
					produto.setEstoqueMaximo(rs.getInt("estoqueMax"));
					produto.setDataCriacao(rs.getDate("dataCriacao").toLocalDate());
					produto.setDataModificacao(rs.getDate("dataModificacao").toLocalDate());
				}
				rs.close();
			}

		} catch (SQLException e) {
			throw new RuntimeException("Error:" + e);
		}

		return produto;
	}

	// Recebe um objeto do tipo produto contendo o id e as informa��es que ser�o
	// atualizadas
	public int atualizaProduto(Produto p) {

		String update = "UPDATE produto SET status = ?, descricao = ?, estoqueMin = ?, estoqueMax = ?, dataCriacao = ?, dataModificacao = ? WHERE id = ?";
		int resultado = 0;

		try (Connection connection = new ConnectionFactory().getConnection();
				PreparedStatement stmt = connection.prepareStatement(update)) {

			stmt.setString(1, p.getStatus());
			stmt.setString(2, p.getDescricao());
			stmt.setInt(3, p.getEstoqueMinimo());
			stmt.setInt(4, p.getEstoqueMaximo());
			stmt.setDate(5, Date.valueOf(p.getDataCriacao()));
			stmt.setDate(6, Date.valueOf(p.getDataModificacao()));
			stmt.setInt(7, p.getId());

			resultado = stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}

	// Recebe o id do produto e o exclui do banco de dados
	public int deletaProduto(int id) {
		String delete = "DELETE FROM produto WHERE id = ?";
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

	// Lista todos os produtos cadastrados
	public List<Produto> listarProdutos() {

			List<Produto> produtos = null;

			String select = "SELECT id, status, descricao, estoqueMin, estoqueMax, dataCriacao, dataModificacao FROM produto";

			try (Connection connection = new ConnectionFactory().getConnection();
					PreparedStatement stmt = connection.prepareStatement(select)) {

				try (ResultSet rs = stmt.executeQuery()) {
					produtos = new ArrayList<Produto>();
					while (rs.next()) {
						
						Produto produto = new Produto(
						rs.getInt("id"),
						rs.getString("status"),
						rs.getString("descricao"),
						rs.getInt("estoqueMin"),
						rs.getInt("estoqueMax"),
						rs.getDate("dataCriacao").toLocalDate(),
						rs.getDate("dataModificacao").toLocalDate());
						
						produtos.add(produto);
					}
					rs.close();
				}

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			return produtos;
		}
}
