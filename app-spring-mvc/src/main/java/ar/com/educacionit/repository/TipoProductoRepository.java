package ar.com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.educacionit.domain.TipoProducto;

public interface TipoProductoRepository extends JpaRepository<TipoProducto, Long>{

}
