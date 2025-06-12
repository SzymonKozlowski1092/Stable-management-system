package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controls.HorseButton;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class UserView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel cardsPanel;
	private CardLayout cardLayout;
	//HorseButton view
	private JPanel horseView;
	private JLabel userLabel;
	//Notes View
	private JPanel notesView;
	private JPanel buttonsPanel;

	public UserView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 605);
		cardLayout = new CardLayout();
		cardsPanel = new JPanel(cardLayout);
		cardsPanel.setBackground(SystemColor.info);
		
		//HorseButton view
		horseView = new JPanel(new BorderLayout());
		
		userLabel = new JLabel("Witaj, Jan Kowalski");
		userLabel.setBackground(new Color(184, 134, 11));
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userLabel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        horseView.add(userLabel, BorderLayout.NORTH);
        
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        JScrollPane scroll = new JScrollPane(buttonsPanel);
        horseView.add(scroll, BorderLayout.CENTER);
		
		
		
		//Notes View
		notesView = new JPanel();
		
		//other
		cardsPanel.add(horseView, "HORSES");
        cardsPanel.add(notesView, "NOTES");
		
		getContentPane().add(cardsPanel);
		//setContentPane(cardsPanel);
		//cardsPanel.setLayout(null);
	}
}
