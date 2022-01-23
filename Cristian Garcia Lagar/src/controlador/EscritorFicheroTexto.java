package controlador;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import entidad.Coche;
import persistencia.DaoCoches;

public class EscritorFicheroTexto {

	public static String fichero = "coches.txt";

	public void escribirFicheroTexto(DaoCoches daoCoches) {

		try (FileWriter fw = new FileWriter(fichero); BufferedWriter bfw = new BufferedWriter(fw)) {

			for (Coche coche : daoCoches.listarCoches()) {

				bfw.write(coche.toString());
				bfw.newLine();

			}

		} catch (FileNotFoundException e) {

			System.out.println("El fichero no existe");
			e.printStackTrace();

		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

}
