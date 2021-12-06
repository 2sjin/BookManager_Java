package javaUser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FrameUserCreate {

	private JFrame frame;
	private JTextField PhoneTextField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;



	/**
	 * Create the application.
	 */
	public FrameUserCreate() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		frame.setBounds(100, 100, 600, 333);
		frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose(); //해당 창만 완전 종료함 
            }
        });
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		panel.setBounds(0, 0, 586, 43);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 \uB4F1\uB85D");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(240, 10, 93, 28);
		panel.add(lblNewLabel);
		
		JLabel Image = new JLabel("");
		Image.setOpaque(true);
		Image.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		Image.setBounds(12, 63, 124, 160);
		frame.getContentPane().add(Image);
		
		JButton ImageButton = new JButton("\uC774\uBBF8\uC9C0 \uBCC0\uACBD");
		ImageButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		ImageButton.setBorder(new LineBorder(Color.BLUE));
		ImageButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		ImageButton.setBounds(12, 250, 124, 30);
		frame.getContentPane().add(ImageButton);
		
		JButton PushButton = new JButton("\uB4F1\uB85D");
		PushButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		PushButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		PushButton.setBorder(new LineBorder(Color.BLUE));
		PushButton.setBounds(378, 250, 92, 30);
		frame.getContentPane().add(PushButton);
		
		JButton CancelButton = new JButton("\uCDE8\uC18C");
		CancelButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		CancelButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		CancelButton.setBorder(new LineBorder(Color.BLUE));
		CancelButton.setBounds(482, 250, 92, 30);
		frame.getContentPane().add(CancelButton);
		
		JLabel lblNewLabel_1 = new JLabel("\uC804\uD654\uBC88\uD638 :");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(166, 64, 92, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uC774\uB984 :");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(166, 99, 92, 18);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uC0DD\uB144\uC6D4\uC77C :");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(166, 134, 92, 18);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\uC131\uBCC4 :");
		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(166, 169, 92, 18);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("\uC774\uBA54\uC77C :");
		lblNewLabel_1_4.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(166, 205, 92, 18);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		PhoneTextField = new JTextField();
		PhoneTextField.setBounds(294, 62, 280, 30);
		PhoneTextField.setBorder(new LineBorder(Color.BLUE));
		frame.getContentPane().add(PhoneTextField);
		PhoneTextField.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.BLUE));
		textField.setBounds(294, 97, 280, 30);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(Color.BLUE));
		textField_1.setBounds(294, 132, 280, 30);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(Color.BLUE));
		textField_2.setBounds(294, 167, 280, 30);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(Color.BLUE));
		textField_3.setBounds(294, 203, 280, 30);
		frame.getContentPane().add(textField_3);
	}
}