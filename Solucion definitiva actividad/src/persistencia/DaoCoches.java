package persistencia;

import java.util.ArrayList;
import java.util.List;
import entidad.Coche;

public class DaoCoches {

	private List<Coche> listaCoches;
	private int id;

	public DaoCoches() {

		listaCoches = new ArrayList<Coche>();
	}

	/**
	 * Añade un coche al arrayList
	 * @param coche
	 * @return si existe un coche con la matricula igual a la del Coche pasado como parametro devuelve false y no añade en caso, en caso contrario devuelve true y lo añade
	 */
	public boolean añadirCoche(Coche coche) {

		boolean añadido;

		coche.setId(id++);

		for (int i = 0; i < listaCoches.size(); i++) {
			if (listaCoches.get(i).getMatricula().equals(coche.getMatricula())) {
				añadido = false;
				return añadido;
			}
		}
		añadido = listaCoches.add(coche);

		return añadido;

	}

	/**
	 * Borra el coche que se encuentre en el arraylist que tiene el id pasado como parametro
	 * @param id
	 * @return true si lo borra y false si no
	 */
	public boolean borrarCoche(int id) {

		boolean borrado = false;

		try {

			for (int i = 0; i < listaCoches.size(); i++) {
				if (listaCoches.get(i).getId() == id) {
					borrado = listaCoches.remove(listaCoches.get(i));
					System.out.println("El coche se ha borrado");
				}
			}

		} catch (IndexOutOfBoundsException e) {
			borrado = false;
			System.out.println("El coche con id " + id + " no se ha borrado.");
		}

		return borrado;
	}

	/**
	 * Consulta el coche que se encuentre en el Arraylist que tiene el id pasado como parametro
	 * @param id
	 * @return Devuelve un objeto coche si se encuentra en el ArrayList y null si no lo encuentra
	 */
	public Coche consultarCoche(int id) {

		Coche cocheDevuelto = null;

		try {

			for (Coche coche : listaCoches) {
				if (coche.getId() == id) {
					cocheDevuelto = coche;

				}

			}

		} catch (IndexOutOfBoundsException e) {
			System.out.println("El coche con id " + id + " no se ha localizado.");
		}

		return cocheDevuelto;

	}

	/**
	 * Lista los coches del ArrayList
	 * @return listado de coches
	 */
	public List<Coche> listarCoches() {

		return listaCoches;
	}

}
