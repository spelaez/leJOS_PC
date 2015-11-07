package objetos.futbol.varios;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;

import java.io.*;

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

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.*;

public class GestorBDJugadores {
	
	public void guardarJugadores(){
		System.out.println(".... GUARDANDO JUGADORES");
		if(Main.listaJugadores.size() ==0){
			System.out.println("No hay jugadores");
			return;
		}
		try {
            DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder Builder = Factory.newDocumentBuilder();
			
			//Elemento Raiz;
			Document document = Builder.newDocument();
			Element raiz = document.createElement("Judadores");
			document.appendChild(raiz);
			//Delantero
			Element delantero =  document.createElement("Delantero");
			raiz.appendChild(delantero);
			//Arquero
			Element arquero =  document.createElement("Arquero");
			raiz.appendChild(arquero);
			//Atributos
			for (int i=0;i<Main.listaJugadores.size();i++){
				if(Main.listaJugadores.get(i) instanceof Arquero){
					Arquero a = (Arquero) Main.listaJugadores.get(i);
					Element jugador = document.createElement("Jugador");
					arquero.appendChild(jugador);
					Element nombre = document.createElement("Nombre");
					jugador.appendChild(nombre);
					nombre.appendChild(document.createTextNode(a.getNombre()));
					Element dorsal = document.createElement("Dorsal");
					jugador.appendChild(dorsal);
					dorsal.appendChild(document.createTextNode(Byte.toString(a.getDorsal())));
					Element tiempoSinGol = document.createElement("TiempoSinGol");
					jugador.appendChild(tiempoSinGol);
					tiempoSinGol.appendChild(document.createTextNode(Integer.toString(a.getTiempoSinGoles())));
					Element jugadas = document.createElement("Jugadas");
					jugador.appendChild(jugadas);
					for(int j=0; j< a.getListaJugadas().size();j++){
						Element jugada = document.createElement("Jugada");
						jugadas.appendChild(jugada);
						jugada.appendChild(document.createTextNode(Integer.toString(Main.listaJugadasComplejas.indexOf(a.getListaJugadas().get(j)))));
					}
				}
				else if(Main.listaJugadores.get(i) instanceof Delantero){
					Delantero a = (Delantero)Main.listaJugadores.get(i);
					Element jugador = document.createElement("Jugador");
					delantero.appendChild(jugador);
					Element nombre = document.createElement("Nombre");
					jugador.appendChild(nombre);
					nombre.appendChild(document.createTextNode(a.getNombre()));
					Element dorsal = document.createElement("Dorsal");
					jugador.appendChild(dorsal);
					dorsal.appendChild(document.createTextNode(Byte.toString(a.getDorsal())));
					Element golesMarcados = document.createElement("GolesMarcados");
					jugador.appendChild(golesMarcados);
					golesMarcados.appendChild(document.createTextNode(Integer.toString(a.getGolesMarcados())));
					Element jugadas = document.createElement("Jugadas");
					jugador.appendChild(jugadas);
					for(int j=0; j< a.getListaJugadas().size();j++){
						Element jugada = document.createElement("Jugada");
						jugadas.appendChild(jugada);
						jugada.appendChild(document.createTextNode(Integer.toString(Main.listaJugadasComplejas.indexOf(a.getListaJugadas().get(j)))));
					}
				}
			}
			
			File folder = new File("D:\\XML");
			if (!folder.exists()){
				folder.mkdirs();
			}
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult fileResult = new StreamResult(new File("D:\\XML\\BDjugadores.xml"));
			transformer.transform(source, fileResult);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		System.out.println("...JUGADORES GUARDADOS EXITOSAMENTE");
	}
	
	public void LeerJugadores(){
		  try {
			File fichero = new File("D:\\XML\\BDjugadores.xml");
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			if(!fichero.exists()){
				System.out.println("..NO EXISTE REGISTRO DE JUGADORES");
				return;
			}
			Document document = documentBuilder.parse(fichero);
			Element raiz = document.getDocumentElement();
			Element arquero = (Element) raiz.getElementsByTagName("Arquero");
			Element delantero = (Element) raiz.getElementsByTagName("Delantero");
			NodeList lista_JugadoresD = delantero.getElementsByTagName("Jugador"); // lista los jugadores de el nodo delantero
			NodeList lista_JugadoresA = arquero.getElementsByTagName("Jugador"); // lista los jugadores del nodo arquero
			for (int i = 0 ; i < lista_JugadoresD.getLength(); i++){
				Element jugadorD =(Element) lista_JugadoresD.item(i); // Saca el elemento jugador
				String nombre = jugadorD.getElementsByTagName("Nombre").item(0).getTextContent();
				String dorsal = jugadorD.getElementsByTagName("Dorsal").item(0).getTextContent();
				String NumeroDeGoles = jugadorD.getElementsByTagName("GolesMarcados").item(0).getTextContent();
			}
			for(int i = 0; i< lista_JugadoresA.getLength(); i++){
				Element jugadorA = (Element) lista_JugadoresA.item(i);
				String nombre = jugadorA.getElementsByTagName("Nombre").item(0).getTextContent();
				String dorsal = jugadorA.getElementsByTagName("Dorsal").item(0).getTextContent();
				String TsinGoles = jugadorA.getElementsByTagName("TiempoSinGol").item(0).getTextContent();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}  

}

