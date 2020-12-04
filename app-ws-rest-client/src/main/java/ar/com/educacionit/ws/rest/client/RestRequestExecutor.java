package ar.com.educacionit.ws.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;
import javax.ws.rs.client.Invocation.Builder;
import org.glassfish.jersey.logging.LoggingFeature;

public abstract class RestRequestExecutor<T> {

	protected String urlRestApi;
	
	public RestRequestExecutor(String urlRestApi) {
		this.urlRestApi = urlRestApi;
	}
	
	public T executeRestCall() throws Exception {
		
		//http://algo.com.ar/api/recurso
		
		//cliente
		Client client = ClientBuilder.newClient( new ClientConfig().register( LoggingFeature.class ) );
		
		//target
		WebTarget webTarget = this.buildWebTarget(client);
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
				
		//response
		Response response = this.buildResponse(invocationBuilder);
		
		//status 
		if(Status.OK.getStatusCode() != response.getStatus()) {
			throw new Exception(response.getStatusInfo().getReasonPhrase());
		}
		
		//creacion del objeto Generic
		T responseT = this.buildResponseDto(response);
		
		return responseT;
	}
	
	protected abstract T buildResponseDto(Response response);
	
	/**
	 * Por defecto se ejecuta GET
	 * @param invocationBuilder
	 * @return
	 */
	private Response buildResponse(Builder invocationBuilder) {
		return invocationBuilder.get();
	}
	
	/**
	 * Arma la url del servicio rest que será consumido.
	 * Ej: http://www.pagina.com.ar/recurso
	 * @param client
	 * @param requestDto
	 * @return
	 */
	protected WebTarget buildWebTarget(Client client) {
		return client.target(getUrlRestApi());
	}
	
	public String getUrlRestApi() {
		return urlRestApi;
	}

	public void setUrlRestApi(String urlRestApi) {
		this.urlRestApi = urlRestApi;
	}
	
	
}
