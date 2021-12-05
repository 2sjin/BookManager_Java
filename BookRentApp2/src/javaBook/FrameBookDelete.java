package javaBook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JButton;

public class DELETEBOOK {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DELETEBOOK window = new DELETEBOOK();
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
	public DELETEBOOK() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BOOKJPanel book_panel = new BOOKJPanel(frame);
		frame.getContentPane().add(book_panel, BorderLayout.CENTER);
		
		JButton DELETE_BUTTON = new JButton("\uC0AD\uC81C");
		DELETE_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		DELETE_BUTTON.setBounds(342, 574, 80, 28);
		book_panel.add(DELETE_BUTTON);
		DELETE_BUTTON.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null,"도서를 삭제 하시겠습니까?","도서 삭제",JOptionPane.ERROR_MESSAGE);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C \uC0AD\uC81C");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panel_1.add(lblNewLabel);
	}
}
