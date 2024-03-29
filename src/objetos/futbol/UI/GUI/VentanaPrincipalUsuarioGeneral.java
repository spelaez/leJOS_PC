package objetos.futbol.UI.GUI;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import objetos.futbol.UI.Main;
import objetos.futbol.UI.menuconsola.Categoria;
import objetos.futbol.UI.menuconsola.Salir;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.varios.UsuarioAdministrador;
import objetos.futbol.varios.UsuarioGeneral;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
/**
 * Clase para crear la ventana para un usuario genera
 * @author Santiago Pelaez, Jhon Eider Murillo Usuga, Juan Pablo Betancur
 *
 */
@SuppressWarnings("serial")
public class VentanaPrincipalUsuarioGeneral extends JFrame implements ActionListener  {
	//Campos de clase
	Container contenedor;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9;
	public JButton b1,b2,b3,enviar;
    public JTextArea ta1,ta2;
	JScrollPane s1,s2;
	JLabel l1,l2;
	JTextField tf1;
	CanchaCanvas cancha;
	Image iCancha;
    /**
     * Constructor para nombrar la ventana
     */
	public VentanaPrincipalUsuarioGeneral(){
		super("Futbol");
		}//Cierre del constructor
	/**
	 * Metodo para lanzar la ventana del usuario general
	 * @throws IOException
	 */
	public void lanzar() throws IOException{
		cancha = new CanchaCanvas();
		iCancha = ImageIO.read(new File("src/images/cancha.png"));
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
		JLabel canchita = new JLabel(new ImageIcon(iCancha));
		canchita.setSize(canchita.getWidth(), canchita.getHeight());
		p5.setSize(canchita.getSize());
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
		ta1.setText("Escriba salir y de clic en enviar si desea salir de emergencia");
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
		if(Main.tipo ==1){
			this.setJMenuBar(((UsuarioGeneral)Main.usuarioActual).getMenu());}
		else if(Main.tipo == 2){
			this.setJMenuBar(((UsuarioAdministrador)Main.usuarioActual).getMenu());
		}
		contenedor.add(p1, BorderLayout.NORTH );
		contenedor.add(p2, BorderLayout.SOUTH);
		contenedor.add(p6, BorderLayout.WEST);
		contenedor.add(p7, BorderLayout.EAST);
		contenedor.add(p5, BorderLayout.CENTER);
		p7.add(p4, BorderLayout.WEST);
		p6.add(p3, BorderLayout.EAST);
		p3.add(l1);
		p4.add(l2);
		p2.add(new JLabel("Accion n : Dato J"), BorderLayout.NORTH);
		p2.add(p9, BorderLayout.CENTER);
		p9.add(tf1);
		p9.add(enviar);
		p2.add(s1, BorderLayout.SOUTH);
		p4.add(l2,BorderLayout.NORTH);
		p4.add(s2, BorderLayout.CENTER);
		p5.add(canchita, BorderLayout.CENTER);
		enviar.addActionListener(this);
		setSize(850,600);
		setVisible(true);
		setLocationRelativeTo (null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//Cierre del metodo
	/**
	 * Metodo para ver el panel
	 * @return
	 */
	public JPanel getP3(){
		return p3;
	}//Cierre del metodo
	/**
	 * Metodo para ver la cancha
	 */
	public JPanel getCancha(){
		return p5;
	}//Cierre del metodo
	/**
	 * Metodo que se ejecuta por una accion en la interfaz
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(tf1.getText().equals("salir")){
			new Salir(Categoria.SISTEMA).ejecutar();
		}
		if(Main.tipoOpcion==1){
		Main.s = tf1.getText();
		tf1.setText(null);
		ta1.setText(null);
		String i = "1";
		try{
			String n = Main.s;
			while(Integer.valueOf(n) < 0 || Integer.valueOf(n) > Main.listaJugadores.size()){
				ta1.append("Dato fuera de rango, por favor ingreselo de nuevo");
			n = Main.s;
			}
			
			Futbolista x = Main.listaJugadores.get(Integer.valueOf(n)-1);
			if( x instanceof Delantero){
				x = (Delantero)x;
				ta1.append(x.toString());
				for(JugadaCompleja c : x.getListaJugadas()){
					
					ta1.append("\n"+i + " " + c);
					i=String.valueOf((Integer.valueOf(i)+1));
				}
			}
			else if( x instanceof Arquero){
				x = (Arquero)x;
				ta1.append(x.toString());
				for(JugadaCompleja c : x.getListaJugadas()){
					
					ta1.append("\n"+i + " " + c);
					i=String.valueOf((Integer.valueOf(i)+1));
				}
			}
		}
		catch(NumberFormatException e){
			ta1.append("Dato incorrecto, ingrese un entero");
		}
		catch(InputMismatchException e){
			ta1.append("Error: dato incorrecto");
		}
		
	}
		else if(Main.tipoOpcion==2){
			Main.s = tf1.getText();
			tf1.setText(null);
			ta1.setText(null);
			try{
				String n = Main.s;
				while(Integer.valueOf(n) < 0 || Integer.valueOf(n) > Main.listaJugadores.size()){
					ta1.append("Dato fuera de rango, por favor ingreselo de nuevo");
					n = Main.s;
				}
				
				
				ta1.append(Main.listaJugadasComplejas.get(Integer.valueOf(n)-1).getExplicacion());
				
			}
			catch(NumberFormatException e){
				ta1.append("Dato incorrecto, ingrese un entero");
			}
			catch(InputMismatchException e){
				ta1.append("Error: dato incorrecto");
			}
		}
		else if(Main.tipoOpcion ==3){
			
				if(Main.aux ==1){
					Main.s = tf1.getText();
					tf1.setText(null);
					ta1.setText(null);
					try{
						String ind = Main.s;
						while(Integer.valueOf(ind) < 1 || Integer.valueOf(ind) > 3){
							ta1.append("Porfavor ingrese una jugada de la lista");
							ind = Main.s;
						}
						Main.r1.ejecutarJugadaCompleja(Integer.valueOf(ind)-1, Main.dis1, Main.dos1);
						if(Main.tInicio != 0){
							Main.gestorEstado.crearBuffer(Main.r1.getJugador(), Main.r1.getJugador().getListaJugadas().get(Integer.valueOf(ind)-1));
						}
					}catch(NumberFormatException e){
						ta1.append("Porfavor ingrese una jugada de la lista");
					}catch(InputMismatchException e){
						ta1.append("Porfavor ingrese una jugada de la lista");
					}catch(IOException e){
						ta1.append("No existe jugada");
					}
				}
				else if(Main.aux ==2){
					try{
						String ind = Main.s;
						while(Integer.valueOf(ind) < 1 || Integer.valueOf(ind) > 3){
							ta1.append("Porfavor ingrese una jugada de la lista");
							ind = Main.s;
						}
						Main.r2.ejecutarJugadaCompleja(Integer.valueOf(ind)-1,Main.dis2,Main.dos2);
						if(Main.tInicio != 0){
							Main.gestorEstado.crearBuffer(Main.r2.getJugador(), Main.r2.getJugador().getListaJugadas().get(Integer.valueOf(ind)-1));
						}
					}catch(NumberFormatException e){
						ta1.append("Porfavor ingrese una jugada de la lista");
					}catch(InputMismatchException e){
						ta1.append("Porfavor ingrese una jugada de la lista");
					}catch(IOException e){
						ta1.append("No existe jugada");
					}
				}
			}
	
		}//Cierre del metodo		
}//Cierre de la clase