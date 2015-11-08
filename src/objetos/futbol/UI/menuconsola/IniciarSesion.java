package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import java.util.Scanner;
import objetos.futbol.varios.UsuarioAdministrador;
import objetos.futbol.varios.UsuarioGeneral;

/**
 * Clase que define la opción iniciar sesion
 * @author Santiago Peláez
 *
 */
public class IniciarSesion extends OpcionDeMenu{
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción iniciar sesión
	 * @param categoria
	 */
	public IniciarSesion(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Método que ejecuta el menú para iniciar sesión
	 */
	@Override
	public void ejecutar() {

		String usuario, clave;
		Scanner scn = new Scanner(System.in);

		if(Main.listaUsuarios.size()==0){
			System.out.println("No hay usuarios registrados.");
			scn.close();
			return;
		}
		System.out.println("-------------------------------------------------------\n"+this);
		System.out.print("1. Usuario Jugador.\n 2. Usuario Administrador");
		int option = scn.nextInt();
		System.out.print("Usuario: ");
		usuario=scn.nextLine();

		System.out.print("ContraseÃ±a: ");
		clave=scn.nextLine();

		if(Main.listaUsuarios.get(usuario)!=null){
			if(Main.listaUsuarios.get(usuario).getClave().equals(clave)){
				if(option == 1 && Main.listaUsuarios.get(usuario) instanceof UsuarioGeneral){
					Main.usuarioActual=Main.listaUsuarios.get(usuario);
				}
				else {
					System.out.print("No existe un usuario jugador con esos datos");
					scn.close();
					return;
				}
				if(option == 2 && Main.listaUsuarios.get(usuario) instanceof UsuarioAdministrador){
					Main.usuarioActual=Main.listaUsuarios.get(usuario);
				}
				else{
					System.out.print("No existe un usuario Administrador con esos datos");
					scn.close();
					return;
				}
			}
			else{
				System.out.println("\nContraseÃ±a incorrecta!");}
		}else{
			System.out.println("\nUsuario no encontrado!");
		}
		scn.close();
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * @return Retorna el tipo de opción
	 */
	public String toString(){
		return "Iniciar Sesion.";
	}//Cierre del método
}//Cierre de la clase