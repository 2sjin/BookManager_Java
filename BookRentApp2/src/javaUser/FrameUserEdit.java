package javaUser;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
public class FrameUserEdit {

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public FrameUserEdit() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		
		JLabel lblNewLabel_1 = new JLabel("\uD68C\uC6D0 \uC815\uBCF4");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 43, 95, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel Top_Panel = new JPanel();
		Top_Panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		Top_Panel.setBounds(0, 0, 541, 33);
		frame.getContentPane().add(Top_Panel);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 \uC815\uBCF4 \uC218\uC815");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		Top_Panel.add(lblNewLabel);
		
		JButton CancelButton = new JButton("\uCDE8\uC18C");
		CancelButton.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		CancelButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		CancelButton.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		CancelButton.setBounds(432, 613, 95, 29);
		frame.getContentPane().add(CancelButton);
		
		JButton CancelButton_1 = new JButton("\uC218\uC815");
		CancelButton_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		CancelButton_1.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		CancelButton_1.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		CancelButton_1.setBounds(325, 613, 95, 29);
		frame.getContentPane().add(CancelButton_1);
		
		PanelUserInfo ct = new PanelUserInfo();
        ct.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
        ct.setBounds(0, 56, 541, 554);
        frame.getContentPane().add(ct);
	}
}