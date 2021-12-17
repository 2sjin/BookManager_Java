package javaBook;

import java.awt.*;
import javax.swing.*;
import other.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;

public class FrameBookCreate{;
	
	private JFrame frame;
	private JTextField jf[];
	private JTextArea DESCRIPTION_FIELD;
	private JLabel la;
	private dbConnector dbConn = new dbConnector();
	private JFileChooser bookimg;
	// 생성자
	public FrameBookCreate() {
		initialize();
	}

	// 프레임 초기화
	private void initialize() {
		frame = new JFrame("도서 추가");
		frame.setVisible(true);
		
		frame.setBounds(100, 100, 555, 689);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		PanelBookInfo book_panel = new PanelBookInfo(frame);
		
		// 객체 공유
		jf = book_panel.getJTextField();
		DESCRIPTION_FIELD = book_panel.getJTextArea();
		la = book_panel.getJLabel();
		
		book_panel.true_flase_enabled(true);
		book_panel.ComponentSetVisible(false);
		frame.getContentPane().add(book_panel);
		JButton INSERT_BUTTON = new JButton("추가");
		INSERT_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		INSERT_BUTTON.setBounds(342, 574, 80, 28);
		INSERT_BUTTON.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num =JOptionPane.showConfirmDialog(null,"도서를 추가 하시겠습니까?","도서 추가",JOptionPane.ERROR_MESSAGE);
				switch(num) {
				case JOptionPane.YES_OPTION:
					String sql= "insert into BOOK(BOOK_ISBN, BOOK_TITLE, BOOK_AUTHOR, BOOK_PUB, BOOK_PRICE"
							+ ",BOOK_DESCRIPTION,BOOK_IMAGE,BOOK_LINK) values(?,?,?,?,?,?,?,?)";
					Connection tmpConn = dbConn.getConnection();
					try {
						PreparedStatement ps = tmpConn.prepareStatement(sql);
						
						ps.setString(1, jf[0].getText());
						ps.setString(2, jf[1].getText());
						ps.setString(3, jf[2].getText());
						ps.setString(4, jf[3].getText());
						ps.setInt(5, Integer.parseInt(jf[4].getText()));
						ps.setString(6, DESCRIPTION_FIELD.getText());
						String filePath = bookimg.getSelectedFile().getPath();
						
						File tmpFile = new File(filePath);
						ps.setBinaryStream(7,new FileInputStream(tmpFile), tmpFile.length());
						ps.setString(8, jf[5].getText());
						
						System.out.println(jf[0].getText());
						System.out.println(jf[1].getText());
						System.out.println(jf[2].getText());
						System.out.println(jf[3].getText());
						System.out.println(jf[4].getText());
						System.out.println(DESCRIPTION_FIELD.getText());
						System.out.println(jf[5].getText());
						System.out.println(tmpFile.getPath());
						
						int count = ps.executeUpdate();
						if(count == 0) {
							JOptionPane.showMessageDialog(null,"ISBN : "+jf[1].getText()+"이(는) 등록에 실패하였습니다.", "신규도서등록",JOptionPane.ERROR_MESSAGE);
						}else {
							JOptionPane.showMessageDialog(null,"ISBN : "+jf[1].getText()+"이(는) 등록이 완료되었습니다.", "신규도서등록",JOptionPane.NO_OPTION);
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
					break;
				}
			}
		});
		// 이미지 변경
		JButton IMAGE_INSERT_BUTTON = new JButton("이미지 추가");
		IMAGE_INSERT_BUTTON.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
		IMAGE_INSERT_BUTTON.setBounds(22, 438, 141, 23);
		IMAGE_INSERT_BUTTON.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon images = FileChooser.getImageIcon(PanelBookInfo.bookWidth, PanelBookInfo.bookHeight);	// 파일 선택기를 통해 이미지 리턴
				
				bookimg = FileChooser.getJFileChooser();
				String filePath = bookimg.getSelectedFile().getPath();
				System.out.println(filePath);
				book_panel.setBookIcon(images);
			}
		});
		book_panel.add(IMAGE_INSERT_BUTTON);
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose(); //해당 창만 완전 종료함 
			}
		});
		JLabel BOOK_Imformation = new JLabel("도서 추가");
		BOOK_Imformation.setForeground(Color.WHITE);
		BOOK_Imformation.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		panel.add(BOOK_Imformation);
		book_panel.add(INSERT_BUTTON);
	}
}