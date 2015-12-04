package objetos.futbol.UI.menuconsola;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objetos.futbol.UI.Main;
import objetos.futbol.varios.UsuarioAdministrador;
/**
 * Clase que define la opncion para registrar un usario administrador
 * @author Juan Pablo Betancur
 *
 */
public class RegistrarUsuarioAdministrador extends OpcionDeMenu implements ActionListener {
	JFrame usr = new JFrame("Registrar");
	Container contenedor;
	JPanel p1,p2,pg;
	JButton aceptar;
	JTextField t1,t2;
	JLabel l1,l2;
	//Campos de la clase
	String Usuario,clave;
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opcion registrar usuario administrador
	 * @param categoria
	 */
	public RegistrarUsuarioAdministrador(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta el menu para registrar un usuario administrador
	 */
	public void ejecutar(){
		contenedor = usr.getContentPane();
		pg = new JPanel();
		pg.setLayout(new GridLayout(3,2));
		contenedor.add(pg);
		l1 = new JLabel("usuario");
		l2 = new JLabel("clave");
		t1 = new JTextField();
		t2 = new JTextField();
		aceptar = new JButton("Aceptar");
		pg.add(l1);
		pg.add(t1);
		pg.add(l2);
		pg.add(t2);
		pg.add(aceptar);
		aceptar.addActionListener(this);
		usr.setSize(300, 120);
		usr.setVisible(true);		
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	public String toString(){
		return "Registrar usuario administrador";
	}//Cierre del metodo
	@Override
	/**
	 * Metodo que se ejecuta por una accion en la interfaz
	 */
	public void actionPerformed(ActionEvent arg0) {
		Usuario = t1.getText();
		clave = t2.getText();
		UsuarioAdministrador usuario = new UsuarioAdministrador(Usuario,clave);		
		Main.listaUsuarios.put(Usuario,usuario);
		usr.dispose();
	}//Cierre del metodo	
}//Cierre de la clase

