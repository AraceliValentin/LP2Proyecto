package pe.edu.cibertec.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int ID_Cliente;
	private String Nombre;
	private String NumRuc;
	private String Direccion;
	private String Telefono;

	public Cliente() {
	}

	public Cliente(int iD_Cliente, String nombre, String numRuc, String direccion, String telefono) {
		this.ID_Cliente = iD_Cliente;
		this.Nombre = nombre;
		this.NumRuc = numRuc;
		this.Direccion = direccion;
		this.Telefono = telefono;
	}

	public int getID_Cliente() {
		return ID_Cliente;
	}

	public void setID_Cliente(int iD_Cliente) {
		this.ID_Cliente = iD_Cliente;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getNumRuc() {
		return NumRuc;
	}

	public void setNumRuc(String numRuc) {
		this.NumRuc = numRuc;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		this.Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}
	
}
