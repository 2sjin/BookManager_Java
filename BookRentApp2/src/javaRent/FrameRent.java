package javaRent;

// 패키지 불러오기(GUI 구현 목적)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

// 패키지 불러오기(다른 사용자 정의 패키지 사용 목적)
import javaBook.*;
import javaUser.*;

// [도서 대여] 프레임 클래스 
public class FrameRent extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
				JOptionPane.showConfirmDialog(null,"도서를 대여하였습니다.","도서 대여",JOptionPane.CLOSED_OPTION);
			}
		});
	}
}
