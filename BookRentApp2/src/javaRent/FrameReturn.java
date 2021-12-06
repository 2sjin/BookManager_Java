package javaRent;

// 패키지 불러오기(GUI 구현 목적)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

// 패키지 불러오기(다른 사용자 정의 패키지 사용 목적)
import javaBook.*;

// [도서 반납] 프레임 클래스 
public class FrameReturn extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// Create the frame.
	public FrameReturn() {
		setTitle("도서 반납");
		setBounds(100, 100, 555, 689);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		// '도서 정보' 패널 추가
		JPanel book_panel = new PanelBookInfo(this);
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
				JOptionPane.showConfirmDialog(null,"도서를 반납 하시겠습니까?","도서 반납",JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}
