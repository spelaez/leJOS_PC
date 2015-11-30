package objetos.futbol.UI.GUI;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import objetos.futbol.UI.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipalUsuarioGeneral extends JFrame implements ActionListener  {
	Container contenedor;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9;
	JButton b1,b2,b3,enviar;
	JTextArea ta1,ta2;
	JScrollPane s1,s2;
	JLabel l1,l2;
	JTextField tf1;
	JMenuBar menubar;
	JMenu menu1,menu2,menu3;
	JMenuItem delantero,arquero;
    public static int rec =0;
    
	public VentanaPrincipalUsuarioGeneral(){
		super("Futbol");}
	public void lanzar(){
		CanchaCanvas cancha = new CanchaCanvas();
		contenedor = this.getContentPane();
		contenedor.setLayout(new BorderLayout(18,18));
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p3 = new JPanel();
		p3.setBackground(Color.lightGray);
		p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));
		p4 = new JPanel();
		p4.setBackground(Color.lightGray);
		p4.setLayout(new BorderLayout());
		p5 = new JPanel();
		p5.setBackground(Color.BLUE);
		p5.setLayout(new BorderLayout());
		p6 = new JPanel();
		p6.setLayout(new BorderLayout(5,5));
		p8 = new JPanel();
		p8.setLayout(new BorderLayout(5,5));
		p8.setBackground(Color.lightGray);
		p7 = new JPanel();
		p7.setLayout(new BorderLayout(5,5));
		p9 = new JPanel();
		p9.setLayout(new GridLayout(1,2));
		
		l1 = new JLabel("Acciones");
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		b1 = new JButton("Accion 1");
		b1.setAlignmentX(Component.CENTER_ALIGNMENT);
		b2 = new JButton("Accion 2");
		b2.setAlignmentX(Component.CENTER_ALIGNMENT);
		b3 = new JButton("Accion 3");
		b3.setAlignmentX(Component.CENTER_ALIGNMENT);
		l2 = new JLabel("Historia");
		l2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		enviar = new JButton("Enviar");
		tf1 = new JTextField(650);
		ta1 = new JTextArea(5,0);
		ta1.setEditable(false);
		ta1.setLineWrap(true);
		ta1.setWrapStyleWord(true);
		ta2 = new JTextArea();
		ta2.setEditable(false);
		ta2.setLineWrap(true);
		ta2.setWrapStyleWord(true);
		ta2.setBackground(Color.LIGHT_GRAY);
		s1 = new JScrollPane(ta1);
		s1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		s2 = new JScrollPane(ta2);
		s2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		menubar = new JMenuBar();
		
		menu1 = new JMenu("File");
		menu2 = new JMenu("Acciones");
		delantero = new JMenuItem("Delantero");
		arquero = new JMenuItem("Arquero");
		menu2.add(delantero);
		menu2.add(arquero);
		menu3 = new JMenu("Ayuda");
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		contenedor.add(p1, BorderLayout.NORTH );
		contenedor.add(p2, BorderLayout.SOUTH);
		contenedor.add(p6, BorderLayout.WEST);
		contenedor.add(p7, BorderLayout.EAST);
		contenedor.add(p5, BorderLayout.CENTER);
		p1.add(menubar,BorderLayout.NORTH);
		p7.add(p4, BorderLayout.WEST);
		p6.add(p3, BorderLayout.EAST);
		p3.add(l1);
		if(rec == 1){
			p3.add(b1);
			p3.add(b2);
			p3.add(b3);
		}
		p4.add(l2);
		p2.add(new JLabel("Accion n : Dato J"), BorderLayout.NORTH);
		p2.add(p9, BorderLayout.CENTER);
		p9.add(tf1);
		p9.add(enviar);
		p2.add(s1, BorderLayout.SOUTH);
		p4.add(l2,BorderLayout.NORTH);
		p4.add(s2, BorderLayout.CENTER);
		p5.add(cancha, BorderLayout.CENTER);
		//eventos
		delantero.addActionListener(this);
		setSize(650,600);
		setVisible(true);
		setLocationRelativeTo (null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		rec = 1;
		Main.v2.dispose();
		Main.v2 = new VentanaPrincipalUsuarioGeneral();
		Main.v2.lanzar();
		
	}


	

}