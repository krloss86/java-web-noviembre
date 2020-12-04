package ar.com.educacionit.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.educacionit.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

	public Producto findByCodigo(String codigo);
	//select * from producto where codigo =codigo 

	public List<Producto> findAllByTitulo(String desripcion);
	// select * from productos where titulo like = 'desripcion'
}
