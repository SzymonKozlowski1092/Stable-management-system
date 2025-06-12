package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controls.PlaceholderPasswordField;
import controls.PlaceholderTextField;

import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class RegisterView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldLastname;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JTextField textFieldPhone;
	private JTextField textFieldCode;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public RegisterView() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false); 
		setBounds(100, 100, 451, 597);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("Registration");
		lblHeadline.setForeground(new Color(51, 0, 0));
		lblHeadline.setBounds(91, 10, 274, 35);
		lblHeadline.setFont(new Font("Castellar", Font.PLAIN, 32));
		contentPane.add(lblHeadline);
		
		textFieldName = new PlaceholderTextField("Name");
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldName.setBounds(82, 84, 283, 35);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldLastname = new PlaceholderTextField("Surname");
		textFieldLastname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldLastname.setColumns(10);
		textFieldLastname.setBounds(82, 143, 283, 35);
		contentPane.add(textFieldLastname);
		
		textFieldLogin = new PlaceholderTextField("Login");
		textFieldLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldLogin.setColumns(10);
		textFieldLogin.setBounds(82, 199, 283, 35);
		contentPane.add(textFieldLogin);
		
		textFieldPassword = new PlaceholderPasswordField("Password");
		textFieldPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(82, 254, 283, 35);
		contentPane.add(textFieldPassword);
		
		textFieldPhone = new PlaceholderTextField("Phone Number");
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(82, 314, 283, 35);
		contentPane.add(textFieldPhone);
		
		textFieldCode = new PlaceholderTextField("Code");
		textFieldCode.setToolTipText("The registration code can be obtained from the stable manager and is valid for 3 minutes.");
		textFieldCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCode.setColumns(10);
		textFieldCode.setBounds(82, 372, 283, 35);
		contentPane.add(textFieldCode);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(SystemColor.text);
		btnRegister.setBackground(new Color(204, 153, 51));
		btnRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRegister.setBounds(82, 458, 283, 46);
		btnRegister.setOpaque(true);
		btnRegister.setContentAreaFilled(true);
		btnRegister.setBorderPainted(false);
		contentPane.add(btnRegister);
	}
}
