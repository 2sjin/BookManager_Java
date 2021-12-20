package javaUser;

import java.io.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import other.FileChooser;
import other.dbConnector;

import java.awt.*;

public class PanelUserInfo extends JPanel {
	JTextField UserSearch;
	JTextField Phone;
	JTextField Name;
	JTextField Birth;
	JTextField Sex;
	JTextField Email;
	JTable UserSearchResult;
	DefaultTableModel tableModel;
	Object [][] data = new Object[0][6];
	String [] header = {"ISBN", "제목", "저자", "출판사", "대여일", "반납예정일"};
	JTable BookList;
	DefaultTableModel tableModel2;
	Object [][] data2 = new Object[0][6];
	String [] header2 = {"전화번호", "이름", "생년월일", "성별", "등록여부", "대여도서"};
	JButton ImageChange;
	private ResultSet src = null;
	private dbConnector dbConn = new dbConnector();

	// 생성자
	public PanelUserInfo() {
		setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		setLayout(null);
		
		JPanel Center_Panel = new JPanel();
		Center_Panel.setForeground(Color.WHITE);
		Center_Panel.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		Center_Panel.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		Center_Panel.setBounds(12, 10, 516, 537);
		add(Center_Panel);
		Center_Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_2 = new JLabel("회원 검색");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Center_Panel.add(lblNewLabel_2);
		
		UserSearch = new JTextField();
		UserSearch.setColumns(41);
		UserSearch.addActionListener(new UserActionListener());
		Center_Panel.add(UserSearch);
		
		JLabel lblNewLabel_3 = new JLabel("회원 검색 결과");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Center_Panel.add(lblNewLabel_3);
		
		
		tableModel2 = new DefaultTableModel(data2, header2);
		BookList = new JTable(tableModel2);
		BookList.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		
		resizeColumnWidth(BookList);
		BookList.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(BookList);
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
		Image.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		Image.setBounds(12, 10, 119, 140);
		panel.add(Image);
		
		JLabel lblNewLabel_4 = new JLabel("전화번호 :");
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(143, 10, 105, 22);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_2 = new JLabel("이름 :");
		lblNewLabel_4_2.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4_2.setBounds(143, 42, 105, 22);
		panel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_4 = new JLabel("생년월일 :");
		lblNewLabel_4_4.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4_4.setBounds(143, 74, 105, 22);
		panel.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_6 = new JLabel("성별 :");
		lblNewLabel_4_6.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4_6.setBounds(143, 106, 105, 22);
		panel.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_7 = new JLabel("이메일 :");
		lblNewLabel_4_7.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4_7.setBounds(143, 138, 105, 22);
		panel.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel_4_10 = new JLabel("등록여부 :");
		lblNewLabel_4_10.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4_10.setBounds(143, 170, 105, 22);
		panel.add(lblNewLabel_4_10);
		
		JLabel lblNewLabel_4_11 = new JLabel("등록");
		lblNewLabel_4_11.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		lblNewLabel_4_11.setBounds(260, 170, 105, 22);
		panel.add(lblNewLabel_4_11);
		
		JPanel List_Panel = new JPanel();
		List_Panel.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		List_Panel.setBounds(12, 207, 476, 158);
		panel.add(List_Panel);
		List_Panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_5 = new JLabel("대여중인 도서 목록");
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		List_Panel.add(lblNewLabel_5);
		
		tableModel = new DefaultTableModel(data, header);
		UserSearchResult = new JTable(tableModel);
		UserSearchResult.setEnabled(false);
		UserSearchResult.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		JScrollPane jp = new JScrollPane(UserSearchResult);
		jp.setPreferredSize(new Dimension(470, 120));
		List_Panel.add(jp);

		ImageChange = new JButton("이미지 변경");
		ImageChange.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		ImageChange.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		ImageChange.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		ImageChange.setBounds(12, 163, 119, 29);
		ImageChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon images = FileChooser.getImageIcon(119, 140);	// 파일 선택기를 통해 이미지 리턴(매개변수는 가로, 세로 크기)
				Image.setIcon(images);
			}
		});
		panel.add(ImageChange);
		
		Phone = new JTextField();
		Phone.setColumns(10);
		Phone.setBorder(new LineBorder(Color.BLUE));
		Phone.setBounds(260, 10, 210, 22);
		panel.add(Phone);
		
		Name = new JTextField();
		Name.setColumns(10);
		Name.setBorder(new LineBorder(Color.BLUE));
		Name.setBounds(260, 42, 210, 22);
		panel.add(Name);
		
		Birth = new JTextField();
		Birth.setColumns(10);
		Birth.setBorder(new LineBorder(Color.BLUE));
		Birth.setBounds(260, 74, 210, 22);
		panel.add(Birth);
		
		Sex = new JTextField();
		Sex.setColumns(10);
		Sex.setBorder(new LineBorder(Color.BLUE));
		Sex.setBounds(260, 106, 210, 22);
		panel.add(Sex);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBorder(new LineBorder(Color.BLUE));
		Email.setBounds(260, 138, 210, 22);
		panel.add(Email);

		setVisible(true);
	}
	public void tf_enabled(boolean boo) {
		Phone.setEditable(boo);
		Name.setEditable(boo);
		Birth.setEditable(boo);
		Sex.setEditable(boo);
		Email.setEditable(boo);
		ImageChange.setVisible(boo);
	}
	private class UserActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				src = dbConn.executeQurey("Select *from USER;");
				int RowCount = tableModel2.getRowCount(); // 행 갯수 반환
				if (RowCount > 0) { // 행 갯수가 0보다 크다면 모든 행 삭제
					for (int i = RowCount - 1; i >= 0; i--)
						tableModel2.removeRow(i); // 행 삭제 메소드
				}
				while(src.next()) {
					String sexState;
					if(src.getInt(4)==1) {
						sexState = "여성";
					}
					else
						sexState = "남성";
					Object [] tmp = {src.getString(1),src.getString(2),src.getString(3),sexState,src.getString(5),""};
					tableModel2.addRow(tmp);
				}
				resizeColumnWidth(BookList);
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 72; // Min width
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 8, width);
			}
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
}