package objetos.futbol.UI.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import objetos.futbol.UI.Main;

public class OyenteMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent item) {
		String s = (String)item.getActionCommand();
		if(item.getSource() instanceof JMenuItem){
			if(s.equals("Consultar Explicacion de una jugada")){
				System.out.println("dio");
			}
			else if(s.equals("Consultar informacion de un jugador")){
				System.out.println("dio2");
			}
			else if(s.equals("Consultar informacion de un jugador")){
				System.out.println("dio3");
			}
			else if(s.equals("Lista de jugadores")){
				System.out.println("dio4");
			}
			else if(s.equals("Iniciar Partido")){
				System.out.println("dio5");
			}
			else if(s.equals("Inicializar sistema")){
				System.out.println("dio6");
			}
			else if(s.equals("iniciar Secion")){
				System.out.println("dio7");
			}
			else if(s.equals("Finalizar Partido")){
				System.out.println("dio8");
			}
			else if(s.equals("Reanudar Partido")){
				System.out.println("dio9");
			}
			else if(s.equals("Salir")){
				System.out.println("dio10");
			}
		}
		
	}

}
