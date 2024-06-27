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
public class ClienteEditar {
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/editarCliente")
	public String doGET(Model modelo, @RequestParam("cod") int idEditar) {
		Cliente cliente = clienteRepository.buscarPorId_cliente(idEditar);
		modelo.addAttribute("cliente", cliente);
		return "vistas/cliente/editar";
	}

	@PostMapping("/editarCliente")
	public String doPOST(Model modelo, @RequestParam("txtId_cliente") int id_cliente,
				@RequestParam("txtNombre") String nombre,
				@RequestParam("txtNumRuc") String numRuc,
				@RequestParam("txtDireccion") String direccion,
				@RequestParam("txtTelefono") String telefono) {
		clienteRepository.actualizar(id_cliente, nombre, numRuc, direccion, telefono);
		Cliente cliente = new Cliente(id_cliente, nombre, numRuc, direccion, telefono);
		modelo.addAttribute("cliente", cliente);
		return "vistas/cliente/editar";
	}
}
