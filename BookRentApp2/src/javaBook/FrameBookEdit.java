package javaBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

public class FrameBookEdit {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameBookEdit window = new FrameBookEdit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameBookEdit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("도서 수정");
		frame.setVisible(true);
		
		frame.setBounds(100, 100, 555, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelBookInfo book_panel = new PanelBookInfo(frame);
		frame.getContentPane().add(book_panel, BorderLayout.CENTER);
		
		// 이미지 변경
		JFileChooser bookImg = new JFileChooser();
		FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("All Images", "jpg","jpge","png","gif","svg");
		bookImg.setFileFilter(fileFilter);
		JButton IMAGE_UPDATE_BUTTON = new JButton("\uC774\uBBF8\uC9C0 \uBCC0\uACBD");
		IMAGE_UPDATE_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		IMAGE_UPDATE_BUTTON.setBounds(22, 438, 141, 23);
		IMAGE_UPDATE_BUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookImg.showOpenDialog(null);
				String filePath = bookImg.getSelectedFile().getPath();
			}
		});
		
		book_panel.true_flase_enabled(true);
		book_panel.add(IMAGE_UPDATE_BUTTON);
		
		JButton UPDATE_BUTTON = new JButton("\uC218\uC815");
		UPDATE_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		UPDATE_BUTTON.setBounds(342, 574, 80, 28);
		UPDATE_BUTTON.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null,"도서를 수정 하시겠습니까?","도서 수정",JOptionPane.ERROR_MESSAGE);
			}
		});
		book_panel.add(UPDATE_BUTTON);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel BOOK_UPDATE = new JLabel("\uB3C4\uC11C \uC218\uC815");
		BOOK_UPDATE.setForeground(UIManager.getColor("CheckBox.highlight"));
		BOOK_UPDATE.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panel.add(BOOK_UPDATE);
	}
}
