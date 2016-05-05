package modelo;

import util.Fecha;

/** Proyecto: Juego de la vida.
 *  Implementa el concepto de Usuario según el modelo2.
 * 
 *  @since: prototipo2.0
 *  @source: Usuario.java 
 *  @version: 2.0 - 16/03/2016 
 *  @author: Luis H.E.
 */


//Declaramos la herencia
public class Usuario extends Persona {

	// Atributos	
	private String idUsr;
	private Fecha fechaAlta;
	private String claveAcceso;
	private String rol;

	// Constructores
	/**
	 * Constructor convencional.
	 * Establece el valor inicial de cada uno de los atributos.
	 * Recibe parámetros que se corresponden con los atributos menos idUsr
	 * que se genera y controla internamente.
	 */
	public Usuario(Nif nif, String nombre, String apellidos, 
			Direccion domicilio, Correo correo, Fecha fechaNacimiento,
			Fecha fechaAlta, String claveAcceso, String rol) {
		
		super(nif, nombre, apellidos, domicilio, correo, fechaNacimiento);
		
		idUsr = generarIdUsr();
		setFechaAlta(fechaAlta);
		setClaveAcceso(claveAcceso);
		setRol(rol);
	}

	/**
	 * Constructor por defecto.
	 * Establece el valor inicial, por defecto, de cada uno de los atributos.
	 * Llama al constructor convencional de la propia clase.
	 */
	public Usuario(){
	
		/*
		// Con super construye sólo la parte de Usuario que es Persona
		super("00000000A", "Nombre", "Apellido Apellido", 
				"domicilio", "correo@correo.com", "2015.01.01");
		
		
		//Y esta es la parte de Usuario
		idUsr = generarIdUsr();
		setFechaAlta(fechaAlta);
		setClaveAcceso(claveAcceso);
		setRol(rol);
		*/
		
		//Con this podemos construir todo en un solo apartado
				
	this(new Nif("12345678A"), "Nombre", "Apellido Apellido", 
			new Direccion(), new Correo(), new Fecha(), 
				new Fecha(), "claveAcceso", "rol");
	}

	/**
	 * Constructor copia.
	 * Establece el valor inicial de cada uno de los atributos a partir de
	 * los valores obtenidos de un objeto de su misma clase, recibido como parámetro.
	 * Llama al constructor convencional de la propia clase.
	 */
	
	//Tenemos que usar o métodos get para llegar a datos privados( usr.getNif(), usr.getNombre())
	// , o poner como protected los atributos en Persona
	
