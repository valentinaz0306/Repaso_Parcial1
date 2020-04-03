package view;

import processing.core.PApplet;
import model.Perro;
import model.CompareNombre;
import model.CompareId;
import model.CompareEdad;
import model.CompareRaza;
import model.CompareFecha;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;

import controller.ControllerMain;

public class Main extends PApplet {

	private ControllerMain controller;

//txt
	String[] listaPalabras1, listP1;
	String[] listaPalabras2, listP2;

	// listaaa
	private LinkedList<Perro> listaPerros;

	public static void main(String[] args) {
		PApplet.main("view.Main");
	}

	public void settings() {
		size(800, 800);

	}

	public void setup() {
		controller = new ControllerMain();
		// lista perros

		// cargar txt

		listaPalabras1 = loadStrings("texto/datosUno.txt");
		listaPalabras2 = loadStrings("texto/datosDos.txt");

		// split palabras en la mismalinea
		listP1 = listaPalabras1[0].split(",");
		listP2 = listaPalabras1[0].split(",");
		// lista
		listaPerros = new LinkedList<Perro>();

		// arreglo para recorrer las posiicones del txt

		for (int i = 0; i < listaPalabras1.length; i++) {

			listP1 = listaPalabras1[i].split(",");
			String id1 = listP1[0];

			for (int j = 0; j < listaPalabras2.length; j++) {

				listP2 = listaPalabras2[j].split(",");
				String id2 = listP2[0];

				// compara id para ver si son iguales
				if (id1.equals(id2)) {
					listaPerros.add(new Perro(id1, listP1[2], listP2[1], listP1[1], listP2[2]));

				}

			}
		}

		/*
		 * for ( int i = 0 ; i < listaPerros.size() ; i++ ) {
		 * println(listaPerros.get(i).getNombre());} Collections.sort(listaPerros, new
		 * CompareNombre()); println(); for ( int i = 0 ; i < listaPerros.size() ; i++ )
		 * {println(listaPerros.get(i).getNombre());} ]
		 */
	}

	public void printReport() throws FileNotFoundException  {
		PrintWriter pw= new PrintWriter(new File("texto/nuevotxt.txt"));
		pw.print(msg());
		pw.close();
	}
	
	public String msg() {
		
		String m= "";
		for (int i = 0; i < listaPerros.size(); i++) {

			Perro p = listaPerros.get(i);
			// concatenar cadenas de texto
			String mensaje= p.getId() + " " + p.getNombre().toLowerCase() + " " + p.getFecha() + " " + p.getRaza().toLowerCase() + " " + p.getEdad();
			m+=mensaje + "\n";
		} // cierra for
		return m;
	}
	
	public void draw() {
		background(0);

		for (int i = 0; i < listaPerros.size(); i++) {

			fill(255);
			ellipse(200, 100 + i * 50, 50, 50);

			Perro p = listaPerros.get(i);
			// concatenar cadenas de texto
			text(p.getId() + " " + p.getNombre() + " " + p.getFecha() + " " + p.getRaza() + " " + p.getEdad(), 260,
					100 + i * 50);
		} // cierra for

		fill(255);
		text("Key A = ordena el Nombre", 260, 650);
		text("Key S = ordena el ID", 260, 665);
		text("Key D = ordena la Edad", 260, 680);
		text("Key F = ordena la Raza", 260, 695);
		text("Key G = ordena la Fecha", 260, 710);
	}

	public void keyPressed() {

		if (key == 'a' || key == 'A') {

			Collections.sort(listaPerros, new CompareNombre());
			try {
				printReport();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (key == 's' || key == 'S') {

			Collections.sort(listaPerros, new CompareId());
			try {
				printReport();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (key == 'd' || key == 'D') {

			Collections.sort(listaPerros, new CompareEdad());
			try {
				printReport();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (key == 'f' || key == 'F') {

			Collections.sort(listaPerros, new CompareRaza());
			try {
				printReport();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (key == 'g' || key == 'G') {

			Collections.sort(listaPerros, new CompareFecha());
			try {
				printReport();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}// cierre main
