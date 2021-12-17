package javaRent;

// 패키지 불러오기(GUI 구현 목적)
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

// 패키지 불러오기(다른 사용자 정의 패키지 사용 목적)
import javaBook.*;
import other.dbConnector;

// [도서 반납] 프레임 클래스 
public class FrameReturn extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// 생성자
	public FrameReturn() {
		setTitle("도서 반납");
		setBounds(100, 100, 555, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		// '도서 정보' 패널 추가
		PanelBookInfo book_panel = new PanelBookInfo(this);
		getContentPane().add(book_panel);

		// '도서 정보' 제목 패널 추가		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel BOOK_Imformation = new JLabel("도서 정보");
		BOOK_Imformation.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panel.add(BOOK_Imformation);		

		// [반납] 버튼 추가
		JButton UPDATE_BUTTON = new JButton("반납");
		UPDATE_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		UPDATE_BUTTON.setBounds(342, 574, 80, 28);
		book_panel.add(UPDATE_BUTTON);
		UPDATE_BUTTON.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnector dbConn = new dbConnector();
				String clicked_ISBN = book_panel.getBookISBN();
				
				try {
					// 책이 대여 중인지 확인하기 위한 SQL 실행
					ResultSet srcRent = dbConn.executeQurey("SELECT BOOK_ISBN FROM RENT "
							+ "WHERE BOOK_ISBN = '" + clicked_ISBN + "' and RENT_RETURN_DATE is NULL; ");						
					// 이미 반납된 도서일 경우 메시지 출력
					if(srcRent.next() == false)
						JOptionPane.showConfirmDialog(null,"이미 반납한 도서입니다.","도서 반납",JOptionPane.CLOSED_OPTION);						
					// 반납 SQL 수행
					else {
						// 반납 SQL 수행
						dbConn.executeUpdate("UPDATE RENT "
								+ "SET RENT_RETURN_DATE = CURDATE() "
								+ "WHERE RENT.BOOK_ISBN = '" + clicked_ISBN + "' and RENT_RETURN_DATE is null;"
//								+ "UPDATE USER "
//								+ "SET USER_RENT_CNT = USER-RENT-CNT - 1"
//								+ "WHERE USER_PHONE = '01025773617';"
						);
						// 메시지 출력
						ResultSet srcName = dbConn.executeQurey("SELECT BOOK.BOOK_ISBN, BOOK.BOOK_TITLE FROM BOOK, RENT "
								+ "WHERE BOOK.BOOK_ISBN = RENT.BOOK_ISBN and RENT.BOOK_ISBN = '9788970509563';");
						String tmpName = null;
						while(srcName.next())
							tmpName = srcName.getString(2);
						JOptionPane.showConfirmDialog(null, tmpName + "(" + clicked_ISBN + ") 도서를 반납하였습니다.","도서 반납",JOptionPane.CLOSED_OPTION);
					}										

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}
