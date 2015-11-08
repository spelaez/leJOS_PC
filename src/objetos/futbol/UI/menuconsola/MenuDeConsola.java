package objetos.futbol.UI.menuconsola;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import objetos.futbol.UI.menuconsola.Trotar;
/**
 * Clase que define al men� de consola 
 * @author Santiago Pel�ez
 *
 */
public class MenuDeConsola {
	//Campos de la clase
	public static ArrayList<OpcionDeMenu> opciones2 = new ArrayList<>();
	public ArrayList<OpcionDeMenu> opciones;
	public static Scanner scn = new Scanner(System.in);
	Comparator<OpcionDeMenu> c = new Comparator<OpcionDeMenu>() {
		/**
		 * M�todo que compara
		 */
		@Override
		public int compare(OpcionDeMenu o1, OpcionDeMenu o2) {
			return o1.categoria.compareTo(o2.categoria);
		}
		
	};//Cierre del m�todo
	/**
	 * M�todo que permite agregar opciones de men� y ordenarla
	 * @param op
	 */
	public void anadirOpcion(OpcionDeMenu op){
		opciones.add(op);
		ordenarOpciones();
	}//Cierre del m�todo
	/**
	 * M�todo que permite eliminar una opcion de men�
	 * @param op
	 */
	public void eliminarOpcion(OpcionDeMenu op){
		opciones.remove(op);
	}//Cierre del m�todo
	/**
	 * M�todo que permite limpiar la lista de opciones de men�
	 */
	public void limpiar(){
		opciones = new ArrayList<OpcionDeMenu>();
	}//Cierre del m�todo
	/**
	 * M�todo que permite ordenar las opciones de men�
	 */
	public void ordenarOpciones(){
		opciones.sort(c);
	}//Cierre del m�todo
	/**
	 * ejecuta el m�todo lanzar men� que muestra las opciones disponibles a elegir
	 */
	public void lanzarMenu(){
		int option;
		for(int i = 0; i < opciones.size(); i++){
			System.out.println((i+1) +" "+ opciones.get(i));
		}
		System.out.print("\n Por favor ingrese el número de la opción que desea ejecutar");
		try{
		option = scn.nextInt();
		while (option < 0 || option > opciones.size()){
			System.out.println("Dato fuera del rango, Ingrese el dato de nuevo: ");
			option = scn.nextInt();
		}
		}
		catch(NumberFormatException e){
			System.out.println("Error: Dato incorrecto");
		}
		catch(InputMismatchException e){
			System.out.println("Error: Dato incorrecto");
		}
	}//Cierre del m�todo
	/**
	 * M�todo que agrega todas las opciones de men� a una segunda lista
	 */
	private void cargarOpciones(){
		if(opciones2.size() == 0){
			opciones2.add(new Trotar(Categoria.ARQUERO));
			opciones2.add(new Correr(Categoria.ARQUERO));
			opciones2.add(new Chutar(Categoria.ARQUERO));
			opciones2.add(new Patear(Categoria.ARQUERO));
			opciones2.add(new GirarDerecha(Categoria.ARQUERO));
			opciones2.add(new GirarIzquierda(Categoria.ARQUERO));
			opciones2.add(new Retroceder(Categoria.ARQUERO));
			opciones2.add(new RegistrarTiempoSinGoles(Categoria.ARQUERO));
			opciones2.add(new RegistrarTiempoUltimoGol(Categoria.ARQUERO));
			opciones2.add(new Trotar(Categoria.DELANTERO));
			opciones2.add(new Correr(Categoria.DELANTERO));
			opciones2.add(new Chutar(Categoria.DELANTERO));
			opciones2.add(new Patear(Categoria.DELANTERO));
			opciones2.add(new GirarDerecha(Categoria.DELANTERO));
			opciones2.add(new GirarIzquierda(Categoria.DELANTERO));
			opciones2.add(new RegistrarGolAFavor(Categoria.DELANTERO));
			opciones2.add(new Retroceder(Categoria.DELANTERO));
			opciones2.add(new CrearJugador(Categoria.SISTEMA));
			opciones2.add(new ConsultarExplicacionJugada(Categoria.SISTEMA));
			opciones2.add(new ConsultarInfoJugador(Categoria.SISTEMA));
			opciones2.add(new CrearJugadaCompleja(Categoria.SISTEMA));
			opciones2.add(new ImprimirJugadores(Categoria.SISTEMA));
			opciones2.add(new IniciarPartido(Categoria.SISTEMA));
			opciones2.add(new ListaJugadasDisponibles(Categoria.SISTEMA));
			opciones2.add(new Inicializar(Categoria.SISTEMA));
			opciones2.add(new IniciarPartido(Categoria.SISTEMA));
			opciones2.add(new IniciarSesion(Categoria.SISTEMA));
			opciones2.add(new RegistrarUsuarioAdministrador(Categoria.SISTEMA));
			opciones2.add(new RegistrarUsuarioGeneral(Categoria.SISTEMA));
			}
		
	}//Cierre del m�todo
}//Cierre de la clase
