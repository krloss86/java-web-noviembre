package ar.com.educacionit.ws.rest.client.meli;

import javax.ws.rs.core.Response;

import ar.com.educacionit.ws.rest.client.RestRequestExecutor;
import ar.com.educacionit.ws.rest.client.dto.cetegory.UnaCategoria;

public class UnaCategoriaRestExcecutor extends RestRequestExecutor<UnaCategoria> {

	public UnaCategoriaRestExcecutor(String urlRestApi) {
		super(urlRestApi);
	}

	@Override
	protected UnaCategoria buildResponseDto(Response response) {
		
		UnaCategoria una = response.readEntity(UnaCategoria.class); 
		
		return una;
	}

}
