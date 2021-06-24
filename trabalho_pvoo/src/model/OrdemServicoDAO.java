package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import database.ConnectionFactory;

public class OrdemServicoDAO {
	
	ClienteDAO clienteDAO;

	public OrdemServicoDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

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


}
