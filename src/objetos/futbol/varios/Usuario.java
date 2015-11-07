package objetos.futbol.varios;

import java.util.ArrayList;

public interface Usuario {

public void setNombre(String nombre);
public void setClave(String clave);
	
public String getClave();
public String getNombre();
public ArrayList<Integer> getPermisos();

public void lanzarMenu();
}
