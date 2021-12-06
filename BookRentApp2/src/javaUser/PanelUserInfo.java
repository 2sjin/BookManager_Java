package javaUser;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class PanelUserInfo extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_1;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public PanelUserInfo() {
		setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		setLayout(null);
		
		JPanel Center_Panel = new JPanel();
		Center_Panel.setForeground(Color.WHITE);
		Center_Panel.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		Center_Panel.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		Center_Panel.setBounds(12, 10, 518, 539);
		add(Center_Panel);
		Center_Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("\uD68C\uC6D0 \uAC80\uC0C9");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Center_Panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(41);
		Center_Panel.add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("\uD68C\uC6D0 \uAC80\uC0C9 \uACB0\uACFC");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Center_Panel.add(lblNewLabel_3);
		
		table_1 = new JTable();
		table_1.setEnabled(false);
		table_1.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ISBN", "\uC81C\uBAA9", "\uC800\uC790", "\uCD9C\uD310\uC0AC", "\uB300\uC5EC\uC77C", "\uBC18\uB0A9\uC608\uC815\uC77C"
			}
		));
		table = new JTable();
		table.setEnabled(false);
		table.setFont(new Font("굴림", Font.PLAIN, 17));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\uC804\uD654\uBC88\uD638", "\uC774\uB984", "\uC0DD\uB144\uC6D4\uC77C", "\uC131\uBCC4", "\uB4F1\uB85D\uC5EC\uBD80", "\uB300\uC5EC\uB3C4\uC11C"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(500, 90));
		Center_Panel.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(500, 375));
		panel.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		panel.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		Center_Panel.add(panel);
		
		JLabel Image = new JLabel("");
		Image.setOpaque(true);
		Image.setBackground(SystemColor.textHighlight);
		Image.setBounds(12, 10, 119, 140);
		panel.add(Image);
		
		JLabel lblNewLabel_4 = new JLabel("\uC804\uD654\uBC88\uD638 :");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(143, 10, 105, 22);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_2 = new JLabel("\uC774\uB984 :");
		lblNewLabel_4_2.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4_2.setBounds(143, 42, 105, 22);
		panel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C :");
		lblNewLabel_4_4.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4_4.setBounds(143, 74, 105, 22);
		panel.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_6 = new JLabel("\uC131\uBCC4 :");
		lblNewLabel_4_6.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4_6.setBounds(143, 106, 105, 22);
		panel.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_7 = new JLabel("\uC774\uBA54\uC77C :");
		lblNewLabel_4_7.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4_7.setBounds(143, 138, 105, 22);
		panel.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel_4_10 = new JLabel("\uB4F1\uB85D\uC5EC\uBD80 :");
		lblNewLabel_4_10.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4_10.setBounds(143, 170, 105, 22);
		panel.add(lblNewLabel_4_10);
		
		JLabel lblNewLabel_4_11 = new JLabel("\uB4F1\uB85D");
		lblNewLabel_4_11.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4_11.setBounds(260, 170, 105, 22);
		panel.add(lblNewLabel_4_11);
		
		JPanel List_Panel = new JPanel();
		List_Panel.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		List_Panel.setBounds(12, 207, 476, 158);
		panel.add(List_Panel);
		List_Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_5 = new JLabel("\uB300\uC5EC\uC911\uC778 \uB3C4\uC11C \uBAA9\uB85D");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		List_Panel.add(lblNewLabel_5);
		
		JScrollPane jp = new JScrollPane(table_1);
		jp.setPreferredSize(new Dimension(460, 120));
		List_Panel.add(jp);
		
		JButton CancelButton_1_1 = new JButton("\uC774\uBBF8\uC9C0 \uBCC0\uACBD");
		CancelButton_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		CancelButton_1_1.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		CancelButton_1_1.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		CancelButton_1_1.setBounds(12, 163, 119, 29);
		panel.add(CancelButton_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBorder(new LineBorder(Color.BLUE));
		textField_1.setBounds(260, 10, 210, 22);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(new LineBorder(Color.BLUE));
		textField_2.setBounds(260, 42, 210, 22);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBorder(new LineBorder(Color.BLUE));
		textField_3.setBounds(260, 74, 210, 22);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBorder(new LineBorder(Color.BLUE));
		textField_4.setBounds(260, 106, 210, 22);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBorder(new LineBorder(Color.BLUE));
		textField_5.setBounds(260, 138, 210, 22);
		panel.add(textField_5);
		setVisible(true);
	}
}