package objetos.futbol.cancha;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.robots.Robot;
/**
 * Clase para definir la cancha
 * @author Santiago Pelaez
 *
 */
public class Cancha {
	//Campos de clase
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
	private JLabel m1, m2;
	/**
	 * Constructor de la clase
	 */
	public Cancha(){
		Aposx = 0;
		Aposy = LARGO_CANCHA-1;
		Dposx = 0;
		Dposy = 0;
		inicializarCancha();
		repClone = rep.clone();
	}//Cierre del constructor
	/**
	 * Metodo que inicializa la cancha
	 */
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
	}//Cierre del metodo
	/**
	 * Metodo para actulizar la posicion de la cancha en la que se encuentra el robot
	 * @param x
	 * @param y
	 * @param r
	 * @throws IOException
	 */
	public void actualizarPosicion(int x, int y, Robot r) throws IOException{
		//Recibido movimiento del robot en milimetros
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
	}//Cierre del metodo
	/**
	 * Metodo para verificar si el robot esta por fuera de los limites de la cancha
	 * @throws FieldLimitExceededException
	 */
	public void comprobarLimite() throws FieldLimitExceededException{
		if(Aposx > ANCHO_CANCHA/2*61){
			throw new FieldLimitExceededException();
		}
	}//Cierre del metodo
	/**
	 * Metodo para mostrar la cancha 
	 */
	public void mostrarCancha(){
		for(int i = 0; i < LARGO_CANCHA; i++){
			for(int j = 0; j < ANCHO_CANCHA; j++){
				System.out.print(rep[i][j]);
			}
			System.out.print("\n");
		}
	}//Cierre del metodo
	
	public void cargarImagenes() throws IOException{
		m1 = new JLabel(Main.r1.getJugador().getNombre());
		m2 = new JLabel(Main.r2.getJugador().getNombre());
		m1.setSize(50,50);
		m2.setSize(50,50);
		int index1 = Main.listaJugadores.indexOf(Main.r1.getJugador()) + 1;
		int index2 = Main.listaJugadores.indexOf(Main.r2.getJugador()) + 1;
		Image img = ImageIO.read(new File("src/images/"+index1+".gif"));
		Image img2 = ImageIO.read(new File("src/images/"+index2+".gif"));
		Image resized1 = img.getScaledInstance(m1.getWidth(), m1.getHeight(), Image.SCALE_FAST);
		Image resized2 = img2.getScaledInstance(m2.getWidth(), m2.getHeight(), Image.SCALE_FAST);
		m1.setHorizontalAlignment(SwingConstants.LEFT);
		m2.setHorizontalAlignment(SwingConstants.LEFT);
		
		m1.setIcon(new ImageIcon(resized1));
		m2.setIcon(new ImageIcon(resized2));
		m1.setLocation(0, 0);
		m2.setLocation(0, 100);
		Main.v2.getCancha().add(m1);
		Main.v2.getCancha().add(m2);
		Main.v2.getCancha().revalidate();
	}
}//Cierre de la clase
