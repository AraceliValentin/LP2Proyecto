package pe.edu.cibertec.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pe.edu.cibertec.modelos.Producto;

//Le indica a Spring que esta interfaz manejará las operaciones de persistencia
@Repository								// <Clase_del_elemento_a_persistir, tipo_de_dato_de_mi_ID>
public interface ProductoRepository extends JpaRepository<Producto, Integer> { // ID de Producto es int, por eso es Integer
// Realmente Spring Data JPA ya maneja el CRUD automáticamente por lo que no sería necesario esta interfaz, 
// sin embargo, hacerlo de esta forma permite una mayor personalización de las operaciones.
	
	// Crear o Agregar o Insertar
	@Transactional // Realiza la consulta por medio de una transacción, por lo que si falla, esta
					// se revierte.
	@Modifying // Notifica a Spring que esta consulta hará alguna modificación (Insert, Update
				// y Delete) a la BD.
	@Query(value = "INSERT INTO Producto (descripcion, categoria, precio) VALUES (:descripcion, :categoria, :precio)", nativeQuery = true)
	// Se coloca nativeQuery porque JPA no admite consultas de inserción JPQL
	void agregar(String descripcion, String categoria, double precio);

	// Leer o Buscar un producto especifico
	@Query("SELECT p FROM Producto p WHERE p.id = :id") // El parámetro del Query
	public Producto buscarPorId(Integer id); // Es el mismo para el método y esto aplica en todos

	// Actualizar
	@Transactional // Realiza la consulta por medio de una transacción, por lo que si falla, esta
					// se revierte.
	@Modifying // Notifica a Spring que esta consulta hará alguna modificación (Insert, Update
				// y Delete) a la BD.
	@Query("UPDATE Producto p SET p.descripcion = :descripcion, p.categoria = :categoria, p.precio = :precio WHERE p.id = :id")
	void actualizar(Integer id, String descripcion, String categoria, Double precio);

	// Eliminar
	@Transactional // Realiza la consulta por medio de una transacción, por lo que si falla, esta
					// se revierte.
	@Modifying // Notifica a Spring que esta consulta hará alguna modificación (Insert, Update
				// y Delete) a la BD.
	@Query("DELETE FROM Producto p WHERE p.id = :id") // El parámetro del Query
	void eliminar(Integer id); // Es el mismo para el método
	
	/* ========== Otros método ========== */

	// Nuevo ID: Obtiene el nuevo id para los productos con la descripción
	// proporcionada
	@Query("SELECT MAX(p.id) FROM Producto p WHERE p.descripcion = :descripcion") // El parámetro del Query
	Integer nuevoId(String descripcion); // Es el mismo para el método y esto aplica en todos
	
	// Leer o Buscar un producto por su descripcion
	@Query("SELECT p FROM Producto p WHERE p.descripcion LIKE %:descripcion%") // El parámetro del Query
	public List<Producto> buscarPorDescripcion(String descripcion); // Es el mismo para el método y esto aplica en todos
}
