package objetos.futbol.cancha;

import java.io.IOException;

import objetos.futbol.jugadores.Arquero;
import objetos.futbol.robots.Robot;

public class Cancha {
//Medidas en grupos de a 61MM y algunas redondeadas para evitar decimales
	static final int LARGO_CANCHA = 20;
	static final int ANCHO_CANCHA = 30;
	static final int ARCO_ANCHO = 1;
	static final int ARCO_LARGO = 7;
	static final int ZONA_ARCO_ANCHO = 7;
	static final int CAMPO = 15;
	static final int BORDES_EXTERIORES = 5;
	static final int ZONA_SUP_INF = 6;
	static int Aposx, Aposy, Aultx, Aulty, Dposx, Dposy, Dultx, Dulty;
	static String[][] rep;
	static String[][] repClone;
	
	public Cancha(){
		Aposx = 0;
		Aposy = LARGO_CANCHA-1;
		Dposx = 0;
		Dposy = 0;
		inicializarCancha();
		repClone = rep.clone();
	}
	
	public void inicializarCancha(){
		rep = new String[LARGO_CANCHA][ANCHO_CANCHA];
		for(int i=0; i<LARGO_CANCHA; i++){
			for(int j=0; j<ANCHO_CANCHA; j++){
				rep[i][j]= "  ";
			}
		}
		for(int j=0; j<ANCHO_CANCHA; j++){
			rep[0][j] = "# ";
			rep[6][j] = "# ";
			rep[13][j] = "# ";
			rep[19][j] = "# ";
		}
		for(int i=0; i<LARGO_CANCHA; i++){
			rep[i][0] = "# ";
			rep[i][29] = "# ";
		}
		for(int i=6; i<14; i++){
			rep[i][7] = "# ";
			rep[i][22] = "# ";
		}
	}
	
	public void actualizarPosicion(int x, int y, Robot r) throws IOException{//Recibido movimiento del robot en milimetros
		try{
			if(r.getJugador() instanceof Arquero){
			rep[Aposx/61][Aposy/61] = repClone[Aposx/61][Aposy/61];
			Aposx = x;
			Aposy = y;
			rep[Aposx/61][Aposy/61] = "A";
			try{
			comprobarLimite();
			}
			catch(FieldLimitExceededException e){
				System.out.println(e.getMessage());
				rep[Aposx/61][Aposy/61] = repClone[Aposx/61][Aposy/61];
				Aposx = 0;
				Aposy = LARGO_CANCHA-1;
				rep[0][LARGO_CANCHA-1] = "A";
			}
		}
		else{
			rep[Aposx/61][Aposy/61] = repClone[Aposx/61][Aposy/61];
			Dposx = x;
			Dposy = y;
			rep[Aposx/61][Aposy/61] = "D";
		}
		}catch(IndexOutOfBoundsException e){
			System.out.println("El Robot se ha salido de la cancha, porfavor reposicionarlo");
		}
		System.out.println("El robot ha cambiado a la posicion :"+ (Aposx/61) +" "+(Aposy/61));
	}
	
	public void comprobarLimite() throws FieldLimitExceededException{
		if(Aposx > ANCHO_CANCHA/2*61){
			throw new FieldLimitExceededException();
		}
	}

	public void mostrarCancha(){
		for(int i = 0; i < ANCHO_CANCHA; i++){
			for(int j = 0; j < LARGO_CANCHA; j++){
				System.out.print(rep[i][j]);
			}
			System.out.print("\n");
		}
	}
}
