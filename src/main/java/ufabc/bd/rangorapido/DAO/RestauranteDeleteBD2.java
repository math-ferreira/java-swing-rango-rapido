package ufabc.bd.rangorapido.DAO;

import java.sql.SQLException;
import java.sql.Statement;

public class RestauranteDeleteBD2 {
	ConnectBD connectBD = new ConnectBD();

	public boolean deleteRestaurante(String cnpj) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate("DELETE FROM \"RESTAURANTE_ATENDIMENTO\" WHERE \"RESTAURANTE_ATENDIMENTO\".\"Cnpj\" = " + "'" + cnpj + "'");
		cSQL.executeUpdate("DELETE FROM \"RESTAURANTE_ENDERECO\" WHERE \"RESTAURANTE_ENDERECO\".\"Cnpj\" = " + "'" + cnpj + "'");
		cSQL.executeUpdate("DELETE FROM \"PRATO\" WHERE \"PRATO\".\"Cnpj\" = " + "'" + cnpj + "'");
		cSQL.executeUpdate("DELETE FROM \"RESTAURANTE_TELEFONE\" WHERE \"RESTAURANTE_TELEFONE\".\"Cnpj\" = " + "'" + cnpj + "'");
		cSQL.executeUpdate("DELETE FROM \"RESTAURANTE\" WHERE \"RESTAURANTE\".\"Cnpj\" = " + "'" + cnpj + "'");
		return true;
	}

}
