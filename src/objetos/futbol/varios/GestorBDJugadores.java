package objetos.futbol.varios;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.JugadaCompleja;

import java.io.*;
import java.util.ArrayList;

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
		Delantero A;
		Arquero B;
		ArrayList <JugadaCompleja> list = new ArrayList<>();
		System.out.println("CARGANDO JUGADORES");
		  try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File fichero = new File("D:\\XML\\BDjugadores.xml");
			File fichero2 = new File("C:\\Temp\\bd\\BDjugadores.xml");
			if(!fichero.exists()&&!fichero2.exists()){
				return;
			}
			Document document = documentBuilder.parse(new InputSource(new FileInputStream("D:\\XML\\BDjugadores.xml")));
			if(fichero.exists()){
				document = documentBuilder.parse(new InputSource(new FileInputStream("C:\\Windows\\Temp\\BDjugadores.xml")));
			}
			else{
				document = documentBuilder.parse(new InputSource(new FileInputStream("D:\\XML\\BDjugadores.xml")));
			}
			//Raiz
			Element raiz = document.getDocumentElement(); 
			//Delantero
			Element delantero = (Element) raiz.getFirstChild();
			//Arquero 
			Element arquero = (Element) raiz.getLastChild();
			//Lista delanteros
			NodeList Lista_JugadoresD = delantero.getElementsByTagName("Jugador");
			//Lista arqueros
			NodeList Lista_JugadoresA = arquero.getElementsByTagName("Jugador");
			for(int i = 0; i< Lista_JugadoresD.getLength();i++){
				list.clear();
				Element jugador =(Element) Lista_JugadoresD.item(i);
				String nombre = jugador.getElementsByTagName("Nombre").item(0).getTextContent();
				String dorsal = jugador.getElementsByTagName("Dorsal").item(0).getTextContent();
				NodeList Lista_jugadas = jugador.getElementsByTagName("Jugadas");
				for(int j = 0; j<Lista_jugadas.getLength();j++){
					Element jugada = (Element) Lista_jugadas.item(j);
					String index = jugada.getElementsByTagName("Jugada").item(0).getTextContent();
					list.add(Main.listaJugadasComplejas.get(Integer.valueOf(index)));
				}
				A = new Delantero(nombre,"Delantero",(short)0,Byte.valueOf(dorsal),list);
				Main.listaJugadores.add(A);
			}
			for(int i = 0; i<Lista_JugadoresA.getLength();i++){
				list.clear();
				Element jugador = (Element) Lista_JugadoresA.item(i);
				String nombre = jugador.getElementsByTagName("Nombre").item(0).getTextContent();
				String dorsal = jugador.getElementsByTagName("Dorsal").item(0).getTextContent();
				NodeList Lista_jugadas = jugador.getElementsByTagName("Jugadas");
				for(int j = 0; j<Lista_jugadas.getLength();j++){
					Element jugada = (Element) Lista_jugadas.item(j);
					String index = jugada.getElementsByTagName("Jugada").item(0).getTextContent();
					list.add(Main.listaJugadasComplejas.get(Integer.valueOf(index)));
				}
				B = new Arquero(nombre,"Arquero",0,Byte.valueOf(dorsal),list);
				Main.listaJugadores.add(B);
			}
			System.out.println("JUGADORES CARGADOS EXITOSAMENTE");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}  

}

