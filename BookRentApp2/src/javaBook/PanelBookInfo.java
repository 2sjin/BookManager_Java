package javaBook;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
	private String header[] = {"ISBN","제목","저자","출판사","대여자","대여일","반납예정일"};
	private JScrollPane jp;
	private JPanel panel;
	public PanelBookInfo(JFrame frame2) {
		setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		setLayout(null);
		JLabel Book_Search = new JLabel("\uB3C4\uC11C \uAC80\uC0C9");
		Book_Search.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_Search.setBounds(12, 10, 80, 15);
		add(Book_Search);
		
		Search_Field = new JTextField();
		Search_Field.setBounds(104, 7, 414, 21);
		add(Search_Field);
		Search_Field.setColumns(10);
		
		JLabel Search_result = new JLabel("\uB3C4\uC11C \uAC80\uC0C9 \uACB0\uACFC");
		Search_result.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Search_result.setBounds(12, 35, 118, 15);
		add(Search_result);
		
		JLabel Book_ISBN = new JLabel("ISBN:");
		Book_ISBN.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_ISBN.setBounds(175, 202, 77, 15);
		add(Book_ISBN);
		
		JLabel Book_TITLE = new JLabel("\uC81C\uBAA9:");
		Book_TITLE.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_TITLE.setBounds(175, 232, 77, 15);
		add(Book_TITLE);
		
		JLabel Book_AUTHOR = new JLabel("\uC800\uC790:");
		Book_AUTHOR.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_AUTHOR.setBounds(175, 262, 77, 15);
		add(Book_AUTHOR);
		
		JLabel Book_PUB = new JLabel("\uCD9C\uD310\uC0AC:");
		Book_PUB.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_PUB.setBounds(175, 292, 77, 15);
		add(Book_PUB);
		
		JLabel Book_PRICE = new JLabel("\uAC00\uACA9(\uC6D0):");
		Book_PRICE.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_PRICE.setBounds(175, 322, 77, 17);
		add(Book_PRICE);
		
		JLabel Book_LINK = new JLabel("\uAD00\uB828\uB9C1\uD06C:");
		Book_LINK.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_LINK.setBounds(175, 352, 77, 15);
		add(Book_LINK);
		
		JLabel Book_DESCRIPTION = new JLabel("\uB3C4\uC11C\uC124\uBA85:");
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
		
		Book_LENDER = new JLabel("\uB300\uC5EC\uC790");
		Book_LENDER.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_LENDER.setBounds(80, 483, 62, 15);
		add(Book_LENDER);
		
		LENDER_LABEL = new JLabel("");
		LENDER_LABEL.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		LENDER_LABEL.setBounds(45, 508, 141, 15);
		add(LENDER_LABEL);
		
		Book_RENTAL_DATE = new JLabel("\uB300\uC5EC\uC77C");
		Book_RENTAL_DATE.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_RENTAL_DATE.setBounds(252, 483, 70, 17);
		add(Book_RENTAL_DATE);
		
		RENTAL_DATE_LABEL = new JLabel("");
		RENTAL_DATE_LABEL.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		RENTAL_DATE_LABEL.setBounds(212, 508, 141, 15);
		add(RENTAL_DATE_LABEL);
		
		Book_RETURN_DATE = new JLabel("\uBC18\uB0A9 \uC608\uC815\uC77C");
		Book_RETURN_DATE.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		Book_RETURN_DATE.setBounds(408, 483, 110, 17);
		add(Book_RETURN_DATE);
		
		RETURN_DATE_LABEL = new JLabel("");
		RETURN_DATE_LABEL.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		RETURN_DATE_LABEL.setBounds(372, 508, 146, 15);
		add(RETURN_DATE_LABEL);
		
		CANCEL_BUTTON = new JButton("\uCDE8\uC18C");
		CANCEL_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		CANCEL_BUTTON.setBounds(438, 574, 80, 28);
		add(CANCEL_BUTTON);
		CANCEL_BUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(false);
			}
		});
		panel = new JPanel();
		panel.setBounds(12, 60, 506, 110);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		table = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			header
		));
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		jp = new JScrollPane(table);
		jp.setEnabled(false);
		panel.add(jp,BorderLayout.CENTER);
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
}
