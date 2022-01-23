package seleccion;

import java.util.Scanner;

import controlador.EscritorFicheroTexto;
import entidad.Coche;
import persistencia.DaoCoches;

public class Menu {
	
	static Scanner sc = new Scanner(System.in);

	/**
	 * Muestra el menu de la aplicacion
	 * @param daoCoches
	 */
	public static void menu(DaoCoches daoCoches) {
		
		String opcion = "0";
		
		while (!opcion.equals("6")) {
			System.out.println("*** Menu Almacen Coche ***");
			System.out.println("Seleecione una de las siguientes opciones.");
			System.out.println("1.- Añadir nuevo coche");
			System.out.println("2.- Borrar coche por id");
			System.out.println("3.- Consulta coche por id");
			System.out.println("4.- Listado de coches");
			System.out.println("5.- Exportar coches a archivo de text”");
			System.out.println("6.- Terminar el programa");

			opcion = sc.nextLine();
			
			ejecutarOpcion(opcion, daoCoches);

	}
	

}
	/**
	 * Ejecuta la opcion elegida en el menu
	 * @param opcion
	 * @param daoCoches
	 */
	public static void ejecutarOpcion(String opcion, DaoCoches daoCoches) {
		
		String id;
		String matricula;
		String marca;
		String modelo;
		String color;
		Coche coche;
		EscritorFicheroTexto escritorFicheroTexto = new EscritorFicheroTexto();
		
		switch (opcion) {
		case "1":
			System.out.println("Introduce matricula");
			matricula = sc.nextLine();
			System.out.println("Introduce marca");
			marca = sc.nextLine();
			System.out.println("Introduce modelo");
			modelo = sc.nextLine();
			System.out.println("Introduce Color");
			color = sc.nextLine();
			coche = new Coche(matricula, marca, modelo, color);
			if(daoCoches.añadirCoche(coche))
				System.out.println("Coche añadido\n");
			else
				System.out.println("Coche no añadido. La matricula del coche ya existe");
			break;
		case "2":
			System.out.println("Introduce id del coche a borrar");
			id = sc.nextLine();
			daoCoches.borrarCoche(Integer.parseInt(id));
			break;
		case "3":
			System.out.println("Introduce id del coche a buscar");
			id = sc.nextLine();
			System.out.println(daoCoches.consultarCoche(Integer.parseInt(id)));
			break;
		case "4":
			System.out.println("El almacen contiene los siguientes coches:");
			System.out.println(daoCoches.listarCoches());
			break;
		case "5":
			escritorFicheroTexto.escribirFicheroTexto(daoCoches);
			System.out.println("Se han exportado los coches");
			break;

		}
	}
}
