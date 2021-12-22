package javaUser;

import java.io.*;
import java.sql.*;
import java.util.Vector;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import other.FileChooser;
import other.dbConnector;

import java.awt.*;

public class PanelUserInfo extends JPanel {
	protected final static int UserWidth = 119;
	protected final static int UserHeight = 140;
	
	JScrollPane scrollPane;
	JTextField UserSearchField;
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
	JButton SearchButton;
	private ResultSet src = null;
	private dbConnector dbConn = new dbConnector();
	JLabel lblNewLabel_4_11;
	JLabel ImageUser;
	private Vector<String> v2 = new Vector<String>();
	private Vector<Image> vImage = new Vector<Image>();
	
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
		
		UserSearchField = new JTextField();
		UserSearchField.setColumns(38);
		UserSearchField.addActionListener(new UserActionListener());
		Center_Panel.add(UserSearchField);
		
		SearchButton = new JButton("검 색");
		SearchButton.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		SearchButton.setPreferredSize(new Dimension(69, 20));
		SearchButton.addActionListener(new UserActionListener());
		Center_Panel.add(SearchButton);
		
		JLabel lblNewLabel_3 = new JLabel("회원 검색 결과");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Center_Panel.add(lblNewLabel_3);
		
		
		tableModel2 = new DefaultTableModel(data2, header2){
	         public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	       };
		BookList = new JTable(tableModel2);
		BookList.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		
		resizeColumnWidth(BookList);
		BookList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JTable sourceTable = (JTable) e.getSource();
				DefaultTableModel sourceModel = (DefaultTableModel) sourceTable.getModel();
				int clickedTableRow = sourceTable.getSelectedRow();
				Phone.setText((String) sourceModel.getValueAt(clickedTableRow, 0));
				Name.setText((String) sourceModel.getValueAt(clickedTableRow, 1));
				Birth.setText((String) sourceModel.getValueAt(clickedTableRow, 2));
				Sex.setText((String) sourceModel.getValueAt(clickedTableRow, 3));
				Email.setText(v2.get(clickedTableRow));
				lblNewLabel_4_11.setText((String) sourceModel.getValueAt(clickedTableRow, 4));
				
				Image tmpImg = vImage.get(clickedTableRow); // 벡터로부터 Image 불러오기
				tmpImg = tmpImg.getScaledInstance(UserWidth, UserHeight, Image.SCALE_SMOOTH); // Image 크기 재설정
				ImageUser.setIcon(new ImageIcon(tmpImg));
				
				try {
					src = dbConn.executeQurey("SELECT BOOK.BOOK_ISBN, BOOK.BOOK_TITLE, BOOK.BOOK_AUTHOR, BOOK.BOOK_PUB, RENT.RENT_DATE, RENT.RENT_DUE_DATE FROM BOOK\r\n"
							+ "LEFT JOIN RENT ON BOOK.BOOK_ISBN = RENT.BOOK_ISBN\r\n"
							+ "WHERE RENT_RETURN_DATE IS NULL\r\n"
							+ "AND RENT.USER_PHONE = '"+Phone.getText()+"';");
					int RowCount = tableModel.getRowCount(); // 행 갯수 반환
					if (RowCount > 0) { // 행 갯수가 0보다 크다면 모든 행 삭제
						for (int i = RowCount - 1; i >= 0; i--)
							tableModel.removeRow(i); // 행 삭제 메소드
					}
					while(src.next()) {
						
						Object [] tmp = {src.getString(1), src.getString(2), src.getString(3),
								src.getString(4), src.getString(5), src.getString(6)};
						tableModel.addRow(tmp);
					}
					resizeColumnWidth(UserSearchResult);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane = new JScrollPane(BookList);
		scrollPane.setPreferredSize(new Dimension(500, 90));
		Center_Panel.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(500, 375));
		panel.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		panel.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		Center_Panel.add(panel);
		
		ImageUser = new JLabel("");
		ImageUser.setOpaque(isOpaque());
		ImageUser.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		ImageUser.setBounds(12, 10, 119, 140);
		panel.add(ImageUser);
		
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
		
		lblNewLabel_4_11 = new JLabel("등록");
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
		
		tableModel = new DefaultTableModel(data, header){
	         public boolean isCellEditable(int row, int column) {
	             return false;
	          }
	       };
		UserSearchResult = new JTable(tableModel);
		UserSearchResult.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		resizeColumnWidth(UserSearchResult);
		UserSearchResult.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
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
				ImageUser.setIcon(images);
			}
		});
		panel.add(ImageChange);
		
		Phone = new JTextField();
		Phone.setColumns(20);
		Phone.setBorder(new LineBorder(Color.BLUE));
		Phone.setBounds(260, 10, 210, 22);
		panel.add(Phone);
		
		Name = new JTextField();
		Name.setColumns(20);
		Name.setBorder(new LineBorder(Color.BLUE));
		Name.setBounds(260, 42, 210, 22);
		panel.add(Name);
		
		Birth = new JTextField();
		Birth.setColumns(20);
		Birth.setBorder(new LineBorder(Color.BLUE));
		Birth.setBounds(260, 74, 210, 22);
		panel.add(Birth);
		
		Sex = new JTextField();
		Sex.setColumns(20);
		Sex.setBorder(new LineBorder(Color.BLUE));
		Sex.setBounds(260, 106, 210, 22);
		panel.add(Sex);
		
		Email = new JTextField();
		Email.setColumns(30);
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
			String UserSearch = UserSearchField.getText();
			try {
				src = dbConn.executeQurey("Select * FROM USER "+ "WHERE USER.USER_NAME LIKE '%" + UserSearch + "%' or "
						+ " USER.USER_PHONE LIKE '%" + UserSearch + "%';");
				int RowCount = tableModel2.getRowCount(); // 행 갯수 반환
				if (RowCount > 0) { // 행 갯수가 0보다 크다면 모든 행 삭제
					for (int i = RowCount - 1; i >= 0; i--)
						tableModel2.removeRow(i); // 행 삭제 메소드
				}
				while(src.next()) {
					String sexState;
					String memberState;
					if(src.getInt(4)==1) {
						sexState = "여성";
					}
					else
						sexState = "남성";
					if(src.getString(8)==null) {
						memberState = "등록";
					}
					else
						memberState = "미등록";
					Object [] tmp = {src.getString(1),src.getString(2),src.getString(3),sexState,memberState,src.getString(9)};
					tableModel2.addRow(tmp);
					v2.add(src.getString(5));
					InputStream inputStream = src.getBinaryStream(6);
					try {
						vImage.add(ImageIO.read(inputStream)); // 바이너리 데이터를 이미지 형태로 읽어 벡터에 추가
					} catch (IOException errImg) {
						System.out.println("이미지 불러오기 오류");
					}
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
	
	// 리턴 메소드
	public String getUserInfo(String s) {
		switch(s) {
			case "PHONE": return Phone.getText(); 
			case "NAME": return Name.getText();
			case "REG": return "등록";
			default: return null;
		}
	}
}