package objetos.futbol.UI.menuconsola;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.ArrayList;
import objetos.futbol.UI.Main;
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
	
	public MenuDeConsola(){
		cargarOpciones();
	}
	
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
	}//Cierre del m�todo
	/**
	 * M�todo que agrega todas las opciones de men� a una segunda lista
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
			opciones2.add(new RegistrarUsuarioGeneral(Categoria.SISTEMA));//31 // todos
			opciones2.add(new FinalizarPartido(Categoria.SISTEMA));//32//todos
			opciones2.add(new Salir(Categoria.SISTEMA));//33 //todos
			}
		
	}//Cierre del m�todo
}//Cierre de la clase
