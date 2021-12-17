package javaUser;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
public class FrameUserOut {

	private JFrame frame;


	// 생성자
	public FrameUserOut() {
		
		initialize();
	}

	// 프레임 초기화
	private void initialize() {
		frame = new JFrame("회원 탈퇴");
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
		
		JLabel lblNewLabel_1 = new JLabel("회원 정보");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 43, 95, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel Top_Panel = new JPanel();
		Top_Panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		Top_Panel.setBounds(0, 0, 541, 33);
		frame.getContentPane().add(Top_Panel);
		
		JLabel lblNewLabel = new JLabel("회원 탈퇴");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		Top_Panel.add(lblNewLabel);
		
		JButton CancelButton = new JButton("취소");
		CancelButton.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		CancelButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		CancelButton.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		CancelButton.setBounds(432, 613, 95, 29);
		frame.getContentPane().add(CancelButton);
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(CancelButton);
		JButton UserOut = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
        UserOut.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
        UserOut.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
        UserOut.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
        UserOut.setBounds(325, 613, 95, 29);
        UserOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null," 회원을 탈퇴 처리 하시겠습니까?","회원 탈퇴",JOptionPane.YES_NO_OPTION);
			}
		});
        frame.getContentPane().add(UserOut);
		PanelUserInfo ct = new PanelUserInfo();
		ct.Phone.setEnabled(false);
		ct.Name.setEnabled(false);
		ct.Birth.setEnabled(false);
		ct.Sex.setEnabled(false);
		ct.Email.setEnabled(false);
		ct.tf_enabled(false);
        ct.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
        ct.setBounds(0, 56, 541, 554);
        frame.getContentPane().add(ct);
	}
}