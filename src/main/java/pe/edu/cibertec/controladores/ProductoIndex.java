package pe.edu.cibertec.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.cibertec.modelos.Producto;
import pe.edu.cibertec.repositorio.ProductoRepository;

//Le indica a Spring que esta clase manejara las solicitudes HTTP entrantes
@Controller
public class ProductoIndex {
	// Permite usar mi interfaz Repository en el controlador para hacer el CRUD
	@Autowired
	private ProductoRepository productoRepository;

	// Mapeamos al método doGet del servlet ya que Spring permite mapear cada método de forma individual
	@GetMapping("/buscarProducto")
	public String doGET() {
		return "vistas/producto/index"; // Se indica la ruta de la página que se desea que cargue
	}

	// Mapeamos al método doPost del servlet ya que Spring permite mapear cada método de forma individual
	@PostMapping("/buscarProducto")
	// Recogemos el valor enviado por el formulario con RequestParam usando el "name" de la etiqueta <input>
	public String doPOST(@RequestParam("txtDescripcionBuscar") String descripcionBuscar, Model model) {
		// Buscamos con el valor recogido y guardamos el resultado en una lista
		List<Producto> listaProductos = productoRepository.buscarPorDescripcion(descripcionBuscar);
		// El "Model" es el equivalente a "request" y "response", se usa para enviar datos hacia la vista
		// Creamos nuestros EL, los cuales enviaremos a la vista
		model.addAttribute("listaProductos", listaProductos); // Enviamos toda la lista de productos
		model.addAttribute("descripcionBuscada", descripcionBuscar); // Y también la propia descripción para dejarlo en su mismo <input>
		return "vistas/producto/index"; // Se indica la ruta de la página que se desea que cargue
	}
}
