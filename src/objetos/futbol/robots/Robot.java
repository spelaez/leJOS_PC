package objetos.futbol.robots;

import java.io.IOException;
import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;
/**
 * Clase para definir las jugadas primitivas de un robot
 * @author Santiago Peláez
 *
 */
public class Robot {
	//Campos de clase
	private Futbolista jugador;
	private MoverAdelante trotar;
	private MoverAdelante correr;
	private MoverAtras retroceder;
	private Chutar chutar;
	private Chutar patear;
	private Girar girarDerecha;
	private Girar girarIzquierda;
	/**
	 * Constructor para asignar las jugadas primitivas a un futbolista
	 * @param jugador
	 */
	public Robot(Futbolista jugador){
		this.trotar = Main.trotar;
		this.correr = Main.correr;
		this.retroceder = Main.retroceder;
		this.girarDerecha = Main.girarDerecha;
		this.girarIzquierda = Main.girarIzquierda;
		this.chutar = Main.chutar;
		this.patear = Main.patear;
	}//Cierre del constructor
	/**
	 * Método para ver si el futbolista es in arquero o un delantero
	 * @return Retorna el tipo de jugador
	 */
	public Futbolista getJugador(){
		return jugador;
	}//Cierre del método
	/**
	 * Método para modificar al futbolista
	 * @param jugador
	 */
	public void setJugador(Futbolista jugador){
		this.jugador = jugador;
	}//Cierre del método
	/**
	 * Método para llamar al tipo de jugada primitiva en este caso trotar
	 * @return Retorna el ID de la jugada
	 */
	public int ejecutarTrotar(){
		return trotar.getIdJugada();
	}//Cierre del método
	/**
	 * Método para llamar al tipo de jugada primitiva en este caso correr
	 * @return Retorna el ID de la ejecucuion de lajugada
	 */
	public int ejecutarCorrer(){
		return correr.getIdJugada();
	}//Cierre del método
	/**
	 * Método para llamar al tipo de jugada primitiva en este caso retroceder
	 * @return Retorna el ID de la ejecucion de la jugada
	 */
	public int ejecutarRetroceder(){
		return retroceder.getIdJugada();
	}//Cierre del método
	/**
	 * Método para llamar al tipo de jugada primitiva en este caso girar a la derecha
	 * @return Retorna el ID de la ejecucion de la jugada
	 */
	public int ejecutarGirarDerecha(){
		return girarDerecha.getIdJugada();
	}//Cierre del método
	/**
	 * Método para llamar al tipo de jugada primitiva en este caso girar a la izquierda
	 * @return Retorna el ID de la ejecucion de la jugada
	 */
	public int ejecutarGirarIzquierda(){
		return girarIzquierda.getIdJugada();
	}//Cierre del método
	/**
	 * Método para llamar al tipo de jugada primitiva en este caso chutar
	 * @return Retorna el ID de la ejecucion de la jugada
	 */
	public int ejecutarChutar(){
		return chutar.getIdJugada();
	}//Cierre del método
	/**
	 * Método para llamar al tipo de jugada primitiva en este caso patear
	 * @return Retorna el ID de la ejecucion de la jugada
	 */
	public int ejecutarPatear(){
		return patear.getIdJugada();
	}//Cierre del método
	/**
	 * Método para asignarle las jugadas primitivas que componen una jugada compleja
	 * @param index
	 * @throws IOException
	 */
	public void ejecutarJugadaCompleja(int index) throws IOException{
		JugadaCompleja x = jugador.getListaJugadas().get(index);
		for(JugadaPrimitiva j: x.getJugada()){
			Main.dos.writeInt(j.getIdJugada());
		}
		Main.dos.flush();
	}//Cierre del método
}//Cierr de la clase
