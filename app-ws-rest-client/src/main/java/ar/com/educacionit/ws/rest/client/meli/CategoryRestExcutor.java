package ar.com.educacionit.ws.rest.client.meli;

import java.util.List;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import ar.com.educacionit.ws.rest.client.RestRequestExecutor;
import ar.com.educacionit.ws.rest.client.dto.cetegory.Categoria;

public class CategoryRestExcutor extends RestRequestExecutor<List<Categoria>> {

	public CategoryRestExcutor(String urlRestApi) {
		super(urlRestApi);
	}

	@Override
	protected List<Categoria> buildResponseDto(Response response) {
		
		GenericType<List<Categoria>> categoriasType = new GenericType<List<Categoria>>() {};
		
		//converte de json a java
		List<Categoria> categorias = response.readEntity(categoriasType);
		
		return categorias;
	}

}
