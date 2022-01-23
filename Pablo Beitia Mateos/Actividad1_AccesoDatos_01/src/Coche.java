import java.io.Serializable;

public class Coche implements Serializable{
	
	//Serializable-----------------------------------------------------
	private static final long serialVersionUID = -2620676614923941482L;
	//-----------------------------------------------------------------
	
	//Declaración variables-----------------
	private int id;
	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	//--------------------------------------
	
	//Constructores de la clase-----------------------------------------------------------	
	public Coche(int id, String matricula, String marca, String modelo, String color) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}
	
	public Coche() {
		super();
	}
	//----------------------------------------------------------------------------------

	
	//Getters And Setters--------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	//---------------------------------------------
	
	
	//MÉTODO TO STRING-----------------
	@Override
	public String toString() {
		return "Coche [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color="
				+ color + "]";
	}
	//---------------------------------
}
