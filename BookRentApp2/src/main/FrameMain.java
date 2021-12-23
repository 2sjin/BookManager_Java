package main;

// 패키지 불러오기(GUI 구현 목적)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 패키지 불러오기(다른 사용자 정의 패키지 사용 목적)
import javaBook.*;
import javaRent.*;
import javaUser.*;

// 초기 메인 화면 프레임 클래스 
public class FrameMain extends JFrame {
	private static final long serialVersionUID = 1L;
	private Container contentPane = getContentPane();
	
	// 프레임 생성
	public FrameMain() {
		// 프레임 설정
		setTitle("도서 대여 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 225);
		setVisible(true);
		setLocationRelativeTo(null); // 화면 정중앙 배치
		setLayout(new BorderLayout());
		contentPane.setBackground(Color.WHITE);
		
		// 레이블 및 텍스트영역 생성
		JLabel mainLabel_N = new JLabel("「 도서 대여 프로그램 」");
		JTextArea mainTextArea = new JTextArea("\n  - 상단의 메뉴를 클릭하여 원하는 기능을 실행하세요."
											 + "\n  - 검색창에 텍스트 입력 후(미입력 시 전체 데이터 조회 가능)"
											 + "\n     [Enter] 키 입력 또는 [검색] 버튼 클릭"
											 + "\n  - 테이블 내 항목은 클릭으로 선택 가능");
		JLabel mainLabel_S = new JLabel("");
		mainLabel_N.setHorizontalAlignment(JLabel.CENTER);
		mainLabel_S.setHorizontalAlignment(JLabel.CENTER);
		mainLabel_N.setForeground(Color.BLUE);
		mainTextArea.setEditable(false);
		mainLabel_N.setFont(new Font("맑은 고딕", Font.BOLD, 22));
		mainTextArea.setFont(new Font("함초롬바탕", Font.PLAIN, 14));
		mainLabel_S.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		contentPane.add(mainLabel_N, BorderLayout.NORTH);
		contentPane.add(mainTextArea, BorderLayout.CENTER);
		contentPane.add(mainLabel_S, BorderLayout.SOUTH);
		
		// 메뉴바 생성
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// 메뉴 생성
		JMenu menuUser = new JMenu("회원관리");
		JMenu menuBook = new JMenu("도서관리");
		JMenu menuRent = new JMenu("도서대여");
		menuBar.add(menuUser);
		menuBar.add(menuBook);
		menuBar.add(menuRent);
		
		// [회원관리] 메뉴아이템 생성
		JMenuItem menuItemUser_0 = new JMenuItem("회원 조회");
		JSeparator separator_0 = new JSeparator();
		JMenuItem menuItemUser_1 = new JMenuItem("회원 등록");
		JMenuItem menuItemUser_2 = new JMenuItem("회원 정보 수정");
		JMenuItem menuItemUser_3 = new JMenuItem("회원 탈퇴/재등록");
		menuUser.add(menuItemUser_0);
		menuUser.add(separator_0);
		menuUser.add(menuItemUser_1);
		menuUser.add(menuItemUser_2);
		menuUser.add(menuItemUser_3);
		
		// [회원관리] 메뉴아이템에 이벤트 추가
		menuItemUser_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameUserSearch();
			}			
		});
		menuItemUser_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameUserCreate();
			}			
		});
		menuItemUser_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameUserEdit();
			}			
		});
		menuItemUser_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameUserOut();
			}			
		});

		// [도서관리] 메뉴아이템 생성
		JMenuItem menuItemBook_0 = new JMenuItem("도서 조회");
		JSeparator separator_1 = new JSeparator();
		JMenuItem menuItemBook_1 = new JMenuItem("도서 추가");
		JMenuItem menuItemBook_2 = new JMenuItem("도서 수정");
		JMenuItem menuItemBook_3 = new JMenuItem("도서 삭제");
		menuBook.add(menuItemBook_0);
		menuBook.add(separator_1);
		menuBook.add(menuItemBook_1);
		menuBook.add(menuItemBook_2);
		menuBook.add(menuItemBook_3);

		// [도서관리] 메뉴아이템에 이벤트 추가
		menuItemBook_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameBookSearch();
			}			
		});
		menuItemBook_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameBookCreate();
			}
			
		});
		menuItemBook_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameBookEdit();
			}			
		});
		menuItemBook_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameBookDelete();
			}
		});

		// [도서대여] 메뉴아이템 생성
		JMenuItem menuItemRent_0 = new JMenuItem("도서 대여");
		JMenuItem menuItemRent_1 = new JMenuItem("도서 반납");
		menuRent.add(menuItemRent_0);
		menuRent.add(menuItemRent_1);

		// [도서대여] 메뉴아이템에 이벤트 추가
		menuItemRent_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameRent();
			}			
		});
		menuItemRent_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrameReturn();
			}			
		});
	}
}
