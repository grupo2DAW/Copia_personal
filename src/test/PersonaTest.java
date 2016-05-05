package test;

import static org.junit.Assert.*;
import modelo.Correo;
import modelo.Direccion;
import modelo.Nif;
import modelo.Persona;
import modelo.Usuario;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.Fecha;


//GENERADO POR JUNIT

public class PersonaTest {

	private Persona persona1;
	private Persona persona2;
	
	
	//Con BEFORE hace este método antes que todos y cada uno de los test
	
	@Before
	public void crearObjetosPrueba(){
		
		persona1 = new Usuario ();
		persona2 = new Usuario (new Nif("33345678C"),"Baldomero", "Fernández", 
				new Direccion ("30003","Rue Percebe","1", "Murcia", "España"),
				new Correo(), new Fecha(), new Fecha(), "miau21", "normal");

		//Al hacer abstract la clase Persona, hemos tenido que añadir 3 elementos para que sea un constructor de Usuario
		
	}
	

	//Con AFTER hace este método después de todos y cada uno de los test
	
	//Borramos los objetos persona creados para hacer test
	
	
	//Para que funcione AFTER y BEFORE los métodos de prueba deben llevar etiquetado el : @Test
	
	
	@After
	public void borrarObjetosPrueba(){
		
		persona1=null;
		persona2=null;
		
	}
	
	
	//Test constructor convencional
	@Test
	public void testPersonaConvencional() {
		
		//  2 formas de hacer lo mismo, que el objeto persona2 convencional se ha construido y no es nulo
		assertTrue(persona2 != null);
		
		assertNotNull(persona2);
		
		// Este assert es más farragoso, necesita 2 objetos
		
		assertNotEquals(persona2, null);
		
		
		
	}


	@Test
	public void testGetNif() {
		assertEquals(persona2.getNif().toString(), "33345678C");
	}

	@Test
	public void testGetNombre() {
		assertEquals(persona2.getNombre(), "Baldomero");
	}

	@Test
	public void testGetApellidos() {
		assertEquals(persona2.getApellidos(), "Fernández");
	}

	@Test
	public void testGetDomicilio() {
		assertNotNull(persona2.getDomicilio());
	}

	@Test
	public void testGetFechaNacimiento() {
		assertNotNull(persona2.getFechaNacimiento());
	}

	@Test
	public void testGetCorreo() {
		assertNotNull(persona2.getCorreo());
	}

	@Test
	public void testSetNif() {
		
		// Hacemos toda esta comprobación porque Nif es un objeto:
		
		Nif nif = new Nif ("33345678C");
		persona1.setNif(nif);
		assertSame(persona1.getNif(), nif );
	}

	@Test
	public void testSetDomicilio() {
		
		Direccion direccion = new Direccion ("30003","Rue Percebe","1", "Murcia", "España");
		persona1.setDomicilio(direccion);
		assertSame(persona1.getDomicilio(), direccion );
	}

	@Test
	public void testDomicilioValido() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNombre() {
		
		persona1.setNombre("Pepito");
		assertEquals(persona1.getNombre(), "Pepito" );
	}

	@Test
	public void testSetApellidos() {
		persona1.setApellidos("Perezcito");
		assertEquals(persona1.getApellidos(), "Perezcito" );
	}

	@Test
	public void testSetFechaNacimiento() {
		Fecha fecha = new Fecha (2010, 4, 27);
		persona1.setFechaNacimiento(fecha);
		assertSame(persona1.getFechaNacimiento(), fecha );
	}

	@Test
	public void testSetCorreo() {
		Correo correo = new Correo ("pepe@gmail.com");
		persona1.setCorreo(correo);
		assertSame(persona1.getCorreo(), correo );
	}

	@Test
	public void testToString() {
		
		
		assertEquals(persona2.toString(), 
				"\nnif: \t\t33345678C," +
				"\nnombre: \tBaldomero," +
				"\napellidos: \tFernández," +
				"\ndomicilio: \t30003,Rue Percebe,1,Murcia,España," +
				"\ncorreo: \temail@email.com," +
				"\nfechaNacimiento: \t2016-4-28,");
		
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString1() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}
