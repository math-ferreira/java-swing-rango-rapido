package ufabc.bd.rangorapido.view.restaurante;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufabc.bd.rangorapido.DAO.RestauranteInsertBD;
import ufabc.bd.rangorapido.DAO.RestauranteUpdateBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class RestauranteAlterarMenuView extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPreco;
	private JTextField textFieldDisp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestauranteAlterarMenuView frame = new RestauranteAlterarMenuView(null);
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
	public RestauranteAlterarMenuView(String cnpj) {
		// Conecta com o banco de dados
		RestauranteInsertBD restauranteInsert = new RestauranteInsertBD();
		RestauranteUpdateBD restauranteUpdate = new RestauranteUpdateBD();

		setTitle("Alterar Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox comboBoxTipoComida = new JComboBox();
		comboBoxTipoComida.setModel(new DefaultComboBoxModel(new String[] { "", "Arabe", "Mexicana", "Churrasco",
				"Caseira", "Forno a lenha", "Burgers", "Pizza e Esfiha", "Vegetariana", "Vegana", "Outros" }));
		comboBoxTipoComida.setBounds(120, 103, 157, 22);
		contentPane.add(comboBoxTipoComida);

		JLabel lblAlterarModificar = new JLabel("Alterar / Modificar:");
		lblAlterarModificar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlterarModificar.setBounds(26, 34, 186, 22);
		contentPane.add(lblAlterarModificar);

		JLabel lblEspecialidade = new JLabel("Especialidade:");
		lblEspecialidade.setBounds(26, 107, 122, 14);
		contentPane.add(lblEspecialidade);

		JLabel lblAdicionarPratos = new JLabel("Adicionar Pratos:");
		lblAdicionarPratos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdicionarPratos.setBounds(26, 164, 198, 22);
		contentPane.add(lblAdicionarPratos);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBounds(26, 218, 90, 14);
		contentPane.add(lblDescrio);

		JTextPane textPaneDesc = new JTextPane();
		textPaneDesc.setBounds(91, 218, 186, 77);
		contentPane.add(textPaneDesc);

		JLabel lblPreo = new JLabel("Pre\u00E7o:  R$");
		lblPreo.setBounds(26, 325, 90, 14);
		contentPane.add(lblPreo);

		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(191, 322, 86, 20);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);

		JLabel lblQuantidadeDisponibilidade = new JLabel("Quantidade disponibilidade:");
		lblQuantidadeDisponibilidade.setBounds(26, 369, 151, 14);
		contentPane.add(lblQuantidadeDisponibilidade);

		textFieldDisp = new JTextField();
		textFieldDisp.setBounds(191, 366, 86, 20);
		contentPane.add(textFieldDisp);
		textFieldDisp.setColumns(10);

		JButton btnAdicionarPrato = new JButton("Adicionar Prato");
		btnAdicionarPrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldDisp.getText().trim().equals("") || textFieldPreco.getText().trim().equals("")
						|| textPaneDesc.getText().trim().equals("")) {
					JOptionPane.showInternalMessageDialog(contentPane,
							"Dados incorretos!\nPreencha todos os dados para prosseguir!");
				} else {
					try {
						restauranteInsert.insertPrato(cnpj, textPaneDesc.getText().trim(),
								textFieldPreco.getText().trim(), textFieldDisp.getText().trim());
						if (comboBoxTipoComida.getSelectedIndex() != 0) {
							restauranteUpdate.updateGenerico(cnpj, "Tipo_comida",
									comboBoxTipoComida.getSelectedItem().toString());
						}
						JOptionPane.showInternalMessageDialog(contentPane, "Prato Inserido com sucesso!");
						RestauranteAreaView area = new RestauranteAreaView(cnpj);
						area.setVisible(true);
						RestauranteAlterarMenuView.this.dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnAdicionarPrato.setBounds(140, 415, 140, 23);
		contentPane.add(btnAdicionarPrato);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RestauranteAreaView area = new RestauranteAreaView(cnpj);
					area.setVisible(true);
					RestauranteAlterarMenuView.this.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVoltar.setBounds(191, 458, 89, 23);
		contentPane.add(btnVoltar);
	}
}
