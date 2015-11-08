package objetos.futbol.UI.menuconsola;

import objetos.futbol.varios.GestorBDUsuarios;
import objetos.futbol.varios.GestorBDJugadores;
import objetos.futbol.varios.GestorBDJugadasComplejas;

public class Salir extends OpcionDeMenu{

	public Salir(Categoria categoria) {
		super(categoria);
	}

	@Override
	public void ejecutar() {
		System.out.print("---------------------------------------------------\n"+this+"\n");
		new GestorBDUsuarios().guardarUsuarios();
		new GestorBDJugadores().guardarJugadores();
		new GestorBDJugadasComplejas().guardarJugadas();
		//new GestorBDEstado().guardarEstado();
		System.exit(0);
	}
	
	public String toString(){
		return "Salir";
	}

}
