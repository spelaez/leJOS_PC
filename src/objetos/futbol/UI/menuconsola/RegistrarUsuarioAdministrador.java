package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.varios.UsuarioAdministrador;

public class RegistrarUsuarioAdministrador extends OpcionDeMenu {

	String Usuario,clave;

	public RegistrarUsuarioAdministrador(Categoria categoria){
		super(categoria);
	}

	public void ejecutar(){
		System.out.print("---------------------------------------------------\n"+this+"\n");
		System.out.println("Por favor ingresa un nombre de usuario");
		Usuario = Main.scn.nextLine();
		System.out.println("Porfavor ingresa tu contrase�a");
		clave=Main.scn.nextLine();
		UsuarioAdministrador usuario = new UsuarioAdministrador(Usuario,clave);
		Main.listaUsuarios.put(Usuario,usuario);
	}

	public String toString(){
		return "Registrar usuario administrador";
	}
}

