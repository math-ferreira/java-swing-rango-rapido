package ufabc.bd.rangorapido.view.cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ufabc.bd.rangorapido.DAO.ClienteSelectBD;
import ufabc.bd.rangorapido.DAO.RestauranteSelectBD;
import ufabc.bd.rangorapido.view.restaurante.RestauranteMenuView;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class ClienteBuscaRestauranteView extends JFrame {

	private JPanel contentPane;
	private ArrayList<String> listNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteBuscaRestauranteView frame = new ClienteBuscaRestauranteView(null);
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
	public ClienteBuscaRestauranteView(String cpf) {
		RestauranteSelectBD restauranteSelect = new RestauranteSelectBD();

		setTitle("Restaurantes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("img");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(ClienteBuscaRestauranteView.class.getResource("/resource/logo_menor.png")));
		label.setBounds(10, 117, 225, 171);
		contentPane.add(label);

		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> listRestaurantes = new JList<String>(model);
		listRestaurantes.setBorder(UIManager.getBorder("TitledBorder.border"));
		listRestaurantes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listRestaurantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listRestaurantes.setBounds(266, 53, 265, 331);
		ArrayList<String> listTipoComida = null;
		try {
			listNome = new ArrayList<String>();
			listNome = restauranteSelect.selectCampoRestaurante("Nome_oficial");
			listTipoComida = new ArrayList<String>();
			listTipoComida = restauranteSelect.selectCampoRestaurante("Tipo_comida");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < listNome.size(); i++) {
			model.add(i, listNome.get(i) + "   -   " + listTipoComida.get(i));
		}

		contentPane.add(listRestaurantes);

		JButton btnVerMenu = new JButton("Abrir Menu");
		btnVerMenu.setForeground(new Color(255, 255, 255));
		btnVerMenu.setBackground(new Color(0, 128, 0));
		btnVerMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestauranteMenuView menu;
				try {
					menu = new RestauranteMenuView(
							restauranteSelect.selectCnpj(listNome.get(listRestaurantes.getSelectedIndex())), cpf);
					menu.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				ClienteBuscaRestauranteView.this.dispose();
			}
		});
		btnVerMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVerMenu.setBounds(555, 143, 138, 33);
		contentPane.add(btnVerMenu);

		JButton btnFiltrarPesquisa = new JButton("Filtrar Pesquisa");
		btnFiltrarPesquisa.setBounds(555, 312, 130, 23);
		contentPane.add(btnFiltrarPesquisa);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteAreaView area = new ClienteAreaView(cpf);
				area.setVisible(true);
				ClienteBuscaRestauranteView.this.dispose();
			}
		});
		btnVoltar.setBounds(555, 360, 130, 23);
		contentPane.add(btnVoltar);

		JLabel lblNomes = new JLabel("Restaurantes e tipo de comidas");
		lblNomes.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNomes.setBounds(257, 11, 298, 33);
		contentPane.add(lblNomes);
		
		JLabel lblImg = new JLabel("img2");
		lblImg.setIcon(new ImageIcon(ClienteBuscaRestauranteView.class.getResource("/resource/tela-inicial.jpg")));
		lblImg.setBounds(10, 11, 225, 382);
		contentPane.add(lblImg);

	}
}
