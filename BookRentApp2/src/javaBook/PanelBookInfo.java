package javaBook;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import other.*;
public class PanelBookInfo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField Search_Field;
	private JTextField ISBN_FIELD;
	private JTextField TITLE_FIELD;
	private JTextField AUTHOR_FIELD;
	private JTextField PUB_FIELD;
	private JTextField PRICE_FIELD;
	private JTextField LINK_FIELD;
	private JTextField DESCRIPTION_FIELD;
	private JLabel BOOK_IMAGE;
	private JLabel Book_LENDER;
	private JLabel LENDER_LABEL;
	private JLabel Book_RENTAL_DATE;
	private JLabel RENTAL_DATE_LABEL;
	private JLabel Book_RETURN_DATE;
	private JLabel RETURN_DATE_LABEL;
	private JButton CANCEL_BUTTON;
	private JTable table;
	private DefaultTableModel tableModel;
	private String header[] = {"ISBN","제목","저자","출판사","대여자","대여일","반납예정일"};
	private JScrollPane jp;
	private JPanel panel;
	private Object[][] data = new Object[0][8];
	private ResultSet src=null;
	private dbConnector dbConn = new dbConnector();
	private JLabel Book_Search;
	private JLabel Search_result;
	public PanelBookInfo(JFrame frame2) {
		setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		setLayout(null);
		Book_Search = new JLabel("도서 검색");
		Book_Search.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_Search.setBounds(12, 10, 80, 15);
		add(Book_Search);
		tableModel = new DefaultTableModel(data, header);
		table = new JTable(tableModel);
		Search_Field = new JTextField();
		Search_Field.setBounds(104, 7, 350, 21);
		Search_Field.addActionListener(new BookActionListener());
		add(Search_Field);
		Search_Field.setColumns(10);
		
		Search_result = new JLabel("도서 검색 결과");
		Search_result.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Search_result.setBounds(12, 35, 118, 15);
		add(Search_result);
		
		JLabel Book_ISBN = new JLabel("ISBN:");
		Book_ISBN.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_ISBN.setBounds(175, 202, 77, 15);
		add(Book_ISBN);
		
		JLabel Book_TITLE = new JLabel("제목:");
		Book_TITLE.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_TITLE.setBounds(175, 232, 77, 15);
		add(Book_TITLE);
		
		JLabel Book_AUTHOR = new JLabel("저자:");
		Book_AUTHOR.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_AUTHOR.setBounds(175, 262, 77, 15);
		add(Book_AUTHOR);
		
		JLabel Book_PUB = new JLabel("출판사:");
		Book_PUB.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_PUB.setBounds(175, 292, 77, 15);
		add(Book_PUB);
		
		JLabel Book_PRICE = new JLabel("가격(원):");
		Book_PRICE.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_PRICE.setBounds(175, 322, 77, 17);
		add(Book_PRICE);
		
		JLabel Book_LINK = new JLabel("관련링크:");
		Book_LINK.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_LINK.setBounds(175, 352, 77, 15);
		add(Book_LINK);
		
		JLabel Book_DESCRIPTION = new JLabel("도서설명:");
		Book_DESCRIPTION.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_DESCRIPTION.setBounds(175, 382, 77, 15);
		add(Book_DESCRIPTION);
		
		ISBN_FIELD = new JTextField();
		ISBN_FIELD.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		ISBN_FIELD.setEnabled(false);
		ISBN_FIELD.setBounds(259, 200, 259, 21);
		add(ISBN_FIELD);
		ISBN_FIELD.setColumns(10);
		
		TITLE_FIELD = new JTextField();
		TITLE_FIELD.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		TITLE_FIELD.setEnabled(false);
		TITLE_FIELD.setColumns(10);
		TITLE_FIELD.setBounds(259, 230, 259, 21);
		add(TITLE_FIELD);
		
		AUTHOR_FIELD = new JTextField();
		AUTHOR_FIELD.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		AUTHOR_FIELD.setEnabled(false);
		AUTHOR_FIELD.setColumns(10);
		AUTHOR_FIELD.setBounds(259, 260, 259, 21);
		add(AUTHOR_FIELD);
		
		PUB_FIELD = new JTextField();
		PUB_FIELD.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		PUB_FIELD.setEnabled(false);
		PUB_FIELD.setColumns(10);
		PUB_FIELD.setBounds(259, 290, 259, 21);
		add(PUB_FIELD);
		
		PRICE_FIELD = new JTextField();
		PRICE_FIELD.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		PRICE_FIELD.setEnabled(false);
		PRICE_FIELD.setColumns(10);
		PRICE_FIELD.setBounds(259, 320, 259, 21);
		add(PRICE_FIELD);
		
		LINK_FIELD = new JTextField();
		LINK_FIELD.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		LINK_FIELD.setEnabled(false);
		LINK_FIELD.setColumns(10);
		LINK_FIELD.setBounds(259, 350, 259, 21);
		add(LINK_FIELD);
		
		DESCRIPTION_FIELD = new JTextField();
		DESCRIPTION_FIELD.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		DESCRIPTION_FIELD.setEnabled(false);
		DESCRIPTION_FIELD.setColumns(10);
		DESCRIPTION_FIELD.setBounds(259, 380, 259, 80);
		add(DESCRIPTION_FIELD);
		
		BOOK_IMAGE = new JLabel("");
		BOOK_IMAGE.setOpaque(isOpaque());
		BOOK_IMAGE.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		BOOK_IMAGE.setBounds(22, 190, 141, 227);
		add(BOOK_IMAGE);
		
		Book_LENDER = new JLabel("대여자");
		Book_LENDER.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_LENDER.setBounds(80, 483, 62, 15);
		add(Book_LENDER);
		
		LENDER_LABEL = new JLabel("");
		LENDER_LABEL.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		LENDER_LABEL.setBounds(45, 508, 141, 15);
		add(LENDER_LABEL);
		
		Book_RENTAL_DATE = new JLabel("대여일");
		Book_RENTAL_DATE.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_RENTAL_DATE.setBounds(252, 483, 70, 17);
		add(Book_RENTAL_DATE);
		
		RENTAL_DATE_LABEL = new JLabel("");
		RENTAL_DATE_LABEL.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		RENTAL_DATE_LABEL.setBounds(212, 508, 141, 15);
		add(RENTAL_DATE_LABEL);
		
		Book_RETURN_DATE = new JLabel("반납 예정일");
		Book_RETURN_DATE.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_RETURN_DATE.setBounds(408, 483, 110, 17);
		add(Book_RETURN_DATE);
		
		RETURN_DATE_LABEL = new JLabel("");
		RETURN_DATE_LABEL.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		RETURN_DATE_LABEL.setBounds(372, 508, 146, 15);
		add(RETURN_DATE_LABEL);
		
		CANCEL_BUTTON = new JButton("취소");
		CANCEL_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		CANCEL_BUTTON.setBounds(438, 574, 80, 28);
		add(CANCEL_BUTTON);
		CANCEL_BUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.dispose();
			}
		});
		panel = new JPanel();
		panel.setBounds(12, 60, 506, 110);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		jp = new JScrollPane(table);
		jp.setEnabled(false);
		panel.add(jp,BorderLayout.CENTER);
		
		JButton Search_Button = new JButton("검색");
		Search_Button.setBounds(466, 9, 69, 22);
		Search_Button.addActionListener(new BookActionListener());
		add(Search_Button);
	}
	public void true_flase_enabled(boolean boo) {
		ISBN_FIELD.setEnabled(boo);
		TITLE_FIELD.setEnabled(boo);
		AUTHOR_FIELD.setEnabled(boo);
		PUB_FIELD.setEnabled(boo);
		PRICE_FIELD.setEnabled(boo);
		LINK_FIELD.setEnabled(boo);
		DESCRIPTION_FIELD.setEnabled(boo);
	}
	public void ComponentSetVisible(boolean boo) {
		Book_Search.setVisible(boo);
		Search_Field.setVisible(boo);
		Search_result.setVisible(boo);
		panel.setVisible(boo);
		Book_LENDER.setVisible(boo);
		LENDER_LABEL.setVisible(boo);
		Book_RENTAL_DATE.setVisible(boo);
		RENTAL_DATE_LABEL.setVisible(boo);
		Book_RETURN_DATE.setVisible(boo);
		RETURN_DATE_LABEL.setVisible(boo);
	}
	public void setBookIcon(ImageIcon img) {
		BOOK_IMAGE.setIcon(img);
	}
	// 내부 클래서로 이벤트 리스너 작성 with 검색필드, 검색버튼
	private class BookActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			// 검색필드의 text값 db명령문을 Search 수행
			src = dbConn.executeQurey("select * from BOOK where BOOK_TITLE LIKE '%"+Search_Field.getText()+"%';");
			try {
				int RowCount = tableModel.getRowCount();	// 행 갯수 반환
				if(RowCount>0) {	//행 갯수가 0보다 크다면 모든 행 삭제
					for(int i= RowCount -1;i>=0;i--)
						tableModel.removeRow(i);
				}
				while(src.next()) {
					System.out.println(src.getString("BOOK_TITLE"));
					Object[] tmp = {src.getString(1),src.getString(2),src.getString(3),src.getString(4),
							src.getInt(5),src.getString(6),"Click",src.getString(8)};
					tableModel.addRow(tmp);
					// DB에서 BLOB 자료형으로 저장된 데이터 그림 데이터로 변환
					InputStream inputStream = src.getBinaryStream(7);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}

