package com.kenyo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kenyo.model.Producto;
import com.kenyo.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public List<Producto> allProductos() {
		return productoRepository.findAll();
	}

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Producto findOne(Long id) {
		return productoRepository.findOne(id);
	}

	@Override
	public void delete(Long id) {
		productoRepository.delete(id);		
	}

	@Override
	public List<Producto> search(String name) {
		return productoRepository.findByNombreContaining(name);
	}

	@Override
	public List<Producto> searchByPrecios(Double preciomin, Double preciomax) {
		return productoRepository.findByPrecioGreaterThanEqualAndPrecioLessThan(preciomin, preciomax);
	}

}
