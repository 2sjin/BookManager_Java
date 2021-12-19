package javaRent;

// 패키지 불러오기(GUI 구현 목적)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

// 패키지 불러오기(DB 구현 목적)
import java.sql.*;

// 패키지 불러오기(다른 사용자 정의 패키지 사용 목적)
import javaBook.*;
import javaUser.*;
import other.dbConnector;

// [도서 대여] 프레임 클래스 
public class FrameRent extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	dbConnector dbConn = new dbConnector();
	
	// 생성자
	public FrameRent() {
		setTitle("도서 대여");
		setBounds(100, 100, 1100, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		// '회원 정보' 패널 추가
		PanelUserInfo user_panel = new PanelUserInfo();
		user_panel.setBounds(5, 39, 531, 608);
		getContentPane().add(user_panel);
		user_panel.tf_enabled(false);	// [이미지 변경] 버튼 숨기기, 텍스트필드 입력 비활성화
		
		// '회원 정보' 제목 패널 추가
		JPanel panelL = new JPanel();
		panelL.setBounds(5, 5, 531, 34);
		getContentPane().add(panelL);
		panelL.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel USER_Imformation = new JLabel("회원 정보");
		USER_Imformation.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panelL.add(USER_Imformation);
		
		// '도서 정보' 패널 추가
		PanelBookInfo book_panel = new PanelBookInfo(this);
		book_panel.setBounds(550, 39, 531, 608);
		getContentPane().add(book_panel);
		
		// '도서 정보' 제목 패널 추가
		JPanel panelR = new JPanel();
		panelR.setBounds(550, 5, 531, 34);
		getContentPane().add(panelR);
		panelR.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel BOOK_Imformation = new JLabel("도서 정보");
		BOOK_Imformation.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panelR.add(BOOK_Imformation);
		
		// [대여] 버튼 추가
		JButton UPDATE_BUTTON = new JButton("대여");
		UPDATE_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		UPDATE_BUTTON.setBounds(342, 574, 80, 28);
		book_panel.add(UPDATE_BUTTON);
		
		UPDATE_BUTTON.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clicked_ISBN = book_panel.getBookISBN();	// 클릭한 도서의 ISBN 가져오기
				String clicked_PHONE = "01025773617";			// 클릭한 회원의 전화번호 가져오기(구현 예정)
				
				try {
					// 책이 대여중인지 확인하기 위한 SQL 실행
					ResultSet srcRent = dbConn.executeQurey("SELECT BOOK_ISBN FROM RENT "
							+ "WHERE BOOK_ISBN = '" + clicked_ISBN + "' and RENT_RETURN_DATE is NULL; ");
					// 이미 대여중인 도서일 경우 메시지 출력
					if(srcRent.next() == true)
						JOptionPane.showConfirmDialog(null,"이미 대여중인 도서입니다.","도서 대여",JOptionPane.CLOSED_OPTION);						
					// 대여중이 아닌 도서일 경우
					else {
						// 대여 SQL 수행
						dbConn.executeUpdate("INSERT INTO RENT(RENT_DATE, RENT_DUE_DATE, BOOK_ISBN, USER_PHONE) "
								+ "VALUES(CURDATE(), date_add(CURDATE(), interval 14 day), " + clicked_ISBN + ", '" + clicked_PHONE + "');");
						// 대여 카운트 증가 SQL 수행
						dbConn.executeUpdate("UPDATE USER SET USER_RENT_CNT = USER_RENT_CNT + 1 "
								+ "WHERE USER_PHONE = '01025773617';");
						// 대여 일련번호 갱신
						dbConn.executeUpdate("UPDATE BOOK SET RENT_SEQ = '" + getMax_RENT_SEQ() + "'"
								+ "WHERE BOOK.BOOK_ISBN = '" + clicked_ISBN + "';");
						// 메시지 출력
						JOptionPane.showConfirmDialog(null, ISBN_to_TITLE(clicked_ISBN) + "(" + clicked_ISBN + ") 도서를 대여하였습니다.\n"
								 + "※ 대여자: " + PHONE_to_NAME(clicked_PHONE) + "(" + clicked_PHONE + ")",
								"도서 대여",JOptionPane.CLOSED_OPTION);
					}
					
				} catch (SQLException e1) { e1.printStackTrace(); }	
			}
		});		
	}
	
	// 메소드: 특정 ISBN에 해당하는 도서 제목 저장 	
	public String ISBN_to_TITLE(String ISBN) {
		String temp = null;
		try {
			ResultSet srcTitle = dbConn.executeQurey("SELECT BOOK.BOOK_TITLE FROM BOOK, RENT "
					+ "WHERE BOOK.BOOK_ISBN = RENT.BOOK_ISBN and RENT.BOOK_ISBN = '" + ISBN + "';");
			while(srcTitle.next())
				temp = srcTitle.getString(1);
		} catch (SQLException e) {
			return null;
		}		
		return temp;
	}
	
	// 메소드: 특정 전화번호에 해당하는 회원 이름 저장 	
	public String PHONE_to_NAME(String PHONE) {
		String temp = null;
		try {
			ResultSet srcName = dbConn.executeQurey("SELECT USER.USER_NAME FROM USER, RENT "
					+ "WHERE USER.USER_PHONE = RENT.USER_PHONE and RENT.USER_PHONE = '" + PHONE + "';");
			while(srcName.next())
				temp = srcName.getString(1);
		} catch (SQLException e) {
			return null;
		}		
		return temp;
	}
	
	// 메소드: 대여 일련번호(RENT_SEQ)의 최대값 리턴
	public String getMax_RENT_SEQ() {
		String temp = null;
		try {
			ResultSet srcName = dbConn.executeQurey("SELECT MAX(RENT_SEQ) FROM RENT;");
			while(srcName.next())
				temp = srcName.getString(1);
		} catch (SQLException e) {
			return null;
		}		
		return temp;
	}
	
}
