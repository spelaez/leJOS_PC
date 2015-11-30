package objetos.futbol.UI.menuconsola;

import java.util.Comparator;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.util.ArrayList;
import objetos.futbol.UI.menuconsola.Trotar;
/**
 * Clase que define al menu de consola 
 * @author Santiago Pelaez
 *
 */
@SuppressWarnings("serial")
public class MenuDeConsola extends JMenuBar{
	//Campos de la clase
	public static ArrayList<OpcionDeMenu> opciones2 = new ArrayList<>();
	public ArrayList<OpcionDeMenu> opciones;
	private JMenu archivo;
	private JMenu acciones;
	private JMenu delantero;
	private JMenu arquero;
	/**
	 * Metodo que carga las opciones del menu
	 */
	public MenuDeConsola(){
		super();
		delantero = new JMenu("Delantero");
		arquero = new JMenu("Arquero");
		acciones = new JMenu("Acciones");
		archivo = new JMenu("Archivo");
		this.add(archivo);
		this.add(acciones);
		acciones.add(arquero);
		acciones.add(delantero);
		setVisible(true);
		cargarOpciones();
	}//Cierre del metodo
	
	Comparator<OpcionDeMenu> c = new Comparator<OpcionDeMenu>() {
		/**
		 * Metodo que compara si las opciones son iguales
		 */
		@Override
		public int compare(OpcionDeMenu o1, OpcionDeMenu o2) {
			return o1.categoria.compareTo(o2.categoria);
		}//Cierre del metodo
		
	};
	/**
	 * Metodo que permite agregar opciones de menu y ordenarla
	 * @param op
	 */
	public void anadirOpcion(OpcionDeMenu op){
		opciones.add(op);
		ordenarOpciones();
	}//Cierre del metodo
	/**
	 * Metodo que permite eliminar una opcion de menu
	 * @param op
	 */
	public void eliminarOpcion(OpcionDeMenu op){
		opciones.remove(op);
	}//Cierre del metodo
	/**
	 * Metodo que permite limpiar la lista de opciones de menu
	 */
	public void limpiar(){
		opciones = new ArrayList<OpcionDeMenu>();
	}//Cierre del metodo
	/**
	 * Metodo que permite ordenar las opciones de menu
	 */
	public void ordenarOpciones(){
		opciones.sort(c);
	}//Cierre del metodo
	/**
	 * ejecuta el metodo lanzar menu que muestra las opciones disponibles a elegir
	 */
	/*public void lanzarMenu(){
		String option;
		for(int i = 0; i < opciones.size(); i++){
			if(i == 0){
				System.out.println("Opciones de Arquero\n----------------------------------");
			}
			else if (i == 10){
				System.out.println("Opciones de Delantero\n----------------------------------");
			}
			else if (i == 19){
				System.out.println("Opciones de Sistema\n----------------------------------");
			}
			System.out.println((i+1) +" "+ opciones.get(i));
		}
		System.out.println("\n Por favor ingrese el numero de la opcion que desea ejecutar");
		try{
		option = Main.scn.nextLine();
		while (Integer.valueOf(option) < 0 || Integer.valueOf(option) > opciones.size()){
			System.out.println("Dato fuera del rango, Ingrese el dato de nuevo: ");
			option = Main.scn.nextLine();
		}
		opciones.get(Integer.valueOf(option)-1).ejecutar();
		}
		catch(NumberFormatException e){
			System.out.println("Error: Dato incorrecto");
		}
		catch(InputMismatchException e){
			System.out.println("Error: Dato incorrecto");
		}
		
	}*/
	//Cierre del metodo
	/**
	 * Metodo que agrega todas las opciones de menu a una segunda lista
	 */
	private void cargarOpciones(){
		if(opciones2.size() == 0){
			
			//Opciones Arquero
			opciones2.add(new Trotar(Categoria.ARQUERO));// 1
			opciones2.add(new Correr(Categoria.ARQUERO));// 2
			opciones2.add(new Retroceder(Categoria.ARQUERO));// 3
			opciones2.add(new GirarDerecha(Categoria.ARQUERO));// 4
			opciones2.add(new GirarIzquierda(Categoria.ARQUERO));// 5
			opciones2.add(new Chutar(Categoria.ARQUERO));// 6
			opciones2.add(new Patear(Categoria.ARQUERO));// 7
			opciones2.add(new EjecutarJugadaCompleja(Categoria.ARQUERO)); //8
			opciones2.add(new RegistrarTiempoSinGoles(Categoria.ARQUERO));// 9
			opciones2.add(new RegistrarTiempoUltimoGol(Categoria.ARQUERO));// 10
			
			//Opciones Delantero
			opciones2.add(new Trotar(Categoria.DELANTERO));//11
			opciones2.add(new Correr(Categoria.DELANTERO));//12
			opciones2.add(new Retroceder(Categoria.DELANTERO));//13
			opciones2.add(new GirarDerecha(Categoria.DELANTERO));//14
			opciones2.add(new GirarIzquierda(Categoria.DELANTERO));//15
			opciones2.add(new Chutar(Categoria.DELANTERO));//16
			opciones2.add(new Patear(Categoria.DELANTERO));//17	
			opciones2.add(new EjecutarJugadaCompleja(Categoria.DELANTERO)); //18
			opciones2.add(new RegistrarGolAFavor(Categoria.DELANTERO));//19
			
			//Opciones Sistema
			opciones2.add(new MostrarCancha(Categoria.SISTEMA));//20 todos
			opciones2.add(new CrearJugador(Categoria.SISTEMA));//21  //Solo admin
			opciones2.add(new ConsultarExplicacionJugada(Categoria.SISTEMA));//22 //todos
			opciones2.add(new ConsultarInfoJugador(Categoria.SISTEMA));//23 //todos
			opciones2.add(new CrearJugadaCompleja(Categoria.SISTEMA));//24 //solo admin
			opciones2.add(new ImprimirJugadores(Categoria.SISTEMA));//25  // todos
			opciones2.add(new IniciarPartido(Categoria.SISTEMA));//26 //todos
			opciones2.add(new ListaJugadasDisponibles(Categoria.SISTEMA));//27 //solo admin
			opciones2.add(new Inicializar(Categoria.SISTEMA));//28 //todos
			opciones2.add(new IniciarSesion(Categoria.SISTEMA));//29 todos
			opciones2.add(new RegistrarUsuarioAdministrador(Categoria.SISTEMA));//30 solo admin
			opciones2.add(new FinalizarPartido(Categoria.SISTEMA));//31//todos
			opciones2.add(new CargarEstadoAnterior(Categoria.SISTEMA));//32//todos
			opciones2.add(new Salir(Categoria.SISTEMA));//33 //todos
			}
		
	}
	
	public void cargarItems(){
		for(int i = 0; i < opciones.size(); i++){
			if(i < 10){
				this.arquero.add(opciones2.get(i));
			}
			else if (i < 19){
				this.delantero.add(opciones2.get(i));
			}
			else{
				this.archivo.add(opciones2.get(i));
			}
		}
	}
	//Cierre del metodo
}//Cierre de la clase
