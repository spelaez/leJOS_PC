package objetos.futbol.varios;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import objetos.futbol.UI.Main;

public class GestorBDUsuarios {


	public void guardarJugadores(){
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
					
					Element permisos = document.createElement("Permisos");
					usuario.appendChild(permisos);
					
					for(int j = 0; j < g.getPermisos().size(); j++){
						Element permiso = document.createElement("Permiso");
						permisos.appendChild(permiso);
						permiso.appendChild(document.createTextNode(String.valueOf(g.getPermisos().get(j))));
					}


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
					
					Element permisos = document.createElement("Permisos");
					usuario.appendChild(permisos);

					for(int j = 0; j < g.getPermisos().size(); j++){
						Element permiso = document.createElement("Permiso");
						permisos.appendChild(permiso);
						permiso.appendChild(document.createTextNode(String.valueOf(g.getPermisos().get(j))));
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
	public void leerJugdores(){
		System.out.print("Leyendo base de datos de jugadores");
		Usuario g;
		ArrayList<Integer> p = new ArrayList<Integer>();
		try{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File fichero = new File("/Users/Santiago/Documents/XML/BDUsuarios.xml");
			File fichero2 = new File("/Users/Santiago/Documents/XML/temp/BDUsuarios.xml");
			
			if(!fichero.exists() && !fichero2.exists()){
				return;
			}
			
			Document doc= builder.parse(new InputSource(new FileInputStream("/Users/Santiago/Documents/XML/BDUsuarios.xml")));
			if(fichero.exists()){
				doc = builder.parse(new InputSource(new FileInputStream("/Users/Santiago/Documents/XML/temp/BDUsuarios.xml")));
			}
			else{
				doc = builder.parse(new InputSource(new FileInputStream("Users/Santiago/Documents/XML/temp/BDUsuarios.xml")));
			}
			
			//raiz
			Element raiz = doc.getDocumentElement();
			Element general = (Element) raiz.getFirstChild();
			Element administrador = (Element)raiz.getLastChild();
			
			NodeList generales = general.getElementsByTagName("Usuario");
			NodeList admins = administrador.getElementsByTagName("Administrador");
			
			for(int i=0; i<generales.getLength(); i++){
				p.clear();
				Element usuario = (Element)generales.item(i).getChildNodes(); //Coge cada elemento usuario
				
				String nombre = usuario.getAttribute("Nombre");
				String clave = usuario.getAttribute("Clave");
				
				NodeList permisos = usuario.getElementsByTagName("Permisos");
				
				for(int j = 0; j < permisos.getLength(); j++){
					Element permiso = (Element)permisos.item(j);
					p.add(Integer.valueOf(permiso.getTextContent()));
				}
				
				g = new UsuarioAdministrador(nombre, clave, p);
				Main.listaUsuarios.put(nombre, g);
			}
			
			for(int i=0; i<admins.getLength(); i++){
				p.clear();
				Element usuario = (Element)generales.item(i).getChildNodes(); //Coge cada elemento administrador
				
				String nombre = usuario.getAttribute("Nombre");
				String clave = usuario.getAttribute("Clave");
				
				NodeList permisos = usuario.getElementsByTagName("Permisos");
				
				for(int j = 0; j < permisos.getLength(); j++){
					Element permiso = (Element)permisos.item(j);
					p.add(Integer.valueOf(permiso.getTextContent()));
				}
				
				g = new UsuarioGeneral(nombre, clave, p);
				Main.listaUsuarios.put(nombre, g);
			}
			
			System.out.println("Lectura exitosa.");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

