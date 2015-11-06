package objetos.futbol.varios;

import objetos.futbol.UI.Main;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Enumeration;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.*;

public class GestorBDJugadores {

	public void guardarJugadores(){
		System.out.println("...Guardondo jugadores");
		if(Main.listaJugadores.size() == 0){
			System.out.println("No hay jugadores");
			return;
		}
	}

}
