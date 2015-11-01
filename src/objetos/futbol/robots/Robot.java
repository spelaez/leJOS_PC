package objetos.futbol.robots;

import objetos.futbol.jugadores.Futbolista;

public class Robot {
	private Futbolista jugador;
	private MoverAdelante trotar;
	private MoverAdelante correr;
	private MoverAtras retroceder;
	private Chutar chutar;
	private Chutar patear;
	private Girar girar;
	
	public Robot(Futbolista jugador, MoverAdelante trotar, MoverAdelante correr, MoverAtras retroceder, Chutar chutar, Chutar patear, Girar girar){
		this.jugador = jugador;
		this.trotar = trotar;
		this.correr = correr;
		this.retroceder = retroceder;
		this.chutar = chutar;
		this.patear = patear;
		this.girar = girar;
	}
	
	public Robot(Futbolista jugador){
		this.jugador = jugador;
		this.trotar = new MoverAdelante(1);
		this.correr = new MoverAdelante(2);
		this.retroceder = new MoverAtras(1);
		this.chutar = new Chutar(1, 10);
		this.patear = new Chutar(2,10);
		this.girar = new Girar(1, 20);
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
	
	public int ejecutarGirar(){
		return girar.getIdJugada();
	}
	
	public int ejecutarChutar(){
		return chutar.getIdJugada();
	}
	
	public int ejecutarPatear(){
		return patear.getIdJugada();
	}
	
	public void ejecutarJugadaCompleja(int index){
	}
}
