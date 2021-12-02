package TP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class inout extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField ISBN_Input;
	private JTextField textField_1;
	private JTextField BOOK_TITLE;
	private JTextField BOOK_AUTHIR;
	private JTextField BOOK_PUB;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField RENT_NAME;
	private JTextField RENT_USER_PHONE;
	private JTextField RENT_USER_EMAIL;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField BOOK_PRICE;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inout frame = new inout();
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
	public inout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 863);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel NORTH_BAR = new JPanel();
		NORTH_BAR.setBounds(0, 0, 799, 23);
		contentPane.add(NORTH_BAR);
		NORTH_BAR.setLayout(null);
		
		JButton btnNewButton = new JButton("\uB300\uC5EC");
		btnNewButton.setBounds(0, 0, 97, 23);
		NORTH_BAR.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("\uBC18\uB0A9");
		btnNewButton_2.setBounds(406, 0, 97, 23);
		NORTH_BAR.add(btnNewButton_2);
		
		JPanel RENT_1 = new JPanel();
		RENT_1.setBackground(SystemColor.activeCaption);
		RENT_1.setBounds(0, 21, 385, 390);
		contentPane.add(RENT_1);
		RENT_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(12, 10, 57, 15);
		RENT_1.add(lblNewLabel);
		
		ISBN_Input = new JTextField();
		ISBN_Input.setBounds(91, 7, 116, 21);
		RENT_1.add(ISBN_Input);
		ISBN_Input.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("\uD655\uC778");
		btnNewButton_3.setBounds(276, 6, 97, 23);
		RENT_1.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("\uB300\uC5EC\uC644\uB8CC");
		btnNewButton_5.setBounds(276, 357, 97, 23);
		RENT_1.add(btnNewButton_5);
		
		JLabel lblNewLabel_2 = new JLabel("\uC81C\uBAA9");
		lblNewLabel_2.setBounds(12, 63, 57, 15);
		RENT_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC800\uC790");
		lblNewLabel_3.setBounds(12, 88, 57, 15);
		RENT_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_4.setBounds(12, 113, 57, 15);
		RENT_1.add(lblNewLabel_4);
		
		BOOK_TITLE = new JTextField();
		BOOK_TITLE.setBounds(91, 60, 116, 21);
		RENT_1.add(BOOK_TITLE);
		BOOK_TITLE.setColumns(10);
		
		BOOK_AUTHIR = new JTextField();
		BOOK_AUTHIR.setBounds(91, 85, 116, 21);
		RENT_1.add(BOOK_AUTHIR);
		BOOK_AUTHIR.setColumns(10);
		
		BOOK_PUB = new JTextField();
		BOOK_PUB.setBounds(91, 110, 116, 21);
		RENT_1.add(BOOK_PUB);
		BOOK_PUB.setColumns(10);
		
		JPanel BOOK_IMG = new JPanel();
		BOOK_IMG.setBounds(219, 62, 154, 178);
		RENT_1.add(BOOK_IMG);
		
		JLabel lblNewLabel_9 = new JLabel("\uB300\uC5EC\uC790");
		lblNewLabel_9.setBounds(12, 222, 57, 15);
		RENT_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("\uC5F0\uB77D\uCC98");
		lblNewLabel_11.setBounds(12, 251, 57, 15);
		RENT_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_13 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_13.setBounds(12, 282, 57, 15);
		RENT_1.add(lblNewLabel_13);
		
		RENT_NAME = new JTextField();
		RENT_NAME.setBounds(91, 219, 116, 21);
		RENT_1.add(RENT_NAME);
		RENT_NAME.setColumns(10);
		
		RENT_USER_PHONE = new JTextField();
		RENT_USER_PHONE.setBounds(91, 248, 116, 21);
		RENT_1.add(RENT_USER_PHONE);
		RENT_USER_PHONE.setColumns(10);
		
		RENT_USER_EMAIL = new JTextField();
		RENT_USER_EMAIL.setBounds(91, 279, 116, 21);
		RENT_1.add(RENT_USER_EMAIL);
		RENT_USER_EMAIL.setColumns(10);
		
		JButton btnNewButton_7 = new JButton("\uD68C\uC6D0\uD655\uC778");
		btnNewButton_7.setBounds(99, 310, 97, 23);
		RENT_1.add(btnNewButton_7);
		
		JLabel lblNewLabel_4_1 = new JLabel("\uAC00\uACA9");
		lblNewLabel_4_1.setBounds(12, 138, 57, 15);
		RENT_1.add(lblNewLabel_4_1);
		
		BOOK_PRICE = new JTextField();
		BOOK_PRICE.setColumns(10);
		BOOK_PRICE.setBounds(91, 135, 116, 21);
		RENT_1.add(BOOK_PRICE);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(397, 0, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel RENT_2 = new JPanel();
		RENT_2.setBackground(SystemColor.activeCaption);
		RENT_2.setBounds(407, 21, 392, 390);
		contentPane.add(RENT_2);
		RENT_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ISBN");
		lblNewLabel_1.setBounds(12, 10, 57, 15);
		RENT_2.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 7, 116, 21);
		RENT_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("\uD655\uC778");
		btnNewButton_4.setBounds(283, 6, 97, 23);
		RENT_2.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("\uBC18\uB0A9\uC644\uB8CC");
		btnNewButton_6.setBounds(283, 357, 97, 23);
		RENT_2.add(btnNewButton_6);
		
		JLabel lblNewLabel_5 = new JLabel("\uC81C\uBAA9");
		lblNewLabel_5.setBounds(12, 63, 57, 15);
		RENT_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uC800\uC790");
		lblNewLabel_6.setBounds(12, 88, 57, 15);
		RENT_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_7.setBounds(12, 113, 57, 15);
		RENT_2.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(91, 60, 116, 21);
		RENT_2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(91, 85, 116, 21);
		RENT_2.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(91, 110, 116, 21);
		RENT_2.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(219, 63, 161, 177);
		RENT_2.add(panel_4);
		
		JLabel lblNewLabel_10 = new JLabel("\uBC18\uB0A9\uC790");
		lblNewLabel_10.setBounds(12, 184, 57, 15);
		RENT_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_12 = new JLabel("\uC5F0\uB77D\uCC98");
		lblNewLabel_12.setBounds(12, 209, 57, 15);
		RENT_2.add(lblNewLabel_12);
		
		JLabel lblNewLabel_14 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_14.setBounds(12, 234, 57, 15);
		RENT_2.add(lblNewLabel_14);
		
		textField_11 = new JTextField();
		textField_11.setBounds(91, 181, 116, 21);
		RENT_2.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(91, 206, 116, 21);
		RENT_2.add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(91, 231, 116, 21);
		RENT_2.add(textField_13);
		textField_13.setColumns(10);
		
		JLabel lblNewLabel_7_1 = new JLabel("\uAC00\uACA9");
		lblNewLabel_7_1.setBounds(12, 138, 57, 15);
		RENT_2.add(lblNewLabel_7_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(91, 135, 116, 21);
		RENT_2.add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 446, 789, 305);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ISBN", "제목", "저자",  "대여일자", "반납일자"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(107);
		table.getColumnModel().getColumn(1).setPreferredWidth(44);
		table.getColumnModel().getColumn(2).setPreferredWidth(101);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_8 = new JLabel("\uB3C4\uC11C \uD604\uD669");
		lblNewLabel_8.setBounds(44, 421, 123, 15);
		contentPane.add(lblNewLabel_8);
	}
}
