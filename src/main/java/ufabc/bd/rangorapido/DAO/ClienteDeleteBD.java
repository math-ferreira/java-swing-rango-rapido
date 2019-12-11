package ufabc.bd.rangorapido.DAO;

import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDeleteBD {
	ConnectBD connectBD = new ConnectBD();

	public boolean deletePedido(String idEncomenda) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate("DELETE FROM \"ENCOMENDA\" WHERE \"ENCOMENDA\".\"ID\" = " + idEncomenda);
		return true;
	}

	public boolean deleteCliente(String cpf) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate("DELETE FROM \"ENCOMENDA\" WHERE \"ENCOMENDA\".\"Cpf\" = " + "'" + cpf + "'");
		cSQL.executeUpdate("DELETE FROM \"CLIENTE_CARTAO\" WHERE \"CLIENTE_CARTAO\".\"Cpf\" = " + "'" + cpf + "'");
		cSQL.executeUpdate("DELETE FROM \"CLIENTE_EMAIL\" WHERE \"CLIENTE_EMAIL\".\"Cpf\" = " + "'" + cpf + "'");
		cSQL.executeUpdate("DELETE FROM \"CLIENTE_ENDERECO\" WHERE \"CLIENTE_ENDERECO\".\"Cpf\" = " + "'" + cpf + "'");
		cSQL.executeUpdate("DELETE FROM \"CLIENTE_TELEFONE\" WHERE \"CLIENTE_TELEFONE\".\"Cpf\" = " + "'" + cpf + "'");
		cSQL.executeUpdate("DELETE FROM \"CLIENTE\" WHERE \"CLIENTE\".\"Cpf\" = " + "'" + cpf + "'");
		return true;
	}

}
