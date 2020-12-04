package ar.com.educacionit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.educacionit.ws.rest.client.RestRequestExecutor;
import ar.com.educacionit.ws.rest.client.dto.cetegory.Categoria;
import ar.com.educacionit.ws.rest.client.meli.CategoryRestExcutor;

@Controller
public class MeliController {

	@RequestMapping( value="/meli/categorias")
	public String categoria(Model model) {
		
		String urlRestApi = "https://api.mercadolibre.com/sites/MLA/categories";//db
		
		RestRequestExecutor<List<Categoria>> categoriaExecutor = new CategoryRestExcutor(urlRestApi);
		
		List<Categoria> categorias;
		try {
			categorias = categoriaExecutor.executeRestCall();
		} catch (Exception e) {	
			categorias = new ArrayList<Categoria>();
		}
		
		model.addAttribute("categorias",categorias);
		
		return "categorias";
	}	
	
}
