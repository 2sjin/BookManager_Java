package javaBook;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;
import javax.imageio.ImageIO;

import other.*;

public class PanelBookInfo extends JPanel {
	protected final static int bookWidth = 141;
	protected final static int bookHeight = 227;

	private static final long serialVersionUID = 1L;

	private JTextField Search_Field;
	private JTextArea DESCRIPTION_FIELD;
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
	private String header[] = { "ISBN", "제목", "저자", "출판사", "대여자", "대여일", "반납예정일" };
	private JScrollPane jp;
	private JPanel panel;
	private JButton Search_Button;
	private Object[][] data = new Object[0][8];
	private ResultSet src = null;
	private dbConnector dbConn = new dbConnector();
	private JLabel Book_Search;
	private JLabel Search_result;
	private Object[] tmp = null;
	private Vector<Integer> v1 = new Vector<Integer>();
	private Vector<String> v2 = new Vector<String>();
	private Vector<String> v3 = new Vector<String>();
	private Vector<Image> vImage = new Vector<Image>();
	private JTextField jf[] = new JTextField[7];

	// 생성자
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

		jf[0] = new JTextField();
		jf[0].setForeground(SystemColor.windowText);
		jf[0].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		jf[0].setEditable(false);
		jf[0].setBounds(259, 200, 259, 21);
		add(jf[0]);
		jf[0].setColumns(13);

		jf[1] = new JTextField();
		jf[1].setForeground(SystemColor.windowText);
		jf[1].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		jf[1].setEditable(false);
		jf[1].setColumns(100);
		jf[1].setBounds(259, 230, 259, 21);
		add(jf[1]);

		jf[2] = new JTextField();
		jf[2].setForeground(SystemColor.windowText);
		jf[2].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		jf[2].setEditable(false);
		jf[2].setColumns(50);
		jf[2].setBounds(259, 260, 259, 21);
		add(jf[2]);

		jf[3] = new JTextField();
		jf[3].setForeground(SystemColor.windowText);
		jf[3].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		jf[3].setEditable(false);
		jf[3].setColumns(30);
		jf[3].setBounds(259, 290, 259, 21);
		add(jf[3]);

		jf[4] = new JTextField();
		jf[4].setForeground(SystemColor.windowText);
		jf[4].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		jf[4].setEditable(false);
		jf[4].setColumns(11);
		jf[4].setBounds(259, 320, 259, 21);
		add(jf[4]);

		jf[5] = new JTextField();
		jf[5].setForeground(SystemColor.windowText);
		jf[5].setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		jf[5].setEditable(false);
		jf[5].setColumns(255);
		jf[5].setBounds(259, 350, 259, 21);
		add(jf[5]);

		DESCRIPTION_FIELD = new JTextArea();
		DESCRIPTION_FIELD.setEditable(false);
		DESCRIPTION_FIELD.setForeground(SystemColor.windowText);
		DESCRIPTION_FIELD.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		DESCRIPTION_FIELD.setColumns(10);
		DESCRIPTION_FIELD.setBounds(259, 380, 259, 80);
		DESCRIPTION_FIELD.setLineWrap(true);
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
		LENDER_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
		LENDER_LABEL.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		LENDER_LABEL.setBounds(45, 508, 141, 15);
		add(LENDER_LABEL);

		Book_RENTAL_DATE = new JLabel("대여일");
		Book_RENTAL_DATE.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_RENTAL_DATE.setBounds(252, 483, 70, 17);
		add(Book_RENTAL_DATE);

		RENTAL_DATE_LABEL = new JLabel("");
		RENTAL_DATE_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
		RENTAL_DATE_LABEL.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		RENTAL_DATE_LABEL.setBounds(212, 508, 141, 15);
		add(RENTAL_DATE_LABEL);

		Book_RETURN_DATE = new JLabel("반납 예정일");
		Book_RETURN_DATE.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_RETURN_DATE.setBounds(408, 483, 110, 17);
		add(Book_RETURN_DATE);

		RETURN_DATE_LABEL = new JLabel("");
		RETURN_DATE_LABEL.setHorizontalAlignment(SwingConstants.CENTER);
		RETURN_DATE_LABEL.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		RETURN_DATE_LABEL.setBounds(378, 508, 146, 15);
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
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		resizeColumnWidth(table);
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				// 이벤트 처리를 위한 table 관련 객제 정보 받기
				JTable sourceTable = (JTable) e.getSource();
				DefaultTableModel sourceModel = (DefaultTableModel) sourceTable.getModel();

