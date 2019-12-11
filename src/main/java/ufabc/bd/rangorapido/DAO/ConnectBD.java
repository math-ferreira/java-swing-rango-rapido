package ufabc.bd.rangorapido.DAO;

import java.sql.*;

public class ConnectBD {

	public Connection connectPostGreSQL() {
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/RANGORAPIDO";
		String username = "postgres";
		String password = "postmanmath";

		try {
			Class.forName(driver);
			Connection con = null;
			con = (Connection) DriverManager.getConnection(url, username, password);
			System.out.println("Conexão realizada com sucesso!");
			return con;

		} catch (ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
		return null;
	}
}