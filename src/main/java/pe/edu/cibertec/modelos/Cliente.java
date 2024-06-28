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
	  
	  
	  //Contructores
	  public Cliente() {
		}


	public Cliente(int ID_Cliente, String Nombre, String NumRuc, String Direccion, String Telefono) {
		this.ID_Cliente = ID_Cliente;
		this.Nombre = Nombre;
		this.NumRuc = NumRuc;
		this.Direccion = Direccion;
		this.Telefono = Telefono;
	}


	public int getID_Cliente() {
		return ID_Cliente;
	}


	public void setID_Cliente(int ID_Cliente) {
		this.ID_Cliente = ID_Cliente;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}


	public String getNumRuc() {
		return NumRuc;
	}


	public void setNumRuc(String NumRuc) {
		this.NumRuc = NumRuc;
	}


	public String getDireccion() {
		return Direccion;
	}


	public void setDireccion(String Direccion) {
		this.Direccion = Direccion;
	}


	public String getTelefono() {
		return Telefono;
	}


	public void setTelefono(String Telefono) {
		this.Telefono = Telefono;
	}
	  
	  
	  
	  

}
