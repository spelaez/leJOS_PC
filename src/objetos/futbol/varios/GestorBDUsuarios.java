package objetos.futbol.varios;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import objetos.futbol.UI.Main;

public class GestorBDUsuarios {


	public void guardarJugadores(){
		System.out.println("Guardando usuarios...");
		if(Main.listaUsuarios.size() == 0){
			System.out.println("No hay usuarios");
			return;
		}
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			//Elemento raíz
			Document document = builder.newDocument();
			Element raiz = document.createElement("Usuarios");
			document.appendChild(raiz);

			//Usuario General
			Element general = document.createElement("Usuario general");
			raiz.appendChild(general);

			//Usuario Administrador
			Element administrador = document.createElement("Usuario Administrador");
			raiz.appendChild(administrador);

			//Atributos
			for(int i = 0; i < Main.listaUsuarios.size(); i++){
				Usuario g = Main.listaUsuarios.get(i);
				if(g instanceof UsuarioGeneral){
					g = (UsuarioGeneral)g;
					Element usuario = document.createElement("Usuario");
					general.appendChild(usuario);

					Element nombre = document.createElement("Nombre");
					usuario.appendChild(nombre);
					nombre.appendChild(document.createTextNode(g.getNombre()));

					Element clave = document.createElement("Clave");
					usuario.appendChild(clave);
					clave.appendChild(document.createTextNode(g.getClave()));

					for(int j = 0; j < g.getPermisos().size(); j++){
						Element permiso = document.createElement("Permiso");
						general.appendChild(permiso);

						permiso.appendChild(document.createTextNode(String.valueOf(g.getPermisos().get(i))));
					}


				}
				else if (g instanceof UsuarioAdministrador){
					g = (UsuarioAdministrador)g;
					Element usuario = document.createElement("Administrador");
					general.appendChild(usuario);

					Element nombre = document.createElement("Nombre");
					usuario.appendChild(nombre);
					nombre.appendChild(document.createTextNode(g.getNombre()));

					Element clave = document.createElement("Clave");
					usuario.appendChild(clave);
					clave.appendChild(document.createTextNode(g.getClave()));

					for(int j = 0; j < g.getPermisos().size(); j++){
						Element permiso = document.createElement("Permiso");
						general.appendChild(permiso);

						permiso.appendChild(document.createTextNode(String.valueOf(g.getPermisos().get(i))));
					}

				}
			}

			File folder = new File("/Users/Santiago/Documents/XML");
			if(!folder.exists()){
				folder.mkdirs();
			}
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource src = new DOMSource(document);
			StreamResult fileResult = new StreamResult(new File("/Users/Santiago/Documents/XML/BDUsuarios.xml"));
			transformer.transform(src, fileResult);	

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}

