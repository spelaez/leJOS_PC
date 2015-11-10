package objetos.futbol.varios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;

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

import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import objetos.futbol.UI.Main;

public class GestorBDUsuarios {


	public void guardarUsuarios(){
		Usuario g;
		System.out.println("Guardando usuarios...");
		Enumeration<Usuario> enumUsu = Main.listaUsuarios.elements(); 
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
			Element general = document.createElement("Usuario_general");
			raiz.appendChild(general);

			//Usuario Administrador
			Element administrador = document.createElement("Usuario_Administrador");
			raiz.appendChild(administrador);

			//Atributos
			while(enumUsu.hasMoreElements()){
				g = enumUsu.nextElement();
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

				}
				else if (g instanceof UsuarioAdministrador){
					g = (UsuarioAdministrador)g;
					Element usuario = document.createElement("Administrador");
					administrador.appendChild(usuario);

					Element nombre = document.createElement("Nombre");
					usuario.appendChild(nombre);
					nombre.appendChild(document.createTextNode(g.getNombre()));

					Element clave = document.createElement("Clave");
					usuario.appendChild(clave);
					clave.appendChild(document.createTextNode(g.getClave()));
				}
			}

			File folder = new File("src\\gestorBD");
			if(!folder.exists()){
				folder.mkdirs();
			}
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource src = new DOMSource(document);
			StreamResult fileResult = new StreamResult(new File("src\\gestorBD\\BDUsuarios.xml"));
			transformer.transform(src, fileResult);	
			System.out.println("Guardado exitoso.");
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
	public void leerUsuarios(){
		System.out.println("Leyendo base de datos de usuarios");
		Usuario g;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			File file = new File("src\\gestorBD\\BDUsuarios.xml");
			Document doc = builder.parse(new InputSource(new FileInputStream(file)));
			
			Element raiz = doc.getDocumentElement();
			Element general = (Element)raiz.getElementsByTagName("Usuario_general").item(0);
			Element admin = (Element)raiz.getElementsByTagName("Usuario_Administrador").item(0);
			NodeList generales = general.getElementsByTagName("Usuario");
			NodeList admins = admin.getElementsByTagName("Administrador");
			for(int i = 0; i < generales.getLength(); i++){
				Node usuario = generales.item(i);
				NodeList datos = usuario.getChildNodes();
				String name = (datos.item(0).getTextContent());
				String clave = (datos.item(1).getTextContent());
				g = new UsuarioGeneral(name, clave);
				Main.listaUsuarios.put(name, g);
			
			
			}
			for(int i = 0; i < admins.getLength(); i++){
				Node usuario = admins.item(i);
				NodeList datos = usuario.getChildNodes();
				String name = (datos.item(0).getTextContent());
				String clave = (datos.item(1).getTextContent());
				g = new UsuarioAdministrador(name, clave);
				Main.listaUsuarios.put(name, g);
			
			
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
}

