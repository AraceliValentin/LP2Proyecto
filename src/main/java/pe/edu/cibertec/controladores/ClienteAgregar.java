package pe.edu.cibertec.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.cibertec.modelos.Cliente;
import pe.edu.cibertec.repositorio.ClienteRepository;

@Controller
public class ClienteAgregar {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/agregarCliente")
    public String doGET(Model modelo) {
        Cliente cliente = new Cliente();
        modelo.addAttribute("cliente", cliente);
        return "vistas/cliente/agregar"; // La ruta es sin la extensión del archivo
    }

    @PostMapping("/agregarCliente")
    public String doPOST(Model modelo,
                         @RequestParam("txtNombre") String nombre,
                         @RequestParam("txtNumRuc") String numRuc,
                         @RequestParam("txtDireccion") String direccion,
                         @RequestParam("txtTelefono") String telefono) {
        clienteRepository.agregar(nombre, numRuc, direccion, telefono);
        // Obtener el nuevo ID del cliente agregado
        Integer nuevoId = clienteRepository.nuevoId(nombre);
        Cliente cliente = new Cliente(nuevoId, nombre, numRuc, direccion, telefono);
        modelo.addAttribute("cliente", cliente);
        return "vistas/cliente/agregar"; // La ruta es sin la extensión del archivo
    }
}
