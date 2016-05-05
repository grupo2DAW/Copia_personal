package test;

import util.Fecha;
import modelo.Correo;
import modelo.Direccion;
import modelo.Nif;
import modelo.Persona;

public class PersonaTest2 {
	private Persona persona1;
	private Persona persona2;
	private Persona persona3;	
	private Persona persona4;	


	public PersonaTest2(){

		testSet();
		testGet();
		testConstructores();
		testToString();

	}


	public void testSet(){

		System.out.println("Pruebas de métodos set...");
		persona1 = new Persona();
		mostrar(persona1);

		persona1.setNif(new Nif("87654321B"));
		persona1.setNombre("Pepe");
		persona1.setApellidos("López Pérez");
		persona1.setDomicilio(new Direccion( "30012", "Alta", "10", "Murcia", "España"));
		persona1.setCorreo(new Correo());
		persona1.setFechaNacimiento(new Fecha(1990, 11, 30));

		mostrar(persona1);

		//Para mostrar datos incorrectos

		//IMPORTANTE: UN OBJETO SOLO FALLA CUANDO ES NULL, PORQUE NO SE HA CONSTRUIDO EL OBJETO 


		persona4 = new Persona();
		//Falla Nif
		persona4 = new Persona ( null, "Pepe", "López", new Direccion("30012", "Calle", "10", "Murcia", "España"),
				new Correo(), new Fecha());

		//Falla nombre
		persona4 = new Persona ( new Nif(), "Pepe", "López", new Direccion("30012", "Calle", "10", "Murcia", "España"),
				new Correo(), new Fecha());
		persona4.setApellidos("López Pérez");
		persona4.setDomicilio(new Direccion( "30012", "Alta", "10", "Murcia", "España"));
		persona4.setCorreo(new Correo());
		persona4.setFechaNacimiento(new Fecha());

	}
	public void testGet(){

		System.out.println("Pruebas de métodos get...");

		persona1 = new Persona ();
		mostrar(persona1);


	}

	public void mostrar (Persona persona){

		System.out.println("\nnif: \t\t\t" + persona.getNif());
		System.out.println("nombre: \t\t" + persona.getNombre());
		System.out.println("apellidos: \t\t" + persona.getApellidos());
		System.out.println("domicilio: \t\t" + persona.getDomicilio());
		System.out.println("correo: \t\t" + persona.getCorreo());
		System.out.println("fecha de nacimiento: \t" + persona.getFechaNacimiento()+"\n");


	}
	public void testConstructores(){

		System.out.println("Pruebas de métodos constructores...");

		persona1 = new Persona ();

		persona2 = new Persona (new Nif("33345678C"),"Baldomero", "Fernández", 
				new Direccion ("30003","Rue Percebe","1", "Murcia", "España"), new Correo(), new Fecha());

		persona3 = new Persona (persona1);

		// Para datos incorrectos
		persona4 = new Persona();


		mostrar(persona1);
		mostrar(persona2);
		mostrar(persona3);
	}

	public void testToString(){

		//con System.err.println.... muestra mensaje en rojo

		System.out.println("Pruebas de métodos toString...");
		persona1 = new Persona ();
		mostrar(persona1);

		System.out.println(persona1);

	}

}
