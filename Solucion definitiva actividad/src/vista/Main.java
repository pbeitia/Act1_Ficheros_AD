package vista;

import java.io.File;

import controlador.EscritorFicheroBinario;
import controlador.LectorFicheroBinario;
import persistencia.DaoCoches;
import seleccion.Menu;

public class Main {

	public static void main(String[] args) {

		LectorFicheroBinario lectorFicheroBinario = new LectorFicheroBinario();
		EscritorFicheroBinario escritorFicheroBinario = new EscritorFicheroBinario();
		File fichero = new File("coches.dat");
		DaoCoches daoCoches = new DaoCoches();

		if (fichero.exists()) {
			lectorFicheroBinario.lecturaInicial(daoCoches);
		}
		Menu.menu(daoCoches);
		escritorFicheroBinario.escribirCochesEnFichero(daoCoches);
		System.out.println("Fin del programa");

	}

}
