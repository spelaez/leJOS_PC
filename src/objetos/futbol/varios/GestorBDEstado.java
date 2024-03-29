package objetos.futbol.varios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.Arquero;
import objetos.futbol.jugadores.Delantero;
import objetos.futbol.jugadores.Futbolista;
import objetos.futbol.jugadores.JugadaCompleja;
/**
 * Clase para crear, guardar, borrar, leer y cargar el estado de un partido
 * @author Jhon Eider Murillo Usuga
 *
 */
public class GestorBDEstado {
	/**
	 * Metodo para crear un buffer con las caracteristicas necesitadas
	 * @param x
	 * @param y
	 */
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
					if(Main.tPausa == 0){
						String time =Long.toString(((System.currentTimeMillis() - Main.tInicio)/ 1000));
						bw.write(time);
						bw.newLine();
					}
					else if(Main.tPausa>0){
						String time =Long.toString((((System.currentTimeMillis() - Main.tInicio)+Main.tPausa)/ 1000));
						bw.write(time);
						bw.newLine();
					}
					
				}
				else if (x instanceof Delantero){
					String t = "Delantero";
					bw.write(t );
					bw.newLine();
					String n = y.getNombre();
					bw.write(n );
					bw.newLine();
					if(Main.tPausa == 0){
						String time =Long.toString(((System.currentTimeMillis() - Main.tInicio)/ 1000));
						bw.write(time);
						bw.newLine();
					}
					else if(Main.tPausa>0){
						String time =Long.toString((((System.currentTimeMillis() - Main.tInicio)+Main.tPausa)/ 1000));
						bw.write(time);
						bw.newLine();
					}
				
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
	}//Cierre del metodo
	/**
	 * Metodo para borrar el buffer
	 */
	public void borrarBuffer(){
		File fich = new File("src\\gestorBD\\Buffer.txt");
		if(fich.exists()){
			fich.delete();
		}
	}//Cierre del metodo
	/**
	 * Metodo para borrar el estado guardado en el buffer
	 */
	public void borrarEstado(){
		File fich = new File("src\\gestorBD\\Estado.xml");
		if(fich.exists()){
			fich.delete();
		}
	}//Cierre del metodo
	/**
	 * Metodo para guardar el estado del partido en el buffer
	 */
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
					Element NOM = document.createElement("NombreJugada");
					Jugada.appendChild(NOM);
					NOM.appendChild(document.createTextNode(br.readLine()));
					Element tiempo = document.createElement("TiempoEnQueSeEjecuto");
					Jugada.appendChild(tiempo);
					tiempo.appendChild(document.createTextNode(br.readLine()));
				}
				else if(linea.equals("Delantero")){
					
					Element Jugada = document.createElement("Jugadarealizadas");
					delantero.appendChild(Jugada);
					Element NOM = document.createElement("NombreJugada");
					Jugada.appendChild(NOM);
					NOM.appendChild(document.createTextNode(br.readLine()));
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
	}//Cierre del metodo
	/**
	 * Metodo para leer el estado guardado en el buffer
	 */
	public void leerEstado(){
		Main.v2.ta2.setText(null);
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
			Main.v2.ta2.append("Estadisticas");
			//Raiz
			Element raiz = document.getDocumentElement(); 
			//Delantero
			Element delantero = (Element) raiz.getFirstChild();
			//Arquero 
			Element arquero = (Element) raiz.getLastChild();
			//nombre arquero
			Element nombreA = (Element) arquero.getFirstChild();
			String name = nombreA.getTextContent();
			Main.v2.ta2.append("\n Arquero");
			Main.v2.ta2.append("\n"+name);
			NodeList x= arquero.getChildNodes();
			Element tiempoSin = (Element)  x.item(1);
			String time = tiempoSin.getTextContent();
			Main.v2.ta2.append("\n Tiempo sin goles: "+ time );
			NodeList jugadas = arquero.getElementsByTagName("Jugadarealizadas");
		
			for(int i=0;i<Main.r1.getJugador().getListaJugadas().size();i++){
				int cont=0;
				ArrayList<String> tiempos = new ArrayList<>();
				for(int j=0; j<jugadas.getLength();j++){
					
					Element jug =(Element) jugadas.item(j);
					String nomj = jug.getElementsByTagName("NombreJugada").item(0).getTextContent();
					if(Main.r1.getJugador().getListaJugadas().get(i).getNombre().equals(nomj)){
						cont++;
						String tiempo = jug.getElementsByTagName("TiempoEnQueSeEjecuto").item(0).getTextContent();
						tiempos.add(tiempo);
					}
				}
				if(cont > 0){
					Main.v2.ta2.append("\n La jugada: " + Main.r1.getJugador().getListaJugadas().get(i).getNombre() + " Se realizo" );
					Main.v2.ta2.append("\n"+cont + " Veces \n" + "En los tiempos:");
					for(int j =0 ; j<tiempos.size();j++){
						Main.v2.ta2.append("\n"+tiempos.get(j) + " Segundos");
					}
				}
			}
			
			//nombre delantero
			Element nombreD = (Element) delantero.getFirstChild();
			String named = nombreD.getTextContent();
			Main.v2.ta2.append("\n Delantero");
			Main.v2.ta2.append("\n"+named);
			NodeList y = delantero.getChildNodes();
			Element goles = (Element) y.item(1);
			String numgoles = goles.getTextContent();
			Main.v2.ta2.append("\n Goles marcados: " + numgoles );
			NodeList jugadasR = delantero.getElementsByTagName("Jugadarealizadas");
			for(int i = 0;i<Main.r2.getJugador().getListaJugadas().size(); i++){
				int cont =0;
				ArrayList<String> tiempos = new ArrayList<>();
				for(int j=0;j<jugadasR.getLength();j++){
					Element jug = (Element) jugadasR.item(j);
					String nomj = jug.getElementsByTagName("NombreJugada").item(0).getTextContent();
					if(Main.r2.getJugador().getListaJugadas().get(i).getNombre().equals(nomj)){
						cont++;
						String tiempo = jug.getElementsByTagName("TiempoEnQueSeEjecuto").item(0).getTextContent();
						tiempos.add(tiempo);
					}
				}
				if(cont > 0){
					Main.v2.ta2.append("\n La jugada: " + Main.r2.getJugador().getListaJugadas().get(i).getNombre() + " Se realizo" );
					Main.v2.ta2.append("\n"+cont + " Veces \n" + "En los tiempos:");
					for(int j =0 ; j<tiempos.size();j++){
						Main.v2.ta2.append("\n"+tiempos.get(j) + " Segundos");
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			}		
	}//Cierre del metodo
	/**
	 * Metodo para cargar el estado del partido que se guardo en el buffer
	 */
	public void cargarEstado(){
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
			//Raiz
			Element raiz = document.getDocumentElement(); 
			//Delantero
			Element delantero = (Element) raiz.getFirstChild();
			//Arquero 
			Element arquero = (Element) raiz.getLastChild();
			//nombre arquero
			Element nombreA = (Element) arquero.getFirstChild();
			String name = nombreA.getTextContent();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//Cierre del metodo
}//Cierre de la clase
