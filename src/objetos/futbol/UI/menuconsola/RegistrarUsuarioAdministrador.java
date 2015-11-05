package objetos.futbol.UI.menuconsola;

import java.util.Scanner;
import objetos.futbol.UI.Main;
import objetos.futbol.varios.UsuarioAdministrador;

public class RegistrarUsuarioAdministrador extends OpcionDeMenu {

	String Usuario,clave;
	Scanner scn = new Scanner(System.in);

	public RegistrarUsuarioAdministrador(Categoria categoria){
		super(categoria);
	}

	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this);
		System.out.println("Por favor ingresa un nombre de usuario");
		Usuario = scn.next();
		System.out.println("Porfavor ingresa tu contraseña");
		clave=scn.next();
		UsuarioAdministrador usuario = new UsuarioAdministrador(Usuario,clave);
		Main.listaUsuarios.put(Usuario,usuario);	
	}

	public String toString(){
		return "Registrar usuario administrador";
	}
}

