package objetos.futbol.UI.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import objetos.futbol.UI.Main;

public class OyenteMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent accion) {
		String s = (String)accion.getActionCommand();
		if(s.equals("Delantero")){
			Main.tipo = 1;
			Main.v2.dispose();
			Main.v2 = new VentanaPrincipalUsuarioGeneral();
			Main.v2.lanzar();
		
		}
		else if(s.equals("Arquero")){
			Main.tipo = 2;
			Main.v2.dispose();
			Main.v2 = new VentanaPrincipalUsuarioGeneral();
			Main.v2.lanzar();
			
		}
		
	}

}
