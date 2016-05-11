package modelo;

public class Correo {

	protected String correo;

	public Correo (String correo){
		
		setCorreo(correo);
		
	}
	
	
	public Correo() {
		
		this ("email@gmail.com");
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	@Override
	public String toString() {
		return "" + correo + "";
	}
	
	
	
	
}
