package objetos.futbol.robots;
//Clase para definir la jugada primitiva chutar 
public class Chutar extends JugadaPrimitiva {
	private int idJugada;
	private int grados;
	//Método para asígnar la velocidad y los grados con los que chuta 
	public Chutar(int velocidad, int grados){
		super(velocidad);
		this.grados = grados;
		setIdJugada();
	}
	//Método para consultar el tipo de jugada
	public int getIdJugada(){
		return idJugada;
	}
	//Metodo para modificar el tipo de jugada primitiva
	public void setIdJugada(){
		if(velocidad <= 1 && velocidad > 0){
			idJugada = 5;
		}
		else{
			idJugada = 6;
		}
	}
	//Metodo para cosultar los grados 
	public int getGrados(){
		return grados;
	}
}
