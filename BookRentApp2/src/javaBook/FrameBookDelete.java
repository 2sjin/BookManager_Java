package javaBook;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class FrameBookDelete{
	private JFrame frame;
	private JPanel panel_1 = new JPanel();
	public FrameBookDelete() {
		frame = new JFrame("도서 삭제");
		frame.setVisible(true);
		frame.setBounds(100, 100, 555, 689);
		PanelBookInfo book_panel = new PanelBookInfo(frame);
		frame.getContentPane().add(book_panel, BorderLayout.CENTER);
		JButton DELETE_BUTTON = new JButton("삭제");
		DELETE_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		DELETE_BUTTON.setBounds(342, 574, 80, 28);
		book_panel.add(DELETE_BUTTON);
		DELETE_BUTTON.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null,"도서를 삭제 하시겠습니까?","도서 삭제",JOptionPane.ERROR_MESSAGE);
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose(); //해당 창만 완전 종료함 
			}
		});
		panel_1.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		JLabel Delete_Label = new JLabel("도서 삭제");
		Delete_Label.setForeground(Color.WHITE);
		Delete_Label.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panel_1.add(Delete_Label);
	}
	public JFrame getFrame() {
		return frame;
	}
}