	public Usuario(Usuario usr) {
		this(usr.nif, usr.nombre, usr.apellidos, 
				usr.domicilio, usr.correo, usr.fechaNacimiento, 
				usr.fechaAlta, usr.claveAcceso, usr.rol);
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

	public String getIdUsr() {
		return idUsr;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public Fecha getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Correo getCorreo() {
		return correo;
	}

	public Fecha getFechaAlta() {
		return fechaAlta;
	}

	public String getRol() {
		return rol;
	}

	public void setNif(Nif nif) {
		assert nif != null;
		assert nifValido(nif);
		this.nif = nif;
		// Detecta que no es tiempo de constructor.
		if (this.idUsr != null) {
			reGenerarIdUsr();
		}
	}

	private boolean nifValido(Nif nif) {		
		assert nif.toString().matches("^[0-9]{8}[a-zA-Z]");
		// Letra de control.
		return letraValida(nif);		
	}

	private boolean letraValida(Nif nif) {
		// Algoritmo de obtención letra
		//--Pendiente--
		return true;
	}
	
	private void reGenerarIdUsr() {
		assert nif != null;
		assert nombre != null;
		assert apellidos != null;
		idUsr = generarIdUsr();
	}
	
	private String generarIdUsr() {
		StringBuilder idUsr = new StringBuilder();
		// Primera letra nombre
		idUsr.append(nombre.charAt(0)); 

		// Primera letra de los apellidos, 1ª del primero y 1ª del segundo si lo hay
		String[] apellidos = this.apellidos.split(" ");
		idUsr.append(apellidos[0].charAt(0));
		if (apellidos.length > 1) {
			idUsr.append(apellidos[1].charAt(0));
		}

		// Últimos dos caracteres del nif
		idUsr.append(nif.toString().substring(nif.toString().length()-2));	
		
		// Comprueba que no existe y varía si es necesario.
		// ¿Cuantas veces debería intentarlo?
		while (buscarUsuario(idUsr.toString()) != null) {
			variarIdUsr(idUsr);
		}
		return idUsr.toString().toUpperCase();
	}

	private Usuario buscarUsuario(String idUsr) {
		// Busca y devuelve el usuario según su idUsr
		//--Pendiente--
		return null;
	}

	private void variarIdUsr(StringBuilder idUsr) {
		if (idUsr.charAt(4) == 'Z') {
			idUsr.setCharAt(4, 'A');
		}
		else {		
			// Cambia la última letra con la siguiente en el alfabeto.
			idUsr.setCharAt(4, (char) (idUsr.charAt(4) + 1));
		}
	}
	
	public void setNombre(String nombre) {
		assert nombre != null;
		assert nombreValido(nombre);
		this.nombre = nombre;
		// Detecta que no es tiempo de constructor.
		if (idUsr != null) {
			reGenerarIdUsr();
		}
	}

	private boolean nombreValido(String nombre) {
		return nombre.matches("^[A-Z][áéíóúa-z]+[ A-Záéíóú\\w ]*");
	}
	
	public void setApellidos(String apellidos) {
		assert apellidos != null;
		assert apellidosValidos(apellidos);
		this.apellidos = apellidos;
		// Detecta que no es tiempo de constructor.
		if (this.idUsr != null) {
			reGenerarIdUsr();
		}
	}

	private boolean apellidosValidos(String apellidos) {
		return apellidos.matches("^[A-Z][áéíóúa-z \\w]+");
	}
		
	
	public void setClaveAcceso(String claveAcceso) {
		assert claveAcceso != null;
		assert claveAccesoValida(claveAcceso);
		this.claveAcceso = encriptarCesar(claveAcceso);
	}

	private boolean claveAccesoValida(String claveAcceso) {
		return claveAcceso.matches("[A-ZÑa-zñ0-9%&#_-]{4,18}");
	}
	
	private String encriptarCesar(String claveAcceso) {
		StringBuilder encriptada = new StringBuilder();
		String alfabetoNormal =   "%&#_-0123456789abcdefghijklmnñopqrstuvwxyzABCEFGHIJKLMNÑOPQRSTUVWXYZ";
		String alfabetoDesplazado = "6789abcdefghijklmnñopqrstuvwxyzABCEFGHIJKLMNÑOPQRSTUVWXYZ%&#_-012345";
		for (char i = 0; i < claveAcceso.length(); i++) {
			int posicion = alfabetoNormal.indexOf(claveAcceso.charAt(i));
			encriptada.append(alfabetoDesplazado.charAt(posicion));
		}
		return encriptada.toString();
	}

	public void setFechaNacimiento(Fecha fechaNacimiento) {
		assert fechaNacimiento != null;
		assert fechaNacimientoValida(fechaNacimiento);
		this.fechaNacimiento = fechaNacimiento;
	}

	private boolean fechaNacimientoValida(Fecha fechaNacimiento) {
		assert fechaNacimiento.toString().matches("^[0-9]{4}[/.-][0-9]{2}[/.-][0-9]{2}");
		//Semántica
		return fechaNacimientoCoherente(fechaNacimiento);
	}
	
	private boolean fechaNacimientoCoherente(Fecha fechaNacimiento) {
		// Comprueba que fechaNacimiento no es, por ejemplo, del futuro
		// --Pendiente--
		return true;
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
	
	public void setFechaAlta(Fecha fechaAlta) {
		assert fechaAlta != null;
		assert fechaAltaValida(fechaAlta);
		this.fechaAlta = fechaAlta;
	}

	private boolean fechaAltaValida(Fecha fechaAlta) {
		assert fechaAlta.toString().matches("^[0-9]{4}[/.-][0-9]{2}[/.-][0-9]{2}$");
		// Semántica.
		return fechaAltaCoherente(fechaAlta);
	}
	
	private boolean fechaAltaCoherente(Fecha fechaAlta) {
		// Comprueba que fechaAlta no es, por ejemplo, del futuro
		// --Pendiente--
		return true;
	}

	public void setRol(String rol) {
		assert rol != null;
		assert rolValido(rol);
		this.rol = rol;
	}

	private boolean rolValido(String rol) {
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
				+ "\n idUsr: \t%s,"
				+ "\n domicilio: \t%s,"
				+ "\n correo: \t%s,"
				+ "\n fechaNacimiento: \t%s,"
				+ "\n fechaAlta: \t%s,"
				+ "\n claveAcceso: \t%s,"
				+ "\n rol: \t\t%s", 
				nif, nombre, apellidos, idUsr, domicilio, correo, 
				fechaNacimiento, fechaAlta, claveAcceso, rol);		
	}

	public Usuario getUsr() {
		// Falta resolver el getUsr
		return null;
		
	}
	
	

		
		
		
	
	
	
	
	
	

} // class