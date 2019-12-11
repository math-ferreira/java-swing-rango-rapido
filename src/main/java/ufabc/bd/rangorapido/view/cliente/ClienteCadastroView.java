package ufabc.bd.rangorapido.view.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import ufabc.bd.rangorapido.DAO.ClienteInsertBD;
import ufabc.bd.rangorapido.view.InitView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class ClienteCadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUltimoNome;
	private JTextField textFieldCpf;
	private JTextField textFieldRg;
	private JPasswordField passwordFieldSenha;
	private JPasswordField passwordFieldConfirmar;
	private JTextField textFieldPrimeiroNome;
	private JTextField textFieldTel;
	private JComboBox<Object> comboBoxTipoTel;
	private JTextField textFieldLogradouro;
	private JTextField textFieldCidade;
	private JTextField textFieldEmail;
	private JTextField textFieldNumCartao;
	private JTextField textFieldTitularUltimo;
	private JTextField textFieldTitularPrimeiro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteCadastroView frame = new ClienteCadastroView();
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
	
	public ClienteCadastroView() {
		
		// Conecta ao Banco de Dados
		ClienteInsertBD clienteBd = new ClienteInsertBD();

		JOptionPane popUp = new JOptionPane();

		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 502);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBoxTipoTel = new JComboBox<Object>();
		comboBoxTipoTel.setModel(new DefaultComboBoxModel<Object>(new String[] { "Fixo", "Celular" }));
		comboBoxTipoTel.setBounds(375, 248, 90, 20);
		contentPane.add(comboBoxTipoTel);

		JLabel lblImg = new JLabel("img");
		lblImg.setBounds(10, 142, 244, 171);
		contentPane.add(lblImg);
		lblImg.setIcon(new ImageIcon(ClienteCadastroView.class.getResource("/resource/logo_menor.png")));

		JLabel lblCadastroCliente = new JLabel("Cadastro de cliente");
		lblCadastroCliente.setForeground(new Color(128, 0, 0));
		lblCadastroCliente.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblCadastroCliente.setBounds(10, 0, 436, 52);
		contentPane.add(lblCadastroCliente);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(264, 155, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblRg = new JLabel("RG:");
		lblRg.setBounds(264, 199, 46, 14);
		contentPane.add(lblRg);

		JLabel lblUltimoNome = new JLabel("Ultimo Nome:");
		lblUltimoNome.setBounds(264, 110, 151, 14);
		contentPane.add(lblUltimoNome);

		textFieldUltimoNome = new JTextField();
		textFieldUltimoNome.setBounds(375, 107, 151, 20);
		contentPane.add(textFieldUltimoNome);
		textFieldUltimoNome.setColumns(10);

		textFieldCpf = new JTextField(15);
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(375, 152, 99, 20);
		contentPane.add(textFieldCpf);

		textFieldRg = new JTextField();
		textFieldRg.setColumns(10);
		textFieldRg.setBounds(375, 196, 99, 20);
		contentPane.add(textFieldRg);

		JComboBox comboBoxUf = new JComboBox();
		comboBoxUf.setModel(new DefaultComboBoxModel(
				new String[] { "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR",
						"PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		comboBoxUf.setBounds(681, 157, 60, 22);
		contentPane.add(comboBoxUf);

		MaskFormatter mascaraData = null;
		try {
			mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JFormattedTextField jFormattedTextData = new JFormattedTextField(mascaraData);
		jFormattedTextData.setBounds(681, 367, 60, 20);
		contentPane.add(jFormattedTextData);

		JButton buttonCadastrar = new JButton("Confirmar Cadastro");
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldPrimeiroNome.getText().trim().equals("") || textFieldUltimoNome.getText().trim().equals("")
						|| textFieldCpf.getText().trim().equals("") || textFieldRg.getText().trim().equals("")
						|| textFieldUltimoNome.getText().trim().equals("")
						|| passwordFieldSenha.getPassword().length <= 0 || textFieldTel.getText().trim().equals("")
						|| textFieldCidade.getText().trim().equals("") || textFieldEmail.getText().trim().equals("")
						|| textFieldLogradouro.getText().trim().equals("")
						|| textFieldNumCartao.getText().trim().equals("")
						|| textFieldTitularPrimeiro.getText().trim().equals("")
						|| textFieldTitularUltimo.getText().trim().equals("") || comboBoxTipoTel.getSelectedIndex() < 0
						|| jFormattedTextData.getText().trim().equals("/  /")) {
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane,
							"Dados incorretos!\nPreencha todos os dados para prosseguir!");
					passwordFieldSenha.setText("");
					passwordFieldConfirmar.setText("");

				} else if (!Arrays.equals(passwordFieldSenha.getPassword(), passwordFieldConfirmar.getPassword())) {
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane, "Senha não confere! Insira novamente");
					passwordFieldSenha.setText("");
					passwordFieldConfirmar.setText("");
				} else {
					String password = new String(passwordFieldSenha.getPassword());
					try {
						if (clienteBd.insertCliente(textFieldCpf.getText().trim(), textFieldRg.getText().trim(),
								textFieldPrimeiroNome.getText().trim(), textFieldUltimoNome.getText().trim(),
								password)) {

							clienteBd.insertTelefone(textFieldCpf.getText().trim(), textFieldTel.getText().trim(),
									comboBoxTipoTel.getSelectedItem().toString());

							clienteBd.insertCartao(textFieldCpf.getText().trim(), textFieldNumCartao.getText().trim(),
									textFieldTitularPrimeiro.getText().trim(), textFieldTitularUltimo.getText().trim(),
									jFormattedTextData.getText());

							clienteBd.insertEmail(textFieldCpf.getText().trim(), textFieldEmail.getText().trim());

							clienteBd.insertEndereco(textFieldCpf.getText().trim(),
									textFieldLogradouro.getText().trim(), textFieldCidade.getText().trim(),
									comboBoxUf.getSelectedItem().toString());

							popUp.setVisible(true);
							JOptionPane.showInternalMessageDialog(contentPane, "Cadastro realizado com sucesso!");
							ClienteLoginView login = new ClienteLoginView();
							login.setVisible(true);
							ClienteCadastroView.this.dispose();
						} else {
							popUp.setVisible(true);
							JOptionPane.showInternalMessageDialog(contentPane, "Dados incorretos!");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		buttonCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonCadastrar.setBounds(638, 429, 151, 23);
		contentPane.add(buttonCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteLoginView clienteLogin = new ClienteLoginView();
				clienteLogin.setVisible(true);
				ClienteCadastroView.this.dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBounds(815, 429, 99, 23);
		contentPane.add(btnVoltar);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(264, 342, 46, 14);
		contentPane.add(lblSenha);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(375, 339, 136, 20);
		contentPane.add(passwordFieldSenha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setBounds(264, 377, 99, 17);
		contentPane.add(lblConfirmarSenha);

		passwordFieldConfirmar = new JPasswordField();
		passwordFieldConfirmar.setBounds(375, 374, 136, 20);
		contentPane.add(passwordFieldConfirmar);

		JLabel lblPrimeiroNome = new JLabel("Primeiro Nome:");
		lblPrimeiroNome.setBounds(264, 67, 151, 14);
		contentPane.add(lblPrimeiroNome);

		textFieldPrimeiroNome = new JTextField();
		textFieldPrimeiroNome.setColumns(10);
		textFieldPrimeiroNome.setBounds(375, 64, 151, 20);
		contentPane.add(textFieldPrimeiroNome);

		textFieldTel = new JTextField(11);
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(375, 293, 127, 20);
		contentPane.add(textFieldTel);

		JLabel labelTel = new JLabel("Telefone:");
		labelTel.setBounds(264, 296, 151, 14);
		contentPane.add(labelTel);

		JLabel labelTipoTel = new JLabel("Tipo Telefone:");
		labelTipoTel.setBounds(264, 251, 151, 14);
		contentPane.add(labelTipoTel);

		JLabel labelLogradouro = new JLabel("Logradouro:");
		labelLogradouro.setBounds(570, 70, 151, 14);
		contentPane.add(labelLogradouro);

		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setColumns(10);
		textFieldLogradouro.setBounds(681, 67, 214, 20);
		contentPane.add(textFieldLogradouro);

		JLabel labelCidade = new JLabel("Cidade:");
		labelCidade.setBounds(570, 113, 151, 14);
		contentPane.add(labelCidade);

		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(681, 110, 151, 20);
		contentPane.add(textFieldCidade);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(570, 161, 46, 14);
		contentPane.add(lblUf);

		JLabel labelEmail = new JLabel("E-mail:");
		labelEmail.setBounds(264, 414, 46, 14);
		contentPane.add(labelEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(375, 411, 188, 20);
		contentPane.add(textFieldEmail);

		JLabel lblNumeroCarto = new JLabel("Numero Cart\u00E3o:");
		lblNumeroCarto.setBounds(570, 248, 151, 14);
		contentPane.add(lblNumeroCarto);

		textFieldNumCartao = new JTextField();
		textFieldNumCartao.setColumns(10);
		textFieldNumCartao.setBounds(681, 245, 214, 20);
		contentPane.add(textFieldNumCartao);

		JLabel lblTitularNome_1 = new JLabel("Titular 2\u00BA nome:");
		lblTitularNome_1.setBounds(570, 331, 151, 14);
		contentPane.add(lblTitularNome_1);

		textFieldTitularUltimo = new JTextField();
		textFieldTitularUltimo.setColumns(10);
		textFieldTitularUltimo.setBounds(681, 328, 214, 20);
		contentPane.add(textFieldTitularUltimo);

		JLabel lblDataVencimento = new JLabel("Data Vencimento:");
		lblDataVencimento.setBounds(570, 372, 151, 14);
		contentPane.add(lblDataVencimento);

		JLabel lblTitularNome = new JLabel("Titular 1\u00BA  nome:");
		lblTitularNome.setBounds(570, 291, 151, 14);
		contentPane.add(lblTitularNome);

		textFieldTitularPrimeiro = new JTextField();
		textFieldTitularPrimeiro.setColumns(10);
		textFieldTitularPrimeiro.setBounds(681, 288, 214, 20);
		contentPane.add(textFieldTitularPrimeiro);
	}
}
