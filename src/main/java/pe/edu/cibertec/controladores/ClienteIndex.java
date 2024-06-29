package pe.edu.cibertec.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.cibertec.modelos.Cliente;
import pe.edu.cibertec.repositorio.ClienteRepository;

@Controller
public class ClienteIndex {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/buscarCliente")
    public String doGET() {
        return "vistas/cliente/index"; // Se indica la ruta de la página que se desea que cargue
    }

    @PostMapping("/buscarCliente")
    public String doPOST(@RequestParam("txtNombreBuscar") String nombreBuscar, Model model) {
        List<Cliente> listaClientes = clienteRepository.buscarPorNombre(nombreBuscar);
        model.addAttribute("listaClientes", listaClientes); // Enviamos toda la lista de clientes
        model.addAttribute("nombreBuscado", nombreBuscar); // Y también el nombre buscado para dejarlo en su mismo <input>
        return "vistas/cliente/index"; // Se indica la ruta de la página que se desea que cargue
    }
}
