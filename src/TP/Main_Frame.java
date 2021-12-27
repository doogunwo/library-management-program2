package TP;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Status.Book_Status;
import Status.Member_Status;
import Status.Rent_Status;

import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Console;
import java.io.InputStream;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class Main_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField Search_Filed;
	private JTextField tf_ISBN;
	private JTextField tf_Title;
	private JTextField tf_Authir;
	private JTextField tf_Pub;
	private JTextField tf_Price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Frame frame = new Main_Frame();
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
	JLabel book_img = new JLabel("");
	private JTextField Rent_tf;
	private JTextField textField;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	ArrayList<String> list = new ArrayList<String>();
	private JTable ta;

	public Main_Frame() {
		// UPDATE `java03_team03`.`USER_TABLE` SET `USER_RENT_CNT` = '0' WHERE
		// (`USER_PHONE_NUMBER` = '01044421234');
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 723);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("DEU Library");
		lblNewLabel.setBounds(22, 10, 398, 30);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 50, 833, 609);
		contentPane.add(tabbedPane);

		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.WHITE);
		tabbedPane.addTab("\uAC80\uC0C9", null, pn1, null);
		pn1.setLayout(null);
		Search_Filed = new JTextField();
		Search_Filed.setBounds(12, 26, 358, 30);
		pn1.add(Search_Filed);
		Search_Filed.setHorizontalAlignment(SwingConstants.LEFT);
		Search_Filed.setToolTipText("\uCC45\uC774\uB984\uC744 \uC785\uB825\uD558\uC138\uC694");
		Search_Filed.setBackground(SystemColor.text);
		Search_Filed.setColumns(10);
		JButton Search_Button = new JButton("Q");
		Search_Button.setBounds(368, 26, 78, 30);
		pn1.add(Search_Button);
		Search_Button.setToolTipText(
				"\uCC45\uC774\uB984\uC744 \uC785\uB825\uD588\uB098\uC694? \uADF8\uB7EC\uBA74 \uB20C\uB7EC\uC8FC\uC138\uC694");
		Search_Button.setFont(new Font("굴림", Font.BOLD, 20));
		Search_Button.setBackground(SystemColor.activeCaption);
		JPanel Search = new JPanel();
		Search.setBounds(320, 81, 496, 443);
		pn1.add(Search);
		Search.setBackground(Color.WHITE);
		book_img.setBackground(Color.GRAY);

		book_img.setBounds(333, 29, 135, 187);
		Search.add(book_img);
		Search.setLayout(null);

		tf_ISBN = new JTextField();
		tf_ISBN.setBounds(134, 29, 173, 21);
		Search.add(tf_ISBN);
		tf_ISBN.setColumns(10);

		JLabel BOOK_ISBN = new JLabel("ISBN");
		BOOK_ISBN.setFont(new Font("휴먼고딕", Font.PLAIN, 12));
		BOOK_ISBN.setBounds(34, 29, 84, 21);
		Search.add(BOOK_ISBN);

		JLabel BOOK_TITLE = new JLabel("\uC81C\uBAA9");
		BOOK_TITLE.setFont(new Font("휴먼고딕", Font.PLAIN, 12));
		BOOK_TITLE.setBounds(34, 60, 84, 21);
		Search.add(BOOK_TITLE);

		tf_Title = new JTextField();
		tf_Title.setColumns(10);
		tf_Title.setBounds(134, 60, 173, 21);
		Search.add(tf_Title);

		JLabel BOOK_AUTHIR = new JLabel("\uC800\uC790");
		BOOK_AUTHIR.setFont(new Font("휴먼고딕", Font.PLAIN, 12));
		BOOK_AUTHIR.setBounds(34, 95, 84, 21);
		Search.add(BOOK_AUTHIR);

		tf_Authir = new JTextField();
		tf_Authir.setColumns(10);
		tf_Authir.setBounds(134, 95, 173, 21);
		Search.add(tf_Authir);

		JLabel BOOK_PUB = new JLabel("\uCD9C\uD310\uC0AC");
		BOOK_PUB.setFont(new Font("휴먼고딕", Font.PLAIN, 12));
		BOOK_PUB.setBounds(34, 126, 84, 21);
		Search.add(BOOK_PUB);

		tf_Pub = new JTextField();
		tf_Pub.setColumns(10);
		tf_Pub.setBounds(134, 126, 173, 21);
		Search.add(tf_Pub);

		JLabel BOOK_PRICE = new JLabel("\uAC00\uACA9");
		BOOK_PRICE.setFont(new Font("휴먼고딕", Font.PLAIN, 12));
		BOOK_PRICE.setBounds(34, 157, 84, 21);
		Search.add(BOOK_PRICE);

		tf_Price = new JTextField();
		tf_Price.setColumns(10);
		tf_Price.setBounds(134, 157, 173, 21);
		Search.add(tf_Price);

		JLabel Rent_pos = new JLabel("\uC0C1\uD0DC");
		Rent_pos.setFont(new Font("휴먼고딕", Font.PLAIN, 12));
		Rent_pos.setBounds(33, 201, 57, 15);
		Search.add(Rent_pos);

		Rent_tf = new JTextField();
		Rent_tf.setColumns(10);
		Rent_tf.setBounds(134, 198, 173, 21);
		Search.add(Rent_tf);

		textField = new JTextField();
		textField.setText("\uB3C4\uC11C\uB0B4\uC6A9");
		textField.setColumns(10);
		textField.setBounds(31, 229, 276, 64);
		Search.add(textField);
		ta = new JTable();
		
		ta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = ta.getSelectedRow();

				Object value = ta.getValueAt(row, 1);
				System.out.println(value);
				String str1456 = String.valueOf(value);
				System.out.println(str1456);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn = DriverManager.getConnection(
							"jdbc:mysql://jdb.deu.monster:60001/java03_team03", "java03_team03", "980601eh!");
					System.out.println("DB 연결 완료");
					Statement stmt = conn.createStatement();

					String string_Oder = "select BOOK_TITLE,BOOK_ISBN,BOOK_AUTHIR,BOOK_PUB,BOOK_PRICE,BOOK_IMAGE,BOOK_PRE from BOOK_TABLE where BOOK_TITLE ="
							+ "'" + str1456 + "'";
					ResultSet rs2 = stmt.executeQuery(string_Oder);
					// Search_Filed.getText();
					while (rs2.next()) {
						tf_ISBN.setText(rs2.getString("Book_ISBN"));
						tf_Title.setText(rs2.getString("BOOK_TITLE"));
						tf_Authir.setText(rs2.getString("BOOK_AUTHIR"));
						tf_Pub.setText(rs2.getString("BOOK_PUB"));
						tf_Price.setText(rs2.getString("BOOK_PRICE"));

						if (rs2.getString("BOOK_PRE").equals("1")) {
							Rent_tf.setText("대여가능");
						
						} else {
							Rent_tf.setText("대여 불가능");
							
						}

						try {
							InputStream img = rs2.getBinaryStream("BOOK_IMAGE");
							book_img.setIcon(new ImageIcon(ImageIO.read(img)));

						} catch (Exception e3) {

						}

					}

				} catch (Exception e567) {

				}
			}
		});
		ta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ta.setShowHorizontalLines(false);
		ta.setShowGrid(false);
		ta.setShowVerticalLines(false);
		ta.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ISBN", "\uC81C\uBAA9", "\uC800\uC790", "\uCD9C\uD310\uC0AC", "\uC0C1\uD0DC" }));
		ta.setBounds(12, 81, 309, 453);
		pn1.add(ta);

		Search_Button.addActionListener(new ActionListener() {// 텍스트필드해당하는 문자열을 기반으로 DB출력되도록함.
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) ta.getModel();
				model.setNumRows(0);
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn = DriverManager.getConnection(
							"jdbc:mysql://jdb.deu.monster:60001/java03_team03", "java03_team03", "980601eh!");
					System.out.println("DB 연결 완료");
					Statement stmt = conn.createStatement();

					String string_Oder = "select BOOK_TITLE,BOOK_ISBN,BOOK_AUTHIR,BOOK_PUB,BOOK_PRICE,BOOK_IMAGE,BOOK_PRE from BOOK_TABLE where BOOK_TITLE LIKE"
							+ "'%" + Search_Filed.getText() + "%'";
					// 서치필드의 값이 책의 이름입니다. 현재 이 소스코드는 "신"검색시 신이 포함되는 모든 책제목을 가져옵니다.
					ResultSet rs2 = stmt.executeQuery(string_Oder);
					// Search_Filed.getText();
					while (rs2.next()) {

						String[] rows = new String[5];// isbn 제목 저자 출판사 
						rows[0] = rs2.getString("BOOK_ISBN");
						rows[1] = rs2.getString("BOOK_TITLE");
						rows[2] = rs2.getString("BOOK_AUTHIR");
						rows[3] = rs2.getString("BOOK_PUB");
						if(rs2.getString("BOOK_PRE").equals("1")) {
							rows[4]="대여o";
						}
						else {
							rows[4]="대여x";
						}
						
						

						model.addRow(rows);
					}

				} catch (ClassNotFoundException e1) {
					System.out.println("DB 문제1");

				} catch (SQLException e2) {
					System.out.println("DB 문제2");
				}

			}
		});

		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.WHITE);
		tabbedPane.addTab("\uB300\uCD9C", null, pn2, null);
		pn2.setLayout(null);

		JPanel RENT_2_1 = new JPanel();
		RENT_2_1.setLayout(null);
		RENT_2_1.setBackground(Color.WHITE);
		RENT_2_1.setBounds(12, 10, 392, 390);
		pn2.add(RENT_2_1);

		JLabel Rent2LabelIsbn_1 = new JLabel("ISBN");
		Rent2LabelIsbn_1.setBounds(12, 10, 57, 15);
		RENT_2_1.add(Rent2LabelIsbn_1);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(91, 7, 116, 21);
		RENT_2_1.add(textField_7);

		JLabel Rent2LabelTitle_1 = new JLabel("\uC81C\uBAA9");
		Rent2LabelTitle_1.setBounds(12, 63, 57, 15);
		RENT_2_1.add(Rent2LabelTitle_1);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(91, 60, 116, 21);
		RENT_2_1.add(textField_8);

		JLabel Rent2LabelAuthir_1 = new JLabel("\uC800\uC790");
		Rent2LabelAuthir_1.setBounds(12, 88, 57, 15);
		RENT_2_1.add(Rent2LabelAuthir_1);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(91, 85, 116, 21);
		RENT_2_1.add(textField_9);

		JLabel Rent2LabelPub_1 = new JLabel("\uCD9C\uD310\uC0AC");
		Rent2LabelPub_1.setBounds(12, 113, 57, 15);
		RENT_2_1.add(Rent2LabelPub_1);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(91, 110, 116, 21);
		RENT_2_1.add(textField_10);

		JLabel Rent2LabelPrice_1 = new JLabel("\uAC00\uACA9");
		Rent2LabelPrice_1.setBounds(12, 138, 57, 15);
		RENT_2_1.add(Rent2LabelPrice_1);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(91, 135, 116, 21);
		RENT_2_1.add(textField_11);

		JLabel RentLabelUserPhone_1 = new JLabel("\uC5F0\uB77D\uCC98");
		RentLabelUserPhone_1.setBounds(12, 186, 57, 15);
		RENT_2_1.add(RentLabelUserPhone_1);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(91, 183, 116, 21);
		RENT_2_1.add(textField_12);

		JButton returnConfirmationButton_1 = new JButton("\uD655\uC778");
		returnConfirmationButton_1.setBackground(SystemColor.activeCaption);
		returnConfirmationButton_1.setBounds(283, 6, 97, 23);
		RENT_2_1.add(returnConfirmationButton_1);

		JButton returnCompleteButton_1 = new JButton("\uB300\uC5EC\uC644\uB8CC");
		returnCompleteButton_1.setBackground(SystemColor.activeCaption);
		returnCompleteButton_1.setBounds(283, 328, 97, 23);
		RENT_2_1.add(returnCompleteButton_1);

		JLabel img_1 = new JLabel("");
		img_1.setBackground(Color.GRAY);
		img_1.setBounds(219, 47, 161, 186);
		RENT_2_1.add(img_1);

		JLabel cnt_1 = new JLabel("");
		cnt_1.setBounds(301, 332, 57, 15);
		RENT_2_1.add(cnt_1);

		JPanel pn3 = new JPanel();
		pn3.setBackground(Color.WHITE);
		tabbedPane.addTab("\uBC18\uB0A9", null, pn3, null);
		pn3.setLayout(null);

		JPanel RENT_2 = new JPanel();
		RENT_2.setLayout(null);
		RENT_2.setBackground(Color.WHITE);
		RENT_2.setBounds(12, 10, 392, 390);
		pn3.add(RENT_2);

		JLabel Rent2LabelIsbn = new JLabel("ISBN");
		Rent2LabelIsbn.setBounds(12, 10, 57, 15);
		RENT_2.add(Rent2LabelIsbn);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 7, 116, 21);
		RENT_2.add(textField_1);

		JLabel Rent2LabelTitle = new JLabel("\uC81C\uBAA9");
		Rent2LabelTitle.setBounds(12, 63, 57, 15);
		RENT_2.add(Rent2LabelTitle);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(91, 60, 116, 21);
		RENT_2.add(textField_2);

		JLabel Rent2LabelAuthir = new JLabel("\uC800\uC790");
		Rent2LabelAuthir.setBounds(12, 88, 57, 15);
		RENT_2.add(Rent2LabelAuthir);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(91, 85, 116, 21);
		RENT_2.add(textField_3);

		JLabel Rent2LabelPub = new JLabel("\uCD9C\uD310\uC0AC");
		Rent2LabelPub.setBounds(12, 113, 57, 15);
		RENT_2.add(Rent2LabelPub);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(91, 110, 116, 21);
		RENT_2.add(textField_4);

		JLabel Rent2LabelPrice = new JLabel("\uAC00\uACA9");
		Rent2LabelPrice.setBounds(12, 138, 57, 15);
		RENT_2.add(Rent2LabelPrice);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(91, 135, 116, 21);
		RENT_2.add(textField_5);

		JLabel Rent2LabelName = new JLabel("\uBC18\uB0A9\uC790");
		Rent2LabelName.setBounds(12, 184, 57, 15);
		RENT_2.add(Rent2LabelName);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(91, 181, 116, 21);
		RENT_2.add(textField_6);

		JLabel RentLabelUserPhone = new JLabel("\uC5F0\uB77D\uCC98");
		RentLabelUserPhone.setBounds(12, 209, 57, 15);
		RENT_2.add(RentLabelUserPhone);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(91, 206, 116, 21);
		RENT_2.add(textField_13);

		JLabel Rent2LabelEmail = new JLabel("\uC774\uBA54\uC77C");
		Rent2LabelEmail.setBounds(12, 234, 57, 15);
		RENT_2.add(Rent2LabelEmail);

		JLabel img = new JLabel("");
		img.setBackground(Color.DARK_GRAY);
		img.setBounds(230, 59, 150, 199);
		RENT_2.add(img);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(91, 231, 116, 21);
		RENT_2.add(textField_14);

		JButton returnConfirmationButton = new JButton("\uD655\uC778");
		returnConfirmationButton.setBackground(SystemColor.activeCaption);
		returnConfirmationButton.setBounds(283, 6, 97, 23);
		RENT_2.add(returnConfirmationButton);

		JButton returnCompleteButton = new JButton("\uBC18\uB0A9\uC644\uB8CC");
		returnCompleteButton.setBackground(SystemColor.activeCaption);
		returnCompleteButton.setBounds(283, 357, 97, 23);
		RENT_2.add(returnCompleteButton);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(230, 63, 150, 186);
		RENT_2.add(textField_15);

		JPanel pn4 = new JPanel();
		pn4.setBackground(Color.WHITE);
		tabbedPane.addTab("\uD68C\uC6D0\uAD00\uB9AC", null, pn4, null);
		pn4.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(12, 10, 575, 457);
		pn4.add(panel_5);

		JLabel labelName = new JLabel("\uC774\uB984");
		labelName.setBounds(16, 10, 41, 15);
		panel_5.add(labelName);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(78, 7, 116, 21);
		panel_5.add(textField_16);

		JLabel labelBirth = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		labelBirth.setBounds(16, 34, 57, 15);
		panel_5.add(labelBirth);

		JLabel labelPhoneNumber = new JLabel("\uC5F0\uB77D\uCC98");
		labelPhoneNumber.setBounds(16, 59, 41, 15);
		panel_5.add(labelPhoneNumber);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(78, 31, 116, 21);
		panel_5.add(textField_17);

		JLabel labelMail = new JLabel("\uC774\uBA54\uC77C");
		labelMail.setBounds(16, 84, 57, 23);
		panel_5.add(labelMail);

		textField_18 = new JTextField();
		textField_18.setColumns(20);
		textField_18.setBounds(78, 87, 217, 21);
		panel_5.add(textField_18);

		JLabel img_2 = new JLabel("");
		img_2.setForeground(Color.BLACK);
		img_2.setBackground(SystemColor.activeCaption);
		img_2.setBounds(354, 10, 166, 200);
		panel_5.add(img_2);

		JButton im = new JButton("\uD68C\uC6D0\uB4F1\uB85D");
		im.setBackground(SystemColor.activeCaption);
		im.setBounds(12, 133, 97, 23);
		panel_5.add(im);

		JButton dm = new JButton("\uD68C\uC6D0\uC0AD\uC81C");
		dm.setBackground(SystemColor.activeCaption);
		dm.setBounds(12, 166, 97, 23);
		panel_5.add(dm);

		textField_19 = new JTextField();
		textField_19.setColumns(20);
		textField_19.setBounds(78, 56, 217, 21);
		panel_5.add(textField_19);

		JButton memberSearchButton = new JButton("\uD68C\uC6D0\uAC80\uC0C9");
		memberSearchButton.setBackground(SystemColor.activeCaption);
		memberSearchButton.setBounds(206, 6, 97, 23);
		panel_5.add(memberSearchButton);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(16, 108, 57, 15);
		panel_5.add(lblNewLabel_6);

		JButton membershipListButton = new JButton("\uD68C\uC6D0\uBAA9\uB85D\uBCF4\uAE30");
		membershipListButton.setBackground(SystemColor.activeCaption);
		membershipListButton.setBounds(12, 268, 154, 23);
		panel_5.add(membershipListButton);

		JButton btnNewButton = new JButton("\uC0AC\uC9C4\uB4F1\uB85D");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(392, 220, 97, 23);
		panel_5.add(btnNewButton);

		JPanel pn5 = new JPanel();
		pn5.setBackground(Color.WHITE);
		tabbedPane.addTab("\uB3C4\uC11C\uAD00\uB9AC", null, pn5, null);
		pn5.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 10, 706, 534);
		pn5.add(panel);

		JLabel lblNewLabel_2 = new JLabel("ISBN");
		lblNewLabel_2.setBounds(12, 10, 57, 15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("\uC81C\uBAA9");
		lblNewLabel_1_1.setBounds(12, 35, 57, 15);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("\uC800\uC790");
		lblNewLabel_2_1.setBounds(12, 62, 57, 15);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3 = new JLabel("\uAC00\uACA9");
		lblNewLabel_3.setBounds(12, 112, 57, 15);
		panel.add(lblNewLabel_3);

		JButton IN_Button = new JButton("\uB4F1\uB85D");
		IN_Button.setBackground(SystemColor.activeCaption);
		IN_Button.setBounds(12, 174, 97, 23);
		panel.add(IN_Button);

		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(81, 7, 116, 21);
		panel.add(textField_20);

		JLabel man = new JLabel("");
		man.setBounds(330, 10, 154, 178);
		panel.add(man);

		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(81, 32, 116, 21);
		panel.add(textField_21);

		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(81, 59, 116, 21);
		panel.add(textField_22);

		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(81, 109, 116, 21);
		panel.add(textField_23);

		JButton Upload_Button = new JButton("\uC0AC\uC9C4 \uB4F1\uB85D");
		Upload_Button.setBackground(SystemColor.activeCaption);
		Upload_Button.setBounds(358, 207, 97, 23);
		panel.add(Upload_Button);

		JButton btnNewButton_6 = new JButton("\uC911\uBCF5\uCCB4\uD06C");
		btnNewButton_6.setBackground(SystemColor.activeCaption);
		btnNewButton_6.setBounds(197, 6, 97, 23);
		panel.add(btnNewButton_6);

		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(81, 84, 116, 21);
		panel.add(textField_24);

		JLabel lblNewLabel_3_1 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_3_1.setBounds(12, 87, 57, 15);
		panel.add(lblNewLabel_3_1);

		JButton membershipListButton_1 = new JButton("\uB3C4\uC11C\uD604\uD669\uBCF4\uAE30");
		membershipListButton_1.setBackground(SystemColor.activeCaption);
		membershipListButton_1.setBounds(12, 217, 154, 23);
		panel.add(membershipListButton_1);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
