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
		// JTable 관련 -NORTH
		JTable table;
		DefaultTableModel tableModel;

		Object[][] data = new Object[0][8]; // 일단 빈 row 값 삽입, 이때 두번째 인덱스 값 9은 9개의 열이 존제한다는 뜻으로 선언
		String[] columnNames = { "휴대전화", "이름", "생년월일", "메일", "이미지", "가입날짜", "가입여부", "대여권수" };

		tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);
		// 이미지 리스트
		ArrayList<Image> tmpImg = new ArrayList<>();
		try {
			ResultSet src = dbConn.executeQurey("select * from USER_TABLE;");
			while (src.next()) {

				// SQL에서 BOOK_PRE 필드 결과값에 따라 맞는 문자열 배정 - 1:보유, 2:미보유
				String liveState;

				if (src.getInt(7) == 1) {
					liveState = "가입";
				} else {
					liveState = "미가입";
				}

				// ResultSet같은 경우 Index 1번부터 시작

				Object[] tmp = {src.getString(1), src.getString(2), src.getString(3), src.getString(4), "Click",
						src.getString(6), liveState, src.getInt(8)};
				tableModel.addRow(tmp);

				// DB에서 BLOB 자료형으로 저장된 데이터 그림 데이터로 변환
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
		// jtable에서 어떤 row가 클릭될 경우 사용되는 이벤트
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// 이벤트 처리를 위한 table 관련 객제 정보 받기
				JTable sourceTable = (JTable) e.getSource();
				DefaultTableModel sourceModel = (DefaultTableModel) sourceTable.getModel();

				// 클릭한 행 및 컬럼 위치 확보
				int clickedTableRow = sourceTable.getSelectedRow(); // 행
				int clickedTableColumn = sourceTable.getSelectedColumn();// 필드

				if (clickedTableColumn == 4) {
					// 이미지 셀에 클릭하면 해당 row에 맞는 이미지 출력 - 이전에 sql 질의에서 받아온 arraylist에서 얻어오기
					JFrame showBookImgWindows = new JFrame();
					JLabel bookImg = new JLabel(new ImageIcon(tmpImg.get(clickedTableRow)));
					showBookImgWindows.add(bookImg);

					// 이미지를 보여주기 위해 임시로 생기는 창의 'x'버튼 누를 경우 창만 종료되는 이벤트리스너 구현
					showBookImgWindows.addWindowListener(new WindowAdapter() {

						@Override
						public void windowClosing(WindowEvent e) {
							// TODO Auto-generated method stub
							System.out.println("Closed sub windows");
							e.getWindow().dispose(); // 해당 창만 완전 종료함
						}

					});
					showBookImgWindows.pack();
					showBookImgWindows.setLocationRelativeTo(null); // 화면 정중앙 배치
					showBookImgWindows.setVisible(true);

				}
			}
		});

		contentPane.add(new JScrollPane(table), BorderLayout.NORTH);
		// 화면 표시
		setSize(800, 600);
		setLocationRelativeTo(null); // 화면 정중앙 배치
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Member_Status();
	}

}
