package ufabc.bd.rangorapido.view.restaurante;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufabc.bd.rangorapido.DAO.RestauranteDeleteBD2;
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

public class RestauranteAreaView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeRestaurante;
	private JTextField textFieldFant;
	private JTextField textFieldCnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestauranteAreaView frame = new RestauranteAreaView(null);
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
	public RestauranteAreaView(String cnpj) throws SQLException {

		// Conecta ao Banco de Dados
		RestauranteSelectBD restauranteBd = new RestauranteSelectBD();
		RestauranteDeleteBD2 deleteRest = new RestauranteDeleteBD2();

		setTitle("Area do Restaurante");
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
		textFieldNomeRestaurante.setBounds(36, 31, 263, 52);
		textFieldNomeRestaurante.setText(restauranteBd.selectGenericoCnpj(cnpj, "Nome_oficial"));
		contentPane.add(textFieldNomeRestaurante);
		textFieldNomeRestaurante.setColumns(10);

		JLabel lblFantasia = new JLabel("Fantasia:");
		lblFantasia.setBounds(36, 134, 90, 14);
		contentPane.add(lblFantasia);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(36, 171, 46, 14);
		contentPane.add(lblCnpj);

		textFieldFant = new JTextField();
		textFieldFant.setEditable(false);
		textFieldFant.setColumns(10);
		textFieldFant.setBounds(121, 131, 178, 20);
		textFieldFant.setText(restauranteBd.selectGenericoCnpj(cnpj, "Nome_fantasia"));
		contentPane.add(textFieldFant);

		textFieldCnpj = new JTextField();
		textFieldCnpj.setEditable(false);
		textFieldCnpj.setColumns(10);
		textFieldCnpj.setBounds(121, 168, 178, 20);
		textFieldCnpj.setText(restauranteBd.selectGenericoCnpj(cnpj, "Cnpj"));
		contentPane.add(textFieldCnpj);

		JLabel label = new JLabel("img");
		label.setIcon(new ImageIcon(RestauranteAreaView.class.getResource("/resource/logo_menor.png")));
		label.setBounds(385, 32, 252, 171);
		contentPane.add(label);

		JButton btnAlterarMenu = new JButton("Alterar Menu");
		btnAlterarMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestauranteAlterarMenuView menu = new RestauranteAlterarMenuView(cnpj);
				menu.setVisible(true);
				RestauranteAreaView.this.dispose();
			}
		});
		btnAlterarMenu.setBounds(168, 251, 131, 23);
		contentPane.add(btnAlterarMenu);

		JButton btnAlterarDados = new JButton("Alterar dados");
		btnAlterarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestauranteAlterarDadosView alterar = new RestauranteAlterarDadosView(cnpj);
				alterar.setVisible(true);
				RestauranteAreaView.this.dispose();
			}
		});
		btnAlterarDados.setBounds(36, 286, 122, 23);
		contentPane.add(btnAlterarDados);

		JButton btnRemoverRestaurante = new JButton("Remover Restaurante");
		btnRemoverRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deleteRest.deleteRestaurante(cnpj);
					InitView init = new InitView();
					init.frmInicio.setVisible(true);
					RestauranteAreaView.this.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRemoverRestaurante.setBounds(168, 286, 131, 23);
		contentPane.add(btnRemoverRestaurante);

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestauranteLoginView login = new RestauranteLoginView();
				login.setVisible(true);
				RestauranteAreaView.this.dispose();
			}
		});
		btnSair.setBounds(543, 286, 89, 23);
		contentPane.add(btnSair);

		JButton btnAbrirMenu = new JButton("Abrir Menu");
		btnAbrirMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestauranteMenuView menu = new RestauranteMenuView(cnpj, null);
				menu.setVisible(true);
				RestauranteAreaView.this.dispose();
			}
		});
		btnAbrirMenu.setBounds(36, 251, 122, 23);
		contentPane.add(btnAbrirMenu);
	}
}
