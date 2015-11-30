package objetos.futbol.UI.GUI;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import javafx.scene.paint.Color;
import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.Categoria;
import objetos.futbol.UI.menuconsola.Salir;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class VentanaInicial extends JFrame implements ActionListener, MouseListener {

	Container contenedor;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
	JButton b1,b2,b3;
	JTextArea ta1;
	JScrollPane s1;
	JLabel l1,l2,l3;
	JTextField tf1,tf2;
	int opcion;
	public static int cont =0;
	public VentanaInicial(){
		super("Usuario");}
	public void lanzar(){
		contenedor = this.getContentPane();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p8 = new JPanel();
		p7 = new JPanel();
		p9 = new JPanel();
		p10 = new JPanel();
		b1 = new JButton(new ImageIcon("src\\images\\0.gif"));
		b2 = new JButton("Ingresar Usuario");
		b3 = new JButton("Salir");
		tf1 = new JTextField();
		tf2 = new JTextField();
		l1 = new JLabel("<html><body>Dar click al botón ingresar usuario si desea ingresar como UsuarioGeneral. Si desea ingresar como Administrador ingrese su código de usuario y su clave</body></html>" );
		l2 = new JLabel("Usuario Administrador", SwingConstants.CENTER);
		l3 = new JLabel("Bienvenido al sistema", SwingConstants.CENTER);
		
		ta1 = new JTextArea(8,10);
		ta1.setEditable(false);
		ta1.setLineWrap(true);
		ta1.setWrapStyleWord(true);
		ta1.setText("Este programa fue realizado por Santiago Peláez Rúa, Juan Pablo Betancur Giraldo, Jhon Eider Murillo Usuga y Santiago Saldarriaga Sucerquia El objetivo de este es administrar un partido de futbol  por medio de una interfaz gráfica, donde el usuario pueda jugar el partido  protagonizado por robots LeJos y estar al tanto de las estadísticas de juego, poder ver claramente las jugadas, la posición de cada jugador en la cancha y todas las actividades relacionadas con el partido. Básicamente el programa funciona por medio de eventos en donde el usuario interactúe con la interfaz gráfica y se ejecuten métodos que contribuyan al desarrollo del partido.");
		s1 = new JScrollPane(ta1);
		s1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contenedor.setLayout(new GridLayout(1,2,10,10));
		contenedor.add(p1);
		contenedor.add(p2);
		//orden
		p1.setLayout(new GridLayout(2,1,10,0));
		p2.setLayout(new GridLayout(2,1,10,0));
		p3.setLayout(new BorderLayout(5,5));
		p4.setLayout(new BorderLayout(5,5));
		p5.setLayout(new GridLayout(2,0));
		p6.setLayout(new GridLayout(2,1));
		p7.setLayout(new GridLayout(2,1));
		p8.setLayout(new GridLayout(2,1));
		p9.setLayout(new GridLayout(2,2));
		p10.setLayout(new BorderLayout());
		//elementos panel1
		p1.add(p3);
		p1.add(p4);
		p3.add(l3, BorderLayout.CENTER);
		b1.setLayout(new BorderLayout());

		p4.add(b1, BorderLayout.CENTER);
		//elementos panel2
		p2.add(p5);
		p2.add(p6);
		p5.add(s1);
		p5.add(l1);
		p6.add(p7);
		p6.add(p8);

		p7.add(b2);
		p7.add(l2);
		p8.add(p9);
		p8.add(p10);

		p9.add(new JLabel("Codigo de usuario:"));
		p9.add(tf1);
		p9.add(new JLabel("Clave:"));
		p9.add(tf2);
		p10.add(b3, BorderLayout.CENTER);


		//Eventos
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		l3.addMouseListener(this);
		setSize(450,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		String s = (String)accion.getActionCommand();
		if(s.equals("Ingresar Usuario")){

			String usuario = tf1.getText();
			String clave = tf2.getText();
			if(usuario.length() == 0 && clave.length()==0){
				Main.v1.dispose();
				Main.v1 = new VentanaInicial();
				Main.v2.lanzar();
			}
			else{
				
				if(Main.listaUsuarios.containsKey(usuario) && clave.equals(Main.listaUsuarios.get(usuario).getClave())){
					
				}
				else{
					JOptionPane.showMessageDialog(null,"Porfavor ingrese un usuario y clave validos","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else if(s.equals("Salir")){
			opcion = 0;
			Object [] textOpcion = { "Si", "NO"};
			opcion = JOptionPane.showOptionDialog(null, "¿Desea salir del sistema?", "salir del sistema",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,textOpcion,null);
			if(opcion == 0){
				new Salir(Categoria.SISTEMA).ejecutar();
			}
		}
		else{
			cont ++;
			if(cont >10){
				cont =0;
			}
			if (cont == 0){
				b1.setIcon(new ImageIcon("src\\images\\0.gif"));
			}
			else if(cont == 1){
				b1.setIcon(new ImageIcon("src\\images\\1.gif"));
			}
			else if (cont == 2){
				b1.setIcon(new ImageIcon("src\\images\\2.gif"));
			}
			else if (cont == 3){
				b1.setIcon(new ImageIcon("src\\images\\3.gif"));
			}
			else if (cont == 4){
				b1.setIcon(new ImageIcon("src\\images\\4.gif"));
			}
			else if (cont == 5){
				b1.setIcon(new ImageIcon("src\\images\\5.gif"));
			}
			else if (cont == 6){
				b1.setIcon(new ImageIcon("src\\images\\6.gif"));
			}
			else if (cont == 7){
				b1.setIcon(new ImageIcon("src\\images\\7.gif"));
			}
			else if (cont == 8){
				b1.setIcon(new ImageIcon("src\\images\\8.gif"));
			}
			else if (cont == 9){
				b1.setIcon(new ImageIcon("src\\images\\9.gif"));
			}
			else if (cont == 10){
				b1.setIcon(new ImageIcon("src\\images\\10.gif"));
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		l3.setForeground(java.awt.Color.YELLOW);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		l3.setForeground(java.awt.Color.BLACK);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
