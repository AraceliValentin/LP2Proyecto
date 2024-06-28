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
public class ProductoEditar {
	@Autowired
	private ProductoRepository productoRepository;

	@GetMapping("/editarProducto")
	public String doGET(Model modelo, @RequestParam("cod") int idEditar) {
		Producto producto = productoRepository.buscarPorId(idEditar);
		modelo.addAttribute("producto", producto);
		return "vistas/producto/editar";
	}

	@PostMapping("/editarProducto")
	public String doPOST(Model modelo, @RequestParam("txtId") int id,
						@RequestParam("txtDescripcion") String descripcion,
						@RequestParam("txtCategoria") String categoria,
						@RequestParam("txtPrecio") double precio) {
		productoRepository.actualizar(id, descripcion, categoria, precio);
		Producto producto = new Producto(id, descripcion, categoria, precio);
		modelo.addAttribute("producto", producto);
		return "vistas/producto/editar";
	}
}
