package objetos.futbol.varios;

public class Usuario {
protected String nombreUsuario;
protected String clave;

public Usuario(String nombreUsuario, String clave){
	this.nombreUsuario = nombreUsuario;
	this.clave = clave;
}
public void logOut(){
	//System.exit(0);
}
}
