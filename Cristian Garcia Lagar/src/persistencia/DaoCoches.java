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
	 * 
	 * @param coche
	 * @return
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
	 * 
	 * @param id
	 * @return
	 */
	public boolean borrarCoche(int id) {

		boolean borrado = false;

		try {

			for (int i = 0; i < listaCoches.size(); i++) {
				if (listaCoches.get(i).getId() == id) {
					borrado = listaCoches.remove(listaCoches.get(i));
				}
			}

		} catch (IndexOutOfBoundsException e) {
			borrado = false;
			System.out.println("El coche con id " + id + " no se ha borrado.");
		}

		return borrado;
	}

	/**
	 * 
	 * @param id
	 * @return
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
	 * 
	 * @return
	 */
	public List<Coche> listarCoches() {

		return listaCoches;
	}

}
