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
	private JTextField USER_NAME;
	private JTextField USER_BIRTH;
	private JTextField USER_PHONE_NUMBER;
	private JTextField USER_MAIL;
	private final Action action = new SwingAction();
	dbConnector dbConn = new dbConnector();
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
		USER_NAME = new JTextField();
		USER_NAME.setBounds(78, 7, 116, 21);
		panel_5.add(USER_NAME);
		USER_NAME.setColumns(10);

		JLabel labelBirth = new JLabel("생년월일");
		labelBirth.setBounds(16, 34, 57, 15);
		panel_5.add(labelBirth);

		// 회원의 생년월일을 입력할 텍스트 필드
		USER_PHONE_NUMBER = new JTextField();
		USER_PHONE_NUMBER.setBounds(78, 56, 217, 21);
		panel_5.add(USER_PHONE_NUMBER);
		USER_PHONE_NUMBER.setColumns(20);

		JLabel labelPhoneNumber = new JLabel("연락처");
		labelPhoneNumber.setBounds(16, 59, 41, 15);
		panel_5.add(labelPhoneNumber);

		// 회원의 휴대전화를 입력할 텍스트 필드
		USER_BIRTH = new JTextField();
		USER_BIRTH.setBounds(78, 31, 116, 21);
		panel_5.add(USER_BIRTH);
		USER_BIRTH.setColumns(10);

		JLabel labelMail = new JLabel("이메일");
		labelMail.setBounds(16, 84, 57, 23);
		panel_5.add(labelMail);

		// 회원의 이메일를 입력할 텍스트 필드
		USER_MAIL = new JTextField();
		USER_MAIL.setBounds(78, 87, 217, 21);
		panel_5.add(USER_MAIL);
		USER_MAIL.setColumns(20);

		// 회원 이미지
		JFileChooser memberImg = new JFileChooser();
		FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("All Images", "jpg", "jpge", "png", "gif",
				"svg");
		memberImg.setFileFilter(fileFilter);

		// 이름을 입력하고 "회원검색" 버튼을 누르면 생년월일,연락처,이메일을 각각 USER_BIRTH, USER_PHONE_NUMBER,
		// USER_MAIL에 출력
		JButton memberSearchButton = new JButton("회원검색"); // 회원 검색
		memberSearchButton.setBackground(SystemColor.activeCaption);
		memberSearchButton.setBounds(12, 235, 97, 23);
		panel_5.add(memberSearchButton);
		memberSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null,"이름을 입력하고 버튼을 누르면 생년/연락/이메일 각각의 텍스트필드에 정보가
				// 나옴","Message",JOptionPane.ERROR_MESSAGE);
				if (USER_NAME.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요", "Message", JOptionPane.ERROR_MESSAGE);
				} else {
					String sql = "select USER_PHONE_NUMBER, USER_BIRTH, USER_MAIL FROM USER_TABLE WHERE USER_NAME = ";
					String str = sql + "'" + USER_NAME.getText() + "'" + ";";
					try {
						ResultSet src = dbConn.executeQurey(str);
						while (src.next()) {
							USER_PHONE_NUMBER.setText(src.getString(1));
							USER_BIRTH.setText(src.getString(2));
							USER_MAIL.setText(src.getString(3));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		// 텍스트 필드에 값을 입력하고 "회윈등록" 버튼을 누르면 이름, 생년월일, 연락처, 이메일, 등록일을 USER_TABLE에 데이터를 삽입
		JButton membershipRegistrationButton = new JButton("회원등록"); // 회원등록
		membershipRegistrationButton.setBackground(SystemColor.activeCaption);
		membershipRegistrationButton.setBounds(12, 133, 97, 23);
		panel_5.add(membershipRegistrationButton);
		membershipRegistrationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null,"이름/생년/연락/이메일을 입력하고 버튼을 누르면 등록일을 포함하여
				// USER_TABLE에 데이터를 삽입","Message",JOptionPane.ERROR_MESSAGE);
				String sql = "insert into USER_TABLE(USER_PHONE_NUMBER, USER_NAME, USER_BIRTH, USER_MAIL,USER_IMAGE) values(?,?,?,?,?)";
				Connection tmpConn = dbConn.getConnection();
				try {
					PreparedStatement ps = tmpConn.prepareStatement(sql);

					ps.setString(1, USER_PHONE_NUMBER.getText());
					ps.setString(2, USER_NAME.getText());
					ps.setString(3, USER_BIRTH.getText());
					ps.setString(4, USER_MAIL.getText());

					File tmpFile = new File(filePath);

					ps.setBinaryStream(5, new FileInputStream(tmpFile), tmpFile.length());

					int count = ps.executeUpdate();

					if (count == 0) {
						JOptionPane.showMessageDialog(null, "회원 : " + USER_NAME.getText() + "이(는) 등록에 실패하였습니다.",
								"신규회원등록", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "회원 : " + USER_NAME.getText() + "이(는) 등록이 완료되었습니다.",
								"신규회원등록", JOptionPane.NO_OPTION);
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				USER_PHONE_NUMBER.setText("");
				USER_NAME.setText("");
				USER_BIRTH.setText("");
				USER_MAIL.setText("");
			}
		});

		// 수정할 필드의 행을 어떻게 추적할지 모르겠음
		JButton membershipModificationButton = new JButton("회원수정"); // 회원 수정
		membershipModificationButton.setBackground(SystemColor.activeCaption);
		membershipModificationButton.setBounds(12, 169, 97, 23);
		panel_5.add(membershipModificationButton);
		membershipModificationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "모든 테이블 필드에 값이 있을때 수정할 값을 수성하고 버튼을 클릭하면
				// 수정된 값으로 DB에 저장", "Message",JOptionPane.ERROR_MESSAGE);
				if (USER_NAME.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요!", "Message", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						String resultSetSql = "select USER_BOOL from USER_TABLE WHERE USER_NAME = " + "'"
								+ USER_NAME.getText() + "' ;";
						ResultSet resultSetSrc = dbConn.executeQurey(resultSetSql);
						while (resultSetSrc.next()) {
							if (resultSetSrc.getInt(1) == 1) {
								if (!USER_PHONE_NUMBER.getText().equals("")) {
									String str = "update USER_TABLE SET USER_PHONE_NUMBER = '"
											+ USER_PHONE_NUMBER.getText() + "' WHERE USER_NAME = " + "'"
											+ USER_NAME.getText() + "' ;";
									// System.out.println(str);
									int src = dbConn.executeUpdate(str);
								}
								if (!USER_BIRTH.getText().equals("")) {
									String str = "update USER_TABLE SET USER_BIRTH = '" + USER_BIRTH.getText()
											+ "' WHERE USER_NAME = " + "'" + USER_NAME.getText() + "' ;";
									// System.out.println(str);
									int src = dbConn.executeUpdate(str);
								}
								if (!USER_MAIL.getText().equals("")) {
									String str = "update USER_TABLE SET USER_MAIL = '" + USER_MAIL.getText()
											+ "' WHERE USER_NAME = " + "'" + USER_NAME.getText() + "';";
									// System.out.println(str);
									int src = dbConn.executeUpdate(str);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, USER_NAME.getText()+"는 회원이 아닙니다.", "Message",JOptionPane.ERROR_MESSAGE);
								break;
							}
						}

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				USER_NAME.setText("");
				USER_PHONE_NUMBER.setText("");
				USER_BIRTH.setText("");
				USER_MAIL.setText("");
			}
		});

		// 테이블의 행을 어떻게 추적해서 수정할건지 모르겠음
		JButton deleteMembershipButton = new JButton("회원삭제"); // 회원 삭제
		deleteMembershipButton.setBackground(SystemColor.activeCaption);
		deleteMembershipButton.setBounds(12, 202, 97, 23);
		panel_5.add(deleteMembershipButton);
		deleteMembershipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null, "USER_BOOL의 값을 0(false)로 변환", "Message",
				// JOptionPane.ERROR_MESSAGE);
				if (USER_NAME.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "이름을 입력하세요!", "Message", JOptionPane.ERROR_MESSAGE);
				} else {
					String str = "update USER_TABLE SET USER_BOOL = 0 " + " WHERE USER_RENT_CNT = 0 AND USER_NAME = " + "'"
		                     + USER_NAME.getText() + "';";
					int src = dbConn.executeUpdate(str);
				}
			}
		});

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(16, 108, 57, 15);
		panel_5.add(lblNewLabel_6);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setBounds(354, 10, 166, 200);
		panel_5.add(lblNewLabel);

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
				lblNewLabel.setIcon(icon);
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
