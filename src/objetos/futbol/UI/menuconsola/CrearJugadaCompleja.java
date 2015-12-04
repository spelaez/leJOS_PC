package objetos.futbol.UI.menuconsola;

import java.util.InputMismatchException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import objetos.futbol.UI.Main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import objetos.futbol.robots.JugadaPrimitiva;
import objetos.futbol.jugadores.JugadaCompleja;
import objetos.futbol.jugadores.JugadaComplejaDefensiva;
import objetos.futbol.jugadores.JugadaComplejaOfensiva;
import objetos.futbol.jugadores.JugadaComplejaTiroLibre;
import objetos.futbol.varios.UsuarioAdministrador;
/**
 * Clase que define la opncion crear jugada compleja
 * @author Santiago Saldarriaga
 *
 */
@SuppressWarnings("serial")
public class CrearJugadaCompleja extends OpcionDeMenu implements ItemListener, ActionListener {
	JFrame jugadores = new JFrame("Creacion de jugada");
	Container contenedor;
	JPanel p1,arriba,centro,abajo,centizq,centder;
	JButton aceptar;
	ButtonGroup bg1,bg2;
	JRadioButton ofensiva,defensiva,tirolibre,correr,trotar,gizq,gder,chutar,patear,retroceder;
	JTextField nombre,fecha,explicacion;
	ArrayList <JugadaPrimitiva> jugadas= new ArrayList<>();
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion crear jugada compleja
	 * @param categoria
	 */
	public CrearJugadaCompleja(Categoria categoria) {
		super(categoria);		
	}//Cierre del constructor
	/**
	 * Metodo sobreescrito que ejecuta el menu para crear una jugada compleja
	 */
	@Override
	public void ejecutar() {
		//CREACION
		contenedor = jugadores.getContentPane();
		p1 = new JPanel();
		arriba= new JPanel();
		centro=new JPanel();
		abajo=new JPanel();
		bg1= new ButtonGroup();
		ofensiva = new JRadioButton("Jugada Ofensiva");
		defensiva = new JRadioButton("Jugada Defensiva");
		tirolibre=new JRadioButton("Jugada Tiro Libre");
		chutar = new JRadioButton("Chutar");
		patear = new JRadioButton("Patear");
		gder = new JRadioButton("Girar Derecha");
		gizq = new JRadioButton("Girar Izquierda");
		correr = new JRadioButton("Correr");
		trotar = new JRadioButton("trotar");
		retroceder = new JRadioButton("Retroceder");
		nombre=new JTextField();
		fecha=new JTextField();
		explicacion=new JTextField();
		centder=new JPanel();
		centizq=new JPanel();
		aceptar=new JButton("Aceptar");
		//Layout
		p1.setLayout(new BorderLayout(10,10));
		arriba.setLayout(new GridLayout(3,1));
		centro.setLayout(new GridLayout(1,2));
		centizq.setLayout(new GridLayout(3,1));
		centder.setLayout(new GridLayout(3,1));
		abajo.setLayout(new GridLayout(8,1));
		//añadir
		p1.add(arriba, BorderLayout.NORTH);
		p1.add(centro, BorderLayout.CENTER);
		p1.add(abajo, BorderLayout.SOUTH);
		contenedor.add(p1);
		bg1.add(ofensiva);
		bg1.add(defensiva);
		bg1.add(tirolibre);
		arriba.add(ofensiva);
		arriba.add(defensiva);
		arriba.add(tirolibre);
		centro.add(centizq);
		centro.add(centder);
		centizq.add(new JLabel("Nombre"));
		centizq.add(new JLabel("Fecha de Creacion"));
		centizq.add(new JLabel("Explicacion"));
		centder.add(nombre);
		centder.add(fecha);
		centder.add(explicacion);
		abajo.add(trotar);
		abajo.add(correr);
		abajo.add(chutar);
		abajo.add(patear);
		abajo.add(gder);
		abajo.add(gizq);
		abajo.add(retroceder);
		abajo.add(aceptar);

		//listeners
		ofensiva.addItemListener(this);
		defensiva.addItemListener(this);
		tirolibre.addItemListener(this);
		aceptar.addActionListener(this);
		correr.addItemListener(this);
		trotar.addItemListener(this);
		gizq.addItemListener(this);
		gder.addItemListener(this);
		chutar.addItemListener(this);
		patear.addItemListener(this);
		retroceder.addItemListener(this);
		
		jugadores.setSize(400, 400);
		jugadores.setVisible(true);
	}	
	public void actionPerformed(ActionEvent arg0) {
		String s = (String)arg0.getActionCommand();
		if(s.equals("Aceptar")){
		String Nomb,fech,expli;
		Nomb=nombre.getText();
		fech=fecha.getText();
		expli=explicacion.getText();
		if(ofensiva.isSelected()){
			Main.listaJugadasComplejas.add(new JugadaComplejaOfensiva(Nomb,fech,(UsuarioAdministrador) Main.usuarioActual,jugadas,expli));
		}
		if(defensiva.isSelected()){
			Main.listaJugadasComplejas.add(new JugadaComplejaDefensiva(Nomb,fech,(UsuarioAdministrador) Main.usuarioActual,jugadas,expli));
		}
		if(tirolibre.isSelected()){
			Main.listaJugadasComplejas.add(new JugadaComplejaTiroLibre(Nomb,fech,(UsuarioAdministrador) Main.usuarioActual,jugadas,expli));
		}
		jugadores.dispose();
		
		JOptionPane.showMessageDialog(this.jugadores,"Jugada Compleja creada exitosamente");
	}
		}
	public void itemStateChanged(ItemEvent e) {
		if(chutar.isSelected()){
			jugadas.add(Main.chutar);
		}
		if(patear.isSelected()){
			jugadas.add(Main.patear);
		}
		if(correr.isSelected()){
			jugadas.add(Main.correr);
		}
		if(trotar.isSelected()){
			jugadas.add(Main.trotar);
		}
		if(gizq.isSelected()){
			jugadas.add(Main.girarIzquierda);
		}
		if(gder.isSelected()){
			jugadas.add(Main.girarDerecha);
		}
		if(retroceder.isSelected()){
			jugadas.add(Main.retroceder);
		}
	}



