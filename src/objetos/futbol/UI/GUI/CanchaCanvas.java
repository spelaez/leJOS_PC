package objetos.futbol.UI.GUI;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CanchaCanvas extends JFrame{
	
	private MyCanvas canvas = new MyCanvas();
	
	public CanchaCanvas(){
		setLayout(new BorderLayout());
		setSize(400, 320);
		setTitle("Cancha demo");
		add("Center", canvas);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	public static void main(String [] args){
		CanchaCanvas cc = new CanchaCanvas();
	}


	private class MyCanvas extends Canvas{
		@Override
		public void paint(Graphics g){
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, 400, 100);
			g.setColor(Color.BLACK);
			g.fillRect(0, 100, 100, 100);
			g.fillRect(300, 100, 100, 100);
			g.setColor(new Color(0, 100, 0));
			g.fillRect(100, 100, 200, 100);
			g.setColor(Color.YELLOW);
			g.fillRect(0, 200, 400, 100);
			
		}
	}
	
}
