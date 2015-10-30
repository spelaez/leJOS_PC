package objetos.futbol.UI;

public class Usuario {
protected String nombreUsuario;
protected String clave;

public boolean logIn(String nombreUsuario, String clave){
	return(this.nombreUsuario.equals(nombreUsuario) && this.clave.equals(clave));
}

public void logOut(){
	//System.exit(0);
}
}
