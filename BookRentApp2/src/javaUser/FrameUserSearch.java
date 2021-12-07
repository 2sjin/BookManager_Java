package javaUser;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
public class FrameUserSearch {

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public FrameUserSearch() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("회원 조회");
		frame.setVisible(true);
		frame.getContentPane().setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		frame.setBounds(100, 100, 555, 689);
		frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose(); //해당 창만 완전 종료함 
            }
        });
		frame.getContentPane().setLayout(null);
		
		JLabel TitleLabel = new JLabel("회원 정보");
		TitleLabel.setForeground(Color.BLACK);
		TitleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		TitleLabel.setBounds(12, 43, 95, 22);
		frame.getContentPane().add(TitleLabel);
		
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		TitlePanel.setBounds(0, 0, 541, 33);
		frame.getContentPane().add(TitlePanel);
		
		JLabel lblNewLabel = new JLabel("회원 조회");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		TitlePanel.add(lblNewLabel);
		
		JButton CancelButton = new JButton("취소");
		CancelButton.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		CancelButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		CancelButton.setFont(new Font("굴림", Font.PLAIN, 17));
		CancelButton.setBounds(432, 613, 95, 29);
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(CancelButton);
		
		PanelUserInfo ct = new PanelUserInfo();
        ct.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
        ct.setBounds(0, 56, 541, 554);
        ct.tf_enabled(false);
        frame.getContentPane().add(ct);
	}
}