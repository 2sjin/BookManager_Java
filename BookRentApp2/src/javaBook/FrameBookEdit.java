package javaBook;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import other.*;


public class FrameBookEdit {

	private JFrame frame;

	// 생성자
	public FrameBookEdit() {
		initialize();
	}

	// 프레임 초기화
	private void initialize() {
		frame = new JFrame("도서 수정");
		frame.setVisible(true);
		
		frame.setBounds(100, 100, 555, 689);
		
		PanelBookInfo book_panel = new PanelBookInfo(frame);
		frame.getContentPane().add(book_panel, BorderLayout.CENTER);
		
		// 이미지 변경
		JButton IMAGE_UPDATE_BUTTON = new JButton("이미지 변경");
		IMAGE_UPDATE_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		IMAGE_UPDATE_BUTTON.setBounds(22, 438, 141, 23);
		IMAGE_UPDATE_BUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon images = FileChooser.getImageIcon(PanelBookInfo.bookWidth, PanelBookInfo.bookHeight);	// 파일 선택기를 통해 이미지 리턴
				book_panel.setBookIcon(images);
			}
		});
		
		book_panel.true_flase_enabled(true);
		book_panel.add(IMAGE_UPDATE_BUTTON);
		
		JButton UPDATE_BUTTON = new JButton("수정");
		UPDATE_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		UPDATE_BUTTON.setBounds(342, 574, 80, 28);
		UPDATE_BUTTON.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null,"도서를 수정 하시겠습니까?","도서 수정",JOptionPane.ERROR_MESSAGE);
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose(); //해당 창만 완전 종료함 
			}
		});
		book_panel.add(UPDATE_BUTTON);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel BOOK_UPDATE = new JLabel("도서 수정");
		BOOK_UPDATE.setForeground(Color.WHITE);
		BOOK_UPDATE.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panel.add(BOOK_UPDATE);
	}
}
