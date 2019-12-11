package ufabc.bd.rangorapido.view.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufabc.bd.rangorapido.DAO.ClienteDeleteBD;
import ufabc.bd.rangorapido.DAO.ClienteSelectBD;
import ufabc.bd.rangorapido.DAO.RestauranteSelectBD;
import ufabc.bd.rangorapido.view.InitView;

import javax.swing.JTextField;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ClienteAreaView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeRestaurante;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteAreaView frame = new ClienteAreaView(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public ClienteAreaView(String cpf) {

		// Conecta ao Banco de Dados
		ClienteSelectBD clienteSelect = new ClienteSelectBD();
		ClienteDeleteBD clienteDelete = new ClienteDeleteBD();

		setTitle("Area do Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNomeRestaurante = new JTextField();
		textFieldNomeRestaurante.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNomeRestaurante.setFont(new Font("Tahoma", Font.BOLD, 16));
		textFieldNomeRestaurante.setEditable(false);
		textFieldNomeRestaurante.setBounds(36, 38, 263, 52);
		try {
			textFieldNomeRestaurante.setText(clienteSelect.selectGenericoCpf(cpf, "Primeiro_nome"));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		contentPane.add(textFieldNomeRestaurante);
		textFieldNomeRestaurante.setColumns(10);

		JLabel label = new JLabel("img");
		label.setIcon(new ImageIcon(ClienteAreaView.class.getResource("/resource/logo_menor.png")));
		label.setBounds(385, 32, 252, 171);
		contentPane.add(label);

		JButton btnAcompPedido = new JButton("Acompanhar pedido");
		btnAcompPedido.setForeground(new Color(255, 255, 255));
		btnAcompPedido.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAcompPedido.setBackground(new Color(0, 128, 0));
		btnAcompPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientePedidoView pedido;
				try {
					pedido = new ClientePedidoView(clienteSelect.selectMAXEncomendaCliente(cpf, "ID"));
					pedido.setVisible(true);
					ClienteAreaView.this.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAcompPedido.setBounds(87, 134, 174, 23);
		contentPane.add(btnAcompPedido);

		JButton btnRemoverRestaurante = new JButton("Remover Conta");
		btnRemoverRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("aqui: "+cpf);
					clienteDelete.deleteCliente(cpf);
					InitView init = new InitView();
					init.frmInicio.setVisible(true);
					ClienteAreaView.this.dispose();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRemoverRestaurante.setBounds(36, 286, 131, 23);
		contentPane.add(btnRemoverRestaurante);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteLoginView login = new ClienteLoginView();
				login.setVisible(true);
				ClienteAreaView.this.dispose();
			}
		});
		btnSair.setBounds(543, 286, 89, 23);
		contentPane.add(btnSair);

		JButton btnPesqRest = new JButton("Encontrar Restaurantes");
		btnPesqRest.setForeground(new Color(255, 255, 255));
		btnPesqRest.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPesqRest.setBackground(new Color(0, 128, 0));
		btnPesqRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteBuscaRestauranteView busca = new ClienteBuscaRestauranteView(cpf);
				busca.setVisible(true);
				ClienteAreaView.this.dispose();
			}
		});
		btnPesqRest.setBounds(87, 168, 174, 23);
		contentPane.add(btnPesqRest);
	}
}
