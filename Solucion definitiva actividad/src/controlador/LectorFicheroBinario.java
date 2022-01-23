package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import entidad.Coche;
import persistencia.DaoCoches;

public class LectorFicheroBinario {

	public static final String fichero = "coches.dat";

	
	/**
	 * Lee de un fichero binario los coches contenidos en el arrayList de daoCoches 
	 * @param daoCoches
	 */
	@SuppressWarnings("unchecked")
	public void lecturaInicial(DaoCoches daoCoches) {

		ArrayList<Coche> listaCoche = new ArrayList<Coche>();

		try (FileInputStream fis = new FileInputStream(fichero); ObjectInputStream ois = new ObjectInputStream(fis);) {

			listaCoche = (ArrayList<Coche>) ois.readObject();
			for (Coche coche : listaCoche) {
				daoCoches.añadirCoche(coche);
			}

		} catch (FileNotFoundException e) {

			System.out.println("El fichero no existe");
			e.printStackTrace();

		} catch (IOException e1) {

			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
