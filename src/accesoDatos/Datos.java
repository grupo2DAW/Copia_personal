package accesoDatos;

import java.util.Hashtable;
import java.util.Map;
import java.util.ArrayList;

import util.Fecha;
import modelo.Correo;
import modelo.Direccion;
import modelo.Nif;
import modelo.SesionUsuario;
import modelo.Usuario;

public class Datos {


	private ArrayList<Usuario> datosUsuarios;
	private ArrayList<SesionUsuario> datosSesiones;
	
	private Hashtable<String, String> equivalencias;


	//Constructor
	public Datos() {

		datosUsuarios = new ArrayList<Usuario>();
		datosSesiones = new ArrayList<SesionUsuario>();
		equivalencias = new Hashtable<String, String>();
		cargarDatosPrueba();
	}



	public ArrayList<Usuario> getDatosUsuarios() {
		return datosUsuarios;
	}


	public ArrayList<SesionUsuario> getDatosSesiones(){
		return datosSesiones;

	}

	public int getSesionesRegistradas(){
		return datosSesiones.size();
	}

	
	/**
	 * Obtiene el idUsr que equivale a la credencial recibida
	 *  
	 * @param credencialUsr , puede ser Nif, email, idUsr
	 * @return
	 */
	public String equivalenciaId(String credencialUsr){
		
		return equivalencias.get(credencialUsr);
	}
	
	
	
	
	/*Obtiene todos los usuarios almacenados en texto
	 * 
	 */
	public String textoDatosUsuarios(){

		StringBuilder aux = new StringBuilder();
		for (Usuario u: datosUsuarios){
			aux.append("\n" + u);
		}
		return aux.toString();
	}

	

	

	/**
	 * Muestra por consola todos los usuarios almacenados.
	 */
	public String volcarDatosUsuarios() {

		StringBuilder aux = new StringBuilder();
		for (Usuario u: datosUsuarios) {
			aux.append("<sesion>"
					+"<usr>" 
					+"<attrib>"+ u.getUsr().getNif() +"</attrib>"
					+"<attrib>"+ u.getUsr().getNombre() +"</attrib>"
					+"<attrib>"+ u.getUsr().getApellidos() +"</attrib>"
					+"<attrib>"+ u.getUsr().getIdUsr() +"</attrib>"
					+"<attrib>"+ u.getUsr().getDomicilio() +"</attrib>"
					+"<attrib>"+ u.getUsr().getCorreo() +"</attrib>"
					+"<attrib>"+ u.getUsr().getFechaNacimiento() +"</attrib>"
					+"<attrib>"+ u.getUsr().getFechaAlta() +"</attrib>"
					+"<attrib>"+ u.getUsr().getClaveAcceso() +"</attrib>"
					+"<attrib>"+ u.getUsr().getRol() +"</attrib>"
					+ "</usr>"
					+"<atrib>"+u.getFechaAlta()+"</atrib>"
					+"</sesion>");
			//Falta resolver el método getUsr
		}
		return aux.toString();
	}


	public String volcarDatosSesiones() {

		StringBuilder aux = new StringBuilder();
		for (SesionUsuario s: datosSesiones) {
			aux.append("<sesion>"
					+ "<usr>" 
					+"<attrib>"+ s.getUsr().getNif() +"</attrib>"
					+"<attrib>"+ s.getUsr().getNombre()+"</attrib>"
					+"<attrib>"+ s.getUsr().getApellidos()+"</attrib>"
					+"<attrib>"+ s.getUsr().getIdUsr()+"</attrib>"
					+"<attrib>"+ s.getUsr().getDomicilio()+"</attrib>"
					+"<attrib>"+ s.getUsr().getCorreo()+"</attrib>"
					+"<attrib>"+ s.getUsr().getFechaNacimiento()+"</attrib>"
					+"<attrib>"+ s.getUsr().getFechaAlta()+"</attrib>"
					+"<attrib>"+ s.getUsr().getClaveAcceso()+"</attrib>"
					+"<attrib>"+ s.getUsr().getRol()+"</attrib>"
					+ "</usr>"
					+ "</sesion>"
					);

		}
		return aux.toString();
	}


	/**
	 * Genera datos de prueba válidos dentro 
	 * del almacén de datos.
	 */
	private void cargarDatosPrueba() {
		final int MAX_USUARIOS_PRUEBA = 10;
		for (int i = 0; i < MAX_USUARIOS_PRUEBA; i++) {
			Usuario usr = new Usuario(new Nif("0234455"+ i + "K"), "Pepe" + i,
					"López" + " Pérez" +i, new Direccion("30132","C/Luna", "27", "Murcia", "España"), 
					new Correo("pepe" + i + "@gmail.com"), new Fecha(1990,11,12), 
					new Fecha( 2014,12,03), "miau" + i, "usuario normal");
			
			
			datosUsuarios.add(usr);
			
			//Añade equivalencias para idUsr, hacemos el mismo IdUsr, Nif y email
			equivalencias.put(usr.getIdUsr(), usr.getIdUsr());
			equivalencias.put(usr.getNif().toString(), usr.getIdUsr());
			equivalencias.put(usr.getCorreo().toString().toUpperCase(), usr.getIdUsr());
			
		}
	}
/**
	public Usuario buscarUsuario(String idUsr){
		for (int i = 0; i < datosUsuarios.size() ; i++) {
			if(datosUsuarios.get(i).getIdUsr().equals(idUsr.toUpperCase())){
				return datosUsuarios.get(i);		
			}
		}
		return null;
	}
	
	*/
	
	public void registrarSesion(SesionUsuario sesionUsuario){
		datosSesiones.add(sesionUsuario);

	}
/**Búsqueda binaria de Usuario, cambiamos por el método buscarUsuario ya que este suponemos que optimiza tiempo.
 *  
 * @param idUsr
 * @return
 */
	
	public Usuario buscarUsuario(String idUsr){
		
		int comparacion;
		int inicio = 0;
		int fin = datosUsuarios.size() -1;
		int medio;
		while ( inicio <= fin){
			medio = (inicio + fin) /2;
			comparacion = datosUsuarios.get(medio).getIdUsr().compareToIgnoreCase(idUsr);
			
			if (comparacion == 0){
				return datosUsuarios.get(medio);
			}
			if ( comparacion < 0){
			
				inicio = medio + 1;
			}			
			else{
				fin = medio -1;
			}				
			}
		
		return null;
		}
	
	
	
} //class
