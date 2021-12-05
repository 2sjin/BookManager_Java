package javaRent;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javaBook.PanelBookInfo;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// [도서 대여] 프레임 클래스 
public class FrameRent extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Create the frame.
	public FrameRent() {
		setTitle("도서 대여");
		setBounds(100, 100, 1100, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		// '회원 정보' 패널 추가
		JPanel user_panel = new PanelBookInfo(this);
		user_panel.setBounds(5, 39, 531, 608);
		getContentPane().add(user_panel);
		
		// '회원 정보' 제목 패널 추가
		JPanel panelL = new JPanel();
		panelL.setBounds(5, 5, 531, 34);
		getContentPane().add(panelL);
		panelL.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JLabel USER_Imformation = new JLabel("회원 정보");
		USER_Imformation.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panelL.add(USER_Imformation);
		
		// '도서 정보' 패널 추가
		JPanel book_panel = new PanelBookInfo(this);
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
				JOptionPane.showConfirmDialog(null,"도서를 대여 하시겠습니까?","도서 대여",JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}
