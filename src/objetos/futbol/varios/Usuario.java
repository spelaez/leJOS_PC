package objetos.futbol.varios;
/**
 * Interfaz para ser implementada por los tipos de usuarios
 * @author Santiago Pelaez
 *
 */
public interface Usuario {

public void setNombre(String nombre);
public void setClave(String clave);
	
public String getClave();
public String getNombre();
public void lanzarMenu();
}
