package objetos.futbol.robots;

import java.io.IOException;
import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;

public class Robot {
	private Futbolista jugador;
	private MoverAdelante trotar;
	private MoverAdelante correr;
	private MoverAtras retroceder;
	private Chutar chutar;
	private Chutar patear;
	private Girar girarDerecha;
	private Girar girarIzquierda;
	
	public Robot(Futbolista jugador){
		this.trotar = Main.trotar;
		this.correr = Main.correr;
		this.retroceder = Main.retroceder;
		this.girarDerecha = Main.girarDerecha;
		this.girarIzquierda = Main.girarIzquierda;
		this.chutar = Main.chutar;
		this.patear = Main.patear;
		this.jugador = jugador;
	}
	
	public Futbolista getJugador(){
		return jugador;
	}
	
	public void setJugador(Futbolista jugador){
		this.jugador = jugador;
	}
	
	public int ejecutarTrotar(){
		return trotar.getIdJugada();
	}
	
	public int ejecutarCorrer(){
		return correr.getIdJugada();
	}
	
	public int ejecutarRetroceder(){
		return retroceder.getIdJugada();
	}
	
	public int ejecutarGirarDerecha(){
		return girarDerecha.getIdJugada();
	}
	
	public int ejecutarGirarIzquierda(){
		return girarIzquierda.getIdJugada();
	}
	
	public int ejecutarChutar(){
		return chutar.getIdJugada();
	}
	
	public int ejecutarPatear(){
		return patear.getIdJugada();
	}
	
	public void ejecutarJugadaCompleja(int index) throws IOException{
		JugadaCompleja x = jugador.getListaJugadas().get(index);
		for(JugadaPrimitiva j: x.getJugada()){
			Main.dos.writeInt(j.getIdJugada());
		}
		Main.dos.flush();
	}
}
