package objetos.futbol.varios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;

public class GestorBDEstado {

	public void crearBuffer(Futbolista x, JugadaCompleja y){
		try {
			File fich = new File("src\\gestorBD\\Buffer.txt");
			if(fich.exists()){
				BufferedWriter bw = new BufferedWriter(new FileWriter(fich,true));
				if(x instanceof Arquero){
					String t = "Arquero";
					bw.write(t );
					bw.newLine();
					String n = y.getNombre();
					bw.write(n);
					bw.newLine();
					String time =Long.toString(((System.currentTimeMillis() - Main.tInicio)/ 1000));
					bw.write(time);
					bw.newLine();
					
				}
				else if (x instanceof Delantero){
					String t = "Delantero";
					bw.write(t );
					bw.newLine();
					String n = y.getNombre();
					bw.write(n );
					bw.newLine();
					String time =Long.toString(((System.currentTimeMillis() - Main.tInicio)/ 1000));
					bw.write(time);
					bw.newLine();
				
				}
				bw.close();
			}
			else{
				BufferedWriter bw = new BufferedWriter(new FileWriter(fich));
				if(x instanceof Arquero){
					String t = "Arquero";
					bw.write(t);
					bw.newLine();
					String n = y.getNombre();
					bw.write(n);
					bw.newLine();
					String time =Long.toString(((System.currentTimeMillis() - Main.tInicio)/ 1000));
					bw.write(time);
					bw.newLine();
				
				}
				else if (x instanceof Delantero){
					String t = "Delantero";
					bw.write(t );
					bw.newLine();
					String n = y.getNombre();
					bw.write(n );
					bw.newLine();
					String time =Long.toString(((System.currentTimeMillis() - Main.tInicio)/ 1000));
					bw.write(time);
					bw.newLine();
					
				}
				bw.close();
			}
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void borrarBuffer(){
		File fich = new File("src\\gestorBD\\Buffer.txt");
		if(fich.exists()){
			fich.delete();
		}
	}
	
	public void borrarEstado(){
		File fich = new File("src\\gestorBD\\Estado.xml");
		if(fich.exists()){
			fich.delete();
		}
	}
	public void guardarEstado(){
		try {
			DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder Builder = Factory.newDocumentBuilder();
			
			//Elemento raiz
			Document document = Builder.newDocument();
			Element raiz = document.createElement("Estado");
			document.appendChild(raiz);
			
			//Elemento Delantero
			Element delantero =  document.createElement("Delantero");
			raiz.appendChild(delantero);
			Element nombred = document.createElement("Nombre");
			delantero.appendChild(nombred);
			nombred.appendChild(document.createTextNode(Main.r2.getJugador().getNombre()));
			Element goles = document.createElement("GolesMarcados");
			delantero.appendChild(goles);
			goles.appendChild(document.createTextNode(Short.toString(((Delantero)Main.r2.getJugador()).getGolesMarcados())));
			
			//Elemento Arquero
			Element arquero =  document.createElement("Arquero");
			raiz.appendChild(arquero);
			Element nombrea = document.createElement("Nombre");
			arquero.appendChild(nombrea);
			nombrea.appendChild(document.createTextNode(Main.r1.getJugador().getNombre()));
			Element TiempoSin = document.createElement("TiempoSinGol");
			arquero.appendChild(TiempoSin);
			TiempoSin.appendChild(document.createTextNode(Integer.toString(((Arquero)(Main.r1.getJugador())).getTiempoSinGoles())));
			
			//lectura
			File archivo = new File("src\\gestorBD\\Buffer.txt");
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			
			String linea;
			while((linea = br.readLine())!= null){
				if(linea.equals("Arquero")){
					
					
					Element Jugada = document.createElement("Jugadarealizadas");
					arquero.appendChild(Jugada);
					Jugada.appendChild(document.createTextNode(br.readLine()));
					Element tiempo = document.createElement("TiempoEnQueSeEjecuto");
					Jugada.appendChild(tiempo);
					tiempo.appendChild(document.createTextNode(br.readLine()));
				}
				else if(linea.equals("Delantero")){
					
					Element Jugada = document.createElement("JugadaRealizadas");
					delantero.appendChild(Jugada);
					Jugada.appendChild(document.createTextNode(br.readLine()));
					Element tiempo = document.createElement("TiempoEnQueSeEjecuto");
					Jugada.appendChild(tiempo);
					tiempo.appendChild(document.createTextNode(br.readLine()));
				}
			}
			 if( null != fr ){   
	               fr.close();     
	          } 
			 File folder = new File("src\\gestorBD");
				if (!folder.exists()){
					folder.mkdirs();
				}
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				DOMSource source = new DOMSource(document);
				StreamResult fileResult = new StreamResult(new File("src\\gestorBD\\Estado.xml"));
				transformer.transform(source, fileResult);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public void leerEstado(){
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File fichero = new File("src\\gestorBD\\Estado.xml");
			if(!fichero.exists()){
				return;
			}
			Document document = documentBuilder.parse(new InputSource(new FileInputStream("src\\gestorBD\\Estado.xml")));
			if(fichero.exists()){
				document = documentBuilder.parse(new InputSource(new FileInputStream("src\\gestorBD\\Estado.xml")));
			}
			System.out.println("Estadisticas");
			//Raiz
			Element raiz = document.getDocumentElement(); 
			//Delantero
			Element delantero = (Element) raiz.getFirstChild();
			//Arquero 
			Element arquero = (Element) raiz.getLastChild();
			//nombre delantero
			Element nombreD = (Element) delantero.getFirstChild();
			String name = nombreD.getTextContent();
			System.out.println("Delantero");
			System.out.println(name);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
