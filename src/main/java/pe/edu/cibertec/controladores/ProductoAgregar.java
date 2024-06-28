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
public class ProductoAgregar {
	@Autowired
	private ProductoRepository productoRepository;

	@GetMapping("/agregarProducto")
	public String doGET(Model modelo) {
		Producto producto = new Producto(0, "", "", 0.0);
		modelo.addAttribute("producto", producto);
		return "vistas/producto/agregar"; // La ruta es sin la extensión del archivo
	}

	@PostMapping("/agregarProducto")
	public String doPOST(Model modelo, @RequestParam("txtDescripcion") String descripcion,
						@RequestParam("txtCategoria") String categoria,
						@RequestParam("txtPrecio") double precio) {
		// Acomodarlo de esta forma es solo una cuestión de orden
		productoRepository.agregar(descripcion, categoria, precio);
		Producto producto = new Producto(productoRepository.nuevoId(descripcion),
										 descripcion, categoria, precio);
		modelo.addAttribute("producto", producto);
		return "vistas/producto/agregar"; // La ruta es sin la extensión del archivo
	}
}
