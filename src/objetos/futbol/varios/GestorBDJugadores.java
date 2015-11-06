package objetos.futbol.varios;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
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

import org.xml.sax.InputSource;
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
					Element nombre = document.createElement(a.getNombre());
					arquero.appendChild(nombre);
					Element dorsal = document.createElement("Dorsal");
					nombre.appendChild(dorsal);
					dorsal.appendChild(document.createTextNode(Byte.toString(a.getDorsal())));
					Element tiempoSinGol = document.createElement("Tiempo sin gol");
					tiempoSinGol.appendChild(document.createTextNode(Integer.toString(a.getTiempoSinGoles())));
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
	}
}
