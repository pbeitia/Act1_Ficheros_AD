import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	static File file = new File("coches.dat");
	static Scanner sc = new Scanner(System.in);
	public static final String nombreFichero = "coches.dat";
	static List<Coche> listaCoche = new ArrayList<Coche>();
	static int contador = 0;
	
	public static void main(String[] args) throws IOException {
		
		int opcion = 0;
	
		System.out.println("INICIO DEL PROGRAMA...");
		System.out.println("REALIZANDO COMPROBACIÓN DE ARCHIVO...");
		
		if(!file.exists()) {
			file.createNewFile();
			System.out.println("Creado archivo: " + file.getName());
		}else{
			System.out.println("El archivo  " + file.getName() + " ya existe.");
			if(file.length() == 0) {
				System.out.println("Todavía no hay coches para listar.");
			}else {
				cargarCoches();
				System.out.println("La lista de coches es: ");
				listar();
			}
		}
		
		try {
		do {
			menu();
			System.out.println("----------------------------");
			System.out.println("Escribe tu número de opción:");
			
			
				opcion = sc.nextInt();
				
			switch (opcion) {
			case 1: 
				añadir();
				break;
				
			case 2:
				System.out.println("Escribe el id del coche a eliminar:");
				int idEliminar = sc.nextInt();
				borrarCoche(idEliminar);
				break;
				
			case 3:
				System.out.println("Escribe el id del coche a consultar:");
				int idConsulta = sc.nextInt();
				consultar(idConsulta);
				break;
				
			case 4:
				listar();
				break;
			
			case 5:
				try(FileOutputStream fos = new FileOutputStream(file);
						ObjectOutputStream oos = new ObjectOutputStream(fos);){
					oos.writeObject(listaCoche);
					System.out.println("COCHES AÑADIDOS AL ARCHIVO");
				}catch (IOException e) {
					e.printStackTrace();
				}
				break;
				
			default:
				System.out.println("-------------------------");
				System.out.println("ESCRIBE UNA OPCIÓN VÁLIDA");
			}
			
		}while(opcion != 5);
		
		}catch(InputMismatchException e) {
			System.out.println("Error: " + e);
			System.out.println("Programa cerrado por precaución.");
		}
		

	}
	
	public static void añadir() {
	
		Coche coche = new Coche();
		System.out.println("Escriba el id del coche:");
		coche.setId(sc.nextInt());
		System.out.println("Escriba la matrícula del coche:");
		coche.setMatricula(sc.nextLine());
		coche.setMatricula(sc.next());
		System.out.println("Escriba la marca del coche:");
		coche.setMarca(sc.next());
		System.out.println("Escriba el modelo de coche:");
		coche.setModelo(sc.next());
		System.out.println("Escriba el color del coche:");
		coche.setColor(sc.next());
		listaCoche.add(coche);
		System.out.println("COCHE GUARDADO EN LISTA");
	}
	
	public static void listar(){			
			System.out.println("------------------");
			System.out.println("Imprimiendo coches");
			System.out.println("------------------");
			
			for(Coche c : listaCoche){
				System.out.println(c);
			}
	}
	
	public static void consultar(int id) {
		boolean exist = false;
		for(int i = 0; i<listaCoche.size() ;i++) {
			if(listaCoche.get(i).getId() == id) {
				System.out.println(listaCoche.get(i));
				exist = true;
				break;
			}
		}
		
		if(exist == false) {
			System.out.println("---------------------------------");
			System.out.println("No existe ningún coche con ese id");
			System.out.println("---------------------------------");
		}
	}
	
	public static void borrarCoche(int id) {
		boolean exist = false;
		for(int i = 0; i<listaCoche.size() ;i++) {
			if(listaCoche.get(i).getId() == id) {
				System.out.println("Coche Eliminado con id: " + id);
				listaCoche.remove(i);
				exist = true;
				break;
			}
		}
		
		if(exist == false) {
			System.out.println("---------------------------------");
			System.out.println("No existe ningún coche con ese id");
			System.out.println("---------------------------------");
		}
	}
	
	private static void cargarCoches() {
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);){
			
			listaCoche = (List<Coche>)ois.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void menu() {
		System.out.println("");
		System.out.println("----------ALMACEN COCHES----------");
		System.out.println("----------------------------------");
		System.out.println("1 -> AÑADIR NUEVO COCHE");
		System.out.println("2 -> BORRAR COCHE POR ID");
		System.out.println("3 -> CONSULTA COCHE POR ID");
		System.out.println("4 -> LISTAR COCHES");
		System.out.println("5 -> TERMINAR EL PROGRAMA");
	}
}
