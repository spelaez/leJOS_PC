package objetos.futbol.UI.menuconsola;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import objetos.futbol.UI.menuconsola.OpcionDeMenu;
/**
 * Clase para generar botones de opciones
 * @author Santiago Pelaez
 *
 */
@SuppressWarnings("serial")
public class OpcionBoton extends JButton{
	OpcionDeMenu opcion;
	/**
	 * Constructor para definir los botones de las opciones
	 * @param nombre
	 * @param opcion
	 */
	public OpcionBoton(String nombre, OpcionDeMenu opcion){
		super(nombre);
		this.opcion = opcion;
		this.addActionListener(new AbstractAction("Ejecutar") {
			/**
			 * Metodo que se ejecuta por una accion en la interfaz
			 */
			@Override
			public void actionPerformed(ActionEvent boton) {
				OpcionBoton o = (OpcionBoton)boton.getSource();
				o.opcion.ejecutar();
			}//Cierre del metodo
		});
	}//Cierre del constructor
}//Cierre de la clase
