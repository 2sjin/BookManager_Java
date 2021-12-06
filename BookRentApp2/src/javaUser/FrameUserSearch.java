package javaUser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;
public class FrameUserSearch {

	private JFrame frame;


	/**
	 * Create the application.
	 */
	public FrameUserSearch() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
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
		
		JLabel TitleLabel = new JLabel("\uD68C\uC6D0 \uC815\uBCF4");
		TitleLabel.setForeground(Color.BLACK);
		TitleLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		TitleLabel.setBounds(12, 43, 95, 22);
		frame.getContentPane().add(TitleLabel);
		
		JPanel TitlePanel = new JPanel();
		TitlePanel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		TitlePanel.setBounds(0, 0, 541, 33);
		frame.getContentPane().add(TitlePanel);
		
		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 \uC870\uD68C");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		TitlePanel.add(lblNewLabel);
		
		JButton CancelButton = new JButton("\uCDE8\uC18C");
		CancelButton.setBorder(new LineBorder(UIManager.getColor("CheckBoxMenuItem.selectionBackground")));
		CancelButton.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
		CancelButton.setFont(new Font("굴림", Font.PLAIN, 17));
		CancelButton.setBounds(432, 613, 95, 29);
		frame.getContentPane().add(CancelButton);
		
		PanelUserInfo ct = new PanelUserInfo();
        ct.setBackground(UIManager.getColor("InternalFrame.activeBorderColor"));
        ct.setBounds(0, 56, 541, 554);
        frame.getContentPane().add(ct);
	}
}