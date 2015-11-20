package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
/**
 * Clase que defnie la opcion iniciar partido
 * @author Santiago Peláez
 *
 */
public class IniciarPartido extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción iniciar partido
	 * @param categoria
	 */
	public IniciarPartido(Categoria categoria) {
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método que ejecuta el menú para iniciar partido
	 */
	@Override
	public void ejecutar() {
		if(Main.pausa == false){
			Main.pausa = false;
			Main.gestorEstado.borrarBuffer();
			Main.gestorEstado.borrarEstado();
			System.out.print("---------------------------------------------------\n"+this+"\n");
			Main.tInicio = System.currentTimeMillis();
			Main.tUltimoGol = Main.tInicio;
			System.out.print("Partido Iniciado\n-----------------------------------------------------------");
		}
		else if(Main.pausa == true){
			System.out.println("Porfavor reanude el prtido dando la opcion Reanudar partido");
		}
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * @return Retorna el tipo de opción
	 */
	@Override
	public String toString(){
		return "Iniciar Partido";
	}//Cierre del método
}//Cierre de la clase

