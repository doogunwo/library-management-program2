package TP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Rental_Form extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rental_Form frame = new Rental_Form();
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
	public Rental_Form() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 447, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel RENT_2 = new JPanel();
		RENT_2.setLayout(null);
		RENT_2.setBackground(Color.WHITE);
		RENT_2.setBounds(12, 10, 392, 390);
		contentPane.add(RENT_2);
		
		JLabel Rent2LabelIsbn = new JLabel("ISBN");
		Rent2LabelIsbn.setBounds(12, 10, 57, 15);
		RENT_2.add(Rent2LabelIsbn);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(91, 7, 116, 21);
		RENT_2.add(textField);
		
		JLabel Rent2LabelTitle = new JLabel("\uC81C\uBAA9");
		Rent2LabelTitle.setBounds(12, 63, 57, 15);
		RENT_2.add(Rent2LabelTitle);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 60, 116, 21);
		RENT_2.add(textField_1);
		
		JLabel Rent2LabelAuthir = new JLabel("\uC800\uC790");
		Rent2LabelAuthir.setBounds(12, 88, 57, 15);
		RENT_2.add(Rent2LabelAuthir);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(91, 85, 116, 21);
		RENT_2.add(textField_2);
		
		JLabel Rent2LabelPub = new JLabel("\uCD9C\uD310\uC0AC");
		Rent2LabelPub.setBounds(12, 113, 57, 15);
		RENT_2.add(Rent2LabelPub);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(91, 110, 116, 21);
		RENT_2.add(textField_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(219, 63, 161, 177);
		RENT_2.add(panel_4);
		
		JLabel Rent2LabelPrice = new JLabel("\uAC00\uACA9");
		Rent2LabelPrice.setBounds(12, 138, 57, 15);
		RENT_2.add(Rent2LabelPrice);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(91, 135, 116, 21);
		RENT_2.add(textField_4);
		
		JLabel Rent2LabelName = new JLabel("\uBC18\uB0A9\uC790");
		Rent2LabelName.setBounds(12, 184, 57, 15);
		RENT_2.add(Rent2LabelName);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(91, 181, 116, 21);
		RENT_2.add(textField_5);
		
		JLabel RentLabelUserPhone = new JLabel("\uC5F0\uB77D\uCC98");
		RentLabelUserPhone.setBounds(12, 209, 57, 15);
		RENT_2.add(RentLabelUserPhone);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(91, 206, 116, 21);
		RENT_2.add(textField_6);
		
		JLabel Rent2LabelEmail = new JLabel("\uC774\uBA54\uC77C");
		Rent2LabelEmail.setBounds(12, 234, 57, 15);
		RENT_2.add(Rent2LabelEmail);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(91, 231, 116, 21);
		RENT_2.add(textField_7);
		
		JButton returnConfirmationButton = new JButton("\uD655\uC778");
		returnConfirmationButton.setBackground(SystemColor.activeCaption);
		returnConfirmationButton.setBounds(283, 6, 97, 23);
		RENT_2.add(returnConfirmationButton);
		
		JButton returnCompleteButton = new JButton("\uB300\uC5EC\uC644\uB8CC");
		returnCompleteButton.setBackground(SystemColor.activeCaption);
		returnCompleteButton.setBounds(283, 357, 97, 23);
		RENT_2.add(returnCompleteButton);
	}
}
