package objetos.futbol.UI.menuconsola;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.JugadaCompleja;
/**
 * Clase que define la opción crear jugador, consiste de un ArrayList para guardar las jugadas complejas del jugador nuevo
 * @author Jhon Eider Murilo
 *
 */
public class CrearJugador extends OpcionDeMenu implements ItemListener, ActionListener {
	JFrame jugadores = new JFrame("Creacion de jugador");
	Container contenedor;
	JPanel p1,arriba,centro,abajo,centizq,centder;
	JButton aceptar;
	ButtonGroup bg1,bg2;
	JRadioButton delantero,arquero;
	JTextField nombre,posicion,goles,dorsal;
	ArrayList <JugadaCompleja> jugadas= new ArrayList<>();
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion crear jugador
	 * @param categoria
	 */
	public CrearJugador(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta el menu de crear jugador
	 */
	@Override
	public void ejecutar(){
		//CREACION
		contenedor = jugadores.getContentPane();
		p1 = new JPanel();
		arriba= new JPanel();
		centro=new JPanel();
		abajo=new JPanel();
		bg1= new ButtonGroup();
		delantero = new JRadioButton("delantero");
		arquero = new JRadioButton("arquero");
		nombre=new JTextField();
		posicion=new JTextField();
		goles=new JTextField();
		dorsal=new JTextField();
		centder=new JPanel();
		centizq=new JPanel();
		aceptar=new JButton("Aceptar");
		//Layout
		p1.setLayout(new BorderLayout(10,10));
		arriba.setLayout(new GridLayout(2,1));
		centro.setLayout(new GridLayout(1,2));
		centizq.setLayout(new GridLayout(4,1));
		centder.setLayout(new GridLayout(4,1));
		abajo.setLayout(new GridLayout(Main.listaJugadasComplejas.size(),2));
		//añadir
		p1.add(arriba, BorderLayout.NORTH);
		p1.add(centro, BorderLayout.CENTER);
		p1.add(abajo, BorderLayout.SOUTH);
		contenedor.add(p1);
		bg1.add(arquero);
		bg1.add(delantero);
		arriba.add(arquero);
		arriba.add(delantero);
		centro.add(centizq);
		centro.add(centder);
		abajo.add(new JLabel("Por favor seleccione 3 jugadas para su jugador"));
		for(int i=0;i<Main.listaJugadasComplejas.size();i++){
			JRadioButton z = new JRadioButton(Main.listaJugadasComplejas.get(i).getNombre());
						z.setName(i+"");
						z.addItemListener(new ItemListener(){
							public void itemStateChanged(ItemEvent e) {
								if(z.isSelected()){
									for(int j=0;j<Main.listaJugadasComplejas.size();j++){
										if(z.getText().equals(Main.listaJugadasComplejas.get(j).getNombre())==true){
											if(jugadas.size()<3){
												jugadas.add(Main.listaJugadasComplejas.get(j));
											}
											
										}
									}
									
								}
							}
					});
						abajo.add(z);
		}
		abajo.add(aceptar);
		//listeners
		delantero.addItemListener(this);
		arquero.addItemListener(this);
		aceptar.addActionListener(this);
		jugadores.setSize(400, 400);
		jugadores.setVisible(true);
	}//Cierre del metodo
	/**
	 * Metodo que se ejecuta por una accion en la interfaz
	 */
	public void actionPerformed(ActionEvent arg0) {
				String Nomb,pos;
				short gol;
				byte dor;
				int tiemposingol;
				Nomb=nombre.getText();
				pos=posicion.getText();
				gol=Short.valueOf(goles.getText());
				dor=Byte.valueOf(dorsal.getText());
				tiemposingol= Integer.valueOf(goles.getText());
				jugadores.dispose();
				
				if(delantero.isSelected()){
					Main.listaJugadores.add(new Delantero(Nomb,pos,gol,dor,jugadas));
				}
				if(arquero.isSelected()){
					Main.listaJugadores.add(new Arquero(Nomb,pos,tiemposingol,dor,jugadas));
				}
				JOptionPane.showMessageDialog(this.jugadores,"Jugador registrado correctamente");
			}//Cierre del metodo
	/**
	 * Metodo que se ejecuta cuando el usuario la selecciona a traves de la interfaz
	 */
	public void itemStateChanged(ItemEvent e) {
							if(delantero.isSelected()){
								centizq.removeAll();
								centder.removeAll();
								centizq.add(new JLabel("Nombre"));
								centizq.add(new JLabel("Posicion"));
								centizq.add(new JLabel("GolesMarcados"));
								centizq.add(new JLabel("Dorsal"));
								centder.add(nombre);
								centder.add(posicion);
								centder.add(goles);
								centder.add(dorsal);
								centro.setVisible(false);
								centro.setVisible(true);
	}
							if(arquero.isSelected()){
								centizq.removeAll();
								centder.removeAll();
								centizq.add(new JLabel("Nombre"));
								centizq.add(new JLabel("Posicion"));
								centizq.add(new JLabel("Tiempo Sin goles"));
								centizq.add(new JLabel("Dorsal"));
								centder.add(nombre);
								centder.add(posicion);
								centder.add(goles);
								centder.add(dorsal);
								centro.setVisible(false);
								centro.setVisible(true);
							}
	}//Cierre del metodo
		/*System.out.print("---------------------------------------------------\n"+this+"\n");
		System.out.println("Ingrese tipo jugador");
		System.out.println("1 Delantero \n2 Arquero ");
		try{
			String tipo = Main.scn.nextLine();
			while(Integer.valueOf(tipo) < 1 || Integer.valueOf(tipo) > 2){
				System.out.print("Dato fuera de rango, por favor ingreselo de nuevo");
				tipo = Main.scn.nextLine();
			}
			ArrayList<JugadaCompleja> lista = new ArrayList<>(); 
			System.out.println("Ingrese Nombre");
			String nom = Main.scn.nextLine();
			System.out.println("Ingrese Dorsal");
			String dor = Main.scn.nextLine();
			if(Main.listaJugadasComplejas.size() > 0 ){
				String n;
				while(lista.size()<3){
					new ListaJugadasDisponibles(Categoria.SISTEMA).ejecutar();
					System.out.println("0. Salir");
					try{
						n = Main.scn.nextLine();
						while(Integer.valueOf(n) < 0 || Integer.valueOf(n) > Main.listaJugadasComplejas.size()){
							System.out.println("Dato fuera de rango, porfavor ingrese un entero");
							n = Main.scn.nextLine();
						}
						n =String.valueOf((Integer.valueOf(n)- 1));
						if(Integer.valueOf(n) == -1){
							break;
						}
						else{
							lista.add(Main.listaJugadasComplejas.get(Integer.valueOf(n)));	
						}
					}catch(InputMismatchException e){
						System.out.println("Error: Dato incorrecto, ingrese un entero");
					}catch(NumberFormatException e){
						System.out.println("Dato incorrecto, ingrese un entero");
					}catch(IndexOutOfBoundsException e){
						System.out.println("Dato fuera de rango");
					}
				}
			}
			else{
				System.out.println("No hay jugadas disponibles, porfavor cree una jugada primero");
				return;
			}
			if(Integer.valueOf(tipo) == 1){
				Main.listaJugadores.add(new Delantero(nom,"delantero",(short)0,Byte.valueOf(dor),lista));
			}
			else if( Integer.valueOf(tipo) == 2){
				Main.listaJugadores.add(new Arquero(nom,"arquero",0,Byte.valueOf(dor),lista));
			}
		}catch(InputMismatchException e){
			System.out.println("Error: Dato incorrecto, ingrese un entero");
		}catch(NumberFormatException e){
			System.out.println("Dato incorrecto, ingrese un entero");
		}

	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Crear nuevo Jugador";
	}//Cierre del metodo
}//Cierre de la clase
