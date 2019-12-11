package ufabc.bd.rangorapido.DAO;

import java.sql.SQLException;
import java.sql.Statement;

public class RestauranteUpdateBD {
	ConnectBD connectBD = new ConnectBD();

	public boolean updateGenerico(String cnpj, String campoAlterado, String valor) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate("UPDATE \"RESTAURANTE\" SET " + "\"" + campoAlterado + "\"=" + "'" + valor + "'" + "WHERE "
				+ "\"Cnpj\"= " + "'" + cnpj + "';");
		return true;
	}

}
