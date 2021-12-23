package javaUser;

import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import other.FileChooser;
import other.dbConnector;
public class FrameUserEdit {

	private JFrame frame;
	private dbConnector dbConn = new dbConnector();
	JFileChooser userimg;
	String filePath=null;
	private DefaultTableModel sourceModel;
	private int clickedTableRow;
	private String User_Phone;
	int sexcheck;
	// 생성자
	public FrameUserEdit() {
		
		initialize();
	}

	// 프레임 초기화
	private void initialize() {
		frame = new JFrame("회원 정보 수정");
		frame.setVisible(true);
		frame.getContentPane().setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		frame.setBounds(100, 100, 555, 689);
		frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose(); //해당 창만 완전 종료함 
            }
        });
		frame.getContentPane().setLayout(null);
		PanelUserInfo ct = new PanelUserInfo();
		JLabel lblNewLabel_1 = new JLabel("회원 정보");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 43, 95, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel Top_Panel = new JPanel();
		Top_Panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		Top_Panel.setBounds(0, 0, 541, 33);
		frame.getContentPane().add(Top_Panel);
		
		JLabel lblNewLabel = new JLabel("회원 정보 수정");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		Top_Panel.add(lblNewLabel);
		
		ct.ImageChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon images = FileChooser.getImageIcon(119, 140);
				userimg = FileChooser.getJFileChooser();
				filePath = userimg.getSelectedFile().getPath();
				System.out.println(filePath);
				ct.ImageUser.setIcon(images);
			}
		});
		
		ct.BookList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 이벤트 처리를 위한 table 관련 객제 정보 받기
				JTable sourceTable = (JTable) e.getSource();
				sourceModel = (DefaultTableModel) sourceTable.getModel();
				// 클릭한 행 및 컬럼 위치 확보(클릭한 위치의 정보 출력)
				clickedTableRow = sourceTable.getSelectedRow(); // 행
				User_Phone = (String)sourceModel.getValueAt(clickedTableRow, 0);
			}
		});
		JButton CancelButton = new JButton("취소");
		CancelButton.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		CancelButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		CancelButton.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		CancelButton.setBounds(432, 613, 95, 29);
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(CancelButton);
		JButton EditButton = new JButton("수정");
		EditButton.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		EditButton.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		EditButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		EditButton.setBounds(325, 613, 95, 29);
		EditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null," 회원 정보를 수정 하시겠습니까?","회원 정보 수정",JOptionPane.YES_NO_OPTION);
				switch(result) {
				case JOptionPane.YES_OPTION:{
					String sql = "update USER set USER_PHONE = ?, USER_NAME = ?, USER_BIRTH = ?, USER_SEX = ?,"
							+" USER_MAIL = ?, USER_IMAGE = ? WHERE USER_PHONE = ?";
					Connection tmpConn = dbConn.getConnection();
					if(ct.Sex.getText().equals("남자")) {
						sexcheck=0;
					}
					else
						sexcheck=1;
					try {
						PreparedStatement ps = tmpConn.prepareStatement(sql);
						ps.setString(1, ct.Phone.getText());
						ps.setString(2, ct.Name.getText());
						ps.setString(3, ct.Birth.getText());
						ps.setInt(4, sexcheck);
						ps.setString(5, ct.Email.getText());
						File tmpFile = new File(filePath);
						ps.setBinaryStream(6,new FileInputStream(tmpFile), tmpFile.length());
						ps.setString(7, User_Phone);
						int count = ps.executeUpdate();
						if(count == 0) {
							JOptionPane.showMessageDialog(null,"ISBN : "+ct.Name.getText()+"이(는) 수정에 실패하였습니다.", "도서 수정",JOptionPane.ERROR_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null,"ISBN : "+ct.Name.getText()+"로 수정이 완료되었습니다.", "도서 수정",JOptionPane.NO_OPTION);
						}
					}catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
			}
		});
		frame.getContentPane().add(EditButton);

        ct.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
        ct.setBounds(0, 56, 541, 554);
        frame.getContentPane().add(ct);
	}
}