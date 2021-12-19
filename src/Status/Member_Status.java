package Status;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

import comm.dbConnector;

public class Member_Status extends JFrame {
	dbConnector dbConn = new dbConnector();

	public Member_Status() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		// JTable ���� -NORTH
		JTable table;
		DefaultTableModel tableModel;

		Object[][] data = new Object[0][8]; // �ϴ� �� row �� ����, �̶� �ι�° �ε��� �� 9�� 9���� ���� �����Ѵٴ� ������ ����
		String[] columnNames = { "�޴���ȭ", "�̸�", "�������", "����", "�̹���", "���Գ�¥", "���Կ���", "�뿩�Ǽ�" };

		tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);
		// �̹��� ����Ʈ
		ArrayList<Image> tmpImg = new ArrayList<>();
		try {
			ResultSet src = dbConn.executeQurey("select * from USER_TABLE;");
			while (src.next()) {

				// SQL���� BOOK_PRE �ʵ� ������� ���� �´� ���ڿ� ���� - 1:����, 2:�̺���
				String liveState;

				if (src.getInt(7) == 1) {
					liveState = "����";
				} else {
					liveState = "�̰���";
				}

				// ResultSet���� ��� Index 1������ ����

				Object[] tmp = {src.getString(1), src.getString(2), src.getString(3), src.getString(4), "Click",
						src.getString(6), liveState, src.getInt(8)};
				tableModel.addRow(tmp);

				// DB���� BLOB �ڷ������� ����� ������ �׸� �����ͷ� ��ȯ
				InputStream inputStream = src.getBinaryStream(5);
				try {

					tmpImg.add(ImageIO.read(inputStream));

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// jtable���� � row�� Ŭ���� ��� ���Ǵ� �̺�Ʈ
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// �̺�Ʈ ó���� ���� table ���� ���� ���� �ޱ�
				JTable sourceTable = (JTable) e.getSource();
				DefaultTableModel sourceModel = (DefaultTableModel) sourceTable.getModel();

				// Ŭ���� �� �� �÷� ��ġ Ȯ��
				int clickedTableRow = sourceTable.getSelectedRow(); // ��
				int clickedTableColumn = sourceTable.getSelectedColumn();// �ʵ�

				if (clickedTableColumn == 4) {
					// �̹��� ���� Ŭ���ϸ� �ش� row�� �´� �̹��� ��� - ������ sql ���ǿ��� �޾ƿ� arraylist���� ������
					JFrame showBookImgWindows = new JFrame();
					JLabel bookImg = new JLabel(new ImageIcon(tmpImg.get(clickedTableRow)));
					showBookImgWindows.add(bookImg);

					// �̹����� �����ֱ� ���� �ӽ÷� ����� â�� 'x'��ư ���� ��� â�� ����Ǵ� �̺�Ʈ������ ����
					showBookImgWindows.addWindowListener(new WindowAdapter() {

						@Override
						public void windowClosing(WindowEvent e) {
							// TODO Auto-generated method stub
							System.out.println("Closed sub windows");
							e.getWindow().dispose(); // �ش� â�� ���� ������
						}

					});
					showBookImgWindows.pack();
					showBookImgWindows.setLocationRelativeTo(null); // ȭ�� ���߾� ��ġ
					showBookImgWindows.setVisible(true);

				}
			}
		});

		contentPane.add(new JScrollPane(table), BorderLayout.NORTH);
		// ȭ�� ǥ��
		setSize(800, 600);
		setLocationRelativeTo(null); // ȭ�� ���߾� ��ġ
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Member_Status();
	}

}