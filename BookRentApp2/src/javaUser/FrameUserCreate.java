package javaUser;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

import other.FileChooser;
public class FrameUserCreate {

	private JFrame frame;
	private JTextField PhoneTextField;
	private JTextField NametextField;
	private JTextField BirthtextField;
	private JTextField SextextField;
	private JTextField EmailtextField;



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
		frame = new JFrame("회원 등록");
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
		
		JLabel lblNewLabel = new JLabel("회원 등록");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(240, 10, 93, 28);
		panel.add(lblNewLabel);
		
		JLabel Image = new JLabel("");
		Image.setOpaque(true);
		Image.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		Image.setBounds(12, 63, 124, 160);
		frame.getContentPane().add(Image);
		
		JButton ImageButton = new JButton("이미지 변경");
		ImageButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		ImageButton.setBorder(new LineBorder(Color.BLUE));
		ImageButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		ImageButton.setBounds(12, 250, 124, 30);
		ImageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon images = FileChooser.getImageIcon(124, 160);	// 파일 선택기를 통해 이미지 리턴(매개변수는 가로, 세로 크기)
				Image.setIcon(images);
			}
		});
		frame.getContentPane().add(ImageButton);
		
		JButton PushButton = new JButton("등록");
		PushButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		PushButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		PushButton.setBorder(new LineBorder(Color.BLUE));
		PushButton.setBounds(378, 250, 92, 30);
		frame.getContentPane().add(PushButton);
		PushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null," 회원을 등록 하시겠습니까?","회원 등록",JOptionPane.YES_NO_OPTION);
			}
		});
		
		JButton CancelButton = new JButton("취소");
		CancelButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		CancelButton.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		CancelButton.setBorder(new LineBorder(Color.BLUE));
		CancelButton.setBounds(482, 250, 92, 30);
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(CancelButton);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호 :");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(166, 64, 92, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("이름 :");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(166, 99, 92, 18);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("생년월일 :");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(166, 134, 92, 18);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("성별 :");
		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(166, 169, 92, 18);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("이메일 :");
		lblNewLabel_1_4.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_1_4.setBounds(166, 205, 92, 18);
		frame.getContentPane().add(lblNewLabel_1_4);
		
		PhoneTextField = new JTextField();
		PhoneTextField.setBounds(294, 62, 280, 30);
		PhoneTextField.setBorder(new LineBorder(Color.BLUE));
		frame.getContentPane().add(PhoneTextField);
		PhoneTextField.setColumns(10);
		
		NametextField = new JTextField();
		NametextField.setColumns(10);
		NametextField.setBorder(new LineBorder(Color.BLUE));
		NametextField.setBounds(294, 97, 280, 30);
		frame.getContentPane().add(NametextField);
		
		BirthtextField = new JTextField();
		BirthtextField.setColumns(10);
		BirthtextField.setBorder(new LineBorder(Color.BLUE));
		BirthtextField.setBounds(294, 132, 280, 30);
		frame.getContentPane().add(BirthtextField);
		
		SextextField = new JTextField();
		SextextField.setColumns(10);
		SextextField.setBorder(new LineBorder(Color.BLUE));
		SextextField.setBounds(294, 167, 280, 30);
		frame.getContentPane().add(SextextField);
		
		EmailtextField = new JTextField();
		EmailtextField.setColumns(10);
		EmailtextField.setBorder(new LineBorder(Color.BLUE));
		EmailtextField.setBounds(294, 203, 280, 30);
		frame.getContentPane().add(EmailtextField);
	}
}