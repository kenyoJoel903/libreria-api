package com.kenyo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kenyo.model.Producto;
import com.kenyo.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	
	@GetMapping
	public ResponseEntity<List<Producto>> productos(){
		List<Producto> productos = productoService.allProductos();
		if(productos == null) {
			productos = new ArrayList<>();
		}
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Producto> save(@Valid @RequestBody Producto producto){
		producto = productoService.save(producto);
		return new ResponseEntity<>(producto, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProduct(@PathVariable("id") Long id){
		Producto producto = productoService.findOne(id);
		if(producto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(producto, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Producto> editProducto(@PathVariable("id") Long id, @RequestBody Producto producto){
		Producto pro = productoService.findOne(id);
		if(pro == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		producto = productoService.save(producto);
		return new ResponseEntity<>(producto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id){
		Producto producto = productoService.findOne(id);
		if(producto == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/search/{text}")
	public ResponseEntity<List<Producto>> search(@PathVariable("text")String text){
		List<Producto> productos = productoService.search(text);
		if(productos == null) {
			productos = new ArrayList<>();
		}
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}
	
	
	@GetMapping("/search-precio/{precio.min}/{precio.max}")
	public ResponseEntity<List<Producto>> searchPrecio(@PathVariable("precio.min") double preciomin, @PathVariable("precio.max") double preciomax){
		List<Producto> productos = productoService.searchByPrecios(preciomin, preciomax);
		if(productos == null) {
			productos = new ArrayList<>();
		}
		return new ResponseEntity<>(productos, HttpStatus.OK);
	}

}
