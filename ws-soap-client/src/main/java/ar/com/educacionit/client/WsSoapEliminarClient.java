package ar.com.educacionit.client;

import java.util.List;

import ar.com.educacionit.soap.server.Producto;
import ar.com.educacionit.soap.server.impl.ProductoWSSoapServiceImplService;
import ar.com.educacionit.soap.server.impl.ProductoWsSoapService;
import ar.com.educacionit.soap.server.impl.WSSoapException;

public class WsSoapEliminarClient {

	public static void main(String[] args) {

		ProductoWSSoapServiceImplService psws = new ProductoWSSoapServiceImplService();
		
		ProductoWsSoapService ps = psws.getProductoWSSoapServiceImplPort();
		
		try {
			Producto pe = ps.eliminarProducto("2000");
			System.out.println(pe);
		} catch (WSSoapException e) {
			e.printStackTrace();
		}
	}

}
