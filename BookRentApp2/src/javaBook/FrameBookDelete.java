package javaBook;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import other.dbConnector;

public class FrameBookDelete{
	private JFrame frame;
	private JPanel panel_1 = new JPanel();
	private JTable table;
	private String Book_ISBN;
	private dbConnector dbConn = new dbConnector();
	private DefaultTableModel sourceModel;
	private int clickedTableRow;
	
	public FrameBookDelete() {
		frame = new JFrame("도서 삭제");
		frame.setVisible(true);
		frame.setBounds(100, 100, 555, 689);
		frame.setLocationRelativeTo(null); // 화면 정중앙 배치
		PanelBookInfo book_panel = new PanelBookInfo(frame);
		frame.getContentPane().add(book_panel, BorderLayout.CENTER);
		
		table = book_panel.getJTable();
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
		JButton DELETE_BUTTON = new JButton("삭제");
		DELETE_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		DELETE_BUTTON.setBounds(342, 574, 80, 28);
		book_panel.add(DELETE_BUTTON);
		DELETE_BUTTON.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num =JOptionPane.showConfirmDialog(null,"도서를 삭제 하시겠습니까?","도서 삭제",JOptionPane.ERROR_MESSAGE);
				switch (num) {
					case JOptionPane.YES_OPTION: {
						if(sourceModel.getValueAt(clickedTableRow,5)==null) {
							String sql = "delete from BOOK where BOOK_ISBN = ?";
							Connection tmpConn = dbConn.getConnection();
							try {
								PreparedStatement ps = tmpConn.prepareStatement(sql);
								ps.setString(1, Book_ISBN);
								int count = ps.executeUpdate();
								if(count == 0) {
									JOptionPane.showMessageDialog(null,"ISBN : "+Book_ISBN+"이(는) 삭제에 실패하였습니다.", "도서 삭제",JOptionPane.ERROR_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null,"ISBN : "+Book_ISBN+"로 삭제가 완료되었습니다.", "도서 삭제",JOptionPane.NO_OPTION);
								}
							}
							catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else {
							JOptionPane.showMessageDialog(null,"대여 중에는 삭제가 불가합니다.", "도서 삭제",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose(); //해당 창만 완전 종료함 
			}
		});
		panel_1.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		JLabel Delete_Label = new JLabel("도서 삭제");
		Delete_Label.setForeground(Color.WHITE);
		Delete_Label.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panel_1.add(Delete_Label);
	}
	public JFrame getFrame() {
		return frame;
	}
}