package objetos.futbol.robots;

import java.io.IOException;
import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;
//Clase para definir las jugadas primitivas de un robot
public class Robot {
	private Futbolista jugador;
	private MoverAdelante trotar;
	private MoverAdelante correr;
	private MoverAtras retroceder;
	private Chutar chutar;
	private Chutar patear;
	private Girar girarDerecha;
	private Girar girarIzquierda;
	//M�todo para asignar las jugadas primitivas a un futbolista
	public Robot(Futbolista jugador){
		this.trotar = Main.trotar;
		this.correr = Main.correr;
		this.retroceder = Main.retroceder;
		this.girarDerecha = Main.girarDerecha;
		this.girarIzquierda = Main.girarIzquierda;
		this.chutar = Main.chutar;
		this.patear = Main.patear;
	}
	//M�todo para ver si el futbolista es in arquero o un delantero
	public Futbolista getJugador(){
		return jugador;
	}
	//M�todo para modificar al futbolista
	public void setJugador(Futbolista jugador){
		this.jugador = jugador;
	}
	//M�todo para llamar al tipo de jugada primitiva en este caso trotar
	public int ejecutarTrotar(){
		return trotar.getIdJugada();
	}
	//M�todo para llamar al tipo de jugada primitiva en este caso correr
	public int ejecutarCorrer(){
		return correr.getIdJugada();
	}
	//M�todo para llamar al tipo de jugada primitiva en este caso retroceder
	public int ejecutarRetroceder(){
		return retroceder.getIdJugada();
	}
	//M�todo para llamar al tipo de jugada primitiva en este caso girar a la derecha
	public int ejecutarGirarDerecha(){
		return girarDerecha.getIdJugada();
	}
	//M�todo para llamar al tipo de jugada primitiva en este caso girar a la izquierda
	public int ejecutarGirarIzquierda(){
		return girarIzquierda.getIdJugada();
	}
	//M�todo para llamar al tipo de jugada primitiva en este caso chutar
	public int ejecutarChutar(){
		return chutar.getIdJugada();
	}
	//M�todo para llamar al tipo de jugada primitiva en este caso patear
	public int ejecutarPatear(){
		return patear.getIdJugada();
	}
	//M�todo para asignarle las jugadas primitivas que componen una jugada compleja
	public void ejecutarJugadaCompleja(int index) throws IOException{
		JugadaCompleja x = jugador.getListaJugadas().get(index);
		for(JugadaPrimitiva j: x.getJugada()){
			Main.dos.writeInt(j.getIdJugada());
		}
		Main.dos.flush();
	}
}
