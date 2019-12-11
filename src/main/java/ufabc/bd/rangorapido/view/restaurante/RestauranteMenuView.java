package ufabc.bd.rangorapido.view.restaurante;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ufabc.bd.rangorapido.DAO.RestauranteSelectBD;
import ufabc.bd.rangorapido.view.cliente.ClienteBuscaRestauranteView;
import ufabc.bd.rangorapido.view.cliente.ClientePagamentoView;

import javax.swing.JList;
import javax.swing.ListModel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;

public class RestauranteMenuView extends JFrame {

	private JPanel contentPane;
	HashMap<String, String> list = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestauranteMenuView frame = new RestauranteMenuView(null, null);
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
	public RestauranteMenuView(String cnpj, String cpf) {

		RestauranteSelectBD restauranteSelect = new RestauranteSelectBD();

		setTitle("Menu Restaurante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> listPratos = new JList<String>(model);
		listPratos.setBackground(new Color(240, 248, 255));
		DefaultListCellRenderer renderer = (DefaultListCellRenderer) listPratos.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		listPratos.setBorder(UIManager.getBorder("TitledBorder.border"));
		listPratos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPratos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		listPratos.setBounds(256, 61, 432, 397);
		contentPane.add(listPratos);

		try {
			list = restauranteSelect.selectPrato(cnpj);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Object key;
		for (int i = 0; i < list.size(); i++) {
			key = list.keySet().toArray()[i];
			model.add(i, "Prato: " + key + " - Valor: R$ " + list.get(key));
		}

		JButton btnRealizarPedido = new JButton("Realizar pedido");
		btnRealizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientePagamentoView pagamento;
				try {
					for (int i = 0; i < list.size(); i++) {
						if (listPratos.getSelectedValue().contains(list.keySet().toArray()[i].toString())) {
							String descricao = list.keySet().toArray()[i].toString().toString();
							pagamento = new ClientePagamentoView(cpf, cnpj,
									restauranteSelect.selectIdPrato(descricao, "ID"));
							pagamento.setVisible(true);
							RestauranteMenuView.this.dispose();
						}
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRealizarPedido.setForeground(new Color(255, 255, 255));
		btnRealizarPedido.setBackground(new Color(0, 128, 0));
		btnRealizarPedido.setBounds(535, 487, 153, 23);
		contentPane.add(btnRealizarPedido);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cpf != null) {
					ClienteBuscaRestauranteView busca = new ClienteBuscaRestauranteView(cpf);
					busca.setVisible(true);
					RestauranteMenuView.this.dispose();
				} else {
					try {
						RestauranteAreaView area = new RestauranteAreaView(cnpj);
						area.setVisible(true);
						RestauranteMenuView.this.dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnVoltar.setBounds(535, 522, 153, 23);
		contentPane.add(btnVoltar);

		JLabel labelNomeRest = new JLabel("");
		labelNomeRest.setHorizontalAlignment(SwingConstants.LEFT);
		labelNomeRest.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelNomeRest.setBounds(20, 11, 432, 39);
		try {
			labelNomeRest.setText("Peça sua comida no " + restauranteSelect.selectGenericoCnpj(cnpj, "Nome_oficial"));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		contentPane.add(labelNomeRest);

		JLabel label = new JLabel("img");
		label.setIcon(new ImageIcon(RestauranteMenuView.class.getResource("/resource/rango.jpeg")));
		label.setBounds(20, 61, 238, 397);
		contentPane.add(label);
		if (cpf == null) {
			btnRealizarPedido.setVisible(false);
		}

	}
}
