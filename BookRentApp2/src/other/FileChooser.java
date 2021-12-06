package other;

import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.*;
 
// ���� ���ñ� Ŭ����(�̹����� ������)
public class FileChooser {
	private static JFileChooser bookImg = new JFileChooser();
	private static FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("All Images", "jpg","jpge","png","gif","svg");
	
	public static ImageIcon getImageIcon() {
		bookImg.setFileFilter(fileFilter);
		bookImg.showOpenDialog(null);
		String filePath = bookImg.getSelectedFile().getPath();
		
		// �̹��� ũ�� �缳��
    	ImageIcon images = new ImageIcon(filePath);          // ��ο��� �ε��� Image ������ ImageIcon ��ü�� ���� 
        Image tempImg = images.getImage();                      	          // ImageIcon�� Image�� ��ȯ
        tempImg = tempImg.getScaledInstance(155, 207, Image.SCALE_SMOOTH);    // Image ũ�� �缳��
        images = new ImageIcon(tempImg);                                    // �缳���� Image�� ImageIcon ��ü�� �����
        
        return images;
	}
}
