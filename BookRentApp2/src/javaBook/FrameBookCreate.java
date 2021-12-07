package javaBook;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import other.FileChooser;

import java.awt.event.*;
// 안녕
public class FrameBookCreate{

	private JFrame frame;
	/**
	 * Create the application.
	 */
	public FrameBookCreate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("도서 추가");
		frame.setVisible(true);
		
		frame.setBounds(100, 100, 555, 689);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		PanelBookInfo book_panel = new PanelBookInfo(frame);
		book_panel.true_flase_enabled(true);
		book_panel.ComponentSetVisible(false);
		frame.getContentPane().add(book_panel);
		JButton INSERT_BUTTON = new JButton("추가");
		INSERT_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		INSERT_BUTTON.setBounds(342, 574, 80, 28);
		INSERT_BUTTON.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null,"도서를 추가 하시겠습니까?","도서 추가",JOptionPane.ERROR_MESSAGE);
			}
		});
		// 이미지 변경
		JButton IMAGE_INSERT_BUTTON = new JButton("이미지 추가");
		IMAGE_INSERT_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		IMAGE_INSERT_BUTTON.setBounds(22, 438, 141, 23);
		IMAGE_INSERT_BUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon images = FileChooser.getImageIcon(141, 227);	// 파일 선택기를 통해 이미지 리턴(매개변수는 가로, 세로 크기)
				book_panel.setBookIcon(images);
			}
		});
		book_panel.add(IMAGE_INSERT_BUTTON);
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose(); //해당 창만 완전 종료함 
			}
		});
		JLabel BOOK_Imformation = new JLabel("도서 추가");
		BOOK_Imformation.setForeground(Color.WHITE);
		BOOK_Imformation.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panel.add(BOOK_Imformation);
		book_panel.add(INSERT_BUTTON);
	}
}