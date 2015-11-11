package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.varios.UsuarioAdministrador;
/**
 * Clase que define la opncion para registrar un usario administrador
 * @author Juan Pablo Betancur
 *
 */
public class RegistrarUsuarioAdministrador extends OpcionDeMenu {
	//Campos de la clase
	String Usuario,clave;
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción registrar usuario administrador
	 * @param categoria
	 */
	public RegistrarUsuarioAdministrador(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método que ejecuta el menú para registrar un usuario administrador
	 */
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this+"\n");
		System.out.println("Por favor ingresa un nombre de usuario");
		Usuario = Main.scn.next();
		System.out.println("Porfavor ingresa tu contraseï¿½a");
		clave=Main.scn.next();
		UsuarioAdministrador usuario = new UsuarioAdministrador(Usuario,clave);		
		Main.listaUsuarios.put(Usuario,usuario);
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * @return Retorna el tipo de opción
	 */
	public String toString(){
		return "Registrar usuario administrador";
	}//Cierre del método
}//Cierre de la clase

