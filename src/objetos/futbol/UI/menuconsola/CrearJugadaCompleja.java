package objetos.futbol.UI.menuconsola;
import java.util.InputMismatchException;
import java.util.Scanner;
import objetos.futbol.UI.Main;
import java.util.ArrayList;
import objetos.futbol.robots.JugadaPrimitiva;
import objetos.futbol.jugadores.JugadaComplejaDefensiva;
import objetos.futbol.jugadores.JugadaComplejaOfensiva;
import objetos.futbol.jugadores.JugadaComplejaTiroLibre;
import objetos.futbol.varios.UsuarioAdministrador;

public class CrearJugadaCompleja extends OpcionDeMenu {


	public CrearJugadaCompleja(Categoria categoria) {
		super(categoria);		
	}

	@Override
	public void ejecutar() {		
		System.out.print("--------------------------------------------\n"+this);
		System.out.print("Ingrese el tipo de jugada compleja");
		System.out.print("1 Para defensiva \n2 Para ofensiva \n3 Para tiro libre");
		Scanner scn = new Scanner(System.in);

		try{
			int n = scn.nextInt();
			while(n < 1 || n > 3){
				System.out.print("Dato fuera de rango, por favor ingr�selo de nuevo");
				n = scn.nextInt();
			}			
			System.out.println("Ingrese nombre de la jugada");
			String nom = scn.next();
			System.out.println("Ingrese fecha de creacion Dia-Mes-A�o");
			String fecha = scn.next();				
			System.out.println("Ingrese una explicacion");
			String expl = scn.next();	
			ArrayList <JugadaPrimitiva> lista = new ArrayList<>();
			byte num;

			do{
				System.out.println("1. Trotar \n2. Correr \n3. Retroceder \n4. Girar derecha \n5. Girar izquierda \n6. Chute normal \n7. Chute fuerte \n0 Para salir" );
				num = scn.nextByte();						
				if(num == 1){
					lista.add(Main.trotar);
				}
				else if(num == 2){
					lista.add(Main.correr);
				}
				else if(num == 3){
					lista.add(Main.retroceder);
				}
				else if(num == 4){
					lista.add(Main.girarDerecha);
				}
				else if(num == 5){
					lista.add(Main.girarIzquierda);
				}
				else if(num == 6){
					lista.add(Main.chutar);
				}
				else if(num == 7){
					lista.add(Main.patear);
				}
			}while(num != 0);


			if(n == 1){				
				Main.listaJugadasComplejas.add(new JugadaComplejaDefensiva(nom, fecha,  (UsuarioAdministrador)Main.usuarioActual, lista, expl ));				
			}
			else if( n == 2){
				Main.listaJugadasComplejas.add(new JugadaComplejaOfensiva(nom, fecha,  (UsuarioAdministrador)Main.usuarioActual, lista, expl ));
			}
			else if(n == 3){
				Main.listaJugadasComplejas.add(new JugadaComplejaTiroLibre(nom, fecha,  (UsuarioAdministrador)Main.usuarioActual, lista, expl ));		
			}	
		}
		catch(NumberFormatException e){
			System.out.println("Dato incorrecto, ingrese un entero");
		}
		catch(InputMismatchException e){
			System.out.println("Error: dato incorrecto");
		}
		scn.close();
		Main.usuarioActual.lanzarMenu();
	}	

	public String toString(){
		return "Crear nueva jugada compleja";
	}
}
