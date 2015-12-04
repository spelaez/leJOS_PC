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
/**
 * Clase para cargar las imagenes utilizadas para los jugadores
 * @author Santiago Pelaez
 *
 */
@SuppressWarnings("serial")
public class ImageLoading extends JFrame{
	//Campos de clase
	private RectangleImage rImg = null;
	/**
	 * Metodo para poner las imagenes de los jugadores disponibles
	 */
	public void paint(Graphics g){
		this.setSize(640, 400);
		
		if (rImg == null){
			rImg = new RectangleImage(getImage("src/images/1.gif"), 25, 25);
		}
		
		Graphics2D g2 = (Graphics2D)g;
		rImg.move(350, 250);
		rImg.draw(g2, this);
	}//Cierre del metodo
	/**
	 * Metodo para asignar las imagenes
	 * @param path
	 * @return
	 */
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
	}//Cierre del metodo
	/**
	 * Clase para dibujar un icono con las imagenes usadas para los jugadores
	 * @author Santiago Pelaezx
	 *
	 */
	class RectangleImage{
		//Campos de clase
		private Image img = null;
		private Rectangle rect = null;
		/**
		 * Metodo para especificar el icono
		 * @param img
		 * @param x
		 * @param y
		 */
		public RectangleImage(Image img, int x, int y){
			this.img = img;
			ImageIcon icon = new ImageIcon(img);
			this.rect = new Rectangle(x, y, icon.getIconWidth(), icon.getIconHeight());
		}//Cierre del metodo
		/**
		 * Metodo para ver el icono
		 * @return
		 */
		public Rectangle getRect(){
			return this.rect;
		}//Cierre del metodo
		/**
		 * Metodo para ver la imagen 
		 * @return
		 */
		public Image getImg(){
			return this.img;
		}//Cierre del metodo
		/**
		 * Metodo para asignar el desplazamiento 
		 * @param x
		 * @param y
		 */
		public void move(int x, int y){
			this.rect.setBounds(x, y, rect.width, rect.height);
		}//Cierre del metodo
		/**
		 * Metodo para dibijuar el icono
		 * @param g2
		 * @param o
		 */
		public void draw(Graphics2D g2, ImageObserver o){
			g2.drawImage(this.img, this.rect.x, this.rect.y, this.rect.width, this.rect.height, o);
		}//Cierre del metodo		
	}//Cierre de la clase
}//Cierre de la clase