				// 클릭한 행 및 컬럼 위치 확보(클릭한 위치의 정보 출력)
				int clickedTableRow = sourceTable.getSelectedRow(); // 행
				jf[0].setText((String) sourceModel.getValueAt(clickedTableRow, 0));
				jf[1].setText((String) sourceModel.getValueAt(clickedTableRow, 1));
				jf[2].setText((String) sourceModel.getValueAt(clickedTableRow, 2));
				jf[3].setText((String) sourceModel.getValueAt(clickedTableRow, 3));
				jf[4].setText(v1.get(clickedTableRow).toString());
				jf[5].setText(v2.get(clickedTableRow));
				DESCRIPTION_FIELD.setText(v3.get(clickedTableRow));
				LENDER_LABEL.setText((String) sourceModel.getValueAt(clickedTableRow, 4));
				RENTAL_DATE_LABEL.setText((String) sourceModel.getValueAt(clickedTableRow, 5));
				RETURN_DATE_LABEL.setText((String) sourceModel.getValueAt(clickedTableRow, 6));

				// 클릭한 위치의 데이터에 해당하는 이미지 출력
				Image tmpImg = vImage.get(clickedTableRow); // 벡터로부터 Image 불러오기
				tmpImg = tmpImg.getScaledInstance(bookWidth, bookHeight, Image.SCALE_SMOOTH); // Image 크기 재설정
				BOOK_IMAGE.setIcon(new ImageIcon(tmpImg)); // 재설정한 Image를 ImageIcon 객체로 재생성하여 레이블에 반영

			}
		});
		jp = new JScrollPane(table);
		jp.setEnabled(false);

		panel.add(jp, BorderLayout.CENTER);

		Search_Button = new JButton("검색");
		Search_Button.setBounds(466, 9, 69, 22);
		Search_Button.addActionListener(new BookActionListener());
		add(Search_Button);
	}

	public void true_flase_enabled(boolean boo) {
		jf[0].setEditable(boo);
		jf[1].setEditable(boo);
		jf[2].setEditable(boo);
		jf[3].setEditable(boo);
		jf[4].setEditable(boo);
		jf[5].setEditable(boo);
		DESCRIPTION_FIELD.setEditable(boo);
	}

	public void ComponentSetVisible(boolean boo) {
		Book_Search.setVisible(boo);
		Search_Button.setVisible(boo);
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

	// 내부 클래스로 이벤트 리스너 작성 with 검색필드, 검색버튼
	private class BookActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			// 검색필드(책의 제목, 책의 저자,책의 ISBN) text값 db명령문을 Search 수행
			String BookSearch = Search_Field.getText();

			try {
				src = dbConn.executeQurey("select BOOK.*,RENT_DATE,RENT_DUE_DATE from BOOK"
						+ " LEFT JOIN RENT ON BOOK.BOOK_ISBN = RENT.BOOK_ISBN" + " where BOOK.BOOK_TITLE LIKE '%"
						+ BookSearch + "%' or " + "BOOK.BOOK_AUTHOR LIKE '%" + BookSearch + "%' or BOOK.BOOK_ISBN = '"
						+ BookSearch + "';");
				int RowCount = tableModel.getRowCount(); // 행 갯수 반환
				if (RowCount > 0) { // 행 갯수가 0보다 크다면 모든 행 삭제
					for (int i = RowCount - 1; i >= 0; i--)
						tableModel.removeRow(i); // 행 삭제 메소드
				}
				while (src.next()) { // 검색된 데이터의 사용
					Object data[] = { src.getString(1), src.getString(2), src.getString(3), src.getString(4), " ",
							src.getString(9), src.getString(10) };
					tmp = data;
					tableModel.addRow(tmp); // 행 추가 메소드
					v1.add(src.getInt(5)); // 가격 데이터를 벡터에 추가
					v2.add(src.getString(8)); // 대여자 데이터를 벡터에 추가
					v3.add(src.getString(6)); // 도서설명 데이터를 벡터에 추가

					// DB에서 BLOB 자료형으로 저장된 데이터 그림 데이터로 변환
					InputStream inputStream = src.getBinaryStream(7);
					try {
						vImage.add(ImageIO.read(inputStream)); // 바이너리 데이터를 이미지 형태로 읽어 벡터에 추가
					} catch (IOException errImg) {
						System.out.println("이미지 불러오기 오류");
					}
				}
				resizeColumnWidth(table);
			} catch (SQLException e1) {
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

	public JTextField[] getJTextField() {
		return jf;
	}

	public JTextArea getJTextArea() {
		return DESCRIPTION_FIELD;
	}

	public JLabel getJLabel() {
		return BOOK_IMAGE;
	}

	public String getBookISBN() {
		return jf[0].getText();
	}


	public JTable getJTable() {
		return table;
	}

	public void Tableremove(int column) {
		v1.remove(column);
		v2.remove(column);
		v3.remove(column);
		vImage.remove(column);
	}
}
