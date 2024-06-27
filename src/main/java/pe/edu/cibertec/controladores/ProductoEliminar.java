package pe.edu.cibertec.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.cibertec.modelos.Producto;
import pe.edu.cibertec.repositorio.ProductoRepository;

@Controller
public class ProductoEliminar {
	@Autowired
	private ProductoRepository productoRepository;

	@GetMapping("/eliminarProducto")
	public String doGET(Model modelo, @RequestParam("cod") int idEliminar) {
		Producto producto = productoRepository.buscarPorId(idEliminar);
		modelo.addAttribute("producto", producto);
		return "vistas/producto/eliminar";
	}

	@PostMapping("/eliminarProducto")
	public String doPOST(Model modelo, @RequestParam("txtId") int id) {
		productoRepository.eliminar(id);
		// Después de eliminar, hay que regresar a la página principal de Producto
		return "redirect:/buscarProducto";
	}
}
