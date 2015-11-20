package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
/**
 * Clase que defnie la opcion iniciar partido
 * @author Santiago Pel�ez
 *
 */
public class IniciarPartido extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opci�n iniciar partido
	 * @param categoria
	 */
	public IniciarPartido(Categoria categoria) {
		super(categoria);
	}//Cierre del constructor
	/**
	 * M�todo que ejecuta el men� para iniciar partido
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
	}//Cierre del m�todo
	/**
	 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
	 * @return Retorna el tipo de opci�n
	 */
	@Override
	public String toString(){
		return "Iniciar Partido";
	}//Cierre del m�todo
}//Cierre de la clase

