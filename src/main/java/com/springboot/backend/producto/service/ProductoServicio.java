package com.springboot.backend.producto.service;

import java.util.List;

import com.springboot.backend.producto.model.Producto;

public interface ProductoServicio {
	
	public Producto save(Producto producto);
	
	public void delete(Integer id);
	
	public Producto findById(Integer id);
	
	public List<Producto> findAll();

}
