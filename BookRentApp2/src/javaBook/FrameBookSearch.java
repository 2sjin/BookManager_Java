package javaBook;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class FrameBookSearch {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public FrameBookSearch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("도서 조회");
		frame.setVisible(true);
		
		frame.setBounds(100, 100, 555, 689);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel book_panel = new PanelBookInfo(frame);
		frame.getContentPane().add(book_panel);
		
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
		JLabel BOOK_Imformation = new JLabel("도서 조회");
		BOOK_Imformation.setForeground(Color.WHITE);
		BOOK_Imformation.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panel.add(BOOK_Imformation);
	}

}
