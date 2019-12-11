package ufabc.bd.rangorapido.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class RestauranteSelectBD {
	ConnectBD connectBD = new ConnectBD();

	public String selectCondicao(String cnpj, String campo, String variavel) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery("Select * from \"RESTAURANTE\" where \"Cnpj\" = '" + cnpj + "'");
		while (rs.next()) {
			if (rs.getString(campo).equals(variavel)) {
				return rs.getString(campo);
			}
		}
		return "";
	}

	public String selectGenericoCnpj(String cnpj, String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery("Select * from \"RESTAURANTE\" where \"Cnpj\" = '" + cnpj + "'");
		while (rs.next()) {
			return rs.getString(campo);
		}
		return "";
	}

	public ArrayList<String> selectCampoRestaurante(String campo) throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery("Select * from \"RESTAURANTE\"");
		while (rs.next()) {
			list.add(rs.getString(campo));
		}
		return list;
	}

	public String selectCnpj(String nomeOficial) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL
				.executeQuery("Select * from \"RESTAURANTE\" WHERE \"Nome_oficial\" = " + "'" + nomeOficial + "'");
		rs.next();
		return rs.getString("Cnpj");
	}

	public HashMap<String, String> selectPrato(String cnpj) throws SQLException {
		HashMap<String, String> hashmapPrato = new HashMap<String, String>();
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery("Select * from \"PRATO\" WHERE \"Cnpj\" = '" + cnpj + "'");
		while (rs.next()) {
			hashmapPrato.put(rs.getString("Descricao"), rs.getString("Preco"));
		}
		return hashmapPrato;
	}

	public String selectGenericoPrato(String id, String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery("Select * from \"PRATO\" WHERE \"ID\" = '" + id + "'");
		rs.next();
		return rs.getString(campo);
	}

	public String selectIdPrato(String descricao, String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery("Select * from \"PRATO\" WHERE \"Descricao\" = " + "'" + descricao + "'");
		rs.next();
		return rs.getString(campo);
	}

	public String selectMAXEntregador(String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL
				.executeQuery("Select * from \"ENTREGADOR\" WHERE \"ID\" = (select max(\"ID\") from \"ENTREGADOR\")");
		rs.next();
		return rs.getString(campo);
	}

	public String selectMAXEncomenda(String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL
				.executeQuery("Select * from \"ENCOMENDA\" WHERE \"ID\" = (select max(\"ID\") from \"ENCOMENDA\")");
		rs.next();
		return rs.getString(campo);
	}

	public String selectEncomenda(String idEncomenda, String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery("Select * from \"ENCOMENDA\" WHERE \"ID\" = " + "'" + idEncomenda + "'");
		while (rs.next()) {
			return rs.getString(campo);
		}
		return null;
	}

	public String selectEncomendaInnerJoinRestaurante(String idEncomenda, String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery(
				"Select * from \"RESTAURANTE\" INNER JOIN \"ENCOMENDA\" ON \"RESTAURANTE\".\"Cnpj\"=\"ENCOMENDA\".\"Cnpj\" WHERE \"ENCOMENDA\".\"ID\" = "
						+ "'" + idEncomenda + "'");
		while (rs.next()) {
			return rs.getString(campo);
		}
		return "";
	}

	public String selectEncomendaInnerJoinRestauranteTelefone(String idEncomenda, String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery(
				"Select * from \"RESTAURANTE\" INNER JOIN \"ENCOMENDA\" ON \"RESTAURANTE\".\"Cnpj\"=\"ENCOMENDA\".\"Cnpj\" INNER JOIN \"RESTAURANTE_TELEFONE\" ON \"RESTAURANTE_TELEFONE\".\"Cnpj\"=\"ENCOMENDA\".\"Cnpj\" WHERE \"ENCOMENDA\".\"ID\" = "
						+ "'" + idEncomenda + "'");
		while (rs.next()) {
			return rs.getString(campo);
		}
		return "";
	}

	public String selectEncomendaInnerJoinEntregador(String idEncomenda, String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery(
				"Select * from \"ENTREGADOR\" INNER JOIN \"ENCOMENDA\" ON \"ENTREGADOR\".\"ID\"=\"ENCOMENDA\".\"ID_Entregador\" WHERE \"ENCOMENDA\".\"ID\" = "
						+ "'" + idEncomenda + "'");
		while (rs.next()) {
			return rs.getString(campo);
		}
		return "";
	}

	public String selectEncomendaInnerJoinPrato(String idEncomenda, String campo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		ResultSet rs = cSQL.executeQuery(
				"Select * from \"PRATO\" INNER JOIN \"ENCOMENDA\" ON \"PRATO\".\"ID\"=\"ENCOMENDA\".\"ID_Prato\" WHERE \"ENCOMENDA\".\"ID\" = "
						+ "'" + idEncomenda + "'");
		while (rs.next()) {
			return rs.getString(campo);
		}
		return "";
	}
}
