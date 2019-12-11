package ufabc.bd.rangorapido.view.cliente;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ufabc.bd.rangorapido.DAO.ClienteSelectBD;
import ufabc.bd.rangorapido.view.InitView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ClienteLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCpf;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteLoginView frame = new ClienteLoginView();
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
	public ClienteLoginView() {

		// Conecta ao Banco de Dados
		ClienteSelectBD clienteBd = new ClienteSelectBD();
		JOptionPane popUp = new JOptionPane();

		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 327);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLoginCliente = new JLabel("Login Cliente");
		lblLoginCliente.setForeground(new Color(128, 0, 0));
		lblLoginCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginCliente.setBounds(41, 39, 194, 38);
		contentPane.add(lblLoginCliente);

		JLabel lblImg = new JLabel("img");
		lblImg.setIcon(new ImageIcon(ClienteLoginView.class.getResource("/resource/logo_menor.png")));
		lblImg.setBounds(10, 74, 250, 164);
		contentPane.add(lblImg);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(282, 62, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(282, 130, 46, 14);
		contentPane.add(lblSenha);

		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(282, 80, 124, 20);
		contentPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldCpf.getText().equals("") || passwordField.getPassword().length <= 0) {
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane, "Log in incorreto. Insira todas as informações");
				} else {
					try {
						String password = new String(passwordField.getPassword());
						if (!(clienteBd.selectCondicao(textFieldCpf.getText().trim(), "Senha", password).isEmpty())) {
							JOptionPane.showInternalMessageDialog(contentPane, "Log in realizado com sucesso!");

							ClienteAreaView area = new ClienteAreaView(textFieldCpf.getText().trim());
							area.setVisible(true);
							ClienteLoginView.this.dispose();
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
				ClienteCadastroView clienteCadastro = new ClienteCadastroView();
				clienteCadastro.setVisible(true);
				ClienteLoginView.this.dispose();
			}
		});
		btnCadastrar.setBounds(282, 235, 110, 23);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InitView init = new InitView();
				init.frmInicio.setVisible(true);
				ClienteLoginView.this.dispose();
			}
		});
		btnVoltar.setBounds(414, 235, 69, 23);
		contentPane.add(btnVoltar);

		passwordField = new JPasswordField();
		passwordField.setBounds(282, 146, 124, 20);
		contentPane.add(passwordField);
	}
}
