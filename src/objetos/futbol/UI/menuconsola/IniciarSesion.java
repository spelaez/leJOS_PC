package objetos.futbol.UI.menuconsola;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import objetos.futbol.UI.Main;
import objetos.futbol.UI.GUI.VentanaInicial;
import objetos.futbol.UI.GUI.VentanaPrincipalUsuarioGeneral;
import objetos.futbol.varios.UsuarioAdministrador;
import objetos.futbol.varios.UsuarioGeneral;

/**
 * Clase que define la opcion iniciar sesion
 * @author Santiago Pelaez
 *
 */
public class IniciarSesion extends OpcionDeMenu implements ActionListener{
	JFrame usr = new JFrame("Iniciar secion");
	Container contenedor;
	JTextField usuario,clave;
	JLabel l2,l3;
	JPanel p1,p2,pg;
	JButton aceptar;
	/**
	 * Constructor que accesa al tipo de categoria que tiene la opción iniciar sesion
	 * @param categoria
	 */
	public IniciarSesion(Categoria categoria){
		super(categoria);
	}//Cierre del constructor
	/**
	 * Metodo que ejecuta el menu para iniciar sesion
	 */
	@Override
	public void ejecutar() {
		if(Main.listaUsuarios.size()==0){
			Main.v2.ta1.append("No hay usuarios registrados.");
			return;
		}
		contenedor =usr.getContentPane();
		
		
		l2 = new JLabel("Usuario");
		l3 = new JLabel("Clave");
		aceptar =new JButton("Iniciar secion");
		usuario = new JTextField();
		clave = new JTextField();
		pg = new JPanel();
		
		p2  = new JPanel();
		p2.setLayout(new GridLayout(3,2));
		
		contenedor.add(p2);
		
		
		
		p2.add(l2);
		p2.add(usuario);
		p2.add(l3);
		p2.add(clave);
		p2.add(aceptar);
		aceptar.addActionListener(this);
		usr.setLocationRelativeTo(null);
		usr.setSize(400, 150);
		usr.setVisible(true);
	
	}//Cierre del metodo
	/**
	 * Metodo sobreescrito de object que esta asignado por defecto, modificado para devolver el tipo de opcion
	 * @return Retorna el tipo de opcion
	 */
	public String toString(){
		return "iniciar Sesion.";
	}//Cierre del metodo
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String usuarios = usuario.getText();
		String claves = clave.getText();
		if(Main.listaUsuarios.containsKey(usuarios) && claves.equals(Main.listaUsuarios.get(usuarios).getClave())){
			Main.tipo =2;
			Main.v2.dispose();
			Main.v2 = new VentanaPrincipalUsuarioGeneral();
			Main.usuarioActual = (UsuarioAdministrador)Main.listaUsuarios.get(usuarios);
			try {
				Main.v2.lanzar();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			usr.dispose();
		}
		else{
			usr.dispose();
			JOptionPane.showMessageDialog(null,"Porfavor ingrese un usuario y clave validos","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
}//Cierre de la clase

