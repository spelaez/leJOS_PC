package objetos.futbol.cancha;

public class Cancha {
//Medidas en dm
	static final float LARGO_CANCHA = 12.2F;
	static final float ANCHO_CANCHA = 18.3F;
	static final float ARCO_ANCHO = 0.8F;
	static final float ARCO_LARGO = 4.5F;
	static final float ZONA_ARCO_ANCHO = 4.5F;
	static final float CAMPO = 9.3F;
	static final float BORDES_EXTERIORES = 3F;
	static final float ZONA_CENTRAL = 9.3F;
	static final float ZONA_SUP_INF = 3.85F;
	static String[][] rep;
	
	public void inicializarCancha(){
		rep = new String[(int)LARGO_CANCHA][(int)ANCHO_CANCHA];
		for(int i=0; i<(int)LARGO_CANCHA; i++){
			for(int j=0; j<(int)ANCHO_CANCHA; j++){
				rep[i][j]= " ";
			}
		}
		for(int j=0; j<(int)ANCHO_CANCHA; j++){
			rep[0][j] = "#";
			rep[4][j] = "#";
			rep[8][j] = "#";
			rep[(int)(LARGO_CANCHA-1)][j] = "#";
		}
		for(int i=0; i<(int)LARGO_CANCHA; i++){
			rep[i][0] = "#";
			rep[i][(int)(ANCHO_CANCHA-1)] = "#";
		}
		for(int i=4; i<=8; i++){
			rep[i][5] = "#";
			rep[i][14] = "#";
		}
	}
	
	public void actualizarPosicion(int i, int j, int anti, int antj){
		rep[i][j] = "X";
		rep[anti][antj] = " ";
	}
}
