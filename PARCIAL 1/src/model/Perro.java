package model;

public class Perro {

	private String id;
	private String edad;
	private String raza;
	private String nombre;
	private String fecha;

	public Perro(String id,String edad,String raza,String nombre, String fecha) {
		this.id=id;	
		this.edad=edad;	
		this.raza=raza;	
		this.nombre=nombre;	
		this.fecha=fecha;	
	
}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}

	