package model;
import java.util.Comparator;

public class CompareEdad implements Comparator<Perro> {
   
	@Override
    public int compare(Perro perro1, Perro perro2) {
		int edad1= Integer.parseInt(perro1.getEdad());
		int edad2= Integer.parseInt(perro2.getEdad());
    	return edad1- edad2;
    }

}