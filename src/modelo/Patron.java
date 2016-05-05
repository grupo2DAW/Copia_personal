/**Implementa el concepto Patron de celdas según el modelo 2.1
 * @since: prototipo 2.1
 * @author: Grupo2
 * @source: Patron.java
 * @version: 1.0 - 05/05/2016
 */

package modelo;

import java.util.Arrays;
import java.io.Serializable;

public class Patron {


	String nombre;
	byte [][] esquema;

	//Constructor convencional
	public Patron(String nombre, byte[][] esquema) {

		setNombre (nombre);
		setEsquema ( esquema );
	}

	//Constructor por defecto
	public Patron(){

		this("NombreDefecto",new byte[0][0]);

	}

	//Constructor copia
	public Patron(Patron patron){

		this(patron.nombre, patron.esquema);
		this.esquema=new byte [patron.esquema.length][patron.esquema.length];
		for ( int i = 0; i < patron.esquema.length; i++){

			this.esquema[i]=Arrays.copyOf(patron.esquema[i], patron.esquema.length);

		}
	}

	//Constructor especial
	public Patron(String nombre, int filas, int columnas, String imagen) {

		byte [][] esquema=new byte [filas][columnas];

		for ( int i = 0; i < filas; i++ ){
			for (int j = 0; j < columnas; j++){


			}
		}

		// Se puede hacer con ArrayList

		setEsquema (esquema);
	}




	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {

		if ( nombre != null){
			this.nombre = nombre;	
		}else{
			this.nombre = "NombrePatron";
		}
	}

	public byte[][] getEsquema() {
		return esquema;
	}

	public void setEsquema(byte[][] esquema) {
		this.esquema = esquema;
	}




}
