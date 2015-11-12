package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
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
		System.out.println("Elija como desea iniciar sesion");
		String usuario, clave;

		if(Main.listaUsuarios.size()==0){
			System.out.println("No hay usuarios registrados.");
			return;
		}
		System.out.print("---------------------------------------------------\n"+this+"\n");
		System.out.print("1. Usuario Jugador.\n2. Usuario Administrador\n");
		String option = Main.scn.nextLine();
		System.out.print("Usuario:\n");
		usuario=Main.scn.nextLine();
		System.out.print("Contrasena:\n");
		clave=Main.scn.nextLine();

		if(Main.listaUsuarios.get(usuario)!=null){
			if(Main.listaUsuarios.get(usuario).getClave().equals(clave)){
				if(Integer.valueOf(option) == 1 && Main.listaUsuarios.get(usuario) instanceof UsuarioGeneral){
					Main.usuarioActual=Main.listaUsuarios.get(usuario);
					System.out.println("Logueo existoso");
				}
				if(Integer.valueOf(option) == 2 && Main.listaUsuarios.get(usuario) instanceof UsuarioAdministrador){
					Main.usuarioActual=Main.listaUsuarios.get(usuario);
					System.out.println("Logueo exitoso");
				}
			}
			else{
				System.out.println("\nContrasena incorrecta!");
				return;
			}
		}else{
			System.out.println("\nUsuario no encontrado!");
					return;
		}	
		System.out.println("El usuario no posee el rol especificado");
		return;
	}//Cierre del método
	/**
	 * Método sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opción
	 * @return Retorna el tipo de opción
	 */
	public String toString(){
		return "iniciar Sesion.";
	}//Cierre del método
}//Cierre de la clase

