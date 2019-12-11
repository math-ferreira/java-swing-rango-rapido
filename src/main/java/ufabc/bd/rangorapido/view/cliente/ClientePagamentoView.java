package ufabc.bd.rangorapido.view.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufabc.bd.rangorapido.DAO.ClienteInsertBD;
import ufabc.bd.rangorapido.DAO.ClienteSelectBD;
import ufabc.bd.rangorapido.DAO.RestauranteInsertBD;
import ufabc.bd.rangorapido.DAO.RestauranteSelectBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientePagamentoView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPreco;
	private JTextField textFieldRest;
	private JTextField textFieldTroco;
	private JTextField textFieldNumeroCartao;
	private JTextField textFieldTitular;
	private JButton btnPagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientePagamentoView frame = new ClientePagamentoView(null, null, null);
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
	public ClientePagamentoView(String cpf, String cnpj, String idPrato) {
		JOptionPane popUp = new JOptionPane();

		RestauranteSelectBD restauranteSelect = new RestauranteSelectBD();
		ClienteSelectBD clienteSelect = new ClienteSelectBD();
		RestauranteInsertBD restauranteInsert = new RestauranteInsertBD();

		setTitle("Pagamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 904, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDadosDoPedido = new JLabel("Dados do pedido:");
		lblDadosDoPedido.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDadosDoPedido.setBounds(10, 32, 186, 22);
		contentPane.add(lblDadosDoPedido);

		JLabel lblDescricao = new JLabel("Pedido:");
		lblDescricao.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescricao.setBounds(10, 83, 81, 14);
		contentPane.add(lblDescricao);

		JLabel lblPreo = new JLabel("Valor: R$");
		lblPreo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPreo.setBounds(10, 162, 81, 14);
		contentPane.add(lblPreo);

		JLabel lblRestaurante = new JLabel("Restaurante:");
		lblRestaurante.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRestaurante.setBounds(10, 200, 95, 14);
		contentPane.add(lblRestaurante);

		JLabel lblFormaPagamento = new JLabel("Forma pagamento:");
		lblFormaPagamento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFormaPagamento.setBounds(10, 239, 186, 22);
		contentPane.add(lblFormaPagamento);

		JComboBox comboBoxFormaPagamento = new JComboBox();
		comboBoxFormaPagamento.setModel(new DefaultComboBoxModel(new String[] { "Dinheiro", "Cart\u00E3o" }));
		comboBoxFormaPagamento.setBounds(10, 274, 95, 22);
		contentPane.add(comboBoxFormaPagamento);

		JTextArea textAreaDesc = new JTextArea();
		textAreaDesc.setEditable(false);
		textAreaDesc.setBounds(136, 78, 236, 52);
		try {
			textAreaDesc.setText(restauranteSelect.selectGenericoPrato(idPrato, "Descricao"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		contentPane.add(textAreaDesc);

		textFieldPreco = new JTextField();
		textFieldPreco.setEditable(false);
		textFieldPreco.setBounds(136, 159, 54, 20);
		try {
			textFieldPreco.setText(restauranteSelect.selectGenericoPrato(idPrato, "Preco"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);

		textFieldRest = new JTextField();
		textFieldRest.setEditable(false);
		textFieldRest.setBounds(136, 197, 201, 20);
		try {
			textFieldRest.setText(restauranteSelect.selectGenericoCnpj(cnpj, "Nome_oficial"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		contentPane.add(textFieldRest);
		textFieldRest.setColumns(10);

		JPanel panelDinheiro = new JPanel();
		panelDinheiro.setBounds(413, 32, 453, 98);
		contentPane.add(panelDinheiro);
		panelDinheiro.setLayout(null);
		panelDinheiro.setVisible(false);

		JLabel lblTroco = new JLabel("Valor para troco?");
		lblTroco.setBounds(10, 49, 147, 14);
		panelDinheiro.add(lblTroco);

		textFieldTroco = new JTextField();
		textFieldTroco.setBounds(167, 46, 61, 20);
		panelDinheiro.add(textFieldTroco);
		textFieldTroco.setColumns(10);

		JLabel lblPagementoNoDinheiro = new JLabel("Pagamento no dinheiro: ");
		lblPagementoNoDinheiro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPagementoNoDinheiro.setBounds(124, 11, 287, 24);
		panelDinheiro.add(lblPagementoNoDinheiro);

		JPanel panelCartao = new JPanel();
		panelCartao.setBounds(413, 141, 453, 130);
		contentPane.add(panelCartao);
		panelCartao.setLayout(null);
		panelCartao.setVisible(false);

		JLabel lblNmeroDeCarto = new JLabel("N\u00FAmero de Cart\u00E3o cadastrado: ");
		lblNmeroDeCarto.setBounds(10, 60, 152, 14);
		panelCartao.add(lblNmeroDeCarto);

		textFieldNumeroCartao = new JTextField();
		textFieldNumeroCartao.setEditable(false);
		textFieldNumeroCartao.setBounds(167, 57, 254, 20);
		try {
			textFieldNumeroCartao.setText(clienteSelect.selectClienteInnerJoinCartao(cpf, "Numero"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		panelCartao.add(textFieldNumeroCartao);
		textFieldNumeroCartao.setColumns(10);

		JLabel lblPagamentoNoCarto = new JLabel("Pagamento no cart\u00E3o:");
		lblPagamentoNoCarto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPagamentoNoCarto.setBounds(125, 11, 287, 25);
		panelCartao.add(lblPagamentoNoCarto);

		JLabel lblTitular = new JLabel("Titular:");
		lblTitular.setBounds(10, 93, 46, 14);
		panelCartao.add(lblTitular);

		textFieldTitular = new JTextField();
		textFieldTitular.setEditable(false);
		textFieldTitular.setBounds(167, 88, 254, 20);
		panelCartao.add(textFieldTitular);
		try {
			textFieldTitular.setText(clienteSelect.selectClienteInnerJoinCartao(cpf, "Primeiro_nome_titular"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		textFieldTitular.setColumns(10);

		JButton btnAvancar = new JButton("Avan\u00E7ar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPagar.setVisible(true);
				if (comboBoxFormaPagamento.getSelectedIndex() == 0) {
					panelDinheiro.setVisible(true);
					panelCartao.setVisible(false);
				} else {
					panelDinheiro.setVisible(false);
					panelCartao.setVisible(true);
				}
			}

		});
		btnAvancar.setBounds(283, 299, 89, 23);
		contentPane.add(btnAvancar);

		btnPagar = new JButton("Confirmar dados e pagar");
		btnPagar.setVisible(false);
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoPagamento;
				String troco = null;
				if (comboBoxFormaPagamento.getSelectedIndex() == 0) {
					tipoPagamento = "dinheiro";
					if (!textFieldTroco.getText().trim().equals("")) {
						troco = "'" + textFieldTroco.getText().trim() + "'";
					}
				} else {
					tipoPagamento = "cartao";
				}
				ArrayList<String> listaPrimeiroNome = new ArrayList<String>();
				listaPrimeiroNome.add("Thiago");
				listaPrimeiroNome.add("Danilo");
				listaPrimeiroNome.add("Maysa");
				listaPrimeiroNome.add("João");
				listaPrimeiroNome.add("Isabela");
				listaPrimeiroNome.add("Felipe");
				listaPrimeiroNome.add("Hugo");
				listaPrimeiroNome.add("Luan");
				listaPrimeiroNome.add("Katia");
				int randomIntPrimeiroNome = new Random().nextInt(listaPrimeiroNome.size());

				ArrayList<String> listaUltimoNome = new ArrayList<String>();
				listaUltimoNome.add("Silva");
				listaUltimoNome.add("Dotta");
				listaUltimoNome.add("Santos");
				listaUltimoNome.add("Marques");
				listaUltimoNome.add("Mendez");
				listaUltimoNome.add("Prado");
				listaUltimoNome.add("Costa");
				listaUltimoNome.add("Pereira");
				listaUltimoNome.add("Barbosa");
				int randomIntUltimoNome = new Random().nextInt(listaUltimoNome.size());

				String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g",
						"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
						"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
						"T", "U", "V", "W", "X", "Y", "Z" };
				String placa = "";
				for (int i = 0; i < 6; i++) {
					int j = (int) (Math.random() * carct.length);
					placa += carct[j];
				}

				ArrayList<String> listaVeiculo = new ArrayList<String>();
				listaVeiculo.add("gol");
				listaVeiculo.add("jetta");
				listaVeiculo.add("cb 500");
				listaVeiculo.add("prisma");
				listaVeiculo.add("onix");
				listaVeiculo.add("stilo");
				listaVeiculo.add("uno");
				listaVeiculo.add("hb20");
				listaVeiculo.add("virtus");
				int randomIntVeiculo = new Random().nextInt(listaVeiculo.size());

				Random gerador = new Random();
				int horas = gerador.nextInt(2);
				int minutos = gerador.nextInt(60);
				int segundos = gerador.nextInt(60);
				String tempo = horas + ":" + minutos + ":" + segundos;

				try {
					restauranteInsert.insertEntregador(listaPrimeiroNome.get(randomIntPrimeiroNome),
							listaUltimoNome.get(randomIntUltimoNome), listaVeiculo.get(randomIntVeiculo), placa);
					restauranteInsert.insertEncomenda(cnpj, idPrato, restauranteSelect.selectMAXEntregador("ID"), cpf,
							clienteSelect.selectClienteInnerJoinCartao(cpf, "ID"), troco, tipoPagamento, tempo);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				popUp.setVisible(true);
				JOptionPane.showInternalMessageDialog(contentPane, "Aguardando confirmacao de pedido...");
				JOptionPane.showInternalMessageDialog(contentPane, "Pedido realizado com sucesso");
				try {
					ClientePedidoView pedido = new ClientePedidoView(restauranteSelect.selectMAXEncomenda("ID"));
					pedido.setVisible(true);
					ClientePagamentoView.this.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnPagar.setForeground(new Color(255, 255, 255));
		btnPagar.setBackground(new Color(0, 128, 0));
		btnPagar.setBounds(646, 299, 220, 23);
		contentPane.add(btnPagar);

		JLabel lblImg = new JLabel("img3");
		lblImg.setIcon(new ImageIcon(ClientePagamentoView.class.getResource("/resource/Imagem1.png")));
		lblImg.setBounds(0, -31, 1226, 400);
		contentPane.add(lblImg);

	}
}
