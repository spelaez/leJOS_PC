package objetos.futbol.UI;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import lejos.pc.comm.NXTConnector;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Hashtable;
import objetos.futbol.robots.MoverAdelante;
import objetos.futbol.robots.MoverAtras;
import objetos.futbol.robots.Chutar;
import objetos.futbol.robots.Girar;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.varios.Usuario;
import objetos.futbol.varios.UsuarioAnonimo;
import objetos.futbol.robots.Robot;
import objetos.futbol.varios.GestorBDJugadores;
import objetos.futbol.varios.GestorBDUsuarios;
import objetos.futbol.varios.GestorBDJugadasComplejas;
import objetos.futbol.jugadores.*;
import objetos.futbol.robots.*;
import objetos.futbol.varios.UsuarioAdministrador;
public class Main {	

	//Atributos para manejar el tiempo
	public static long tInicio;
	public static long tPausa;
	public static long tFinal;
	public static long tUltimoGol;

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

	//Robots
	public static Robot r1, r2;

	//Variables de conexion a los robots
	public static NXTConnector conn = new NXTConnector();
	public static boolean connected;

	//Gestores bd
	static GestorBDUsuarios gestorUsuarios = new GestorBDUsuarios();
	static GestorBDJugadores gestorJugadores = new GestorBDJugadores();
	static GestorBDJugadasComplejas gestorJugadas = new GestorBDJugadasComplejas();

	//Usuario anónimo
	static UsuarioAnonimo anonimo = new UsuarioAnonimo();
	
	//Scanner
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//gestorUsuarios.leerUsuarios();
		//gestorJugadores.LeerJugadores();
		//gestorJugadas.leerJugadas();
		UsuarioAdministrador u = new UsuarioAdministrador("holi", "123");
		listaUsuarios.put("holi", u);
		try {
			do {
				System.out.println("\n-------------------------------------------------------"+
						"\n-------------------------------------------------------\nMenu:");

				if (usuarioActual == null) {
					anonimo.menu.lanzarMenu();
				} else {
					usuarioActual.lanzarMenu();
				}
			} while (true);

		}
		catch(Exception e){
			System.out.println("\n\n\nAplicacion terminada\n");
		}
	}
}