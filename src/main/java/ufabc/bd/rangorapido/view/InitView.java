package ufabc.bd.rangorapido.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ufabc.bd.rangorapido.DAO.ConnectBD;
import ufabc.bd.rangorapido.view.cliente.ClienteLoginView;
import ufabc.bd.rangorapido.view.restaurante.RestauranteLoginView;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitView {

	public JFrame frmInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitView window = new InitView();
					window.frmInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InitView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		frmInicio = new JFrame();
		frmInicio.setTitle("Inicio");
		frmInicio.getContentPane().setBackground(Color.WHITE);
		frmInicio.setBounds(100, 100, 940, 502);
		frmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);
		frmInicio.getContentPane().setLayout(null);
		
		JLabel lblSejamBemVindos = new JLabel("Sejam Bem vindos! Rango Rapido");
		lblSejamBemVindos.setHorizontalAlignment(SwingConstants.CENTER);
		lblSejamBemVindos.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblSejamBemVindos.setBounds(313, 11, 537, 108);
		frmInicio.getContentPane().add(lblSejamBemVindos);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(InitView.class.getResource("/resource/rango.jpeg")));
		lblNewLabel_1.setBounds(10, -102, 289, 672);
		frmInicio.getContentPane().add(lblNewLabel_1);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteLoginView clienteLogin = new ClienteLoginView();
				clienteLogin.setVisible(true);
				frmInicio.setVisible(false);
			}
		});
		btnCliente.setBounds(457, 413, 123, 23);
		frmInicio.getContentPane().add(btnCliente);
		
		JButton btnRestaurante = new JButton("Restaurante");
		btnRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestauranteLoginView restauranteLogin = new RestauranteLoginView();
				restauranteLogin.setVisible(true);
				frmInicio.setVisible(false);
			}
		});
		btnRestaurante.setBounds(590, 412, 130, 23);
		frmInicio.getContentPane().add(btnRestaurante);
		
		JLabel lblImg = new JLabel("img");
		lblImg.setBounds(382, 94, 408, 303);
		frmInicio.getContentPane().add(lblImg);
		lblImg.setIcon(new ImageIcon(InitView.class.getResource("/resource/logo.png")));

	}
}
