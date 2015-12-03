package objetos.futbol.UI.GUI;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
class panel1 extends JPanel{
	public void paintComponent(Graphics g) {
		g.setFont(new Font("TimesNewRoman",Font.BOLD,16));
		//g.drawString("Desarrollo", 30, 50);
		g.setFont(new Font("TimesNewRoman",Font.PLAIN,12));
		g.drawString("Programación Orientada a Objetos 2015-2", 30, 205);
		g.drawString("Universidad Nacional de Colombia", 30, 216);
		g.setFont(new Font ("TimesNewRoman", Font.BOLD,16));
		g.drawString("Este proyecto fue realizado por", 30, 55);
		g.setFont(new Font("TimesNewRoman",Font.PLAIN,14));
		g.drawString("Santiago Peláez", 30, 80);
		g.drawString("Jhon Eider Murillo", 30, 95);
		g.drawString("Juan Pablo Betancur", 30, 110);
		g.drawString("Santiago Saldarriaga", 30, 125);
		g.setFont(new Font("TimesNewRoman",Font.PLAIN,14));
		g.drawString("Proyecto realizado con las indicaciones", 30, 150);
		g.drawString("dadas por el profesor en clase con su ayuda", 30, 165);
		g.drawString("y supervición", 30, 180);
		
	}
}

@SuppressWarnings("serial")
public class VentanaAcercaDe extends JFrame {
	Container panel;
	JLabel etiquetaImagen,p1;
	
	public VentanaAcercaDe(){
		super("Acerca de ...");
		panel = getContentPane();
		panel.setLayout(new GridLayout());
		etiquetaImagen = new JLabel(new ImageIcon("src//images//robi.png"));
		
		panel.add(etiquetaImagen,BorderLayout.NORTH);
		panel.add(new panel1());		
			
		setSize(700,300);
		setVisible(true);
	}
}
