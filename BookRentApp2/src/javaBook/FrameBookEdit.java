package javaBook;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import other.*;

public class FrameBookEdit {

	private JFrame frame;
	private JTextField jf[];
	private JTable table;
	private JTextArea DESCRIPTION_FIELD;
	private dbConnector dbConn = new dbConnector();
	private JFileChooser bookimg;
	private DefaultTableModel sourceModel;
	private int clickedTableRow;
	private String Book_ISBN;
	private String filePath=null;

	// 생성자
	public FrameBookEdit() {
		frame = new JFrame("도서 수정");
		frame.setVisible(true);
		frame.setBounds(100, 100, 555, 689);
		PanelBookInfo book_panel = new PanelBookInfo(frame);
		frame.getContentPane().add(book_panel, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null); // 화면 정중앙 배치
		// 객체 공유
		jf = book_panel.getJTextField();
		DESCRIPTION_FIELD = book_panel.getJTextArea();
		table  = book_panel.getJTable();
		bookimg = FileChooser.getJFileChooser();
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 이벤트 처리를 위한 table 관련 객제 정보 받기
				JTable sourceTable = (JTable) e.getSource();
				sourceModel = (DefaultTableModel) sourceTable.getModel();
				// 클릭한 행 및 컬럼 위치 확보(클릭한 위치의 정보 출력)
				clickedTableRow = sourceTable.getSelectedRow(); // 행
				Book_ISBN = (String)sourceModel.getValueAt(clickedTableRow, 0);
			}
		});
		// 이미지 변경
		JButton IMAGE_UPDATE_BUTTON = new JButton("이미지 변경");
		IMAGE_UPDATE_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		IMAGE_UPDATE_BUTTON.setBounds(22, 438, 141, 23);
		IMAGE_UPDATE_BUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon images = FileChooser.getImageIcon(PanelBookInfo.bookWidth, PanelBookInfo.bookHeight);
				bookimg = FileChooser.getJFileChooser();
				filePath = bookimg.getSelectedFile().getPath();
				System.out.println(filePath);
				book_panel.setBookIcon(images);
			}
		});

		book_panel.true_flase_enabled(true);
		book_panel.add(IMAGE_UPDATE_BUTTON);

		JButton UPDATE_BUTTON = new JButton("수정");
		UPDATE_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		UPDATE_BUTTON.setBounds(342, 574, 80, 28);
		UPDATE_BUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 이벤트 처리를 위한 table 관련 객제 정보 받기
				// 클릭한 행 및 컬럼 위치 확보(클릭한 위치의 정보 출력)
				int num = JOptionPane.showConfirmDialog(null, "도서를 수정 하시겠습니까?", "도서 수정", JOptionPane.ERROR_MESSAGE);
				switch (num) {
				case JOptionPane.YES_OPTION: {
						if(sourceModel.getValueAt(clickedTableRow,5)==null && !(filePath==null)) {
							String sql= "update BOOK set BOOK_ISBN = ?, BOOK_TITLE = ?, BOOK_AUTHOR = ?, BOOK_PUB = ?,"
									+ "BOOK_PRICE = ?, BOOK_DESCRIPTION = ?, BOOK_IMAGE = ?,BOOK_LINK = ? "
									+ "where BOOK_ISBN = ?";
							Connection tmpConn = dbConn.getConnection();
							try {
								PreparedStatement ps = tmpConn.prepareStatement(sql);
								ps.setString(1, jf[0].getText());
								ps.setString(2, jf[1].getText());
								ps.setString(3, jf[2].getText());
								ps.setString(4, jf[3].getText());
								ps.setInt(5, Integer.parseInt(jf[4].getText()));
								ps.setString(6, DESCRIPTION_FIELD.getText());
								
								File tmpFile = new File(filePath);
								ps.setBinaryStream(7,new FileInputStream(tmpFile), tmpFile.length());
								ps.setString(8, jf[5].getText());
								ps.setString(9, Book_ISBN);
								int count = ps.executeUpdate();
								if(count == 0) {
									JOptionPane.showMessageDialog(null,"ISBN : "+jf[1].getText()+"이(는) 수정에 실패하였습니다.", "도서 수정",JOptionPane.ERROR_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null,"ISBN : "+jf[1].getText()+"로 수정이 완료되었습니다.", "도서 수정",JOptionPane.NO_OPTION);
								}
							}
							catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else if(sourceModel.getValueAt(clickedTableRow,5)==null && filePath==null) {
							String sql= "update BOOK set BOOK_ISBN = ?, BOOK_TITLE = ?, BOOK_AUTHOR = ?, BOOK_PUB = ?,"
									+ "BOOK_PRICE = ?, BOOK_DESCRIPTION = ?,BOOK_LINK = ? "
									+ "where BOOK_ISBN = ?";
							Connection tmpConn = dbConn.getConnection();
							try {
								PreparedStatement ps = tmpConn.prepareStatement(sql);
								ps.setString(1, jf[0].getText());
								ps.setString(2, jf[1].getText());
								ps.setString(3, jf[2].getText());
								ps.setString(4, jf[3].getText());
								ps.setInt(5, Integer.parseInt(jf[4].getText()));
								ps.setString(6, DESCRIPTION_FIELD.getText());
								ps.setString(7, jf[5].getText());
								ps.setString(8, Book_ISBN);
								int count = ps.executeUpdate();
								if(count == 0) {
									JOptionPane.showMessageDialog(null,"ISBN : "+jf[1].getText()+"이(는) 수정에 실패하였습니다.", "도서 수정",JOptionPane.ERROR_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null,"ISBN : "+jf[1].getText()+"로 수정이 완료되었습니다.", "도서 수정",JOptionPane.NO_OPTION);
									book_panel.refreshTable();	// 테이블 새로고침
								}
							}
							catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else {
							JOptionPane.showMessageDialog(null,"대여 중에는 수정이 불가합니다.", "도서 수정",JOptionPane.ERROR_MESSAGE);
						}
				}
				}
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose(); // 해당 창만 완전 종료함
			}
		});
		book_panel.add(UPDATE_BUTTON);

		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel BOOK_UPDATE = new JLabel("도서 수정");
		BOOK_UPDATE.setForeground(Color.WHITE);
		BOOK_UPDATE.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panel.add(BOOK_UPDATE);
	}
}
