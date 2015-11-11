package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.varios.UsuarioGeneral;
/**
 * Clase que define la opci�n registrar usuario general
 * @author Juan Pablo Betancur
 *
 */
public class RegistrarUsuarioGeneral extends OpcionDeMenu {
	//Campos de la clase
	String Usuario,clave;
	
	int opcion;
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opci�n registrar usuario general
	 * @param categoria
	 */
		public RegistrarUsuarioGeneral(Categoria categoria){
			super(categoria);
		}//Cierre del constructor
		/**
		 * M�todo que ejecuta el men� para registrar un usuario general
		 */
		public void ejecutar(){
			System.out.print("---------------------------------------------------\n"+this+"\n");
			System.out.println("Por favor ingresa un nombre de usuario");
			Usuario= Main.scn.next();
			System.out.println("Porfavor ingresa tu contrase�a");
			clave=Main.scn.next();
			UsuarioGeneral usuario = new UsuarioGeneral(Usuario,clave);
			Main.listaUsuarios.put(Usuario,usuario);
		}//Cierre del m�todo
		/**
		 * M�todo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opci�n
		 *@return Retorna el tipo de opci�n
		 */
		public String toString(){
			return "Registrar usuario general";
		}//Cierre del m�todo
}//Cierre de la clase
