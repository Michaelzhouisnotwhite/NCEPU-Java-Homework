import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel{
	Image image=null;
	Board(){
		setImage();
	}
	void setImage () {
		try {
			image=ImageIO.read(new File("E:\\1.jpg"));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public void paintComponet(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
