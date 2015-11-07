package objetos.futbol.UI.menuconsola;

import java.util.Scanner;
import objetos.futbol.UI.Main;
import objetos.futbol.varios.UsuarioAdministrador;
//Clase que define la opncion para registrar un usario administrador
public class RegistrarUsuarioAdministrador extends OpcionDeMenu {

	String Usuario,clave;
	Scanner scn = new Scanner(System.in);
	//Método que accesa al tipo de categoria que tiene la opcion registrar usuario administrador
	public RegistrarUsuarioAdministrador(Categoria categoria){
		super(categoria);
	}
	//Método que ejecuta el menu para registrar un usuario administrador
	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		System.out.println("Por favor ingresa un nombre de usuario");
		Usuario = scn.next();
		System.out.println("Porfavor ingresa tu contraseña");
		clave=scn.next();
		UsuarioAdministrador usuario = new UsuarioAdministrador(Usuario,clave);
		Main.listaUsuarios.put(Usuario,usuario);	
	}
	//Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	public String toString(){
		return "Registrar usuario administrador";
	}
}

