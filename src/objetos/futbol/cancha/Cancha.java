package objetos.futbol.cancha;

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
	static String[][] rep;
	
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
	
	public void actualizarPosicion(int x, int y){//Recibido movimiento del robot en milimetros
		
		rep[i][j] = "X";
		rep[anti][antj] = " ";
	}
}
