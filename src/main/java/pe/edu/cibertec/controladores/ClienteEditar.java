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
	public String doGET(Model modelo, @RequestParam("cod") int ID_Cliente) {
		Cliente Cliente = clienteRepository.buscarPorId_cliente(ID_Cliente);
		modelo.addAttribute("Cliente", Cliente);
		return "vistas/cliente/editar";
	}

	@PostMapping("/editarCliente")
	public String doPOST(Model modelo, @RequestParam("txtID_Cliente") int ID_Cliente,
				@RequestParam("txtNombre") String Nombre,
				@RequestParam("txtNumRuc") String NumRuc,
				@RequestParam("txtDireccion") String Direccion,
				@RequestParam("txtTelefono") String Telefono) {
		clienteRepository.actualizar(ID_Cliente, Nombre, NumRuc, Direccion, Telefono);
		Cliente cliente = new Cliente(ID_Cliente, Nombre, NumRuc, Direccion, Telefono);
		modelo.addAttribute("cliente", cliente);
		return "vistas/cliente/editar";
	}
}
