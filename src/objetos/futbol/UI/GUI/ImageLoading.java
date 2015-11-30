package objetos.futbol.UI.GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ImageLoading extends JFrame{
	
	private RectangleImage rImg = null;
	
	public void paint(Graphics g){
		this.setSize(640, 400);
		
		if (rImg == null){
			rImg = new RectangleImage(getImage("src/images/1.gif"), 25, 25);
		}
		
		Graphics2D g2 = (Graphics2D)g;
		rImg.move(350, 250);
		rImg.draw(g2, this);
	}
	
	public Image getImage(String path){
		Image tempImage = null;
		try{
			URL imageURL = ImageLoading.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		}
		catch(Exception e){
			System.out.println("Ocurrio un error - " + e.getMessage());
		}
		return tempImage;
	}
	
	class RectangleImage{
		private Image img = null;
		private Rectangle rect = null;
		
		public RectangleImage(Image img, int x, int y){
			this.img = img;
			ImageIcon icon = new ImageIcon(img);
			this.rect = new Rectangle(x, y, icon.getIconWidth(), icon.getIconHeight());
		}
		
		public Rectangle getRect(){
			return this.rect;
		}
		
		public Image getImg(){
			return this.img;
		}
		
		public void move(int x, int y){
			this.rect.setBounds(x, y, rect.width, rect.height);
		}
		
		public void draw(Graphics2D g2, ImageObserver o){
			g2.drawImage(this.img, this.rect.x, this.rect.y, this.rect.width, this.rect.height, o);
		}
		
	}
	
	public static void main(String[] args){
		
	}
}
