package pe.edu.cibertec.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.cibertec.modelos.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Cliente (Nombre, NumRuc, Direccion, Telefono) VALUES (:nombre, :numRuc, :direccion, :telefono)", nativeQuery = true)
    void agregar(String nombre, String numRuc, String direccion, String telefono);

    @Query("SELECT c FROM Cliente c WHERE c.ID_Cliente = :id")
    public Cliente buscarPorId(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Cliente c SET c.Nombre = :nombre, c.NumRuc = :numRuc, c.Direccion = :direccion, c.Telefono = :telefono WHERE c.ID_Cliente = :id")
    void actualizar(Integer id, String nombre, String numRuc, String direccion, String telefono);

    @Transactional
    @Modifying
    @Query("DELETE FROM Cliente c WHERE c.ID_Cliente = :id")
    void eliminar(Integer id);

    @Query("SELECT MAX(c.ID_Cliente) FROM Cliente c WHERE c.Nombre = :nombre")
    Integer nuevoId(String nombre);

    @Query("SELECT c FROM Cliente c WHERE c.Nombre LIKE %:nombre%")
    public List<Cliente> buscarPorNombre(String nombre);
}
