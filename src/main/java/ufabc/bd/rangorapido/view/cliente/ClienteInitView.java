package ufabc.bd.rangorapido.view.cliente;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ClienteInitView extends JFrame{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteInitView window = new ClienteInitView();
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
	public ClienteInitView() {
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ClienteInitView.class.getResource("/resource/form-wizard-login.jpg")));
		lblNewLabel.setBounds(53, 58, 366, 350);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSignIn.setBounds(492, 368, 165, 40);
		frame.getContentPane().add(btnSignIn);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.setBounds(680, 368, 178, 40);
		frame.getContentPane().add(btnCadastrar);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(ClienteInitView.class.getResource("/resource/images.png")));
		label.setBounds(549, 131, 222, 176);
		frame.getContentPane().add(label);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblCliente.setBounds(559, 58, 199, 58);
		frame.getContentPane().add(lblCliente);
		
		
	}

}
