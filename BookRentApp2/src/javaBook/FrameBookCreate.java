package javaBook;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import other.FileChooser;

import java.awt.event.*;
// 안녕
public class FrameBookCreate{

	private JFrame frame;
	private JTextField ISBN_FIELD;
	private JTextField TITLE_FIELD;
	private JTextField AUTHOR_FIELD;
	private JTextField PUB_FIELD;
	private JTextField PRICE_FIELD;
	private JTextField LINK_FIELD;
	private JTextField DESCRIPTION_FIELD;
	private JButton Book_CANCEL;
	private JLabel Image_Label;
	private JButton Image_Change;
	private JPanel panel;

	/**
	 * Create the application.
	 */
	public FrameBookCreate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("도서 추가");
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 550, 340);
		frame.getContentPane().setLayout(null);
		
		JLabel Book_ISBN = new JLabel("ISBN:");
		Book_ISBN.setBounds(210, 30, 50, 15);
		frame.getContentPane().add(Book_ISBN);
		
		JLabel Book_TITLE = new JLabel("제목:");
		Book_TITLE.setBounds(210, 55, 50, 15);
		frame.getContentPane().add(Book_TITLE);
		
		JLabel Book_AUTHOR = new JLabel("저자: ");
		Book_AUTHOR.setBounds(210, 80, 50, 15);
		frame.getContentPane().add(Book_AUTHOR);
		
		JLabel Book_PUB = new JLabel("출판사:");
		Book_PUB.setBounds(210, 105, 50, 15);
		frame.getContentPane().add(Book_PUB);
		
		JLabel Book_PRICE = new JLabel("가격(원):");
		Book_PRICE.setBounds(210, 130, 50, 15);
		frame.getContentPane().add(Book_PRICE);
		
		JLabel Book_LINK = new JLabel("관련링크:");
		Book_LINK.setBounds(210, 155, 64, 15);
		frame.getContentPane().add(Book_LINK);
		
		JLabel Book_DESCRIPTION = new JLabel("도서설명:");
		Book_DESCRIPTION.setBounds(210, 180, 64, 15);
		frame.getContentPane().add(Book_DESCRIPTION);
		
		ISBN_FIELD = new JTextField();
		ISBN_FIELD.setBounds(295, 27, 230, 21);
		frame.getContentPane().add(ISBN_FIELD);
		ISBN_FIELD.setColumns(10);
		
		TITLE_FIELD = new JTextField();
		TITLE_FIELD.setColumns(10);
		TITLE_FIELD.setBounds(295, 52, 230, 21);
		frame.getContentPane().add(TITLE_FIELD);
		
		AUTHOR_FIELD = new JTextField();
		AUTHOR_FIELD.setColumns(10);
		AUTHOR_FIELD.setBounds(295, 77, 230, 21);
		frame.getContentPane().add(AUTHOR_FIELD);
		
		PUB_FIELD = new JTextField();
		PUB_FIELD.setColumns(10);
		PUB_FIELD.setBounds(295, 102, 230, 21);
		frame.getContentPane().add(PUB_FIELD);
		
		PRICE_FIELD = new JTextField();
		PRICE_FIELD.setColumns(10);
		PRICE_FIELD.setBounds(295, 127, 230, 21);
		frame.getContentPane().add(PRICE_FIELD);
		
		LINK_FIELD = new JTextField();
		LINK_FIELD.setColumns(10);
		LINK_FIELD.setBounds(295, 152, 230, 21);
		frame.getContentPane().add(LINK_FIELD);
		
		DESCRIPTION_FIELD = new JTextField();
		DESCRIPTION_FIELD.setColumns(10);
		DESCRIPTION_FIELD.setBounds(295, 177, 230, 60);
		frame.getContentPane().add(DESCRIPTION_FIELD);
		
		JButton Book_CREATE = new JButton("추가");
		Book_CREATE.setBounds(376, 254, 69, 30);
		Book_CREATE.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null,"도서를 추가 하시겠습니까?","도서 추가",JOptionPane.YES_NO_OPTION);
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				e.getWindow().dispose(); //해당 창만 완전 종료함 
			}
		});
		frame.getContentPane().add(Book_CREATE);
		
		Book_CANCEL = new JButton("취소");
		Book_CANCEL.setBounds(457, 254, 69, 30);
		frame.getContentPane().add(Book_CANCEL);
		Book_CANCEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		Image_Label = new JLabel("");
		Image_Label.setOpaque(true);
		Image_Label.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		Image_Label.setBounds(24, 30, 155, 207);
		frame.getContentPane().add(Image_Label);
		
		// 이미지 파일 선택
		Image_Change = new JButton("이미지 변경");
		Image_Change.setBounds(24, 254, 155, 30);
		Image_Change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon images = FileChooser.getImageIcon();	// 파일 선택기를 통해 이미지 리턴
				Image_Label.setIcon(images);
			}
		});
		frame.getContentPane().add(Image_Change);
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		panel.setBounds(0, 0, 536, 25);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("도서 추가");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		panel.add(lblNewLabel);
	}
	public JFrame getFrame() {
		return frame;
	}
}