	/*	System.out.println("---------------------------------------------------\n"+this+"\n");
		System.out.println("Ingrese el tipo de jugada compleja");
		System.out.println("1 Defensiva \n2 Ofensiva \n3 Tiro libre");

		try{
			String n = Main.scn.nextLine();
			while(Integer.valueOf(n) < 1 || Integer.valueOf(n) > 3){
				System.out.println("Dato fuera de rango, por favor ingreselo de nuevo");
				n = Main.scn.nextLine();
			}			
			System.out.println("Ingrese nombre de la jugada");
			String nom = Main.scn.nextLine();
			System.out.println("Ingrese fecha de creacion Dia-Mes-Año");
			String fecha = Main.scn.nextLine();				
			System.out.println("Ingrese una explicacion");
			String expl = Main.scn.nextLine();	
			ArrayList <JugadaPrimitiva> lista = new ArrayList<>();
			String num;

			do{
				System.out.println("1. Trotar \n2. Correr \n3. Retroceder \n4. Girar derecha \n5. Girar izquierda \n6. Chute normal \n7. Chute fuerte \n0 Salir" );
				num = Main.scn.nextLine();						
				if(Byte.valueOf(num) == 1){
					lista.add(Main.trotar);
				}
				else if(Byte.valueOf(num)== 2){
					lista.add(Main.correr);
				}
				else if(Byte.valueOf(num)== 3){
					lista.add(Main.retroceder);
				}
				else if(Byte.valueOf(num) == 4){
					lista.add(Main.girarDerecha);
				}
				else if(Byte.valueOf(num) == 5){
					lista.add(Main.girarIzquierda);
				}
				else if(Byte.valueOf(num)== 6){
					lista.add(Main.chutar);
				}
				else if(Byte.valueOf(num) == 7){
					lista.add(Main.patear);
				}
			}while(Byte.valueOf(num) != 0);


			if(Integer.valueOf(n) == 1){				
				Main.listaJugadasComplejas.add(new JugadaComplejaDefensiva(nom, fecha,  (UsuarioAdministrador)Main.usuarioActual, lista, expl ));				
			}
			else if( Integer.valueOf(n) == 2){
				Main.listaJugadasComplejas.add(new JugadaComplejaOfensiva(nom, fecha,  (UsuarioAdministrador)Main.usuarioActual, lista, expl ));
			}
			else if(Integer.valueOf(n) == 3){
				Main.listaJugadasComplejas.add(new JugadaComplejaTiroLibre(nom, fecha,  (UsuarioAdministrador)Main.usuarioActual, lista, expl ));		
			}	
		}
		catch(NumberFormatException e){
			System.out.println("Dato incorrecto, ingrese un entero");
		}
		catch(InputMismatchException e){
			System.out.println("Error: dato incorrecto");
		}

	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	public String toString(){
		return "Crear nueva jugada compleja";
	}//Cierre del metodo
}//Cierre de la clase
