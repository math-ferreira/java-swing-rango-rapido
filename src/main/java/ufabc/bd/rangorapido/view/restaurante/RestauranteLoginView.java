package ufabc.bd.rangorapido.view.restaurante;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ufabc.bd.rangorapido.DAO.ClienteInsertBD;
import ufabc.bd.rangorapido.DAO.RestauranteInsertBD;
import ufabc.bd.rangorapido.DAO.RestauranteSelectBD;
import ufabc.bd.rangorapido.view.InitView;
import ufabc.bd.rangorapido.view.cliente.ClienteCadastroView;
import ufabc.bd.rangorapido.view.cliente.ClienteLoginView;

public class RestauranteLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCnpj;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestauranteLoginView frame = new RestauranteLoginView();
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
	public RestauranteLoginView() {

		// Conecta ao Banco de Dados
		RestauranteSelectBD restauranteBd = new RestauranteSelectBD();
		JOptionPane popUp = new JOptionPane();

		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 327);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLoginRestaurante = new JLabel("Login Restaurante");
		lblLoginRestaurante.setForeground(new Color(128, 0, 0));
		lblLoginRestaurante.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginRestaurante.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginRestaurante.setBounds(41, 39, 194, 38);
		contentPane.add(lblLoginRestaurante);

		JLabel lblImg = new JLabel("img");
		lblImg.setIcon(new ImageIcon(ClienteLoginView.class.getResource("/resource/logo_menor.png")));
		lblImg.setBounds(10, 74, 250, 164);
		contentPane.add(lblImg);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(282, 62, 158, 14);
		contentPane.add(lblCnpj);

		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(282, 130, 46, 14);
		contentPane.add(lblSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldCnpj.getText().equals("") || passwordField.getPassword().length <= 0) {
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane, "Log in incorreto. Insira todas as informações");
				} else {
					String password = new String(passwordField.getPassword());
					try {
						if (!(restauranteBd.selectCondicao(textFieldCnpj.getText(), "Senha", password).isEmpty())) {
							
							JOptionPane.showInternalMessageDialog(contentPane, "Log in realizado com sucesso!");
							RestauranteAreaView area = new RestauranteAreaView(textFieldCnpj.getText());
							area.setVisible(true);
							RestauranteLoginView.this.dispose();
						} else {
							JOptionPane.showInternalMessageDialog(contentPane, "Log in incorreto");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnEntrar.setBounds(282, 201, 110, 23);
		btnEntrar.setBackground(Color.GREEN);
		btnEntrar.setOpaque(true);
		contentPane.add(btnEntrar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestauranteCadastroView restauranteCadastro = new RestauranteCadastroView();
				restauranteCadastro.setVisible(true);
				RestauranteLoginView.this.dispose();
			}
		});
		btnCadastrar.setBounds(282, 235, 110, 23);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitView init = new InitView();
				init.frmInicio.setVisible(true);
				RestauranteLoginView.this.dispose();
			}
		});
		btnVoltar.setBounds(414, 235, 69, 23);
		contentPane.add(btnVoltar);

		textFieldCnpj = new JTextField();
		textFieldCnpj.setBounds(332, 57, 119, 20);
		contentPane.add(textFieldCnpj);
		textFieldCnpj.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(332, 127, 119, 20);
		contentPane.add(passwordField);
	}

}
