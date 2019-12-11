package ufabc.bd.rangorapido.DAO;

import java.sql.SQLException;
import java.sql.Statement;

public class ClienteInsertBD {
	ConnectBD connectBD = new ConnectBD();

	public boolean insertCliente(String cpf, String rg, String primeiroNome, String ultimoNome, String senha)
			throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate(
				"INSERT INTO \"CLIENTE\" (\"Cpf\",\"Rg\",\"Primeiro_nome\", \"Ultimo_nome\",\"Senha\") VALUES (" + "'"
						+ cpf + "'," + "'" + rg + "'," + "'" + primeiroNome + "'," + "'" + ultimoNome + "'," + "'"
						+ senha + "');");
		return true;
	}

	public boolean insertTelefone(String cpf, String numero, String tipo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate("INSERT INTO \"CLIENTE_TELEFONE\" (\"Cpf\",\"Numero\",\"Tipo\") VALUES (" + "'" + cpf + "',"
				+ "'" + numero + "'," + "'" + tipo + "');");
		return true;
	}

	public boolean insertCartao(String cpf, String numero, String primeiroNomeTitular, String ultimoNomeTitular,
			String dataVencimento) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate(
				"INSERT INTO \"CLIENTE_CARTAO\" (\"Cpf\",\"Numero\",\"Primeiro_nome_titular\", \"Ultimo_nome_titular\",\"Data_vencimento\") VALUES ("
						+ "'" + cpf + "'," + "'" + numero + "'," + "'" + primeiroNomeTitular + "'," + "'"
						+ ultimoNomeTitular + "'," + "'" + dataVencimento + "');");
		return true;
	}

	public boolean insertEmail(String cpf, String email)
			throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate(
				"INSERT INTO \"CLIENTE_EMAIL\" (\"Cpf\",\"Email\") VALUES (" + "'"
						+ cpf + "'," + "'" + email + "');");
		return true;
	}

	public boolean insertEndereco(String cpf, String logradouro, String cidade, String uf)
			throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate(
				"INSERT INTO \"CLIENTE_ENDERECO\" (\"Cpf\",\"Logradouro\",\"Cidade\",\"Uf\") VALUES (" + "'"
						+ cpf + "'," + "'" + logradouro + "'," + "'" + cidade + "'," + "'" + uf + "');");
		return true;
	}

}
