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

//Le indica a Spring que esta clase manejara las solicitudes HTTP entrantes
@Controller
public class ClienteIndex {
	// Permite usar mi interfaz Repository en el controlador para hacer el CRUD
	@Autowired
	private ClienteRepository clienteRepository;

	// Mapeamos al método doGet del servlet ya que Spring permite mapear cada método de forma individual
	@GetMapping("/buscarCliente")
	public String doGET() {
		return "vistas/cliente/index"; // Se indica la ruta de la página que se desea que cargue
	}

	// Mapeamos al método doPost del servlet ya que Spring permite mapear cada método de forma individual
	@PostMapping("/buscarCliente")
	// Recogemos el valor enviado por el formulario con RequestParam usando el "name" de la etiqueta <input>
	public String doPOST(@RequestParam("txtNombreBuscar") String NombreBuscar, Model model) {
		// Buscamos con el valor recogido y guardamos el resultado en una lista
		List<Cliente> listaClientes = clienteRepository.buscarPorNombre(NombreBuscar);
		// El "Model" es el equivalente a "request" y "response", se usa para enviar datos hacia la vista
		// Creamos nuestros EL, los cuales enviaremos a la vista
		model.addAttribute("listaClientes", listaClientes); // Enviamos toda la lista de Clientes
		model.addAttribute("nombreBuscado", NombreBuscar); // Y también la propia descripción para dejarlo en su mismo <input>
		return "vistas/Cliente/index"; // Se indica la ruta de la página que se desea que cargue
	}
}
