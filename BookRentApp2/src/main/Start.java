package main;

import java.awt.*;

// 프로그램 시작 시 Main 메소드를 호출하는 클래스
public class Start {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new FrameMain();
				} catch (Exception e) {
					e.printStackTrace();
				}			}
		});
	}
}
