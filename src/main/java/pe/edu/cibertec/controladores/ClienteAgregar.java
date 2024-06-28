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
	public String doPOST(Model modelo, @RequestParam("txtNombre") String Nombre,
						@RequestParam("txtNumRuc") String NumRuc,
						@RequestParam("txtDireccion") String Direccion,
						@RequestParam("txtTelefono") String Telefono) {
		// Acomodarlo de esta forma es solo una cuestión de orden
	clienteRepository.agregar(Nombre, NumRuc, Direccion, Telefono);
		Cliente cliente = new Cliente(clienteRepository.nuevoId_Cliente(Nombre),
				Nombre, NumRuc, Direccion, Telefono);
		modelo.addAttribute("cliente", cliente);
		return "vistas/cliente/agregar"; // La ruta es sin la extensión del archivo
	}
}
