package pe.edu.cibertec.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pe.edu.cibertec.modelos.Cliente;

//Le indica a Spring que esta interfaz manejará las operaciones de persistencia
@Repository								// <Clase_del_elemento_a_persistir, tipo_de_dato_de_mi_ID>
public interface ClienteRepository extends JpaRepository<Cliente, Integer> { // ID de Producto es int, por eso es Integer
// Realmente Spring Data JPA ya maneja el CRUD automáticamente por lo que no sería necesario esta interfaz, 
// sin embargo, hacerlo de esta forma permite una mayor personalización de las operaciones.
	
	// Crear o Agregar o Insertar
	@Transactional // Realiza la consulta por medio de una transacción, por lo que si falla, esta
					// se revierte.
	@Modifying // Notifica a Spring que esta consulta hará alguna modificación (Insert, Update
				// y Delete) a la BD.
	@Query(value = "INSERT INTO Cliente (Nombre, NumRuc, Direccion, Telefono) VALUES (:Nombre, :NumRuc, :Direccion, :Telefono)", nativeQuery = true)
	// Se coloca nativeQuery porque JPA no admite consultas de inserción JPQL
	void agregar(String Nombre, String NumRuc, String Direccion, String  Telefono);

	// Leer o Buscar un producto especifico
	@Query("SELECT c FROM Cliente c WHERE c.ID_Cliente = :ID_Cliente") // El parámetro del Query
	public Cliente buscarPorId_cliente(Integer ID_Cliente); // Es el mismo para el método y esto aplica en todos

	// Actualizar
	@Transactional // Realiza la consulta por medio de una transacción, por lo que si falla, esta
					// se revierte.
	@Modifying // Notifica a Spring que esta consulta hará alguna modificación (Insert, Update
				// y Delete) a la BD.
	@Query("UPDATE Cliente c SET c.Nombre = :Nombre, c.NumRuc = :NumRuc, c.Direccion = :Direccion , c.Telefono = :Telefono WHERE c.ID_Cliente = :ID_Cliente")
	void actualizar(Integer ID_Cliente, String Nombre, String NumRuc, String Direccion, String  Telefono);

	// Eliminar
	@Transactional // Realiza la consulta por medio de una transacción, por lo que si falla, esta
					// se revierte.
	@Modifying // Notifica a Spring que esta consulta hará alguna modificación (Insert, Update
				// y Delete) a la BD.
	@Query("DELETE FROM Cliente c WHERE c.ID_Cliente = :ID_Cliente") // El parámetro del Query
	void eliminar(Integer ID_Cliente); // Es el mismo para el método
	
	/* ========== Otros método ========== */

	// Nuevo ID: Obtiene el nuevo id para los productos con la descripción
	// proporcionada
	@Query("SELECT MAX(c.ID_Cliente) FROM Cliente c WHERE c.Nombre = :Nombre") // El parámetro del Query
	Integer nuevoId_Cliente(String Nombre); // Es el mismo para el método y esto aplica en todos
	
	// Leer o Buscar un producto por su descripcion
	@Query("SELECT c FROM Cliente c WHERE c.Nombre LIKE %:Nombre%") // El parámetro del Query
	public List<Cliente> buscarPorNombre(String Nombre); // Es el mismo para el método y esto aplica en todos
}
