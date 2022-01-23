package controlador;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;


import persistencia.DaoCoches;

public class EscritorFicheroBinario {
	
	public static final String fichero = "coches.dat";
	
	/**
	 * Escribe en un fichero binario los coches contenidos en el arrayList de daoCoches 
	 * @param daoCoches
	 */
	public void escribirCochesEnFichero(DaoCoches daoCoches) {
		
			
		try(FileOutputStream fos = new FileOutputStream(fichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
		
			oos.writeObject(daoCoches.listarCoches());

			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("El fichero no existe");
			e.printStackTrace();
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
		} 
		}
	}

