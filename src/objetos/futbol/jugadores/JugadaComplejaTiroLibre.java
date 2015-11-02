package objetos.futbol.jugadores;

import java.util.ArrayList;
import objetos.futbol.robots.JugadaPrimitiva;
import objetos.futbol.robots.Chutar;
import objetos.futbol.varios.UsuarioAdministrador;

public class JugadaComplejaTiroLibre extends JugadaCompleja {
	private int potenciachute;
	private int efecto;

	public JugadaComplejaTiroLibre (String nombreJugada,String fechaCreacion,UsuarioAdministrador Autor,ArrayList<JugadaPrimitiva> jugada,String Explicacion){
		super(nombreJugada,fechaCreacion,Autor,jugada,Explicacion);
		JugadaPrimitiva y = super.getJugada().get(super.getJugada().size()-1);
		if(y instanceof Chutar){
			this.potenciachute=y.getVelocidad();
			this.efecto=((Chutar) y).getGrados();
		}
		else{
			throw new ClassCastException();
		}
}
 
	@Override
 	public String identificarJugada() {
		return "Jugada Tiro Libre";
	}
	private String getPotenciachute(){
		if(potenciachute>0 && potenciachute <50){
			return "chute suave";
		}
		else if(potenciachute>=50 && potenciachute<100){
			return "chute medio";
   
		}
		else if (potenciachute>=100){
			return "chute fuerte";
		}
		else{
			return"chute sin potencia";
		}
	}
	private String getEfecto(){
		if(efecto>=18 && efecto<25){
			return "chute directo";
		}
		else if (efecto>=25 && efecto<35){
			return "efecto medio hacia arriba";
		}
		else if(efecto>=35){
			return "tiro vascelina";
		}
		else{
			return "tiro sin efecto";
		}
	}

}