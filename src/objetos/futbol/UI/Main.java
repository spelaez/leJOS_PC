package objetos.futbol.UI;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import lejos.pc.comm.NXTConnector;
import lejos.pc.comm.NXTInfo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Hashtable;
import objetos.futbol.robots.MoverAdelante;
import objetos.futbol.robots.MoverAtras;
import objetos.futbol.robots.Chutar;
import objetos.futbol.robots.Girar;
import objetos.futbol.UI.GUI.VentanaInicial;
import objetos.futbol.UI.GUI.VentanaPrincipalUsuarioGeneral;
import objetos.futbol.cancha.Cancha;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.varios.Usuario;
import objetos.futbol.varios.UsuarioAnonimo;
import objetos.futbol.robots.Robot;
import objetos.futbol.varios.GestorBDJugadores;
import objetos.futbol.varios.GestorBDUsuarios;
import objetos.futbol.varios.GestorBDEstado;
import objetos.futbol.varios.GestorBDJugadasComplejas;
import objetos.futbol.jugadores.*;
/**
 * Clase para ejecutar el menu
 * @author Santiago Pélaez
 *
 */
public class Main {	
	//Campos de clase
	//Atributos para manejar el tiempo
	public static long tInicio;
	public static long tPausa;
	public static long tFinal;
	public static long tUltimoGol;
	public static boolean pausa = false;

	//Objetos de lectura y escritura hacia los robots
	public static DataOutputStream dos;
	public static DataInputStream dis;

	//Jugadas primitivas definidas para todos
	public static MoverAdelante trotar = new MoverAdelante(1);
	public static MoverAdelante correr = new MoverAdelante(2);
	public static MoverAtras retroceder = new MoverAtras(1);
	public static Girar girarDerecha = new Girar(1, 45);
	public static Girar girarIzquierda = new Girar(1,-45);
	public static Chutar chutar = new Chutar(1, -10);
	public static Chutar patear = new Chutar(2, -10);

	//Lista de JugadasComplejas
	public static ArrayList<JugadaCompleja> listaJugadasComplejas = new ArrayList<>();

	//Lista de Usuarios
	public static Hashtable<String, Usuario> listaUsuarios = new Hashtable<>();
	public static Usuario usuarioActual; //Usuario logueado

	//Lista de Jugadores
	public static ArrayList<Futbolista> listaJugadores = new ArrayList<>();
	//Cancha
	public static Cancha cancha = new Cancha();
	//Robots
	public static Robot r1, r2;

	//Variables de conexion a los robots
	public static NXTConnector conn = new NXTConnector();
	public static boolean connected;

	//Gestores bd
	static GestorBDUsuarios gestorUsuarios = new GestorBDUsuarios();
	static GestorBDJugadores gestorJugadores = new GestorBDJugadores();
	static GestorBDJugadasComplejas gestorJugadas = new GestorBDJugadasComplejas();
	public static GestorBDEstado gestorEstado = new GestorBDEstado();

	//Usuario anonimo
	static UsuarioAnonimo anonimo = new UsuarioAnonimo();

	//Objetos con datos para conexion con los robots
	public static NXTInfo nxt1, nxt2;
	public static int connectedTo;

	//Scanner
	public static Scanner scn = new Scanner(System.in);
	//ventanas
	public static VentanaInicial v1 = new VentanaInicial();
	public static VentanaPrincipalUsuarioGeneral  v2 = new VentanaPrincipalUsuarioGeneral();
	/**
	 * Método Main para mostrar al usuario las caracteristicas del juego y el menu
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		gestorUsuarios.leerUsuarios();
		gestorJugadas.leerJugadas();
		gestorJugadores.LeerJugadores();
		v1.lanzar();
		/*try {
			do {
				System.out.println("\n-------------------------------------------------------"+
						"\n-------------------------------------------------------\nMenu:");

				if (usuarioActual == null) {
					anonimo.lanzarMenu();
				} else {
					usuarioActual.lanzarMenu();
				}
			} while (true);

		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("\n\n\nAplicacion terminada\n");
		}*/
	}//Cierre del metodo 
}//Cierre de la clase