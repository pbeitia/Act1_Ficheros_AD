import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class principal {
 public static final String nombreFichero = "Coches.dat";
	    
	    public static void main(String[] args)throws IOException {
	    	List<Coche> listaCoche = new ArrayList<Coche>();
			Coche Coche = new Coche();	
	        mostrarMenu();
	    }
	
	    
	    
	 public static void mostrarMenu() {
	        Scanner teclado = new Scanner(System.in);
	        int opcion;
	 
	        do {
	 
	            System.out.println("1-.Añadir nuevo coche");
	            System.out.println("2-.Borrar coche por id");
	            System.out.println("3-.Consulta coche por id");
	            System.out.println("1-.Listado de coches");
	            System.out.println("1-.Terminar el programa");
	            
	            opcion = teclado.nextInt();
	            switch (opcion) {
	                case 1: {
	                    Añadir();
	                    break;
	                }
	                case 2: {
	                    Borrar();
	                    break;
	                }
	                case 3: {
	                    ConsultarFichero();
	                    
	                    break;
	                }
	                case 4: {
	                    mostrarFichero();
	                    break;
	                }
	                case 5: {
	                    System.out.println("Gracias por usar el programa");
	                }
	                default: {
	                    System.out.println("Opcion incorrecta");
	                }
	 
	            }
	        } while (opcion != 5);
	    }
	 
	    public static void Añadir() {
	    	System.out.println("Añade un id");
	            String id = System.console().readLine();
	        System.out.println("Añade una matricula");
	            String matricula = System.console().readLine();
	        System.out.println("Añade una marca");
	            String marca = System.console().readLine();
	        System.out.println("Añade un modelo");
	            String modelo = System.console().readLine();
	        System.out.println("Añade un color");
	            String color = System.console().readLine();    
	            
	            
	            
	            
			List<Coche> listaCoche = new ArrayList<Coche>();
			Coche Coche = new Coche();		
			Coche.setId(id);
			Coche.setMatricula(matricula);
			Coche.setMarca(marca);
			Coche.setModelo(modelo);
			Coche.setColor(color);
			
			listaCoche.add(Coche);
			
			File file = new File(nombreFichero);
			
			try (FileOutputStream fos = new FileOutputStream(file);
					 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
					//oos = new ObjectOutputStream(new FileOutputStream(new File(nombreFichero)));
					oos.writeObject(listaCoche);
					System.out.println("Objeto introducido");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			System.out.println("Coche añadido");
			
			
	    }
	 
	 
	 
	 
	    public static void Borrar()  {
	    	System.out.println("Introduce el id del coche a borrar");
            String id = System.console().readLine();
            
            
	    	 	File ficheroEntrada=null;
	    	    File ficheroSalida=null;
	    	    FileInputStream flujoEntrada=null;
	    	    FileOutputStream flujoSalida=null;
	    	    ObjectInputStream lector=null;
	    	    ObjectOutputStream escritor=null;
	    	try
	    	{
	    	    ficheroEntrada =new File("Ccohes.dat");
	    	    ficheroSalida = new File("temporal.dat");
	    	    flujoEntrada = new FileInputStream(ficheroEntrada);
	    	    flujoSalida = new FileOutputStream (ficheroSalida);
	    	    lector = new ObjectInputStream (flujoEntrada);
	    	    escritor = new ObjectOutputStream(flujoSalida); 
	    	    Coche Coche;
	    	    while(true)
	    	    { 
	    	        
	    	       
	    	    }
	    	    
	    	}
	    	catch (FileNotFoundException fnfe)
	    	{
	    	    System.out.println("Fichero no encontrado");
	    	}
	    	catch (IOException ioe)
	    	{
	    	    //ioe.printStackTrace();
	    	}
	    }
	    
	    
	    public static void ConsultarFichero()  {
	    	List<Coche> listaCoche = new ArrayList<Coche>();	
	    
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
	 
	    
	    public static void mostrarFichero() {
	    	
			try (FileInputStream file = new FileInputStream("Coches.dat");
					ObjectInputStream buffer = new ObjectInputStream(file);){
				
				boolean eof = false;
				Coche c;
				while (!eof) {
					try {
						c = (Coche) buffer.readObject();
						System.out.println(c);
					} catch (EOFException e1) {
						eof = true;
						//break;
					} catch (IOException e2) {
						System.out.println("Error al leer los coches de la lista");
						System.out.println(e2.getMessage());
					} catch (ClassNotFoundException e3) {
						System.out.println("La lista coche no está cargada en memoria");
						System.out.println(e3.getMessage());
					}
				}
			} catch (IOException e) {
				System.out.println("No se ha podido abrir la lista coches");
				System.out.println(e.getMessage());
				return;
			}			
	    }
	 
	   
	


	

}
