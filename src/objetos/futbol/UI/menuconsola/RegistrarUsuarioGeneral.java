package objetos.futbol.UI.menuconsola;

import java.util.Scanner;
import objetos.futbol.UI.Main;
import objetos.futbol.varios.UsuarioGeneral;
//Clase que define la opcion registrar usuario general
public class RegistrarUsuarioGeneral extends OpcionDeMenu {
		
	String Usuario,clave;
	Scanner scn = new Scanner(System.in);
	
	int opcion;
	//Método que accesa al tipo de categoria que tiene la opcion registrar usuario general
		public RegistrarUsuarioGeneral(Categoria categoria){
			super(categoria);
		}
		//Método que ejecuta el menu para registrar un usuario general
		public void ejecutar(){
			System.out.print("---------------------------------------------------\n"+this);
			System.out.println("Por favor ingresa un nombre de usuario");
			Usuario= scn.next();
			System.out.println("Porfavor ingresa tu contraseña");
			clave=scn.next();
			UsuarioGeneral usuario = new UsuarioGeneral(Usuario,clave);
			Main.listaUsuarios.put(Usuario,usuario);	
		}
		//Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
		public String toString(){
			return "Registrar usuario general";
		}
}
