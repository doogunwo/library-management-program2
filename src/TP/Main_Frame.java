package TP;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTree;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class Main_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField Search_Filed;

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
	public Main_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 953, 723);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("TextArea.border"));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 126, 913, 558);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Search_Filed = new JTextField();
		Search_Filed.setBackground(SystemColor.activeCaption);
		Search_Filed.setBounds(0, 10, 521, 30);
		panel_1.add(Search_Filed);
		Search_Filed.setColumns(10);
		
		JButton Search_Button = new JButton("Q");
		Search_Button.setFont(new Font("±¼¸²", Font.BOLD, 20));
		Search_Button.setBackground(SystemColor.activeCaption);
		Search_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Search_Button.setBounds(518, 10, 78, 30);
		panel_1.add(Search_Button);
		
		JPanel Seach_List = new JPanel();
		Seach_List.setBounds(0, 50, 596, 443);
		panel_1.add(Seach_List);
		Seach_List.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaption);
		panel_3.setBounds(0, 503, 908, 30);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel System_Log = new JPanel();
		System_Log.setBounds(608, 50, 300, 443);
		panel_1.add(System_Log);
		System_Log.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\uC2DC\uC2A4\uD15C\uB85C\uADF8");
		lblNewLabel_1.setBounds(12, 10, 113, 15);
		System_Log.add(lblNewLabel_1);
		
		JPanel Timer = new JPanel();
		Timer.setBounds(608, 10, 300, 36);
		panel_1.add(Timer);
		Timer.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\uC2DC\uACC4");
		lblNewLabel_4.setBounds(61, 0, 57, 15);
		Timer.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(12, 100, 913, 24);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		menuBar.setBounds(0, 0, 97, 23);
		panel.add(menuBar);
		
		JMenu Service = new JMenu("\uB3C4\uC11C\uAD00 \uC11C\uBE44\uC2A4");
		menuBar.add(Service);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\uB300\uC5EC/\uBC18\uB0A9");
		Service.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\uB3C4\uC11C\uAD00\uB9AC");
		Service.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\uD68C\uC6D0\uAD00\uB9AC");
		Service.add(mntmNewMenuItem_4);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(12, 10, 161, 34);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uB3D9\uC758 \uB3C4\uC11C\uAD00");
		lblNewLabel.setBounds(0, 0, 160, 30);
		panel_9.add(lblNewLabel);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 30));
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
