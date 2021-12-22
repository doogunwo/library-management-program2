package TP;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import comm.dbConnector;
import Status.Book_Status;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import comm.dbConnector;

import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.SystemColor;

public class book_form extends JFrame {

	private JPanel contentPane;
	private JTextField ISBN_TF;
	private JTextField title_TF;
	private JTextField Autior_TF;
	private JTextField Price_TF;
	private JTextField Pub_TF;
	dbConnector dbConn = new dbConnector();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					book_form frame = new book_form();
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
	String filePath;

	public book_form() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 726, 628);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 31, 706, 534);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("ISBN");
		lblNewLabel.setBounds(12, 10, 57, 15);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC81C\uBAA9");
		lblNewLabel_1.setBounds(12, 35, 57, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("\uC800\uC790");
		lblNewLabel_2.setBounds(12, 62, 57, 15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uAC00\uACA9");
		lblNewLabel_3.setBounds(12, 112, 57, 15);
		panel.add(lblNewLabel_3);

		JButton IN_Button = new JButton("\uB4F1\uB85D");
		IN_Button.setBackground(SystemColor.activeCaption);
		IN_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sql = "insert into BOOK_TABLE(BOOK_ISBN, BOOK_TITLE, BOOK_AUTHIR, BOOK_PUB,BOOK_PRICE,BOOK_IMAGE,BOOK_PRE) values(?,?,?,?,?,?,?)";
				Connection tmpConn = dbConn.getConnection();
				try {
					PreparedStatement ps = tmpConn.prepareStatement(sql);

					ps.setString(1, ISBN_TF.getText());
					ps.setString(2, title_TF.getText());
					ps.setString(3, Autior_TF.getText());
					ps.setString(4, Pub_TF.getText());
					ps.setString(5, Price_TF.getText());

					File tmpFile = new File(filePath);

					ps.setBinaryStream(6, new FileInputStream(tmpFile), tmpFile.length());
					ps.setString(7, "1");
					int count = ps.executeUpdate();

					if (count == 0) {
						JOptionPane.showMessageDialog(null, "도서 : " + title_TF.getText() + "이(는) 등록에 실패하였습니다.",
								"신규도서등록", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "도서 : " + title_TF.getText() + "이(는) 등록이 완료되었습니다.",
								"신규도서등록", JOptionPane.NO_OPTION);
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ISBN_TF.setText("");
				title_TF.setText("");
				Autior_TF.setText("");
				Pub_TF.setText("");
				Price_TF.setText("");

			}
		}

		);
		IN_Button.setBounds(12, 174, 97, 23);
		panel.add(IN_Button);

		ISBN_TF = new JTextField();
		ISBN_TF.setBounds(81, 7, 116, 21);
		panel.add(ISBN_TF);
		ISBN_TF.setColumns(10);

		JLabel man = new JLabel("");
		man.setBounds(330, 10, 154, 178);
		panel.add(man);

		title_TF = new JTextField();
		title_TF.setBounds(81, 32, 116, 21);
		panel.add(title_TF);
		title_TF.setColumns(10);

		Autior_TF = new JTextField();
		Autior_TF.setBounds(81, 59, 116, 21);
		panel.add(Autior_TF);
		Autior_TF.setColumns(10);

		Price_TF = new JTextField();
		Price_TF.setBounds(81, 109, 116, 21);
		panel.add(Price_TF);
		Price_TF.setColumns(10);

		JFileChooser memberImg = new JFileChooser();
		JButton Upload_Button = new JButton("\uC0AC\uC9C4 \uB4F1\uB85D");
		Upload_Button.setBackground(SystemColor.activeCaption);

		Upload_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int ret = memberImg.showOpenDialog(null);
				filePath = memberImg.getSelectedFile().getPath();
				JOptionPane.showMessageDialog(null, filePath, "당신이 선택된 파일은", JOptionPane.NO_OPTION);
				ImageIcon icon = new ImageIcon(filePath);
				man.setIcon(icon);

			}
		});
		Upload_Button.setBounds(358, 207, 97, 23);
		panel.add(Upload_Button);

		JButton btnNewButton_6 = new JButton("\uC911\uBCF5\uCCB4\uD06C");
		btnNewButton_6.setBackground(SystemColor.activeCaption);

		btnNewButton_6.addActionListener(new ActionListener() {// ISBN 중복체크 버튼
			public void actionPerformed(ActionEvent e) {
				try {
					int cnt = 0;
					Connection conn; // java.sql.Connection
					Statement stmt = null;
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://jdb.deu.monster:60001/java03_team03",
							"java03_team03", "980601eh!");

					stmt = conn.createStatement();

					String string_Oder = "select BOOK_ISBN from BOOK_TABLE";

					ResultSet rs2 = stmt.executeQuery(string_Oder);
					while (rs2.next()) {
						if (ISBN_TF.getText().equals(rs2.getString("BOOK_ISBN"))) {
							JOptionPane.showMessageDialog(null, "중복되는 도서가 있습니다.", "Message", JOptionPane.ERROR_MESSAGE);
							ISBN_TF.setText("");
							cnt++;
							break;
						}

					}

					if (cnt == 0) {
						JOptionPane.showMessageDialog(null, "도서등록이 가능합니다.", "Message", JOptionPane.ERROR_MESSAGE);
					}
				} catch (ClassNotFoundException e1) {
					System.out.println("JDBC 드라이버 로드 에러");
				} catch (SQLException e2) {
					System.out.println("DB 연결 오류");
				}

			}
		});

		btnNewButton_6.setBounds(197, 6, 97, 23);
		panel.add(btnNewButton_6);

		Pub_TF = new JTextField();
		Pub_TF.setColumns(10);
		Pub_TF.setBounds(81, 84, 116, 21);
		panel.add(Pub_TF);

		JLabel lblNewLabel_3_1 = new JLabel("\uCD9C\uD310\uC0AC");
		lblNewLabel_3_1.setBounds(12, 87, 57, 15);
		panel.add(lblNewLabel_3_1);

		JButton membershipListButton = new JButton("\uB3C4\uC11C\uD604\uD669\uBCF4\uAE30");
		membershipListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Book_Status bs= new Book_Status();
				bs.setVisible(true);
			}
		});
		membershipListButton.setBackground(SystemColor.activeCaption);
		membershipListButton.setBounds(12, 217, 154, 23);
		panel.add(membershipListButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(718, 31, 338, 750);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1, 1);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 0, 97, 23);
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(513, 0, 97, 23);
		panel_2.add(btnNewButton_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(0, 0, 1057, 32);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton_2 = new JButton("\uB3C4\uC11C\uAD00\uB9AC");
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(0, 10, 97, 23);
		panel_3.add(btnNewButton_2);
	}
}
