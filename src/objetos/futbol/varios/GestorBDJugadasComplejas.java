package objetos.futbol.varios;
import objetos.futbol.UI.Main;
import objetos.futbol.jugadores.JugadaComplejaDefensiva;
import objetos.futbol.jugadores.JugadaComplejaOfensiva;
import objetos.futbol.jugadores.JugadaComplejaTiroLibre;
import objetos.futbol.robots.JugadaPrimitiva;

import java.io.File;
import java.io.FileInputStream;
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
import org.w3c.dom.*;

public class GestorBDJugadasComplejas {

	public void guardarJugadas(){
		System.out.println(".... Guarardando jugadas");
		if(Main.listaJugadasComplejas.size()==0){
			System.out.println("No hay jugadas");
			return;
		}
		try {
			DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder Builder = Factory.newDocumentBuilder();

			//Elemento Raiz;
			Document document = Builder.newDocument();
			Element raiz = document.createElement("Jugadas_Complejas");
			document.appendChild(raiz);

			//Jugada Compleja Defensiva
			Element defensiva =  document.createElement("Defensiva");
			raiz.appendChild(defensiva);

			//Jugada Compleja Ofensiva
			Element ofensiva =  document.createElement("Ofensiva");
			raiz.appendChild(ofensiva);

			//Jugada Compleja Tiro Libro
			Element tirolibre =  document.createElement("Tiro_Libre");
			raiz.appendChild(tirolibre);

			//Atributos
			for (int i=0;i<Main.listaJugadasComplejas.size();i++){
				if(Main.listaJugadasComplejas.get(i) instanceof JugadaComplejaDefensiva){
					JugadaComplejaDefensiva a = (JugadaComplejaDefensiva) Main.listaJugadasComplejas.get(i);
					Element jugada = document.createElement("Jugada");
					defensiva.appendChild(jugada);
					Element nombre = document.createElement("Nombre");
					jugada.appendChild(nombre);
					nombre.appendChild(document.createTextNode(a.getNombre()));
					Element fecha = document.createElement("Fecha_creacion");
					jugada.appendChild(fecha);
					fecha.appendChild(document.createTextNode(a.getfechaCreacion()));
					Element autor = document.createElement("Autor");
					jugada.appendChild(autor);
					autor.appendChild(document.createTextNode(a.getAutor().getNombre()));
					Element jugadas = document.createElement("Jugadas");
					jugada.appendChild(jugadas);
					for(int j=0; j< a.getJugada().size();j++){
						Element jugadap = document.createElement("Jugada_primitiva");
						jugadas.appendChild(jugadap);
						jugadap.appendChild(document.createTextNode(Integer.toString(a.getJugada().get(j).getIdJugada())));
					}
					Element explicacion = document.createElement("Explicacion");
					jugada.appendChild(explicacion);
					explicacion.appendChild(document.createTextNode(a.getExplicacion()));
					Element complejidad = document.createElement("Complejidad");
					jugada.appendChild(complejidad);
					complejidad.appendChild(document.createTextNode(Integer.toString(a.getnumcomplejidad())));
					Element descripcion = document.createElement("Descripcion");
					jugada.appendChild(descripcion);
					descripcion.appendChild(document.createTextNode(a.getDescripcion()));

				}
				else if(Main.listaJugadasComplejas.get(i) instanceof JugadaComplejaOfensiva){

					JugadaComplejaOfensiva a = (JugadaComplejaOfensiva) Main.listaJugadasComplejas.get(i);
					Element jugada = document.createElement("Jugada");
					ofensiva.appendChild(jugada);
					Element nombre = document.createElement("Nombre");
					jugada.appendChild(nombre);
					nombre.appendChild(document.createTextNode(a.getNombre()));
					Element fecha = document.createElement("Fecha_creacion");
					jugada.appendChild(fecha);
					fecha.appendChild(document.createTextNode(a.getfechaCreacion()));
					Element autor = document.createElement("Autor");
					jugada.appendChild(autor);
					autor.appendChild(document.createTextNode(a.getAutor().getNombre()));
					Element jugadas = document.createElement("Jugadas");
					jugada.appendChild(jugadas);
					for(int j=0; j< a.getJugada().size();j++){
						Element jugadap = document.createElement("Jugada_primitiva");
						jugadas.appendChild(jugadap);
						jugadap.appendChild(document.createTextNode(Integer.toString(a.getJugada().get(j).getIdJugada())));
					}
					Element explicacion = document.createElement("Explicacion");
					jugada.appendChild(explicacion);
					explicacion.appendChild(document.createTextNode(a.getExplicacion()));
					Element efectividad = document.createElement("Efectividad");
					jugada.appendChild(efectividad);
					efectividad.appendChild(document.createTextNode(Integer.toString(a.getNumEfectividad())));
					Element descripcion = document.createElement("Descripcion");
					jugada.appendChild(descripcion);
					descripcion.appendChild(document.createTextNode(a.getDescripcion()));
				}
				else if(Main.listaJugadasComplejas.get(i) instanceof JugadaComplejaTiroLibre){

					JugadaComplejaTiroLibre a = (JugadaComplejaTiroLibre) Main.listaJugadasComplejas.get(i);
					Element jugada = document.createElement("Jugada");
					tirolibre.appendChild(jugada);
					Element nombre = document.createElement("Nombre");
					jugada.appendChild(nombre);
					nombre.appendChild(document.createTextNode(a.getNombre()));
					Element fecha = document.createElement("Fecha_creacion");
					jugada.appendChild(fecha);
					fecha.appendChild(document.createTextNode(a.getfechaCreacion()));
					Element autor = document.createElement("Autor");
					jugada.appendChild(autor);
					autor.appendChild(document.createTextNode(a.getAutor().getNombre()));
					Element jugadas = document.createElement("Jugadas");
					jugada.appendChild(jugadas);
					for(int j=0; j< a.getJugada().size();j++){
						Element jugadap = document.createElement("Jugada_primitiva");
						jugadas.appendChild(jugadap);
						jugadap.appendChild(document.createTextNode(Integer.toString(a.getJugada().get(j).getIdJugada())));
					}
					Element explicacion = document.createElement("Explicacion");
					jugada.appendChild(explicacion);
					explicacion.appendChild(document.createTextNode(a.getExplicacion()));
					Element potencia = document.createElement("Potencia_Chute");
					jugada.appendChild(potencia);
					potencia.appendChild(document.createTextNode(Integer.toString(a.getNumPotencia())));
					Element efecto = document.createElement("Efecto");
					jugada.appendChild(efecto);
					efecto.appendChild(document.createTextNode(Integer.toString(a.getNumEfecto())));
					Element descripcion = document.createElement("Descripcion");
					jugada.appendChild(descripcion);
					descripcion.appendChild(document.createTextNode(a.getDescripcion()));
				}

			}
			File folder = new File("src\\gestorBD");
			if (!folder.exists()){
				folder.mkdirs();
			}
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult fileResult = new StreamResult(new File("src\\gestorBD\\BDjugadas.xml"));
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
		System.out.println("Jugadas guardas exitosamente");
	}

	public void leerJugadas(){
		System.out.println("Leyendo jugadas....");
		try {
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			File fichero = new File("src\\gestorBD\\BDjugadas.xml");
			File fichero2 = new File("C:\\temp\\bd\\BDjugadas.xml");

			if(!fichero.exists() && !fichero2.exists()){
				return;
			}
			Document document= documentBuilder.parse(new InputSource(new FileInputStream("src\\gestorBD\\BDjugadas.xml")));
			if(fichero.exists()){
				document = documentBuilder.parse(new InputSource(new FileInputStream("src\\gestorBD\\BDjugadas.xml")));
			}
			else{
				document = documentBuilder.parse(new InputSource(new FileInputStream("C:\\temp\\bd\\BDUsuarios.xml")));
				System.out.println("estoy leyendo generica");
			}

			Element raiz = document.getDocumentElement(); //raiz
			NodeList x= raiz.getChildNodes();
			Element defensiva = (Element)  x.item(0);
			NodeList lista_jugadasdef = defensiva.getElementsByTagName("Jugada"); // lista las jugadas
			for(int i=0;i<lista_jugadasdef.getLength();i++){
				Element jugada = (Element) lista_jugadasdef.item(i);    
				String nombre=jugada.getElementsByTagName("Nombre").item(0).getTextContent();
				String fecha=jugada.getElementsByTagName("Fecha_creacion").item(0).getTextContent();
				String autor=jugada.getElementsByTagName("Autor").item(0).getTextContent();
				String explicacion=jugada.getElementsByTagName("Explicacion").item(0).getTextContent();
				//int complejidad=Integer.valueOf(jugada.getElementsByTagName("Complejidad").item(0).getTextContent());
				//String descripcion=jugada.getElementsByTagName("Descripcion").item(0).getTextContent();
				NodeList primitivas=jugada.getElementsByTagName("Jugadas");
				ArrayList<JugadaPrimitiva> listajugadas=new ArrayList<>();
				for(int j=0;j<primitivas.getLength();j++){
					NodeList prim = primitivas.item(j).getChildNodes();
					for(int k = 0; k<prim.getLength(); k++){
						int id = Integer.valueOf(prim.item(k).getTextContent());

						if (id==1){
							listajugadas.add(Main.trotar);
						}
						else if(id==2){
							listajugadas.add(Main.correr);
						}
						else if(id==3){
							listajugadas.add(Main.retroceder);
						}
						else if(id==4){
							listajugadas.add(Main.girarDerecha);
						}
						else if(id==5){
							listajugadas.add(Main.girarIzquierda);
						}
						else if(id==6){
							listajugadas.add(Main.chutar);
						}
						else if(id==7){
							listajugadas.add(Main.patear);
						}
					}
				}
				Main.listaJugadasComplejas.add(new JugadaComplejaDefensiva(nombre,fecha,(UsuarioAdministrador)Main.listaUsuarios.get(autor),listajugadas,explicacion));

			}




			Element ofensiva = (Element)  x.item(1);
			NodeList lista_jugadasof = ofensiva.getElementsByTagName("Jugada"); // lista los jugadas del nodo Ofensiva
			for(int i=0;i<lista_jugadasof.getLength();i++){
				Element jugada = (Element) lista_jugadasof.item(i);    
				String nombre=jugada.getElementsByTagName("Nombre").item(0).getTextContent();
				String fecha=jugada.getElementsByTagName("Fecha_creacion").item(0).getTextContent();
				String autor=jugada.getElementsByTagName("Autor").item(0).getTextContent();
				String explicacion=jugada.getElementsByTagName("Explicacion").item(0).getTextContent();
				//int complejidad=Integer.valueOf(jugada.getElementsByTagName("Complejidad").item(0).getTextContent());
				//String descripcion=jugada.getElementsByTagName("Descripcion").item(0).getTextContent();
				NodeList primitivas=jugada.getElementsByTagName("Jugadas");
				ArrayList<JugadaPrimitiva> listajugadas=new ArrayList<>();
				for(int j=0;j<primitivas.getLength();j++){
					Element primi = (Element) primitivas.item(j);
					int id=Integer.valueOf((primi.getElementsByTagName("Jugada_primitiva").item(0).getTextContent()));
					if (id==1){
						listajugadas.add(Main.trotar);
					}
					else if(id==2){
						listajugadas.add(Main.correr);
					}
					else if(id==3){
						listajugadas.add(Main.retroceder);
					}
					else if(id==4){
						listajugadas.add(Main.girarDerecha);
					}
					else if(id==5){
						listajugadas.add(Main.girarIzquierda);
					}
					else if(id==6){
						listajugadas.add(Main.chutar);
					}
					else if(id==7){
						listajugadas.add(Main.patear);
					}
				}
				Main.listaJugadasComplejas.add(new JugadaComplejaOfensiva(nombre,fecha,(UsuarioAdministrador)Main.listaUsuarios.get(autor),listajugadas,explicacion));
			}



			Element tiro = (Element)  x.item(2);
			NodeList lista_jugadastiro = tiro.getElementsByTagName("Jugada"); // lista las jugadas
			for(int i=0;i<lista_jugadastiro.getLength();i++){
				Element jugada = (Element) lista_jugadastiro.item(i);    
				String nombre=jugada.getElementsByTagName("Nombre").item(0).getTextContent();
				String fecha=jugada.getElementsByTagName("Fecha_creacion").item(0).getTextContent();
				String autor=jugada.getElementsByTagName("Autor").item(0).getTextContent();
				String explicacion=jugada.getElementsByTagName("Explicacion").item(0).getTextContent();
				//int complejidad=Integer.valueOf(jugada.getElementsByTagName("Complejidad").item(0).getTextContent());
				//String descripcion=jugada.getElementsByTagName("Descripcion").item(0).getTextContent();
				NodeList primitivas=jugada.getElementsByTagName("Jugadas");
				ArrayList<JugadaPrimitiva> listajugadas=new ArrayList<>();
				for(int j=0;j<primitivas.getLength();j++){
					Element primi = (Element) primitivas.item(j);
					int id=Integer.valueOf((primi.getElementsByTagName("Jugada_primitiva").item(0).getTextContent()));
					if (id==1){
						listajugadas.add(Main.trotar);
					}
					else if(id==2){
						listajugadas.add(Main.correr);
					}
					else if(id==3){
						listajugadas.add(Main.retroceder);
					}
					else if(id==4){
						listajugadas.add(Main.girarDerecha);
					}
					else if(id==5){
						listajugadas.add(Main.girarIzquierda);
					}
					else if(id==6){
						listajugadas.add(Main.chutar);
					}
					else if(id==7){
						listajugadas.add(Main.patear);
					}
				}
				Main.listaJugadasComplejas.add(new JugadaComplejaTiroLibre(nombre,fecha,(UsuarioAdministrador)Main.listaUsuarios.get(autor),listajugadas,explicacion));
			}


		}catch(Exception e){
			System.out.println("el");
		}
	}
}
