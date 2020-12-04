package ar.com.educacionit.ws.rest.client.meli;

import java.util.List;

import ar.com.educacionit.ws.rest.client.RestRequestExecutor;
import ar.com.educacionit.ws.rest.client.dto.cetegory.Categoria;
import ar.com.educacionit.ws.rest.client.dto.cetegory.UnaCategoria;

public class CategoriaMain {

	public static void main(String[] args) throws Exception {
		
		String urlRestApi = "https://api.mercadolibre.com/sites/MLA/categories";//db
		
		/*RestRequestExecutor<List<Categoria>> peticionRest = new CategoryRestExcutor(urlRestApi);

		List<Categoria> categoria = peticionRest.executeRestCall();

		System.out.println(categoria);*/
		
		urlRestApi = "https://api.mercadolibre.com/categories/MLA1072";
		
		//consulta una sola categoria
		RestRequestExecutor<UnaCategoria> peticionRestUna = new UnaCategoriaRestExcecutor(urlRestApi);
		
		UnaCategoria una = peticionRestUna.executeRestCall();
		
		System.out.println(una.getName());
		
		System.out.println(una);
	}

}
