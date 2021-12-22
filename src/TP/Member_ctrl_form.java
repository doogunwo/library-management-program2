package TP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JInternalFrame;
import javax.swing.SpringLayout;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import java.awt.TextField;
import java.awt.CardLayout;
import javax.swing.JSeparator;
import net.miginfocom.swing.MigLayout;
import java.awt.Panel;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDesktopPane;
import java.awt.Label;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Component;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Connection;
import comm.dbConnector;
import Status.Member_Status;

public class Member_ctrl_form extends JFrame {
	private JPanel contentPane;
	private JTextField un;
	private JTextField ub;
	private JTextField ph;
	private JTextField us;
	private final Action action = new SwingAction();

	private String filePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member_ctrl_form frame = new Member_ctrl_form();
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
	public Member_ctrl_form() {
		JButton im = new JButton("회원등록"); // 회원등록
		im.setBackground(SystemColor.activeCaption);
		im.setBounds(12, 133, 97, 23);

		// ArrayList<Image> tmpImg = new ArrayList<>(); // 이미지 저장
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 591, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(5, 5, 1603, 23);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton selectMemberManagementButton = new JButton("회원관리"); // 회원관리
		selectMemberManagementButton.setBounds(0, 0, 97, 23);
		panel.add(selectMemberManagementButton);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 28, 575, 457);
		contentPane.add(panel_5);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setLayout(null);

		JLabel labelName = new JLabel("이름");
		labelName.setBounds(16, 10, 41, 15);
		panel_5.add(labelName);

		// 회원 이름을 입력할 텍스트 필드
		un = new JTextField();
		un.setBounds(78, 7, 116, 21);
		panel_5.add(un);
		un.setColumns(10);

		JLabel labelBirth = new JLabel("생년월일");
		labelBirth.setBounds(16, 34, 57, 15);
		panel_5.add(labelBirth);

		// 회원의 생년월일을 입력할 텍스트 필드

		JLabel labelPhoneNumber = new JLabel("연락처");
		labelPhoneNumber.setBounds(16, 59, 41, 15);
		panel_5.add(labelPhoneNumber);

		// 회원의 휴대전화를 입력할 텍스트 필드
		ub = new JTextField();
		ub.setBounds(78, 31, 116, 21);
		panel_5.add(ub);
		ub.setColumns(10);

		JLabel labelMail = new JLabel("이메일");
		labelMail.setBounds(16, 84, 57, 23);
		panel_5.add(labelMail);

		// 회원의 이메일를 입력할 텍스트 필드
		us = new JTextField();
		us.setBounds(78, 87, 217, 21);
		panel_5.add(us);
		us.setColumns(20);

