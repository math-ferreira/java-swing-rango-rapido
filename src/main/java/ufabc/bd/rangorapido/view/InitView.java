package ufabc.bd.rangorapido.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import ufabc.bd.rangorapido.view.cliente.ClienteInitView;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;

public class InitView {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitView window = new InitView();
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 940, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSejamBemVindos = new JLabel("Sejam Bem vindos! Rango Rapido");
		lblSejamBemVindos.setHorizontalAlignment(SwingConstants.CENTER);
		lblSejamBemVindos.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblSejamBemVindos.setBounds(309, 38, 537, 108);
		frame.getContentPane().add(lblSejamBemVindos);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(InitView.class.getResource("/resource/Capturar.PNG")));
		lblNewLabel.setBounds(319, 119, 441, 258);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(InitView.class.getResource("/resource/9b077e87a3321615c5f45ae2ec96cf14-gpMedium.jpeg")));
		lblNewLabel_1.setBounds(10, -102, 289, 672);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnCli = new JButton("Cliente");
		btnCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteInitView clienteInit = new ClienteInitView();
				clienteInit.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCli.setBounds(457, 413, 123, 23);
		frame.getContentPane().add(btnCli);
		
		JButton btnRest = new JButton("Restaurante");
		btnRest.setBounds(590, 412, 130, 23);
		frame.getContentPane().add(btnRest);

	}
}
