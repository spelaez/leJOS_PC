package objetos.futbol.UI.menuconsola;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import objetos.futbol.UI.menuconsola.OpcionDeMenu;

@SuppressWarnings("serial")
public class OpcionBoton extends JButton{
	OpcionDeMenu opcion;
	
	public OpcionBoton(String nombre, OpcionDeMenu opcion){
		super(nombre);
		this.opcion = opcion;
		this.addActionListener(new AbstractAction("Ejecutar") {
			
			@Override
			public void actionPerformed(ActionEvent boton) {
				OpcionBoton o = (OpcionBoton)boton.getSource();
				o.opcion.ejecutar();
			}
		});
	}
}
