package com.kenyo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kenyo.model.Producto;
import java.lang.String;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {


	List<Producto> findAll();
	
	List<Producto> findByPrecioGreaterThanEqualAndPrecioLessThan(Double precio1, Double precio2);
	
	List<Producto> findByNombreContaining(String nombre);
}
