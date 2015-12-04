package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
/**
 * Clase que defnie la opcion iniciar partido
 * @author Santiago Pelaez
 *
 */
public class IniciarPartido extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion iniciar partido
	 * @param categoria
	 */
	public IniciarPartido(Categoria categoria) {
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta el menu para iniciar partido
	 */
	@Override
	public void ejecutar() {
		if(Main.pausa == false){
			Main.pausa = false;
			Main.gestorEstado.borrarBuffer();
			Main.gestorEstado.borrarEstado();
			
			Main.tInicio = System.currentTimeMillis();
			Main.tUltimoGol = Main.tInicio;
			System.out.print("Partido Iniciado\n-----------------------------------------------------------");
		}
		else if(Main.pausa == true){
			Main.v2.ta1.append("Porfavor reanude el prtido dando la opcion Reanudar partido");
		}
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	@Override
	public String toString(){
		return "Iniciar Partido";
	}//Cierre del metodo
}//Cierre de la clase