		JLabel img = new JLabel("");
		img.setForeground(Color.BLACK);
		img.setBackground(SystemColor.activeCaption);
		img.setBounds(354, 10, 166, 200);
		panel_5.add(img);
		panel_5.add(im);
		JButton dm = new JButton("회원삭제"); // 회원 삭제
		dm.setBackground(SystemColor.activeCaption);
		dm.setBounds(12, 166, 97, 23);
		panel_5.add(dm);
		// 회원 이미지
		JFileChooser memberImg = new JFileChooser();
		FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("All Images", "jpg", "jpge", "png", "gif",
				"svg");
		memberImg.setFileFilter(fileFilter);
		ph = new JTextField();
		ph.setBounds(78, 56, 217, 21);
		panel_5.add(ph);
		ph.setColumns(20);
		// 이름을 입력하고 "회원검색" 버튼을 누르면 생년월일,연락처,이메일을 각각 USER_BIRTH, USER_PHONE_NUMBER,
		// USER_MAIL에 출력
		JButton memberSearchButton = new JButton("회원검색"); // 회원 검색
		memberSearchButton.setBackground(SystemColor.activeCaption);
		memberSearchButton.setBounds(206, 6, 97, 23);
		panel_5.add(memberSearchButton);
		memberSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dbConnector dbConn = new dbConnector();
				String str = "select USER_BIRTH,USER_MAIL,USER_PHONE_NUMBER,USER_IMAGE FROM USER_TABLE WHERE USER_NAME = "
						+ "'" + un.getText() + "'" + ";";
				try {
					ResultSet src = dbConn.executeQurey(str);
					while (src.next()) {
						ub.setText(src.getString("USER_BIRTH"));
						ph.setText(src.getString("USER_PHONE_NUMBER"));

						us.setText(src.getString("USER_MAIL"));
						try {
							InputStream img2 = src.getBinaryStream("USER_IMAGE");
							img.setIcon(new ImageIcon(ImageIO.read(img2)));

						} catch (Exception e3) {

						}
					}

				} catch (SQLException e2) {

				}
				if (ph.getText().equals("")) {
					im.setVisible(true);
					dm.setVisible(false);
					JOptionPane.showMessageDialog(null, "회원이 아닙니다. '등록'이 가능합니다.", "Message", JOptionPane.ERROR_MESSAGE);
				} else {
					im.setVisible(false);
					dm.setVisible(true);
					JOptionPane.showMessageDialog(null, "회원입니다. '삭제'가 가능합니다.", "Message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// 텍스트 필드에 값을 입력하고 "회윈등록" 버튼을 누르면 이름, 생년월일, 연락처, 이메일, 등록일을 USER_TABLE에 데이터를 삽입

		im.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnector dbConn = new dbConnector();
				String sql = "insert into USER_TABLE(USER_PHONE_NUMBER,USER_NAME,USER_BIRTH,USER_MAIL,USER_IMAGE,USER_BOOL,USER_RENT_CNT) values(?,?,?,?,?,?,?)";
				Connection tmpConn = dbConn.getConnection();
				try {
					PreparedStatement ps = tmpConn.prepareStatement(sql);

					ps.setString(1, ph.getText());
					ps.setString(2, un.getText());
					ps.setString(3, ub.getText());
					ps.setString(4, us.getText());
					File tmpFile = new File(filePath);

					ps.setBinaryStream(5, new FileInputStream(tmpFile), tmpFile.length());

					ps.setString(6, "1");					
					ps.setString(7, "0");
					int count = ps.executeUpdate();

					if (count == 0) {
						JOptionPane.showMessageDialog(null, "등록 : " + un.getText() + "이(는) 등록에 실패하였습니다.",
								"신규회원등록", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "등록 : " + un.getText() + "이(는) 등록이 완료되었습니다.",
								"신규회원등록", JOptionPane.NO_OPTION);
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// 테이블의 행을 어떻게 추적해서 수정할건지 모르겠음

		dm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "USER_BOOL의 값을 0(false)로 변환", "Message",
				// JOptionPane.ERROR_MESSAGE);
				dbConnector dbConn = new dbConnector();

			}
		});

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(16, 108, 57, 15);
		panel_5.add(lblNewLabel_6);

		// "회원목록보기" 버튼을 누를시 USER_TABLE의 값을 모두 가져와 JTABLE에 출력
		JButton membershipListButton = new JButton("\uD68C\uC6D0\uBAA9\uB85D\uBCF4\uAE30");
		membershipListButton.setBackground(SystemColor.activeCaption);
		membershipListButton.setBounds(12, 268, 154, 23);
		panel_5.add(membershipListButton);
		membershipListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "태이블표를 새로 고침함", "Message",
				// JOptionPane.ERROR_MESSAGE);
				Member_Status ms = new Member_Status();
				ms.setVisible(true);
			}

		});

		// 사진 등록 버튼
		JButton btnNewButton = new JButton("\uC0AC\uC9C4\uB4F1\uB85D");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(392, 220, 97, 23);
		panel_5.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = memberImg.showOpenDialog(null);
				filePath = memberImg.getSelectedFile().getPath();
				JOptionPane.showMessageDialog(null, filePath, "당신이 선택된 파일은", JOptionPane.NO_OPTION);
				ImageIcon icon = new ImageIcon(filePath);
				img.setIcon(icon);
			}
		});

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}
}
