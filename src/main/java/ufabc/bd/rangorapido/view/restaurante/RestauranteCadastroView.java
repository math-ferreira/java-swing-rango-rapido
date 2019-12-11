package ufabc.bd.rangorapido.view.restaurante;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import ufabc.bd.rangorapido.DAO.RestauranteInsertBD;
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
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;

import javax.swing.JTextPane;

public class RestauranteCadastroView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeFantasia;
	private JTextField textFieldCnpj;
	private JTextField textFielNomeOficial;
	private JTextField textFieldTel;
	private JTextField textFieldCidade;
	private JPasswordField passwordFieldSenha;
	private JPasswordField passwordConfirmarSenha;
	private JTextField textFieldLogradouro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestauranteCadastroView frame = new RestauranteCadastroView();
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
	public RestauranteCadastroView() {

		// Conecta com o banco de dados
		RestauranteInsertBD restauranteInsert = new RestauranteInsertBD();
		JOptionPane popUp = new JOptionPane();

		setTitle("Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 502);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblImg = new JLabel("img");
		lblImg.setBounds(10, 133, 238, 224);
		contentPane.add(lblImg);
		lblImg.setIcon(new ImageIcon(RestauranteCadastroView.class.getResource("/resource/logo_menor.png")));

		JLabel lblCadastroCliente = new JLabel("Cadastro Fiscal do Restaurante");
		lblCadastroCliente.setForeground(new Color(128, 0, 0));
		lblCadastroCliente.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblCadastroCliente.setBounds(10, 11, 693, 52);
		contentPane.add(lblCadastroCliente);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(285, 88, 46, 14);
		contentPane.add(lblCnpj);

		JLabel nomeOficial = new JLabel("Nome Oficial:");
		nomeOficial.setBounds(285, 135, 101, 14);
		contentPane.add(nomeOficial);

		JLabel lblNomeFantasia = new JLabel("Nome Fantasia:");
		lblNomeFantasia.setBounds(285, 174, 151, 14);
		contentPane.add(lblNomeFantasia);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(285, 269, 46, 14);
		contentPane.add(lblTelefone);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(594, 137, 46, 14);
		contentPane.add(lblCidade);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(594, 174, 46, 14);
		contentPane.add(lblUf);

		textFieldNomeFantasia = new JTextField();
		textFieldNomeFantasia.setBounds(392, 171, 136, 20);
		contentPane.add(textFieldNomeFantasia);
		textFieldNomeFantasia.setColumns(10);

		textFieldCnpj = new JTextField();
		textFieldCnpj.setColumns(10);
		textFieldCnpj.setBounds(392, 85, 99, 20);
		contentPane.add(textFieldCnpj);

		textFielNomeOficial = new JTextField();
		textFielNomeOficial.setColumns(10);
		textFielNomeOficial.setBounds(392, 132, 136, 20);
		contentPane.add(textFielNomeOficial);

		textFieldTel = new JTextField();
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(392, 266, 118, 20);
		contentPane.add(textFieldTel);

		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(701, 132, 157, 20);
		contentPane.add(textFieldCidade);

		MaskFormatter mascaraHoraInicio = null;
		try {
			mascaraHoraInicio = new MaskFormatter("##:##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JFormattedTextField jFormattedTextHoraInicio = new JFormattedTextField(mascaraHoraInicio);
		jFormattedTextHoraInicio.setBounds(701, 222, 60, 20);
		contentPane.add(jFormattedTextHoraInicio);

		MaskFormatter mascaraHoraFim = null;
		try {
			mascaraHoraFim = new MaskFormatter("##:##");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JFormattedTextField jFormattedTextHoraFim = new JFormattedTextField(mascaraHoraFim);
		jFormattedTextHoraFim.setBounds(701, 266, 60, 20);
		contentPane.add(jFormattedTextHoraFim);

		JComboBox comboBoxUf = new JComboBox();
		comboBoxUf.setModel(new DefaultComboBoxModel(
				new String[] { "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR",
						"PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		comboBoxUf.setBounds(701, 172, 46, 18);
		contentPane.add(comboBoxUf);

		JComboBox comboBoxTipoComida = new JComboBox();
		comboBoxTipoComida.setModel(new DefaultComboBoxModel(new String[] { "Arabe", "Mexicana", "Churrasco", "Caseira",
				"Forno a lenha", "Burgers", "Pizza e Esfiha", "Vegetariana", "Vegana", "Outros" }));
		comboBoxTipoComida.setBounds(701, 311, 157, 22);
		contentPane.add(comboBoxTipoComida);

		JComboBox<Object> comboBoxTipoTel = new JComboBox<Object>();
		comboBoxTipoTel.setModel(new DefaultComboBoxModel(new String[] { "Fixo", "Celular" }));
		comboBoxTipoTel.setBounds(392, 219, 90, 20);
		contentPane.add(comboBoxTipoTel);

		JButton buttonCadastrar = new JButton("Confirmar Dados Fiscais");
		buttonCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldCnpj.getText().trim().equals("") || textFieldCidade.getText().trim().equals("")
						|| textFieldNomeFantasia.getText().trim().equals("") || textFieldTel.getText().trim().equals("")
						|| textFielNomeOficial.getText().trim().equals("")
						|| textFieldLogradouro.getText().trim().equals("")
						|| jFormattedTextHoraInicio.getText().trim().equals("")
						|| jFormattedTextHoraFim.getText().trim().equals("")) {
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane,
							"Dados incorretos!\nPreencha todos os dados para prosseguir!");
					passwordFieldSenha.setText("");
					passwordConfirmarSenha.setText("");

				} else if (!Arrays.equals(passwordFieldSenha.getPassword(), passwordConfirmarSenha.getPassword())) {
					popUp.setVisible(true);
					JOptionPane.showInternalMessageDialog(contentPane, "Senha não confere! Insira novamente");
					passwordFieldSenha.setText("");
					passwordConfirmarSenha.setText("");
				} else {
					String password = new String(passwordFieldSenha.getPassword());
					try {

						if (restauranteInsert.insertRestaurante(textFieldCnpj.getText().trim(),
								textFielNomeOficial.getText().trim(), textFieldNomeFantasia.getText(),
								comboBoxTipoComida.getSelectedItem().toString(), password))
							popUp.setVisible(true);

						restauranteInsert.insertAtendimento(textFieldCnpj.getText().trim(),
								textFieldCidade.getText().trim(), jFormattedTextHoraInicio.getText().trim(),
								jFormattedTextHoraFim.getText().trim());

						restauranteInsert.insertEndereco(textFieldCnpj.getText().trim(),
								textFieldLogradouro.getText().trim(), textFieldCidade.getText().trim(),
								comboBoxUf.getSelectedItem().toString());

						restauranteInsert.insertTelefone(textFieldCnpj.getText().trim(), textFieldTel.getText().trim(),
								comboBoxTipoTel.getSelectedItem().toString());

						popUp.setVisible(true);
						JOptionPane.showInternalMessageDialog(contentPane, "Cadastro realizado com sucesso!");
						RestauranteLoginView login = new RestauranteLoginView();
						login.setVisible(true);
						RestauranteCadastroView.this.dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		buttonCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonCadastrar.setBounds(567, 429, 204, 23);
		contentPane.add(buttonCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestauranteLoginView restauranteLogin = new RestauranteLoginView();
				restauranteLogin.setVisible(true);
				RestauranteCadastroView.this.dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBounds(815, 429, 99, 23);
		contentPane.add(btnVoltar);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(285, 315, 46, 14);
		contentPane.add(lblSenha);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(392, 312, 136, 20);
		contentPane.add(passwordFieldSenha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		lblConfirmarSenha.setBounds(285, 350, 101, 14);
		contentPane.add(lblConfirmarSenha);

		passwordConfirmarSenha = new JPasswordField();
		passwordConfirmarSenha.setBounds(392, 347, 136, 20);
		contentPane.add(passwordConfirmarSenha);

		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setColumns(10);
		textFieldLogradouro.setBounds(701, 85, 195, 20);
		contentPane.add(textFieldLogradouro);

		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(594, 85, 97, 14);
		contentPane.add(lblLogradouro);

		JLabel label = new JLabel("Tipo Telefone:");
		label.setBounds(285, 222, 151, 14);
		contentPane.add(label);

		JLabel lblHoraAbertura = new JLabel("Hora abertura:");
		lblHoraAbertura.setBounds(594, 225, 90, 14);
		contentPane.add(lblHoraAbertura);

		JLabel lblHoraFechamento = new JLabel("Hora Fechamento:");
		lblHoraFechamento.setBounds(594, 269, 97, 14);
		contentPane.add(lblHoraFechamento);

		JLabel lblTipocomida = new JLabel("TipoComida:");
		lblTipocomida.setBounds(594, 315, 97, 14);
		contentPane.add(lblTipocomida);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
