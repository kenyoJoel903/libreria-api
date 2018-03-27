package com.kenyo.service;

import java.util.List;

import com.kenyo.model.Producto;

public interface ProductoService {
	
	List<Producto> allProductos();
	
	
	Producto save(Producto producto);
	
	Producto findOne(Long id);
	
	void delete(Long id);
	
	List<Producto> search(String name);
	
	List<Producto> searchByPrecios(Double preciomin, Double preciomax);
	

}
