package modelo;

public class Nif {

	
	private String nif;
	
	
	
	public Nif (String nif){
		
		setNif(nif);
		
	}
	
	
	public Nif(){
		this ("12345678A");
		 		
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		
		assert nif != null;
		assert nifValido(nif);
		
		this.nif=nif;
		
	}
	

	private boolean nifValido(String nif) {		
		
		assert nif.toString().matches("^[0-9]{8}[a-zA-Z]{1}$");
		// Letra de control.
		return letraValida(nif);		
	}

	private boolean letraValida(String nif) {
		// Algoritmo de obtención letra
		//--Pendiente--
		return true;
	}


	@Override
	public String toString() {
		return "" + nif + "";
	}
		
	
	
	
} // Class
