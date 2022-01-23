package controlador;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.ObjectOutputStream;


import persistencia.DaoCoches;

public class EscritorFicheroBinario {
	
	public static final String fichero = "coches.dat";
	
	
	public void escribirCochesEnFichero(DaoCoches daoCoches) {
		
			
		try(FileOutputStream fos = new FileOutputStream(fichero);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			System.out.println(daoCoches.listarCoches().size());
			oos.writeObject(daoCoches.listarCoches());
			System.out.println("Fichero de datos de coches escrito");
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("El fichero no existe");
			e.printStackTrace();
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
		} 
		}
	}

