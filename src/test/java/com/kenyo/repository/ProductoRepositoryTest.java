package com.kenyo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.kenyo.model.Producto;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductoRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Test
	public void insertEditDelete_producto() {
		Producto producto = new Producto();
		producto.setNombre("Folder Manilla");
		producto.setPrecio(5.50);
		producto.setUrlImagen("https://www.staples-3p.com/s7/is/image/Staples/s0000441_sc7?$splssku$");
		
		productoRepository.save(producto);
		
		Producto found = productoRepository.findOne(producto.getId());
		
		assertThat(found.getNombre()).isEqualTo(producto.getNombre());
	}

}
