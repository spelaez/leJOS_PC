package objetos.futbol.UI.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OyenteBotones implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent boton) {
		String s = (String)boton.getActionCommand();
		if(boton.getSource() instanceof JButton){
			if(s.equals("Trotar")){
				System.out.println("holi");
			}
			else if(s.equals("Correr")){
				System.out.println("holi2");
			}
			else if(s.equals("Retroceder")){
				System.out.println("holi3");
			}
			else if(s.equals("Girar a la derecha")){
				System.out.println("holi4");
			}
			else if(s.equals("Girar a la izquierda")){
				System.out.println("holi5");
			}
			else if(s.equals("Chutar")){
				System.out.println("holi6");
			}
			else if(s.equals("Patear")){
				System.out.println("holi7");
			}
			else if(s.equals("Jugadas Complejas")){
				System.out.println("holi8");
			}
			else if(s.equals("Registrar tiempo sin goles")){
				System.out.println("holi9");
			}
			else if(s.equals("Registrar el tiempo del ultimo gol")){
				System.out.println("holi10");
			}
			else if(s.equals("Registrar gol a favor")){
				System.out.println("holi11");
			}
		}
		
	}

}
