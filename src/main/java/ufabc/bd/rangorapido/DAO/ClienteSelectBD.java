package ufabc.bd.rangorapido.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteSelectBD {
	ConnectBD connectBD = new ConnectBD();

	public String selectCondicao(String cpf, String campo, String variavel) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery("Select * from \"CLIENTE\" where \"Cpf\" = '" + cpf + "'");
		while (rs.next()) {
			if (rs.getString(campo).equals(variavel)) {
				return rs.getString(campo);
			}
		}
		return "";
	}

	public String selectGenericoCpf(String cpf, String registro) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery("Select * from \"CLIENTE\" where \"Cpf\" = '" + cpf + "'");
		while (rs.next()) {
			return rs.getString(registro);
		}
		return "";
	}

	public String selectClienteInnerJoinCartao(String cpf, String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery(
				"Select * from \"CLIENTE\" INNER JOIN \"CLIENTE_CARTAO\" ON \"CLIENTE\".\"Cpf\"=\"CLIENTE_CARTAO\".\"Cpf\" WHERE \"CLIENTE_CARTAO\".\"Cpf\" = "
						+ "'" + cpf + "'");
		while (rs.next()) {
			return rs.getString(campo);
		}
		return "";
	}

	public String selectEncomendaInnerJoinEndereco(String idEncomenda, String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery(
				"Select * from \"CLIENTE_ENDERECO\" INNER JOIN \"ENCOMENDA\" ON \"CLIENTE_ENDERECO\".\"Cpf\"=\"ENCOMENDA\".\"Cpf\" WHERE \"ENCOMENDA\".\"ID\" = "
						+ "'" + idEncomenda + "'");
		while (rs.next()) {
			return rs.getString(campo);
		}
		return "";
	}

	public String selectMAXEncomendaCliente(String cpf, String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery(
				"Select * from \"ENCOMENDA\" WHERE \"ID\" = (select max(\"ID\") from \"ENCOMENDA\") AND \"ENCOMENDA\".\"Cpf\" = "
						+ "'" + cpf + "'");
		rs.next();
		return rs.getString(campo);
	}
}
