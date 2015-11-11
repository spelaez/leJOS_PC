package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.varios.UsuarioGeneral;
/**
 * Clase que define la opción registrar usuario general
 * @author Juan Pablo Betancur
 *
 */
public class RegistrarUsuarioGeneral extends OpcionDeMenu {
	//Campos de la clase
	String Usuario,clave;
	
	int opcion;
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción registrar usuario general
	 * @param categoria
	 */
		public RegistrarUsuarioGeneral(Categoria categoria){
			super(categoria);
		}//Cierre del constructor
		/**
		 * Método que ejecuta el menú para registrar un usuario general
		 */
		public void ejecutar(){
			System.out.print("---------------------------------------------------\n"+this+"\n");
			System.out.println("Por favor ingresa un nombre de usuario");
			Usuario= Main.scn.next();
			System.out.println("Porfavor ingresa tu contraseï¿½a");
			clave=Main.scn.next();
			UsuarioGeneral usuario = new UsuarioGeneral(Usuario,clave);
			Main.listaUsuarios.put(Usuario,usuario);
		}//Cierre del método
		/**
		 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
		 *@return Retorna el tipo de opción
		 */
		public String toString(){
			return "Registrar usuario general";
		}//Cierre del método
}//Cierre de la clase
