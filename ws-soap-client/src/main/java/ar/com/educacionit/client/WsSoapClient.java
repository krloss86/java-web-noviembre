package ar.com.educacionit.client;

import java.util.List;

import ar.com.educacionit.soap.server.Producto;
import ar.com.educacionit.soap.server.impl.ProductoWSSoapServiceImplService;
import ar.com.educacionit.soap.server.impl.ProductoWsSoapService;
import ar.com.educacionit.soap.server.impl.WSSoapException;

public class WsSoapClient {

	public static void main(String[] args) {

		ProductoWSSoapServiceImplService psws = new ProductoWSSoapServiceImplService();
		
		ProductoWsSoapService ps = psws.getProductoWSSoapServiceImplPort();
		
		try {
			//ctrl+shit+o
			List<Producto> productos = ps.listAll();
			for(Producto producto : productos) {
				System.out.println(producto.getId());
			}
		} catch (WSSoapException e) {
			e.printStackTrace();
		}
	}

}
