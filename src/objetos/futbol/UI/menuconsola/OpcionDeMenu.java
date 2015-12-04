package objetos.futbol.UI.menuconsola;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenuItem;


/**
 * Clase abastracta que lista las opciones de men� por categorias
 * @author Santiago Pelaez
 *
 */
@SuppressWarnings("serial")
public abstract class OpcionDeMenu extends JMenuItem{
	//Campos de clase
	String nombre;
	Categoria categoria;
	/**
	 * Constructor que modifica la categoria
	 * @param categoria
	 */
	public OpcionDeMenu(Categoria categoria){
		super.setText(toString());
		this.categoria = categoria;
		this.addActionListener(new AbstractAction("Accion de item") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OpcionDeMenu o = (OpcionDeMenu) e.getSource();
				o.ejecutar();
			}
		});
	
	}//Cierre del metodo
	/**
	 * Metodo abastracto que sera implementado en otras clases
	 */
	public abstract void ejecutar();
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return retorna null porque no es una opcion como tal
	 */
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}//Cierre del metodo
}//Cierre de la clase
