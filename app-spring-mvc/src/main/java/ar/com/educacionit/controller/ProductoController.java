package ar.com.educacionit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.com.educacionit.domain.Producto;
import ar.com.educacionit.domain.TipoProducto;
import ar.com.educacionit.enums.ProductoClavesEnums;
import ar.com.educacionit.services.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService ps;
	
	@RequestMapping("/list")
	public String listado(Model model) {
		
		List<Producto> productos = this.ps.findProductos();
		
		model.addAttribute(ProductoClavesEnums.PRODUCTOS.getClave(), productos);
		
		return "listado";
	}
	
	@RequestMapping("/new")
	public ModelAndView newProducto() {
		Producto producto = new Producto();
		
		ModelAndView modelAndView =  new ModelAndView("new_producto");
		modelAndView.addObject(ProductoClavesEnums.PRODUCTO.getClave(), producto);
		
		List<TipoProducto> tiposProcutos = this.ps.findTipoProductos();
		modelAndView.addObject(ProductoClavesEnums.TIPOS_PRODUCTOS.getClave(), tiposProcutos);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(
		@ModelAttribute(name = "producto")
		Producto producto) {
	
		this.ps.createProducto(producto);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(
			@PathVariable(name = "id")
			Long id,
			Model model) {
		
		Producto producto = this.ps.getProductoById(id);
		
		model.addAttribute(ProductoClavesEnums.PRODUCTO.getClave(), producto);
		
		List<TipoProducto> tiposProductos = this.ps.findTipoProductos();

		model.addAttribute(ProductoClavesEnums.TIPOS_PRODUCTOS.getClave(), tiposProductos);
		
		return "edit";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(
			@ModelAttribute(name = "producto") 
			Producto producto
			) {
		
		this.ps.actualizarProducto(producto);
		
		return "redirect:/list";
	}
	
	@RequestMapping("/delete/{codigo}")
	public String delete(@PathVariable(name = "codigo") String id) {		
		
		this.ps.eliminarProducto(id);
		
		return "redirect:/list";
	}
}
