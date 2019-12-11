package ufabc.bd.rangorapido.view.restaurante;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufabc.bd.rangorapido.DAO.RestauranteSelectBD;
import ufabc.bd.rangorapido.DAO.RestauranteUpdateBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class RestauranteAlterarDadosView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldOficial;
	private JTextField textFieldFant;
	private JTextField textFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestauranteAlterarDadosView frame = new RestauranteAlterarDadosView(null);
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
	public RestauranteAlterarDadosView(String cnpj) {
		JOptionPane popUp = new JOptionPane();

		// Conecta ao Banco de Dados
		RestauranteUpdateBD restUpdate = new RestauranteUpdateBD();
		RestauranteSelectBD restSelect = new RestauranteSelectBD();

		setTitle("Alterar dados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeOficial = new JLabel("Nome Oficial:");
		lblNomeOficial.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNomeOficial.setBounds(133, 81, 166, 14);
		try {
			lblNomeOficial.setText(restSelect.selectGenericoCnpj(cnpj, "Nome_oficial"));
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		contentPane.add(lblNomeOficial);

		JLabel lblAlterarDados = new JLabel("Alterar dados:");
		lblAlterarDados.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAlterarDados.setBounds(309, 26, 160, 32);
		contentPane.add(lblAlterarDados);

		JLabel lblNomeFantasia = new JLabel("Nome Fantasia:");
		lblNomeFantasia.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNomeFantasia.setBounds(134, 117, 165, 14);
		try {
			lblNomeFantasia.setText(restSelect.selectGenericoCnpj(cnpj, "Nome_fantasia"));
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		contentPane.add(lblNomeFantasia);

		JLabel lblSenha = new JLabel("Senha: ");
		lblSenha.setBounds(27, 165, 97, 14);
		contentPane.add(lblSenha);

		textFieldOficial = new JTextField();
		textFieldOficial.setBounds(309, 81, 160, 20);
		contentPane.add(textFieldOficial);
		textFieldOficial.setColumns(10);

		textFieldFant = new JTextField();
		textFieldFant.setColumns(10);
		textFieldFant.setBounds(309, 117, 160, 20);
		contentPane.add(textFieldFant);

		textFieldSenha = new JTextField();
		textFieldSenha.setColumns(10);
		textFieldSenha.setBounds(309, 162, 160, 20);
		contentPane.add(textFieldSenha);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!textFieldFant.getText().trim().equals("")) {
						restUpdate.updateGenerico(cnpj, "Nome_fantasia", textFieldFant.getText().trim());
					}

					if (!textFieldOficial.getText().trim().equals("")) {
						restUpdate.updateGenerico(cnpj, "Nome_oficial", textFieldOficial.getText().trim());
					}

					if (!textFieldSenha.getText().trim().equals("")) {
						restUpdate.updateGenerico(cnpj, "Senha", textFieldSenha.getText().trim());
					}

					RestauranteAreaView area = new RestauranteAreaView(cnpj);
					area.setVisible(true);
					RestauranteAlterarDadosView.this.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnAlterar.setBounds(271, 227, 89, 23);
		contentPane.add(btnAlterar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RestauranteAreaView area = new RestauranteAreaView(cnpj);
					area.setVisible(true);
					RestauranteAlterarDadosView.this.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnVoltar.setBounds(380, 227, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblNomeOficial_1 = new JLabel("Nome Oficial:");
		lblNomeOficial_1.setBounds(27, 84, 79, 14);
		contentPane.add(lblNomeOficial_1);

		JLabel lblNomeFantasia_1 = new JLabel("Nome Fantasia: ");
		lblNomeFantasia_1.setBounds(27, 120, 97, 14);
		contentPane.add(lblNomeFantasia_1);

		JLabel lblDadosAtuais = new JLabel("Dados atuais:");
		lblDadosAtuais.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDadosAtuais.setBounds(27, 26, 160, 32);
		contentPane.add(lblDadosAtuais);

	}
}
