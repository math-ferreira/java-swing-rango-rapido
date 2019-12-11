package ufabc.bd.rangorapido.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RestauranteInsertBD {
	ConnectBD connectBD = new ConnectBD();

	public boolean insertRestaurante(String cnpj, String nomeOficial, String nomeFantasia, String tipoComida,
			String senha) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate(
				"INSERT INTO \"RESTAURANTE\" (\"Cnpj\",\"Nome_oficial\",\"Nome_fantasia\", \"Tipo_comida\",\"Senha\") VALUES ("
						+ "'" + cnpj + "'," + "'" + nomeOficial + "'," + "'" + nomeFantasia + "'," + "'" + tipoComida
						+ "'," + "'" + senha + "');");
		return true;
	}

	public boolean insertAtendimento(String cnpj, String cidade, String horarioInicio, String horarioFim)
			throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate(
				"INSERT INTO \"RESTAURANTE_ATENDIMENTO\" (\"Cnpj\",\"Cidade\",\"Horario_inicio\", \"Horario_fim\") VALUES ("
						+ "'" + cnpj + "'," + "'" + cidade + "'," + "'" + horarioInicio + "'," + "'" + horarioFim
						+ "');");
		return true;
	}

	public boolean insertEndereco(String cnpj, String logradouro, String cidade, String uf) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate("INSERT INTO \"RESTAURANTE_ENDERECO\" (\"Cnpj\",\"Logradouro\",\"Cidade\", \"UF\") VALUES ("
				+ "'" + cnpj + "'," + "'" + logradouro + "'," + "'" + cidade + "'," + "'" + uf + "');");
		return true;
	}

	public boolean insertTelefone(String cnpj, String numero, String tipo) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate("INSERT INTO \"RESTAURANTE_TELEFONE\" (\"Cnpj\",\"Numero\",\"Tipo\") VALUES (" + "'" + cnpj
				+ "'," + "'" + numero + "'," + "'" + tipo + "');");
		return true;
	}

	public boolean insertPrato(String cnpj, String descricao, String preco, String disp) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate("INSERT INTO \"PRATO\" (\"Cnpj\",\"Descricao\",\"Preco\", \"Disponibilidade\") VALUES ("
				+ "'" + cnpj + "'," + "'" + descricao + "'," + "'" + preco + "'," + "'" + disp + "');");
		return true;
	}

	public boolean insertEncomenda(String cnpj, String idPrato, String idEntregador, String cpf, String idCartao,
			String troco, String tipoPagamento, String tempoEntrega) throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate(
				"INSERT INTO \"ENCOMENDA\" (\"Cnpj\",\"ID_Prato\",\"ID_Entregador\", \"Cpf\", \"ID_Cartao\", \"Troco\", \"Tipo_pagamento\", \"Tempo_entrega\") VALUES ("
						+ "'" + cnpj + "'," + "'" + idPrato + "'," + "'" + idEntregador + "'," + "'" + cpf + "','"
						+ idCartao + "'," + troco + "," + "'" + tipoPagamento + "'," + "'" + tempoEntrega
						+ "');");
		return true;
	}

	public boolean insertEntregador(String primeiroNome, String ultimoNome, String veiculo, String placa)
			throws SQLException {
		Statement cSQL = connectBD.connectPostGreSQL().createStatement();
		cSQL.executeUpdate(
				"INSERT INTO \"ENTREGADOR\" (\"Primeiro_nome\",\"Ultimo_nome\",\"Veiculo\", \"Placa\") VALUES (" + "'"
						+ primeiroNome + "'," + "'" + ultimoNome + "'," + "'" + veiculo + "'," + "'" + placa + "');");
		return true;
	}

}
