package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private final String USER = "root";
    private final String PASSWORD = "12345678";
	private final String SERVER_ADDRESS = "172.17.0.3";
	private final String PORT = "3306";
	private final String DATABASE = "trabalhopoo";
	
    private final String stringConexao = "jdbc:mysql://" + SERVER_ADDRESS + ":" + PORT + "/" + DATABASE;

    public Connection getConnection() {

        try {
        	
            return DriverManager.getConnection(stringConexao, USER, PASSWORD);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}