package objetos.futbol.UI.menuconsola;

import java.util.InputMismatchException;
import objetos.futbol.UI.Main;
import java.util.ArrayList;
import objetos.futbol.robots.JugadaPrimitiva;
import objetos.futbol.jugadores.JugadaComplejaDefensiva;
import objetos.futbol.jugadores.JugadaComplejaOfensiva;
import objetos.futbol.jugadores.JugadaComplejaTiroLibre;
import objetos.futbol.varios.UsuarioAdministrador;
/**
 * Clase que define la opncion crear jugada compleja
 * @author Santiago Saldarriaga
 *
 */
public class CrearJugadaCompleja extends OpcionDeMenu {
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion crear jugada compleja
	 * @param categoria
	 */
	public CrearJugadaCompleja(Categoria categoria) {
		super(categoria);		
	}//Cierre del constructor
	/**
	 * Metodo sobreescrito que ejecuta el menu para crear una jugada compleja
	 */
	@Override
	public void ejecutar() {		
		System.out.println("---------------------------------------------------\n"+this+"\n");
		System.out.println("Ingrese el tipo de jugada compleja");
		System.out.println("1 Defensiva \n2 Ofensiva \n3 Tiro libre");

		try{
			String n = Main.scn.nextLine();
			while(Integer.valueOf(n) < 1 || Integer.valueOf(n) > 3){
				System.out.println("Dato fuera de rango, por favor ingreselo de nuevo");
				n = Main.scn.nextLine();
			}			
			System.out.println("Ingrese nombre de la jugada");
			String nom = Main.scn.nextLine();
			System.out.println("Ingrese fecha de creacion Dia-Mes-Año");
			String fecha = Main.scn.nextLine();				
			System.out.println("Ingrese una explicacion");
			String expl = Main.scn.nextLine();	
			ArrayList <JugadaPrimitiva> lista = new ArrayList<>();
			String num;

			do{
				System.out.println("1. Trotar \n2. Correr \n3. Retroceder \n4. Girar derecha \n5. Girar izquierda \n6. Chute normal \n7. Chute fuerte \n0 Salir" );
				num = Main.scn.nextLine();						
				if(Byte.valueOf(num) == 1){
					lista.add(Main.trotar);
				}
				else if(Byte.valueOf(num)== 2){
					lista.add(Main.correr);
				}
				else if(Byte.valueOf(num)== 3){
					lista.add(Main.retroceder);
				}
				else if(Byte.valueOf(num) == 4){
					lista.add(Main.girarDerecha);
				}
				else if(Byte.valueOf(num) == 5){
					lista.add(Main.girarIzquierda);
				}
				else if(Byte.valueOf(num)== 6){
					lista.add(Main.chutar);
				}
				else if(Byte.valueOf(num) == 7){
					lista.add(Main.patear);
				}
			}while(Byte.valueOf(num) != 0);


			if(Integer.valueOf(n) == 1){				
				Main.listaJugadasComplejas.add(new JugadaComplejaDefensiva(nom, fecha,  (UsuarioAdministrador)Main.usuarioActual, lista, expl ));				
			}
			else if( Integer.valueOf(n) == 2){
				Main.listaJugadasComplejas.add(new JugadaComplejaOfensiva(nom, fecha,  (UsuarioAdministrador)Main.usuarioActual, lista, expl ));
			}
			else if(Integer.valueOf(n) == 3){
				Main.listaJugadasComplejas.add(new JugadaComplejaTiroLibre(nom, fecha,  (UsuarioAdministrador)Main.usuarioActual, lista, expl ));		
			}	
		}
		catch(NumberFormatException e){
			System.out.println("Dato incorrecto, ingrese un entero");
		}
		catch(InputMismatchException e){
			System.out.println("Error: dato incorrecto");
		}

	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	public String toString(){
		return "Crear nueva jugada compleja";
	}//Cierre del metodo
}//Cierre de la clase
