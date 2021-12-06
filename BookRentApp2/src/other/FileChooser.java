package other;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
 
// 파일 선택기 클래스(이미지를 리턴함)
public class FileChooser {
	private static JFileChooser bookImg = new JFileChooser();
	private static FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("All Images", "jpg","jpge","png","gif","svg");
	
	public static ImageIcon getImageIcon(int width, int height) {
		bookImg.setFileFilter(fileFilter);
		bookImg.showOpenDialog(null);
		String filePath = bookImg.getSelectedFile().getPath();
		
		// 이미지 크기 재설정
    	ImageIcon images = new ImageIcon(filePath);          // 경로에서 로드한 Image 파일을 ImageIcon 객체로 생성 
        Image tempImg = images.getImage();                      	          // ImageIcon을 Image로 변환
        tempImg = tempImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);    // Image 크기 재설정
        images = new ImageIcon(tempImg);                                    // 재설정한 Image를 ImageIcon 객체로 재생성
        
        return images;
	}
}
