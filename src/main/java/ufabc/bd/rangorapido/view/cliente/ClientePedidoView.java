package ufabc.bd.rangorapido.view.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufabc.bd.rangorapido.DAO.ClienteDeleteBD;
import ufabc.bd.rangorapido.DAO.ClienteSelectBD;
import ufabc.bd.rangorapido.DAO.RestauranteSelectBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientePedidoView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeRest;
	private JTextField textFieldTel;
	private JTextField textFieldEntr;
	private JTextField textFieldVeiculo;
	private JTextField textFieldPlaca;
	private JTextField textFieldPrato;
	private JTextField textFieldEndereco;
	private JTextField textFieldTipoPag;
	private JTextField textFieldTempoEntrega;
	private JTextField textFieldValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientePedidoView frame = new ClientePedidoView(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientePedidoView(String idEncomenda) {
		JOptionPane popUp = new JOptionPane();

		RestauranteSelectBD restauranteSelect = new RestauranteSelectBD();
		ClienteSelectBD clienteSelect = new ClienteSelectBD();
		ClienteDeleteBD clienteDelete = new ClienteDeleteBD();

		setTitle("Acompanhamento de pedido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 863, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAcompanharPedido = new JLabel("Acompanhar pedido:");
		lblAcompanharPedido.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAcompanharPedido.setBounds(31, 11, 286, 59);
		contentPane.add(lblAcompanharPedido);

		JLabel lblRestaurante = new JLabel("Nome:");
		lblRestaurante.setBounds(31, 108, 139, 14);
		contentPane.add(lblRestaurante);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(31, 133, 46, 14);
		contentPane.add(lblTelefone);

		JLabel lblEntregador = new JLabel("Nome entregador:");
		lblEntregador.setBounds(31, 222, 139, 14);
		contentPane.add(lblEntregador);

		JLabel lblRestaurante_1 = new JLabel("Restaurante");
		lblRestaurante_1.setForeground(new Color(128, 0, 0));
		lblRestaurante_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRestaurante_1.setBounds(31, 81, 125, 14);
		contentPane.add(lblRestaurante_1);

		JLabel lblDadosCliente = new JLabel("Pedido");
		lblDadosCliente.setForeground(new Color(128, 0, 0));
		lblDadosCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDadosCliente.setBounds(381, 81, 125, 14);
		contentPane.add(lblDadosCliente);

		JLabel lblEntregador_1 = new JLabel("Entregador");
		lblEntregador_1.setForeground(new Color(128, 0, 0));
		lblEntregador_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEntregador_1.setBounds(31, 184, 125, 14);
		contentPane.add(lblEntregador_1);

		JLabel lblVeiculo = new JLabel("Veiculo:");
		lblVeiculo.setBounds(31, 252, 46, 14);
		contentPane.add(lblVeiculo);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(31, 283, 46, 14);
		contentPane.add(lblPlaca);

		JLabel lblEndereoEntrega = new JLabel("Endere\u00E7o entrega:");
		lblEndereoEntrega.setBounds(381, 222, 139, 14);
		contentPane.add(lblEndereoEntrega);

		JLabel lblNome = new JLabel("Prato:");
		lblNome.setBounds(381, 108, 46, 14);
		contentPane.add(lblNome);

		JLabel lblPagamento = new JLabel("Pagamento:");
		lblPagamento.setBounds(381, 161, 98, 14);
		contentPane.add(lblPagamento);

		JLabel lblTempoParaEntrega = new JLabel("Tempo para Entrega:");
		lblTempoParaEntrega.setBounds(381, 192, 125, 14);
		contentPane.add(lblTempoParaEntrega);

		textFieldNomeRest = new JTextField();
		textFieldNomeRest.setEditable(false);
		textFieldNomeRest.setBounds(145, 105, 203, 20);
		contentPane.add(textFieldNomeRest);
		try {
			textFieldNomeRest
					.setText(restauranteSelect.selectEncomendaInnerJoinRestaurante(idEncomenda, "Nome_oficial"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		textFieldNomeRest.setColumns(10);

		textFieldTel = new JTextField();
		textFieldTel.setEditable(false);
		textFieldTel.setColumns(10);
		try {
			textFieldTel.setText(restauranteSelect.selectEncomendaInnerJoinRestauranteTelefone(idEncomenda, "Numero"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		textFieldTel.setBounds(145, 130, 119, 20);
		contentPane.add(textFieldTel);

		textFieldEntr = new JTextField();
		textFieldEntr.setEditable(false);
		textFieldEntr.setColumns(10);
		try {
			textFieldEntr.setText(restauranteSelect.selectEncomendaInnerJoinEntregador(idEncomenda, "Primeiro_nome"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		textFieldEntr.setBounds(145, 219, 119, 20);
		contentPane.add(textFieldEntr);

		textFieldVeiculo = new JTextField();
		textFieldVeiculo.setEditable(false);
		textFieldVeiculo.setColumns(10);
		try {
			textFieldVeiculo.setText(restauranteSelect.selectEncomendaInnerJoinEntregador(idEncomenda, "Veiculo"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		textFieldVeiculo.setBounds(145, 249, 119, 20);
		contentPane.add(textFieldVeiculo);

		textFieldPlaca = new JTextField();
		textFieldPlaca.setEditable(false);
		textFieldPlaca.setColumns(10);
		try {
			textFieldPlaca.setText(restauranteSelect.selectEncomendaInnerJoinEntregador(idEncomenda, "Placa"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		textFieldPlaca.setBounds(145, 280, 119, 20);
		contentPane.add(textFieldPlaca);

		textFieldPrato = new JTextField();
		textFieldPrato.setEditable(false);
		textFieldPrato.setBounds(521, 105, 286, 20);
		try {
			textFieldPrato.setText(restauranteSelect.selectEncomendaInnerJoinPrato(idEncomenda, "Descricao"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		contentPane.add(textFieldPrato);
		textFieldPrato.setColumns(10);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setEditable(false);
		textFieldEndereco.setColumns(10);
		try {
			textFieldEndereco.setText(clienteSelect.selectEncomendaInnerJoinEndereco(idEncomenda, "Logradouro") + ", "
					+ clienteSelect.selectEncomendaInnerJoinEndereco(idEncomenda, "Cidade") + " - "
					+ clienteSelect.selectEncomendaInnerJoinEndereco(idEncomenda, "Uf"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		textFieldEndereco.setBounds(521, 219, 286, 20);
		contentPane.add(textFieldEndereco);

		textFieldTipoPag = new JTextField();
		textFieldTipoPag.setEditable(false);
		textFieldTipoPag.setColumns(10);
		try {
			textFieldTipoPag.setText(restauranteSelect.selectEncomenda(idEncomenda, "Tipo_pagamento"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		textFieldTipoPag.setBounds(521, 158, 98, 20);
		contentPane.add(textFieldTipoPag);

		textFieldTempoEntrega = new JTextField();
		textFieldTempoEntrega.setEditable(false);
		textFieldTempoEntrega.setColumns(10);
		try {
			textFieldTempoEntrega.setText(restauranteSelect.selectEncomenda(idEncomenda, "Tempo_entrega"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		textFieldTempoEntrega.setBounds(522, 189, 66, 20);
		contentPane.add(textFieldTempoEntrega);

		JButton btnCancelarPedido = new JButton("Cancelar pedido");
		btnCancelarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cpf = restauranteSelect.selectEncomenda(idEncomenda, "Cpf");
					clienteDelete.deletePedido(idEncomenda);
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane, "Pedido cancelado com sucesso!");
					ClienteAreaView area = new ClienteAreaView(cpf);
					area.setVisible(true);
					ClientePedidoView.this.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCancelarPedido.setBounds(531, 335, 164, 23);
		contentPane.add(btnCancelarPedido);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ClienteAreaView area = new ClienteAreaView(restauranteSelect.selectEncomenda(idEncomenda, "Cpf"));
					area.setVisible(true);
					ClientePedidoView.this.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVoltar.setBounds(718, 335, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblValor = new JLabel("Valor: R$");
		lblValor.setBounds(381, 133, 57, 14);
		contentPane.add(lblValor);

		textFieldValor = new JTextField();
		textFieldValor.setEditable(false);
		textFieldValor.setColumns(10);
		try {
			textFieldValor.setText(restauranteSelect.selectEncomendaInnerJoinPrato(idEncomenda, "Preco"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		textFieldValor.setBounds(521, 130, 71, 20);
		contentPane.add(textFieldValor);
	}
}
