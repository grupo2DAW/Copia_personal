package modelo;

public class Direccion {

	private String codigoPostal;
	private String via;
	private String numero;
	private String poblacion;
	private String pais;





	public Direccion(String codigoPostal, String via, String numero,
			String poblacion, String pais) {
		
		setCodigoPostal(codigoPostal);
		setVia(via);
		setNumero(numero);
		setPoblacion(poblacion);
		setPais(pais);
	}

	public Direccion(){

		this("30000", "Via", "10", "Murcia", "Espana");

	}

	
	public Direccion(Direccion direccion) {
		
		this(direccion.codigoPostal, direccion.via, direccion.numero, direccion.pais, direccion.pais);
		
	}


	public void setCodigoPostal(String codigoPostal) {


		assert codigoPostal != null;
		assert codigoPostalValido(codigoPostal);
		this.codigoPostal=codigoPostal;


	}

	public boolean codigoPostalValido(String codigoPostal) {

		assert codigoPostal.matches("^[00-52]{2}[0-9]{3}$");

		return codigoPostalAutentico(codigoPostal);
	}



	public boolean codigoPostalAutentico(String codigoPostal) {

		// Pendiente

		return true;
	}




	public void setVia(String via) {

		assert via != null;
		assert viaValida(via);
		this.via=via;
				

	}

	
	public boolean viaValida(String via) {
		
		assert via.matches("[áéíóú / ÁÉÍÓÚ,\\w]+");
		
		return true;
	}

	
	public void setNumero(String numero) {


		assert numero != null;
		assert numeroValido(numero);
		this.numero=numero;
				

	}

	private boolean numeroValido(String numero) {
		
		assert numero.matches("[0-9a-zA-Z]{1,5}");
		
		return true;
	}

	public void setPoblacion(String poblacion) {

		this.poblacion=poblacion;

	}


	public void setPais(String pais) {
		assert pais != null;
		assert paisValido(pais);
		this.pais=pais;

	}
	
	public boolean paisValido(String pais){
		
		assert pais.matches("[\\w áéíóúñ]+");
		
		return true;
	}

	@Override
	public String toString() {
		return codigoPostal + "," + via + "," + numero
				+ ","  + poblacion + "," + pais ;
	}




} //class
