package javaUser;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

import other.dbConnector;

import java.awt.*;
public class FrameUserOut {

	private JFrame frame;
	dbConnector dbConn = new dbConnector();
	Connection tmpConn = dbConn.getConnection();
	private DefaultTableModel sourceModel;
	private int clickedTableRow;
	String User_Phone;
	String User_Out;
	// 생성자
	public FrameUserOut() {
		
		initialize();
	}

	// 프레임 초기화
	private void initialize() {
		frame = new JFrame("회원 탈퇴");
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
		
		ct.BookList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 이벤트 처리를 위한 table 관련 객제 정보 받기
				JTable sourceTable = (JTable) e.getSource();
				sourceModel = (DefaultTableModel) sourceTable.getModel();
				// 클릭한 행 및 컬럼 위치 확보(클릭한 위치의 정보 출력)
				clickedTableRow = sourceTable.getSelectedRow(); // 행
				User_Phone = (String)sourceModel.getValueAt(clickedTableRow, 0);
				User_Out = (String)sourceModel.getValueAt(clickedTableRow, 4);
				System.out.println(User_Out);
			}
		});	
		JLabel lblNewLabel_1 = new JLabel("회원 정보");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 43, 95, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel Top_Panel = new JPanel();
		Top_Panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		Top_Panel.setBounds(0, 0, 541, 33);
		frame.getContentPane().add(Top_Panel);
		
		JLabel lblNewLabel = new JLabel("회원 탈퇴");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		Top_Panel.add(lblNewLabel);
		
		JButton CancelButton = new JButton("취소");
		CancelButton.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		CancelButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		CancelButton.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		CancelButton.setBounds(432, 613, 95, 29);
		frame.getContentPane().add(CancelButton);
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		frame.getContentPane().add(CancelButton);
		JButton UserOut = new JButton("\uD68C\uC6D0 \uD0C8\uD1F4");
        UserOut.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
        UserOut.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
        UserOut.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
        UserOut.setBounds(325, 613, 95, 29);
        UserOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(User_Out.equals("등록")) {
					int result = JOptionPane.showConfirmDialog(null," 회원을 탈퇴 처리 하시겠습니까?","회원 탈퇴",JOptionPane.YES_NO_OPTION);
					switch(result) {
					case JOptionPane.YES_OPTION:{
						if(sourceModel.getValueAt(clickedTableRow,5).equals("0")) {
							String sql = "UPDATE USER SET USER_OUT_DATE = now() WHERE USER_PHONE = ?";
							
							
							try {
								PreparedStatement ps = tmpConn.prepareStatement(sql);
								ps.setString(1, User_Phone);								
								int count = ps.executeUpdate();
								if(count == 0) {
									JOptionPane.showMessageDialog(null,"전화번호 : "+User_Phone+"이(는) 탈퇴에 실패하였습니다.", "회원 탈퇴",JOptionPane.ERROR_MESSAGE);
								}else {
									JOptionPane.showMessageDialog(null,"전화번호 : "+User_Phone+"회원의 탈퇴가 완료되었습니다.", "회원 탈퇴",JOptionPane.NO_OPTION);
									ct.refreshTable();	// 테이블 새로고침
								}
								
							}catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						else {
							JOptionPane.showMessageDialog(null,"대여 중인 도서 n권을 모두 반납 후 다시 시도해주세요", "회원 탈퇴",JOptionPane.ERROR_MESSAGE);
						}
					}
					}
				}
				else {
					int num = JOptionPane.showConfirmDialog(null," 이 회원은 탈퇴한 회원입니다. 재등록 하시겠습니까?","재가입",JOptionPane.YES_NO_OPTION);
					if(num==JOptionPane.YES_OPTION) {
						String sql2 = "UPDATE USER SET USER_OUT_DATE = NULL WHERE USER_PHONE = '"+User_Phone+"'";
						dbConn.executeUpdate(sql2);
						ct.refreshTable();
					}else {
						ct.refreshTable();
					}
				}			
			}
		});
        frame.getContentPane().add(UserOut);
		ct.Phone.setEnabled(false);
		ct.Name.setEnabled(false);
		ct.Birth.setEnabled(false);
		ct.Sex.setEnabled(false);
		ct.Email.setEnabled(false);
		ct.tf_enabled(false);
        ct.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
        ct.setBounds(0, 56, 541, 554);
        frame.getContentPane().add(ct);
	}
}