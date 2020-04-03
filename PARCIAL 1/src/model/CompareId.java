package model;
import java.util.Comparator;

	public class CompareId implements Comparator<Perro> {
	   
		@Override
	    public int compare(Perro perro1, Perro perro2) {
			int id1= Integer.parseInt(perro1.getId());
			int id2= Integer.parseInt(perro2.getId());
	    	return id1- id2;
	    }
		
}
