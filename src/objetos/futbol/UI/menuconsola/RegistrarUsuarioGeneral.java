package objetos.futbol.UI.menuconsola;

import objetos.futbol.UI.Main;
import objetos.futbol.varios.UsuarioGeneral;

public class RegistrarUsuarioGeneral extends OpcionDeMenu {
		
	String Usuario,clave;
	
	int opcion;
		public RegistrarUsuarioGeneral(Categoria categoria){
			super(categoria);
		}
		
		public void ejecutar(){
			System.out.print("---------------------------------------------------\n"+this+"\n");
			System.out.println("Por favor ingresa un nombre de usuario");
			Usuario= Main.scn.next();
			System.out.println("Porfavor ingresa tu contrase�a");
			clave=Main.scn.next();
			UsuarioGeneral usuario = new UsuarioGeneral(Usuario,clave);
			Main.listaUsuarios.put(Usuario,usuario);
		}
		
		public String toString(){
			return "Registrar usuario general";
		}
}
