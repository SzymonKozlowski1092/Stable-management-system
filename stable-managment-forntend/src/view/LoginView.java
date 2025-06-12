package view;

import java.awt.EventQueue;
import viewModel.LoginViewModel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controls.PlaceholderPasswordField;
import controls.PlaceholderTextField;

import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LoginView extends JFrame implements LoginViewModel.LoginCallback 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordFieldPassword;
	private PlaceholderTextField passwordFieldLogin;

	/**
	 * Open first (login) and other window. 
	 */
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new LoginView().setVisible(true));
	    }
	/**
	 * Create the frame.
	 */
	public LoginView() 
	{
		LoginViewModel viewModel = new LoginViewModel(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); 
		setBounds(100, 100, 532, 354);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordFieldPassword = new PlaceholderPasswordField("Password");
		passwordFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordFieldPassword.setBounds(134, 147, 247, 34);
		contentPane.add(passwordFieldPassword);
		
		passwordFieldLogin = new PlaceholderTextField("Login");
		passwordFieldLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordFieldLogin.setBounds(134, 79, 247, 34);
		contentPane.add(passwordFieldLogin);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(134, 232, 247, 45);
		btnLogin.setForeground(SystemColor.inactiveCaptionBorder);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBackground(new Color(204, 153, 51));
		btnLogin.setOpaque(true);
		btnLogin.setContentAreaFilled(true);
		btnLogin.setBorderPainted(false);
		contentPane.add(btnLogin);
		
		JLabel lblHeadline = new JLabel("Stable Managment");
		lblHeadline.setForeground(new Color(51, 0, 0));
		lblHeadline.setFont(new Font("Castellar", Font.PLAIN, 32));
		lblHeadline.setBounds(61, 27, 405, 34);
		contentPane.add(lblHeadline);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRegister.setBackground(SystemColor.info);
		btnRegister.setBounds(217, 287, 85, 21);
		btnRegister.setOpaque(true);
		btnRegister.setContentAreaFilled(true);
		btnRegister.setBorderPainted(false);
		contentPane.add(btnRegister);
		
		//command and actionlistener
		btnLogin.setActionCommand("LOGIN");
        btnRegister.setActionCommand("REGISTER");
        
        btnLogin.addActionListener(viewModel);
        btnRegister.addActionListener(viewModel);
	}
	@Override
	public void onLoginSuccess() {
		// TODO manager or user window (now for test its will be user window)
		SwingUtilities.invokeLater(() -> new UserView().setVisible(true));
		dispose();
	}
	@Override
	public void onLoginFailure() 
	{
		JOptionPane.showMessageDialog(
	            this, "Incorrect passwor or login! \nTry again!", "", JOptionPane.ERROR_MESSAGE
	        );
	}
	@Override
	public void onRegisterRequested() 
	{
		 SwingUtilities.invokeLater(() -> new RegisterView().setVisible(true));	
	}
}
