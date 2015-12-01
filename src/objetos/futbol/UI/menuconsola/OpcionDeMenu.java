package objetos.futbol.UI.menuconsola;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JMenuItem;

import objetos.futbol.UI.GUI.OyenteMenu;

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
		this.categoria = categoria;//Cierre del m�todo
		this.addActionListener(new AbstractAction("Accion de item") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OpcionDeMenu o = (OpcionDeMenu) e.getSource();
				o.ejecutar();
			}
		});
	/**
	 * Metodo abastracto que sera implementado en otras clases
	 */
	}
	public abstract void ejecutar();
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}//Cierre de la clase
