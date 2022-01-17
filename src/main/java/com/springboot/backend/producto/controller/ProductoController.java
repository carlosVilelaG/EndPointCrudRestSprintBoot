package com.springboot.backend.producto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.producto.model.Producto;
import com.springboot.backend.producto.service.ProductoServicio;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	private ProductoServicio productoServicio;

	@PostMapping("/productos")
	public Producto save(@RequestBody Producto producto) {
		return productoServicio.save(producto);
	}

	@GetMapping("/productos")
	public List<Producto> productos() {
		return productoServicio.findAll();
	}

	@GetMapping("/productos/{id}")
	public Producto mostrar(@PathVariable Integer id) {
		return productoServicio.findById(id);
	}

	@PutMapping("/productos/{id}")
	public Producto actualizar(@RequestBody Producto producto, @PathVariable Integer id) {
		Producto productoActualizado = productoServicio.findById(id);
		productoActualizado.setNombre(producto.getNombre());
		productoActualizado.setDescripcion(producto.getDescripcion());
		productoActualizado.setPreco(producto.getPreco());
		productoActualizado.setStock(producto.getStock());
		return productoServicio.save(productoActualizado);
	}
	
	@DeleteMapping("/productos/{id}")
	public void delete(@PathVariable Integer id) {
		productoServicio.delete(id);
	}
}
