package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import java.util.Scanner;
import objetos.futbol.varios.UsuarioAdministrador;
import objetos.futbol.varios.UsuarioGeneral;


public class IniciarSesion extends OpcionDeMenu{

	public IniciarSesion(Categoria categoria){
		super(categoria);
	}
	
	@Override
	public void ejecutar() {
		System.out.println("Elija como desea iniciar sesión");
		String usuario, clave;
		Scanner scn = new Scanner(System.in);

		if(Main.listaUsuarios.size()==0){
			System.out.println("No hay usuarios registrados.");
			scn.close();
			return;
		}
		System.out.print("---------------------------------------------------\n"+this+"\n");
		System.out.print("1. Usuario Jugador.\n2. Usuario Administrador\n");
		int option = scn.nextInt();
		System.out.print("Usuario:\n");
		usuario=scn.next();

		System.out.print("Contraseña:\n");
		clave=scn.next();

		if(Main.listaUsuarios.get(usuario)!=null){
			if(Main.listaUsuarios.get(usuario).getClave().equals(clave)){
				if(option == 1 && Main.listaUsuarios.get(usuario) instanceof UsuarioGeneral){
					Main.usuarioActual=Main.listaUsuarios.get(usuario);
					scn.close();
					System.out.println("Logueo existoso");
					Main.usuarioActual.lanzarMenu();
				}
				if(option == 2 && Main.listaUsuarios.get(usuario) instanceof UsuarioAdministrador){
					Main.usuarioActual=Main.listaUsuarios.get(usuario);
					scn.close();
					System.out.println("Logueo exitoso");
					Main.usuarioActual.lanzarMenu();
				}
			}
			else{
				System.out.println("\nContraseña incorrecta!");
				scn.close();
				return;
			}
		}else{
			System.out.println("\nUsuario no encontrado!");
					scn.close();
					return;
		}
		scn.close();
		System.out.println("El usuario no posee el rol especificado");
		return;
	}



	public String toString(){
		return "iniciar Sesion.";
	}
}