package util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Fecha {

	private Calendar calendario; //Clase adaptada ( ver Adapter o Wrapper en tema 12 )

	//La clase fecha se compone de un calendario, relación de "composición"


	//Constructor convencional
	public Fecha ( int año, int mes, int dia ){

		calendario = new GregorianCalendar(año,mes-1,dia);

		// El setLenient en false desactiva el modo benévolo

		calendario.setLenient(false);

	}

	/**
	 *Constructor defecto
	 */

	public Fecha(){

		calendario = new GregorianCalendar();

		calendario.setLenient(false);

	}

	//Constructor copia
	public Fecha (Fecha fecha){
		this (fecha.getAño(), fecha.getMes(), fecha.getDia());

	}


	//Métodos de acceso adaptados

	public int getAño(){

		return calendario.get(Calendar.YEAR);

	}
	// Suponemos que enero será el mes 0 para la clase Calendar, sumar +1
	public int getMes(){

		return calendario.get(Calendar.MONTH) +1;

	}

	public int getDia(){

		return calendario.get(Calendar.DAY_OF_MONTH);

	}

	public void setAño(int año){

		calendario.set(Calendar.YEAR,año);

	}

	//Suponemos que enero será el mes 0 para la clase Calendar,

	//restar -1 al parámetro que le pasamos por entero

	public void setMes(int mes){

		calendario.set(Calendar.MONTH,mes-1);

	}

	public void setDia(int dia){

		calendario.set(Calendar.DAY_OF_MONTH,dia);

	}

	@Override
	public String toString() {
		return getAño() + "-" + getMes() + "-" + getDia() ;

		//" getAño() + "_" + getMes() + "_" + getDia() ";

	}

	//No son el mismo calendario

	public int compareTo(Fecha fecha){

		return calendario.compareTo(fecha.calendario);
	}

	//Para reescribir equals, sí o sí tiene que llamarse así, devolver boolean
	// entra un Object genérico
	// y la fecha luego la transformamos
	// Esto es así porque equals viene de la clase Object, pero lo usamos para fechas

	public boolean equals(Object obj){

		//No son el mismo calendario

		return calendario.getTimeInMillis()
				== ((Fecha) obj).calendario.getTimeInMillis();
	}

	// Con ((Fecha) obj) camuflamos un objeto Fecha como objeto genérico



	public Date toDate(){
		return calendario.getTime();
		//return new Date (calendario.getTimeInMillis());
	}

	public long difMinutos (Fecha fecha){

		return (int) (calendario.getTimeInMillis()
				-fecha.calendario.getTimeInMillis()) / (60*1000); 
	}

	public long difSegundos (Fecha fecha){

		return (int) (calendario.getTimeInMillis()
				-fecha.calendario.getTimeInMillis()) / (1000); 
	}


	public int difSemanas(Fecha fecha){

		return (int) (calendario.getTimeInMillis()
				-fecha.calendario.getTimeInMillis()) / (7*24*60*60*1000);
	}

	public int difDias (Fecha fecha){

		return (int) (calendario.getTimeInMillis()
				-fecha.calendario.getTimeInMillis()) / (24*60*60*1000);
	}

	
	// Con estos métodos añadimos, segundos, horas, días, etc...
	
	// para restar se puede pasar el int en negativo y funciona
	
	public void addSegundos(int segundos){
		calendario.add(Calendar.SECOND, segundos);

	}

	public void addMinutos(int minutos){

		calendario.add(Calendar.MINUTE, minutos);
	}

	public void addHoras(int horas){

		calendario.add(Calendar.HOUR, horas);
	}	
	
	public void addDias(int dias){

		calendario.add(Calendar.DATE, dias);
		
		//Puede ser DATE o DAY_OF_MONTH		
	}		
	
	public void addSemanas(int semanas){

		calendario.add(Calendar.WEEK_OF_YEAR, semanas);
	}	
	
	public void addMeses(int meses){

		calendario.add(Calendar.MONTH, meses);
	}	
	
	public void addAños(int años){

		calendario.add(Calendar.YEAR, años);
	}	
	
	
	} //Class
