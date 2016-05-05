package modelo;

import util.Fecha;
import modelo.Nif;

/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Usuario según el modelo2.
 *  
 *  @since: prototipo2.0
 *  @source: Persona.java 
 *  @version: 2.0 - 16/03/2016 
 *  @author: Luis H.E.
 */

public abstract class Persona {

	
	// Atributos
	//Protected: los datos sólo son accesibles de las clases que heredan, desde otras clase se quedan como privados
	protected Nif nif;
	protected String nombre;
	protected String apellidos;
	protected Direccion domicilio; // Como la clase Direccion están en el mismo paquete, la reconoce, sino se importa
	protected Correo correo;
	protected Fecha fechaNacimiento;
	

	// Constructores
	/**
	 * Constructor convencional.
	 * Establece el valor inicial de cada uno de los atributos.
	 * Recibe parámetros que se corresponden con los atributos menos idUsr
	 * que se genera y controla internamente.
	 */
	public Persona(Nif nif, String nombre, String apellidos, 
			Direccion domicilio, Correo correo, Fecha fechaNacimiento) {
		
		setNif(nif);
		setNombre(nombre);
		setApellidos(apellidos);
		setDomicilio(domicilio);
		setCorreo(correo);
		setFechaNacimiento(fechaNacimiento);
		
	}


	// Métodos de acceso.

	public Nif getNif() {
		return nif;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}


	public Direccion getDomicilio() {
		return domicilio;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Correo getCorreo() {
		return correo;
	}

	public void setNif(Nif nif) {
		
		assert nif != null;
		assert nifValido(nif);
		
		this.nif=nif;
		
	}
	

	private boolean nifValido(Nif nif) {		
		
		assert nif.toString().matches("^[0-9]{8}[a-zA-Z]{1}$");
		// Letra de control.
		return letraValida(nif);		
	}

	private boolean letraValida(Nif nif) {
		// Algoritmo de obtención letra
		//--Pendiente--
		return true;
	}
	

	public void setDomicilio(Direccion domicilio) {
		
		assert domicilio != null;
		assert domicilioValido(domicilio);
		this.domicilio = domicilio;
	}
	
	public boolean domicilioValido(Direccion domicilio) {
		
		assert domicilio != null;
		
		// Semántica.
		return direccionAutentica(domicilio);
	}
	
	private boolean direccionAutentica(Direccion domicilio) {
		// Comprueba que la dirección no es falsa.
		//--Pendiente--
		return true;
	}
	


	public void setNombre(String nombre) {
		assert nombre != null;
		assert nombreValido(nombre);
		this.nombre = nombre;
		}

	private boolean nombreValido(String nombre) {
		return nombre.matches("^[A-Z][áéíóúa-z]+[ A-Záéíóú\\w ]*");
	}
	
	public void setApellidos(String apellidos) {
		assert apellidos != null;
		assert apellidosValidos(apellidos);
		this.apellidos = apellidos;
		// Detecta que no es tiempo de constructor.
	
	}

	private boolean apellidosValidos(String apellidos) {
		
		if ( apellidos != null
				&& apellidos.matches("^[A-Z][áéíóúa-z \\w]+")){
		
		return true;
	}
		return false;
	}
	
		public void setFechaNacimiento(Fecha fechaNacimiento) {
		assert fechaNacimiento != null;
		assert fechaNacimientoValida(fechaNacimiento);
		this.fechaNacimiento = fechaNacimiento;
	}

	private boolean fechaNacimientoValida(Fecha fechaNacimiento) {
		
		assert fechaNacimiento.toString().matches("^[0-9]{4}[/.-][0-9]{2}[/.-][0-9]{2}");
		assert fechaNacimientoCoherente(fechaNacimiento);
		
		return true;
	}
	
	private boolean fechaNacimientoCoherente(Fecha fechaNacimiento) {
		// Comprueba que fechaNacimiento no es, por ejemplo, del futuro
		
		//Fecha se puede comparar con equals(Fecha fecha)
		
		//Fecha se puede comparar con compareTo(Fecha fecha)
		
		if ((fechaNacimiento.compareTo(new Fecha()) >= 0)){
			return true;
			}
		
		return false;
	}
	
	public void setCorreo(Correo correo) {
		assert correo != null;
		assert correoValido(correo);
		this.correo = correo;
	}

	private boolean correoValido(Correo correo) {
		assert correo.toString().matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*"
							+ "@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$");
		// Semántica.
		return correoAutentico(correo);
	}
	
	private boolean correoAutentico(Correo correo) {
		// Comprueba que el correo no es falso
		// --Pendiente--
		return true;
	}
	
	
	// Métodos redefinidos

	/**
	 * Redefine el método heredado de la clase Objecto.
	 * @return el texto formateado del estado (valores de atributos) 
	 * del objeto de la clase Usuario  
	 */
	@Override
	public String toString() {
	
		return String.format(
				"\n nif: \t\t%s,"
				+ "\n nombre: \t%s,"
				+ "\n apellidos: \t%s,"
				+ "\n domicilio: \t%s,"
				+ "\n correo: \t%s,"
				+ "\n fechaNacimiento: \t%s,",
				nif, nombre, apellidos, domicilio, correo, 
				fechaNacimiento);		
	}

	
} // class