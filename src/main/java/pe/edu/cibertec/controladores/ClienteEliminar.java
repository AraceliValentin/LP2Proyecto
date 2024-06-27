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
public class ClienteEliminar {
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/eliminarCliente")
	public String doGET(Model modelo, @RequestParam("cod") int idEliminar) {
		Cliente cliente = clienteRepository.buscarPorId_cliente(idEliminar);
		modelo.addAttribute("cliente", cliente);
		return "vistas/cliente/eliminar";
	}

	@PostMapping("/eliminarCliente")
	public String doPOST(Model modelo, @RequestParam("txtId_cliente") int id_cliente) {
		clienteRepository.eliminar(id_cliente);
		// Después de eliminar, hay que regresar a la página principal de Producto
		return "redirect:/buscarCliente";
	}
}
