

/** 
 * Proyecto: Juego de la vida.
 * Pruebas iniciales de las clases Usuario y SesionUsuario del modelo1.
 * En esta versión no se han aplicado la mayoría de los estándares 
 * de diseño OO dirigidos a conseguir un "código limpio".
 * @since: prototipo1.0
 * @source: JVPrincipal.java 
 * @version: 1.1 - 21/01/2016 
 * @author: ajp
 */

import accesoDatos.Datos;
import accesoUsr.Presentacion;

public class JVPrincipal {

	public static void main(String[] args) {	

		Datos datos = new Datos();
		Presentacion presentacion = new Presentacion();
		//System.out.println(datos.volcarDatosUsuarios());

		if (presentacion.iniciarSesion(datos)) {
			presentacion.arrancarSimulacion();
		}

		
	}

} //class