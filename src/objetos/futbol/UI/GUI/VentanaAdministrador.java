package objetos.futbol.UI.GUI;

import javax.swing.*;

import objetos.futbol.UI.menuconsola.Categoria;
import objetos.futbol.UI.menuconsola.Salir;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class VentanaAdministrador extends JFrame implements ActionListener {
	Container conte;
	JPanel izq,cent,der,abajo,ab1,ab2,ab3;
	JMenuBar menu;
	JMenu file,acciones,ayuda;
	JButton opcion,enviar;
	JLabel lbizq,lbder;
	JTextArea txtder,txtabajo1,txtabajo2;
	JTextField fieldabajo;
	JScrollPane sder,saba1;
	JMenuItem delantero,salir;
	private MyCanvas canvas = new MyCanvas();
	
	public VentanaAdministrador(){
		super("Futbol");
		conte = this.getContentPane();
		//creacion
		izq=new JPanel(); izq.setBackground(Color.LIGHT_GRAY);
		cent=new JPanel(); //cent.setBackground(Color.GRAY);
		der=new JPanel(); der.setBackground(Color.LIGHT_GRAY);
		abajo=new JPanel();//abajo.setBackground(Color.GRAY);
		ab1=new JPanel(); //ab1.setBackground(Color.YELLOW);
		ab2=new JPanel();//ab2.setBackground(Color.BLUE);
		ab3=new JPanel();//ab3.setBackground(Color.GREEN);
		menu=new JMenuBar();
		file=new JMenu();
		acciones=new JMenu();
		ayuda=new JMenu();
		opcion=new JButton();
		lbizq=new JLabel();
		lbder=new JLabel();
		txtder=new JTextArea(10,10);
		txtabajo1=new JTextArea();txtabajo1.setBackground(Color.LIGHT_GRAY);
		txtabajo2=new JTextArea(4,46);//txtabajo2.setBackground(Color.LIGHT_GRAY);
		fieldabajo= new JTextField();//fieldabajo.setBackground(Color.LIGHT_GRAY);
		enviar=new JButton();
		sder= new JScrollPane(txtder);sder.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		saba1= new JScrollPane(txtabajo2);saba1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		delantero= new JMenuItem();
		salir=new JMenuItem();
		
		//layout
		conte.setLayout(new BorderLayout(7,15));
		izq.setLayout(new GridLayout(10,1));
		der.setLayout(new BorderLayout(2,1));
		abajo.setLayout(new BorderLayout(5,5));
		ab1.setLayout(new GridLayout(2,1));
		ab2.setLayout(new GridLayout(1,2));
		cent.setLayout(new GridLayout(1,1));
		
		//TAMAÑO
		setSize(550,510);
		cent.setSize(400, 320);
		txtabajo2.setSize(550, 150);
		opcion.setSize(500,	500);
		
		//texto
		file.setText("File");
		acciones.setText("Acciones");
		ayuda.setText("Ayuda");
		opcion.setText("dale");
		lbizq.setText("Acciones");
		lbder.setText("Historia");
		enviar.setText("Enviar");
		txtabajo1.setText("Accion n:dato j");
		txtabajo1.setLineWrap(true);
		txtabajo2.setLineWrap(true);
		delantero.setText("Delantero");
		salir.setText("Salir");
		//AÑADIR
			//PRINCIPAL
		conte.add(izq,BorderLayout.WEST);
		conte.add(der,BorderLayout.EAST);
		conte.add(abajo,BorderLayout.SOUTH);
		conte.add(cent, BorderLayout.CENTER);
		conte.add(menu);
		menu.add(file);
		menu.add(acciones);
		menu.add(ayuda);
			//IZQUIERDO
		izq.add(lbizq);
		izq.add(opcion);
			//DERECHA
		der.add(lbder,BorderLayout.NORTH);
		der.add(sder,BorderLayout.CENTER);
			//CENTRO
		cent.add(canvas);
			//ABAJO
		abajo.add(ab1,BorderLayout.NORTH);
		abajo.add(ab3,BorderLayout.CENTER);
				//ab1
		ab1.add(txtabajo1);
		ab1.add(ab2);
				//ab2
		ab2.add(fieldabajo);
		ab2.add(enviar);
				//ab3
		ab3.add(saba1);
			//MENU ACCIONES
		acciones.add(delantero);
			//MENU FILE
		file.add(salir);
		
		
		
		//LISTENERS
		salir.addActionListener(this);
		delantero.addActionListener(this);
		
		
		setJMenuBar(menu);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String s= (String)arg0.getActionCommand();
		if(s.equals("Salir")){
			new Salir(Categoria.SISTEMA).ejecutar();
		}
		else if(s.equals("Delantero")){
			izq.removeAll();
			izq.add(lbizq);
			for (int i=0;i<3;i++){
				izq.add(new JButton("hole"));
			}
			conte.setVisible(false);
			conte.setVisible(true);
		}
	}
}
